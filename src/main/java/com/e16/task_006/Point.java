package com.e16.task_006;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Point {
    private static final Logger log = LoggerFactory.getLogger(Point.class);

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
        log.info("Creating point {}, {}", x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Calculate the distance between two points
     * @param p1 first point
     * @param p2 second point
     * @return distance
     */
    public static int dist(final Point p1, final Point p2) {
        log.info("Calculate the distance between two points {}, {}; {}, {}",
                p1.getX(), p1.getY(), p2.getX(), p2.getY());

        return (int) Math.round(Math.pow(p2.getX() - p1.getX(), 2)
                        + Math.pow(p2.getY() - p1.getY(), 2));
    }
}
