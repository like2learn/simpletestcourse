package com.e16.task_014;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReversePhrase {
    private static final Logger log =
            LoggerFactory.getLogger(ReversePhrase.class);

    private final String line;
    private final char delimiter = ' ';

    public ReversePhrase(String line) {
        this.line = line;
        log.info("Call ReversePhrase constructor with \"{}\" ", line);
    }

    /**
     * Reverse order of words in line,
     * for example "Hello World" to "World Hello"
     * @return reversed line
     */
    public String reverse() {
        if (line == null || line.isEmpty()) {
            log.error("String is null or empty");
            return "";
        }
        log.info("Reverse order of words in line");
        int endWord = line.length();
        StringBuilder sb = new StringBuilder(line.length());
        for (int i = line.length() - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(line.substring(i, endWord));
            } else if (line.charAt(i - 1) == delimiter) {
                sb.append(line.substring(i, endWord)).append(delimiter);
                endWord = i - 1;
            }
        }
        return sb.toString();
    }
}
