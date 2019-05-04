package com.cmjones.subwaytracker;

import android.graphics.drawable.Drawable;

/**
 * Represents a train on the New York subway system.
 */
public class Train {
    /** The single-character identifier. */
    private char line;

    /** The borough to which this train is heading. */
    private String direction;

    /** The final station stop. */
    private String destination;

    /** Whether this train runs express. */
    private boolean isExpress;

    private Drawable bullet;

    /** Brooklyn-bound Eighth Avenue Express to Far Rockaway. */
    public static final Train A_BROOKLYN = new Train('A', "Brooklyn", "Coney Island");

    /** Bronx-bound Eighth Avenue Express to Inwood-204th St. */
    public static final Train A_BRONX = new Train('A', "Bronx", "Inwood - 204th St");

    /**
     * Creates a new train.
     *
     * @param setLine the train's line
     * @param setDirection the train's direction
     * @param setDestination the train's destination
     */
    private Train(final char setLine, final String setDirection, final String setDestination) {
        line = setLine;
        direction = setDirection;
        destination = setDestination;
    }

    public char getLine() {
        return line;
    }

    public void setLine(final char setLine) {
        line = setLine;
    }

    public String getDirection() {
        return destination;
    }

    public void setDirection(final String setDirection) {
        direction = setDirection;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String setDestination) {
        destination = setDestination;
    }

    public boolean isExpress() {
        return isExpress;
    }

    public void setExpress(final boolean setExpress) {
        isExpress = setExpress;
    }
}
