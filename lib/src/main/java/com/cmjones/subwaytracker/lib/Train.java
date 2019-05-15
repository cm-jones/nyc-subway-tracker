package com.cmjones.subwaytracker.lib;

import android.graphics.drawable.Drawable;

/**
 * Represents a train on the New York City subway system.
 */
public class Train {
    /** The service this train is running on */
    private Service service;

    /** This train's final station stop */
    private String destination;

    /** This train's initial station stop */
    private String origin;

    /** The borough where this train is heading */
    private String direction;

    /** Whether this train is running express */
    private boolean express;

    /** This train's official MTA emblem */
    private Drawable bullet;

    /** The identifier of this train */
    private int id;

    /** The last assigned instance identifier */
    private static int lastID = 0;

    /**
     * Creates a new Train
     *
     * @param setService the train's service
     * @param setDirection the train's direction
     * @param setDestination the train's destination
     */
    public Train(final Service setService, final String setDirection, final String setDestination,
                 final boolean setExpress) {
        id = ++lastID;
        service = setService;
        direction = setDirection;
        destination = setDestination;
        express = setExpress;
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
     * Set this train's service.
     *
     * @param setService the service to set
     */
    public void setService(Service setService) {
        service = setService;
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
     * Set this train's direction.
     *
     * @param setDirection the direction to set
     */
    public void setDirection(String setDirection) {
        direction = setDirection;
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
     * Set the train's final station stop.
     *
     * @param setDestination the final station stop to set
     */
    public void setDestination(String setDestination) {
        destination = setDestination;
    }

    /**
     * Whether this train is running express.
     *
     * @return true if running express, false if running local
     */
    public boolean getExpress() {
        return express;
    }

    /**
     * Set this train's express-local state.
     *
     * @param setExpress the express-local state to set
     */
    public void setExpress(boolean setExpress) {
        express = setExpress;
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

    /**
     * @param other the other train to compare this one to
     * @return true if the trains are equal, false otherwise
     */
    public boolean equals(Train other) {
        if (other == null) {
            return false;
        }
        return id == other.id;
    }
}
