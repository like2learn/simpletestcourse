package com.e16.task_001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);
    private double result;

    public Calculator() {
        this.result = 0d;
    }

    public double getResult() {
        log.info("return result, {}", result);
        return result;
    }

    public void add(final double a, final double b) {
        result = a + b;
        log.info("addition, {} + {} = {}", a, b, result);
    }

    public void sub(final double a, final double b) {
        result = a - b;
        log.info("subtraction, {} - {} = {}", a, b, result);
    }

    public void mult(final double a, final double b) {
        result = a * b;
        log.info("Multiplication, {} * {} = {}", a, b, result);
    }

    public void div(final double a, final double b) {
        if (b == 0) {
            log.error("division by zero");
            throw new ArithmeticException("division by zero");
        }
        result = a / b;
        log.info("division, {} / {} = {}", a, b, result);
    }

    public void pow(final double num, final double exponent) {
        double acc = num;
        for (int i = 1; i < exponent; i++) {
             acc *= num;
        }
        result = acc;
        log.info("Raise to Power, {} ^ {} = {}", num, exponent, result);
    }

}
