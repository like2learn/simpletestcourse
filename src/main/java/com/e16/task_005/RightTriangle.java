package com.e16.task_005;

import com.e16.task_003.Point;
import com.e16.task_003.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RightTriangle extends Triangle {
    private static final Logger log = LoggerFactory.getLogger(RightTriangle.class);

    public RightTriangle(Point a, Point b, Point c) {
        super(a, b, c);
    }

    /**
     * Check triangle to exists and {@link #isRight()}
     * @return return true if exist and right,
     * false in another case
     * @throws IllegalStateException if triangle not exist
     */
    @Override
    public boolean exists() throws IllegalStateException {
        return super.exists() && isRight();
    }

    /**
     * Checking if a right triangle
     * @return true if right, false in another case
     */
    private boolean isRight() {
        double hypotenuse = Math.max(Math.max(getAB(), getBC()), getAC());
        double a = Math.min(Math.min(getAB(), getBC()), getAC());
        double b = getAB() + getBC() + getAC() - hypotenuse - a;
        log.info("Checking if a triangle with hypotenuse {} " +
                        "and cathetuses {}, {} is a right triangle",
                hypotenuse, a, b);
        return Math.round(Math.pow(hypotenuse, 2)) == Math.round(Math.pow(a, 2) + Math.pow(b, 2));
    }
}
