package com.e16.task_003;

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
     * Calculate distance from this point to another point
     * @param point another point
     * @return distance
     */
    public double distanceTo(final Point point) {
        log.info("Calculate distance from Point {}, {} to {}, {}", x, y, point.getX(), point.getY());
        return Math.sqrt(Math.pow(x - point.getX(), 2) + Math.pow(y - point.getY(), 2));
    }
}
