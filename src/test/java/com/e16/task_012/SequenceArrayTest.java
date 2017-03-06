package com.e16.task_012;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SequenceArrayTest {
    @Test
    public void whenContainsThenTrue() throws Exception {
        SequenceArray array = new SequenceArray(new int[] {0, 1, 1, 1, 0});

        assertThat(array.isContainsSequence(), is(true));
    }

    @Test
    public void whenNotContainsThenFalse() throws Exception {
        SequenceArray array = new SequenceArray(new int[] {0, 1, 0, 1, 0});

        assertThat(array.isContainsSequence(), is(false));
    }

    @Test
    public void whenLengthIsTooSmallThenFalse() throws Exception {
        SequenceArray array = new SequenceArray(new int[] {1, 1});

        assertThat(array.isContainsSequence(), is(false));
    }
}