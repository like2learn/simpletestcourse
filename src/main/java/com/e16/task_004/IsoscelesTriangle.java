package com.e16.task_004;

import com.e16.task_003.Point;
import com.e16.task_003.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IsoscelesTriangle extends Triangle {
    private static final Logger log = LoggerFactory.getLogger(Triangle.class);

    public IsoscelesTriangle(Point a, Point b, Point c) {
        super(a, b, c);
    }

    /**
     * Check triangle to exists and {@link #isIsosceles()}
     * @return return true if exist and isosceles,
     * false in another case
     * @throws IllegalStateException if triangle not exist
     */
    @Override
    public boolean exists() throws IllegalStateException {
        return super.exists() && isIsosceles();
    }

    /**
     * Check triangle to isosceles
     * @return true if isosceles, false in another case
     */
    private boolean isIsosceles() {
        log.info("Check Triangle with sides {}, {}, {} to isosceles",
                getAB(), getAC(), getBC());
        return getAB() == getAC() || getAB() == getBC() || getAC() == getAB();
    }
}
