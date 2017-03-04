package com.e16.task_007;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ExpressionTest {
    private final static String WRONG_EXPRESSION = "2+";
    private final static String VALID_EXPRESSION = "2+4";
    private final static String UNSUPPORTED_OPERATION = "2%4";

    @Test(expected = IllegalStateException.class)
    public void whenCalcWrongExpressionThenThrowException() throws Exception {
        new Expression(WRONG_EXPRESSION).calc();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenCalcWrongOperationThenThrowException() throws Exception {
        new Expression(UNSUPPORTED_OPERATION).calc();
    }

    @Test
    public void whenCalcValidExpressionThenReturnValidResult() throws Exception {
        assertThat(new Expression(VALID_EXPRESSION).calc(), is(6d));
    }
}