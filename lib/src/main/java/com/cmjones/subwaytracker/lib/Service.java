package com.cmjones.subwaytracker.lib;

public class Service {
    /** The single-character route identifier. */
    private String service;

    /** Broadway-Seventh Avenue Local */
    public static final Service ONE = new Service("1");

    /** Seventh Avenue Express */
    public static final Service TWO = new Service("2");

    /** Seventh Avenue Express */
    public static final Service THREE = new Service("3");

    /** Lexington Avenue Express */
    public static final Service FOUR = new Service("4");

    /** Lexington Avenue Express */
    public static final Service FIVE = new Service("5");

    /** Lexington Avenue Local / Pelham Express */
    public static final Service SIX = new Service("6");

    /** Flushing Local */
    public static final Service SEVEN = new Service("7");

    /** Eighth Avenue Express */
    public static final Service A = new Service("A");

    /** Central Park West Local / Sixth Avenue Express */
    public static final Service B = new Service("B");

    /** Eighth Avenue Local */
    public static final Service C = new Service("C");

    /** Sixth Avenue Express */
    public static final Service D = new Service("D");

    /** Eighth Avenue Local */
    public static final Service E = new Service("E");

    /** Sixth Avenue Local */
    public static final Service F = new Service("F");

    /** Brooklyn-Queens Crosstown Local */
    public static final Service G = new Service("G");

    /** Nassau Street Express */
    public static final Service J = new Service("J");

    /** Fourteenth Street - Canarie Local */
    public static final Service L = new Service("L");

    /** Queens Boulevard Local / Sixth Avenue Local / Myrtle Avenue Local */
    public static final Service M = new Service("M");

    /** Broadway Express */
    public static final Service N = new Service("N");

    /** Second Avenue / Broadway Express */
    public static final Service Q = new Service("Q");

    /** Queens Boulevard / Broadway / Fourth Avenue Local */
    public static final Service R = new Service("R");

    /** 42 Street Shuttle / Franklin Avenue Shuttle / Rockaway Park Shuttle */
    public static final Service S = new Service("S");

    /** Broadway Local */
    public static final Service W = new Service("W");

    /** Nassau Street Express */
    public static final Service Z = new Service("Z");

    /**
     * Create a new Service.
     *
     * @param setService the Service's string representation
     */
    private Service(String setService) {
        service = setService;
    }

    public String getService() {
        return service;
    }

    public boolean equals(Service other) {
        return this.getService().equals(other.getService());
    }
}
