package com.e16.task_002;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Point {
    private static final Logger log = LoggerFactory.getLogger(Point.class);

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * calculate distance from this point to another point
     * @param point another point
     * @return distance
     */
    public double distanceTo(final Point point) {
        return Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2));
    }
}
