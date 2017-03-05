package com.e16.task_010;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BracketsTest {
    @Test
    public void whenValidThenTrue() throws Exception {
        Brackets validBrackets = new Brackets("(()(()))");

        assertThat(validBrackets.isCorrect(), is(true));
    }

    @Test
    public void whenClosedBracketsNotEnoughThenFalse() throws Exception {
        Brackets invalidBrackets = new Brackets("(((())");

        assertThat(invalidBrackets.isCorrect(), is(false));
    }

    @Test
    public void whenOpenedBracketsNotEnoughThenFalse() throws Exception {
        Brackets invalidBrackets = new Brackets("(())))");

        assertThat(invalidBrackets.isCorrect(), is(false));
    }

    @Test
    public void whenOddBracketsThenFalse() throws Exception {
        Brackets oddBrackets = new Brackets("(()");

        assertThat(oddBrackets.isCorrect(), is(false));
    }
}