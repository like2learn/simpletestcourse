package com.e16.task_002;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;

public class PointTest {
    @Test
    public void distanceTo() throws Exception {
        Point a = new Point(2, 3);
        Point b = new Point(4, 6);

        assertThat(b.distanceTo(a), is(closeTo(3.606d, 0.001d)));
    }

}