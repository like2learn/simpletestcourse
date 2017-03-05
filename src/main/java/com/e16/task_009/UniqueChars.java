package com.e16.task_009;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class UniqueChars {
    private static final Logger log = LoggerFactory.getLogger(UniqueChars.class);

    private final String line;

    public UniqueChars(String line) {
        this.line = line;
        log.info("Call UniqueChars constructor with line \"{}\" ", line);
    }

    /**
     * Count unique chars in {@link #line}
     * @return count of unique chars
     */
    public long unique() {
        log.info("Counting by unique() of unique chars in \"{}\"", line);
        Set<Character> uniqueSymbols = new HashSet<>();
        for (Character c : line.toCharArray()) {
            uniqueSymbols.add(c);
        }
        return uniqueSymbols.size();
    }
    /**
     * Functional style
     * count unique chars in {@link #line}
     * @return count of unique chars
     */
    public long uniqueFuncStyle() {
        log.info("Count by uniqueFuncStyle() of unique chars in \"{}\"", line);
        return line.chars()
                .distinct()
                .count();
    }
}
