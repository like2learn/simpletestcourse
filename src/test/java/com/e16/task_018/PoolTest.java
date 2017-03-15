package com.e16.task_018;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PoolTest {
    @Test
    public void whenManyUnionsAndHasRequiredUnion() throws Exception {
        Pool pool = new Pool(
                new int[][] {
                        {1, 0, 0},
                        {1, 1, 0},
                        {0, 0, 1}
                }
        );

        assertThat(pool.maxUnion(), is(3));
    }

    @Test
    public void whenOnlyOneUnionAndHasRequiredUnion() throws Exception {
        Pool pool = new Pool(
                new int[][] {
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1}
                }
        );

        assertThat(pool.maxUnion(), is(9));
    }

    @Test
    public void whenOnlyOneUnionAndHasNoRequiredUnion() throws Exception {
        Pool pool = new Pool(
                new int[][] {
                        {0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0}
                }
        );

        assertThat(pool.maxUnion(), is(0));
    }

}