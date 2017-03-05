package com.e16.task_009;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UniqueCharsTest {
    @Test
    public void whenHasNotUnique() throws Exception {
        UniqueChars chars = new UniqueChars("2+2+1+1+1+1+1");

        assertThat(chars.unique(), is(3L));
    }

    @Test
    public void whenHasNotUniqueFuncStyle() throws Exception {
        UniqueChars chars = new UniqueChars("2+2+3+4+3+3+4");

        assertThat(chars.uniqueFuncStyle(), is(4L));
    }

    @Test
    public void whenOnlyUnique() throws Exception {
        UniqueChars chars = new UniqueChars("123");

        assertThat(chars.unique(), is(3L));
    }

    @Test
    public void whenOnlyUniqueFuncStyle() throws Exception {
        UniqueChars chars = new UniqueChars("asdf");

        assertThat(chars.uniqueFuncStyle(), is(4L));
    }

}