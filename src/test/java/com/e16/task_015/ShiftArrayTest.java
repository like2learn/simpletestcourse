package com.e16.task_015;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ShiftArrayTest {
    @Test
    public void whenShiftTwo() throws Exception {
        ShiftArray array = new ShiftArray(new int[] {1, 2, 3, 4, 5});

        assertThat(array.shift(2), is(new int[] {4, 5, 1, 2, 3}));
    }

    @Test
    public void whenArraySizeOne() throws Exception {
        ShiftArray array = new ShiftArray(new int[] {1});

        assertThat(array.shift(20), is(new int[] {1}));
    }

    @Test
    public void whenArraySizeZero() throws Exception {
        ShiftArray array = new ShiftArray(new int[] {});

        assertThat(array.shift(20), is(new int[] {}));
    }

}