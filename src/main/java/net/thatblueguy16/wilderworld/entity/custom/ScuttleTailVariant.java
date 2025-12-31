package net.thatblueguy16.wilderworld.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum ScuttleTailVariant {
    MOSSBACK(0),
    PURPLETAIL(1),
    MUDFOOT(2);

    private static final ScuttleTailVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ScuttleTailVariant::getId)).toArray(ScuttleTailVariant[]:: new);
    private final int id;

    ScuttleTailVariant(int id) {this.id = id;}

    public int getId() {return this.id;}

    public static ScuttleTailVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
