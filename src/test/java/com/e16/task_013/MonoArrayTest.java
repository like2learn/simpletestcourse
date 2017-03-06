package com.e16.task_013;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MonoArrayTest {
    @Test
    public void whenMonoThenTrue() throws Exception {
        MonoArray array = new MonoArray(new int[] {1, 1, 1});

        assertThat(array.isMono(), is(true));
    }

    @Test
    public void isNotMonoThenFalse() throws Exception {
        MonoArray array = new MonoArray(new int[] {0, 0, 1});

        assertThat(array.isMono(), is(false));
    }

    @Test
    public void isHasNoItemsThenFalse() throws Exception {
        MonoArray array = new MonoArray(new int[] {});

        assertThat(array.isMono(), is(false));
    }
}