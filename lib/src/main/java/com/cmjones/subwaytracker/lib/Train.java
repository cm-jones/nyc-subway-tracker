package com.cmjones.subwaytracker.lib;

import android.graphics.drawable.Drawable;

/**
 * Represents a train on the New York City subway system.
 */
public class Train {
    /** The line identifier, e.g. 1, A. */
    private Line line;

    /** The borough where this train is heading. */
    private String direction;

    /** The final station stop. */
    private String destination;

    /** Whether this train is running express. */
    private boolean isExpress;

    /** This train's official MTA emblem. */
    private Drawable bullet;

    /**
     * Creates a new train.
     *
     * @param setLine the train's line
     * @param setDirection the train's direction
     * @param setDestination the train's destination
     */
    public Train(final Line setLine, final String setDirection, final String setDestination,
                  final boolean setIsExpress) {
        line = setLine;
        direction = setDirection;
        destination = setDestination;
        isExpress = setIsExpress;
    }

    /**
     * Get this train's line.
     *
     * @return the line
     */
    public Line getLine() {
        return line;
    }

    /**
     * Get this train's direction.
     *
     * The direction is the borough containing the final station stop.
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Get the train's final station stop.
     *
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Whether this train is running express.
     *
     * @return true if running express, false if running local
     */
    public boolean isExpress() {
        return isExpress;
    }

    /**
     * Get a string representation of the train.
     *
     * @return the train as a string
     */
    @Override
    public String toString() {
        return direction + "-bound " + line + " train to " + destination;
    }
}
