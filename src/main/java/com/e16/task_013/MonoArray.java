package com.e16.task_013;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class MonoArray {
    private static final Logger log =
            LoggerFactory.getLogger(MonoArray.class);

    private final int[] values;

    public MonoArray(final int[] values) {
        this.values = values;
        log.info("Call MonoArray constructor with \"{}\" ", values);
    }

    /**
     * Check array if contains only equal items
     * @return true if equal, otherwise false
     */
    public boolean isMono() {
        if (values == null || values.length == 0) {
            log.error("Array is null or has no items");
            return false;
        }

        log.info("Checking array if contains only equal items");
        int pattern = values[0];

        return Arrays.stream(values).parallel()
                .allMatch(elem -> elem == pattern);
    }
}
