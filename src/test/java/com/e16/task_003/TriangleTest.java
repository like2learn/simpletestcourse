package com.e16.task_003;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TriangleTest {
    private final static Triangle EXISTING_TRIANGLE =
            new Triangle(new Point(4, 2),
                    new Point(6, 1),
                    new Point(8, 2));
    private final static Triangle NOT_EXISTING_TRIANGLE =
            new Triangle(new Point(2, 1),
                    new Point(4, 1),
                    new Point(5, 1));

    @Test
    public void whenTriangleExistThenReturnTrue() throws Exception {
        assertThat(EXISTING_TRIANGLE.exists(), is(true));
    }

    @Test
    public void whenTriangleNotExistThenReturnFalse() throws Exception {
        assertThat(NOT_EXISTING_TRIANGLE.exists(), is(false));
    }

    @Test
    public void whenTriangleExistThenCalculateArea() throws Exception {
        assertThat(EXISTING_TRIANGLE.area(), is(4d));
    }

    @Test(expected = IllegalStateException.class)
    public void whenTriangleNotExistThenThrowException() throws Exception {
        NOT_EXISTING_TRIANGLE.area();
    }
}