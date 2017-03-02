package com.e16.task_001;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CalculatorTest {
    private static Calculator calc;

    @Before
    public void setTestEnv() throws Exception {
        calc = new Calculator();
    }

    @After
    public void destroyTestEnv() throws Exception {
        calc = null;
    }

    @Test
    public void whenAddTwoOnThreeThenResultFive() throws Exception {
        calc.add(2d, 3d);

        assertThat(calc.getResult(), is(5d));
    }

    @Test
    public void whenSubFiveOnTwoThenResultTree() throws Exception {
        calc.sub(5d, 2d);

        assertThat(calc.getResult(), is(3d));
    }

    @Test
    public void whenMultTwoOnThreeThenResultSix() throws Exception {
        calc.mult(2d, 3d);

        assertThat(calc.getResult(), is(6d));
    }

    @Test
    public void whenDivEightOnTwoThenResultFour() throws Exception {
        calc.div(8d, 2d);

        assertThat(calc.getResult(), is(4d));
    }

    @Test
    public void whenPowThreeOnFourThenResultEightyOne() throws Exception {
        calc.pow(3d, 4d);

        assertThat(calc.getResult(), is(81d));
    }

    @Test(expected = ArithmeticException.class)
    public void whenDivByZeroThenException() {
        calc.div(4d, 0d);
    }

}