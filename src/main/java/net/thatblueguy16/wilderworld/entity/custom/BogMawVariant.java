package net.thatblueguy16.wilderworld.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum BogMawVariant {
    DEFAULT(0),
    PURPLE(1),
    GREEN(2);

    private static final BogMawVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(BogMawVariant::getId)).toArray(BogMawVariant[]:: new);
    private final int id;

    BogMawVariant(int id) {this.id = id;}

    public int getId() {return this.id;}

    public static BogMawVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
