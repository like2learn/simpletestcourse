package com.e16.task_006;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SquareTest {
    @Test
    public void whenCallExistsOnSquareThenReturnTrue() throws Exception {
        Square square = new Square(
                new Point(0, 0),
                new Point(0, 2),
                new Point(2, 2),
                new Point(2, 0));

        assertThat(square.exists(), is(true));
    }

    @Test
    public void whenCallExistsOnLineThenReturnFalse() throws Exception {
        Square square = new Square(
                new Point(0, 0),
                new Point(0, 2),
                new Point(0, 4),
                new Point(0, 6));

        assertThat(square.exists(), is(false));
    }

    @Test
    public void whenCallExistsOnNotSquareThenReturnFalse() throws Exception {
        Square square = new Square(
                new Point(0, 0),
                new Point(1, 2),
                new Point(1, 4),
                new Point(0, 6));

        assertThat(square.exists(), is(false));
    }
}