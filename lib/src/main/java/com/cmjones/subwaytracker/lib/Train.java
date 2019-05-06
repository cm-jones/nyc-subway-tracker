package com.cmjones.subwaytracker.lib;

import android.graphics.drawable.Drawable;

/**
 * Represents a train on the New York City subway system.
 */
public class Train {
    /** The service identifier, e.g. 1, A. */
    private Service service;

    /** The borough where this train is heading. */
    private String direction;

    /** The final station stop. */
    private String destination;

    /** Whether this train is running express. */
    private boolean isExpress;

    /** This train's official MTA emblem. */
    private Drawable bullet;

    /** The ID of this instance. */
    private int id;

    /** The last assigned instance ID. */
    private static int lastID = 0;

    /**
     * Creates a new train.
     *
     * @param setService the train's service
     * @param setDirection the train's direction
     * @param setDestination the train's destination
     */
    public Train(final Service setService, final String setDirection, final String setDestination,
                 final boolean setIsExpress) {
        id = ++lastID;
        service = setService;
        direction = setDirection;
        destination = setDestination;
        isExpress = setIsExpress;
    }

    /**
     * Get this train's service.
     *
     * @return the service
     */
    public Service getService() {
        return service;
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
        return direction + "-bound " + service + " train to " + destination;
    }
}
