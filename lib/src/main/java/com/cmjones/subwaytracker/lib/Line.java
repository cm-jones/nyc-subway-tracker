package com.cmjones.subwaytracker.lib;

public class Line {
    /** The single-character route identifier. */
    private String line;

    /** Broadway-Seventh Avenue Local */
    public static final Line ONE = new Line("1");

    /** Seventh Avenue Express */
    public static final Line TWO = new Line("2");

    /** Seventh Avenue Express */
    public static final Line THREE = new Line("3");

    /** Lexington Avenue Express */
    public static final Line FOUR = new Line("4");

    /** Lexington Avenue Express */
    public static final Line FIVE = new Line("5");

    /** Lexington Avenue Local / Pelham Express */
    public static final Line SIX = new Line("6");

    /** Flushing Local */
    public static final Line SEVEN = new Line("7");

    /** Eighth Avenue Express */
    public static final Line A = new Line("A");

    /** Central Park West Local / Sixth Avenue Express */
    public static final Line B = new Line("B");

    /** Eighth Avenue Local */
    public static final Line C = new Line("C");

    /** Sixth Avenue Express */
    public static final Line D = new Line("D");

    /** Eighth Avenue Local */
    public static final Line E = new Line("E");

    /** Sixth Avenue Local */
    public static final Line F = new Line("F");

    /** Brooklyn-Queens Crosstown Local */
    public static final Line G = new Line("G");

    /** Nassau Street Express */
    public static final Line J = new Line("J");

    /** Fourteenth Street - Canarie Local */
    public static final Line L = new Line("L");

    /** Queens Boulevard Local / Sixth Avenue Local / Myrtle Avenue Local */
    public static final Line M = new Line("M");

    /** Broadway Express */
    public static final Line N = new Line("N");

    /** Second Avenue / Broadway Express */
    public static final Line Q = new Line("Q");

    /** Queens Boulevard / Broadway / Fourth Avenue Local */
    public static final Line R = new Line("R");

    /** 42 Street Shuttle / Franklin Avenue Shuttle / Rockaway Park Shuttle */
    public static final Line S = new Line("S");

    /** Broadway Local */
    public static final Line W = new Line("W");

    /** Nassau Street Express */
    public static final Line Z = new Line("Z");

    /**
     * Create a new Line.
     *
     * @param setLine the line's string representation
     */
    private Line(String setLine) {
        line = setLine;
    }

    public String getLine() {
        return line;
    }

    public boolean equals(Line other) {
        return this.getLine().equals(other.getLine());
    }
}
