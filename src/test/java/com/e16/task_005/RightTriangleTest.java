package com.e16.task_005;

import com.e16.task_003.Point;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RightTriangleTest {
    private final static RightTriangle EXISTING_AND_NOT_RIGHT_TRIANGLE =
            new RightTriangle(new Point(1, 1),
                    new Point(5, 2),
                    new Point(4, 1));
    private final static RightTriangle EXISTING_AND_RIGHT_TRIANGLE =
            new RightTriangle(new Point(1, 1),
                    new Point(4, 4),
                    new Point(4, 1));
    @Test
    public void whenTriangleExistsAndRightThenReturnTrue() throws Exception {
        assertThat(EXISTING_AND_RIGHT_TRIANGLE.exists(), is(true));
    }

    @Test
    public void whenTriangleExistsAndNotIRightThenReturnFalse() throws Exception {
        assertThat(EXISTING_AND_NOT_RIGHT_TRIANGLE.exists(), is(false));
    }

}