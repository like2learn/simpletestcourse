package com.e16.task_004;

import com.e16.task_003.Point;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IsoscelesTriangleTest {
    private final static IsoscelesTriangle EXISTING_AND_NOT_ISOSCELES_TRIANGLE =
            new IsoscelesTriangle(new Point(5, 2),
                    new Point(6, 1),
                    new Point(8, 2));
    private final static IsoscelesTriangle EXISTING_AND_ISOSCELES_TRIANGLE =
            new IsoscelesTriangle(new Point(0, 0),
                    new Point(0, 2),
                    new Point(2, 0));

    @Test
    public void whenTriangleExistsAndIsoscelesThenReturnTrue() throws Exception {
        assertThat(EXISTING_AND_ISOSCELES_TRIANGLE.exists(), is(true));
    }

    @Test
    public void whenTriangleExistsAndNotIsoscelesThenReturnFalse() throws Exception {
        assertThat(EXISTING_AND_NOT_ISOSCELES_TRIANGLE.exists(), is(false));
    }
}