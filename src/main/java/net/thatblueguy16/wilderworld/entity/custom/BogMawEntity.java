package net.thatblueguy16.wilderworld.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.task.BreedTask;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.thatblueguy16.wilderworld.entity.ModEntities;
import net.thatblueguy16.wilderworld.item.ModItems;
import net.thatblueguy16.wilderworld.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class BogMawEntity extends AnimalEntity implements Monster {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    private int attackAnimationTimeout = 0;

    private static final TrackedData<Integer> DATA_ID_VARIANT_TYPE =
            DataTracker.registerData(BogMawEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public void tryAttack(BogMawEntity target) {
        super.tryAttack(target);
    }

    public BogMawEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean canBeLeashed() {
        return true;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(1, new AnimalMateGoal(this, 1.5D));
        this.goalSelector.add(3, new FollowParentGoal(this, 1.1D));

        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.60D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4.0f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(7, new AvoidSunlightGoal(this));
        this.goalSelector.add(8, new MeleeAttackGoal(this, 1.2d, true));
        this.goalSelector.add(8, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 7)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, .15)
                .add(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY, .25)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7);
    }

    private void setupAnimationStates(){
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout =35;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

          if(this.attackAnimationTimeout <= 0) {
            this.attackAnimationTimeout =35;
            this.attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }


    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.BEEF);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        BogMawEntity baby = ModEntities.BogMaw.create(world);
        BogMawVariant variant = Util.getRandom(BogMawVariant.values(), this.random);
        baby.setVariant(variant);
        return baby;
    }

    /*VARIANT*/

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_VARIANT_TYPE, 0);
    }

    public BogMawVariant getVariant() {
        return BogMawVariant.byId(this.getTypeVariant() & 675);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_VARIANT_TYPE);
    }

    private void setVariant(BogMawVariant variant) {
        this.dataTracker.set(DATA_ID_VARIANT_TYPE, variant.getId() & 675);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(DATA_ID_VARIANT_TYPE, nbt.getInt("Variant"));
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                                 @Nullable EntityData entityData) {

        BogMawVariant variant = Util.getRandom(BogMawVariant.values(), this.random);
        setVariant(variant);

        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    /* SOUNDS */

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {return ModSounds.BOG_MAW_HURT;}

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.BOG_MAW_DEATH;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.BOG_MAW_IDLE;
    }
}
