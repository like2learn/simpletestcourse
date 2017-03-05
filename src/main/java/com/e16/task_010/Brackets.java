package com.e16.task_010;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Brackets {
    private static final Logger log = LoggerFactory.getLogger(Brackets.class);

    private final String line;

    public Brackets(final String line) {
        this.line = line;
        log.info("Call Brackets constructor with line \"{}\" ", line);
    }

    /**
     * Check line of brackets for correct
     * order of brackets
     * @return true if line is correct,
     * otherwise false
     */
    public boolean isCorrect() {
        log.info("Checking \"{}\" for correct order of brackets ", line);

        /* if length of line is odd then line incorrect */
        if (line.length() % 2 != 0) {
            return false;
        }

        final Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        final Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            Character ch = line.charAt(i);
            if (brackets.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.empty() || ch != brackets.get(stack.pop())) {
                return false;
            }
        }
        /* if not empty then contains not closed brackets */
        return stack.isEmpty();
    }
}
