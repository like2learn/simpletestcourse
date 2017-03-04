package com.e16.task_008;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PrimesTest {

    @Test
    public void whenCalcThenReturnListOfPrimes() throws Exception {
        assertThat(new Primes(29).calc(), is(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)));
    }

}