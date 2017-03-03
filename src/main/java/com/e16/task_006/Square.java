package com.e16.task_006;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.e16.task_006.Point.dist;

public class Square {
    private static final Logger log = LoggerFactory.getLogger(Square.class);

    private final Point p1;
    private final Point p2;
    private final Point p3;
    private final Point p4;

    public Square(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        log.info("Creating the square from points");
    }


    /**
     * Check square for exists
     * @return true if square exist, otherwise false
     */
    public boolean exists() {
        log.info("Checking the square to exists");

        int d2 = dist(p1, p2);
        int d3 = dist(p1, p3);
        int d4 = dist(p1, p4);

        if (d2 == d3 && 2 * d2 == d4) {
            int d = dist(p2, p4);
            return (d == dist(p3, p4) && d == d2);
        }
        if (d3 == d4 && 2 * d3 == d2) {
            int d = dist(p2, p3);
            return (d == dist(p2, p4) && d == d3);
        }
        if (d2 == d4 && 2 * d2 == d3) {
            int d = dist(p2, p3);
            return (d == dist(p3, p4) && d == d2);
        }

        return false;
    }
}
