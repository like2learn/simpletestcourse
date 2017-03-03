package com.e16.task_006;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PointTest {
    private final static int X = 1;
    private final static int Y = 2;
    private final static Point FIRST_POINT = new Point(X, Y);
    private final static Point SECOND_POINT = new Point(3, 4);

    @Test
    public void whenCallGetXThenReturnX() throws Exception {
        assertThat(FIRST_POINT.getX(), is(X));
    }

    @Test
    public void whenCallGetYThenReturnY() throws Exception {
        assertThat(FIRST_POINT.getY(), is(Y));
    }

    @Test
    public void whenCallDistThenReturnDistanceBetweenTwoPoint() throws Exception {
        int expected = (int) Math.round(Math.pow(SECOND_POINT.getX() - FIRST_POINT.getX(), 2)
                + Math.pow(SECOND_POINT.getY() - FIRST_POINT.getY(), 2));

        assertThat(Point.dist(FIRST_POINT, SECOND_POINT), is(expected));
    }

}