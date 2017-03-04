package com.e16.task_007;

import com.e16.task_001.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculate expression from string, like 2+2
 * throw IllegalStateException on wrong expressions
 * throw UnsupportedOperationException if calculation
 * operation unsupported
 */
public class Expression {
    private static final Logger log = LoggerFactory.getLogger(Expression.class);
    private static final String INCORRECT_EXPRESSION = "Incorrect expression";
    private static final String UNSUPPORTED_OPERATION = "Unsupported operation";

    private final String expr;

    public Expression(final String expr) {
        this.expr = expr;
        log.info("Call Expression constructor with \"{}\" ", expr);
    }

    /**
     * Calculate expression from expr,
     * uses {@link Calculator}
     * @return result of calculation
     * @throws IllegalStateException expression is wrong
     * @throws UnsupportedOperationException calculation
     * operation unsupported
     */
    public double calc() throws IllegalStateException {
        Node node = parseExpression();
        if (node.isEmpty) {
            log.error(INCORRECT_EXPRESSION);
            throw new IllegalStateException(INCORRECT_EXPRESSION);
        }
        Calculator calc = new Calculator();
        switch (node.operation) {
            case "+":
                calc.add(node.firstOperand, node.secondOperand);
                break;
            case "-":
                calc.sub(node.firstOperand, node.secondOperand);
                break;
            case "*":
                calc.mult(node.firstOperand, node.secondOperand);
                break;
            case "/":
                calc.div(node.firstOperand, node.secondOperand);
                break;
            case "exp":
                calc.pow(node.firstOperand, node.secondOperand);
                break;
            default:
                String msg = UNSUPPORTED_OPERATION + ", \"" + node.operation + "\"";
                log.error(msg);
                throw new UnsupportedOperationException(msg);
        }
        log.info("Calculate {} {} {}, result is {}",
                node.firstOperand,
                node.operation,
                node.secondOperand,
                calc.getResult());
        return calc.getResult();
    }

    /**
     * Parse expression from expr
     * @return empty Node if expression wrong,
     * otherwise Node with parsed expression
     */
    private Node parseExpression() {
        String pattern = "(\\d+)(\\D+)(\\d+)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(expr);
        if (m.find() && m.groupCount() == 3) {
            log.info("Return node with operator \"{}\" and operands {}, {}",
                    m.group(2), m.group(1), m.group(3));
            return new Node(m.group(2),
                    Integer.parseInt(m.group(1)),
                    Integer.parseInt(m.group(3)));
        }
        log.info("Return empty node");
        return new Node();
    }

    /**
     * Subclass for store parsed expression
     */
    private class Node {
        private final String operation;
        private final int firstOperand;
        private final int secondOperand;
        private boolean isEmpty;

        /**
         * Constructor for empty Node
         */
        private Node() {
            this("", 0,0);
            this.isEmpty = true;
        }

        /**
         * Constructor for Node with expression
         */
        private Node(String operation, int firstOperand, int secondOperand) {
            this.operation = operation;
            this.firstOperand = firstOperand;
            this.secondOperand = secondOperand;
        }

    }

}
