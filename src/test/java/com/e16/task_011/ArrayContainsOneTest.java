package com.e16.task_011;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArrayContainsOneTest {
    @Test
    public void containsOnlyOne() throws Exception {
        ArrayContainsOne array =
                new ArrayContainsOne(new int[] {1, 1, 1, 1, 1});

        assertThat(array.isContainsOnlyOne(), is(true));
    }

    @Test
    public void containsNotOnlyOne() throws Exception {
        ArrayContainsOne array =
                new ArrayContainsOne(new int[] {1, 1, 1, 1, 0});

        assertThat(array.isContainsOnlyOne(), is(false));
    }

}