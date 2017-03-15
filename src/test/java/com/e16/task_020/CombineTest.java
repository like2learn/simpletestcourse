package com.e16.task_020;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;

public class CombineTest {
    @Test
    public void whenTwoElementsInArray() throws Exception {
        Combine combine = new Combine(new int[]{1, 2});
        List<List<Integer>> result = combine.generate();

        assertThat(result, containsInAnyOrder(
                asList(1, 2),
                asList(2, 1)
        ));
        assertThat(result.size(), is(2));
    }

    @Test
    public void whenThreeElementsInArray() throws Exception {
        Combine combine = new Combine(new int[]{1, 2, 3});
        List<List<Integer>> result = combine.generate();

        assertThat(result, containsInAnyOrder(
                asList(1, 2, 3),
                asList(1, 3, 2),
                asList(2, 1, 3),
                asList(2, 3, 1),
                asList(3, 2, 1),
                asList(3, 1, 2)
        ));
        assertThat(result.size(), is(6));
    }

    @Test
    public void whenZeroItemsInArray() {
        Combine combine = new Combine(new int[]{});
        List<List<Integer>> result = combine.generate();

        assertThat(result.size(), is(0));
    }

    @Test (expected = IllegalStateException.class)
    public void whenArraysIsNull() {
        Combine combine = new Combine(null);
        List<List<Integer>> result = combine.generate();
    }
}