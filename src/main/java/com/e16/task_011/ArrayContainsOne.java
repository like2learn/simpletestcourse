package com.e16.task_011;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ArrayContainsOne {
    private static final Logger log =
            LoggerFactory.getLogger(ArrayContainsOne.class);

    private final int[] values;
    private final int zero = 0;

    public ArrayContainsOne(final int[] values) {
        this.values = values;
        log.info("Call ArrayContainsOne constructor with \"{}\" ", values);
    }

    /**
     * Check {@link #values} for not contains {@link #zero}
     * @return false is contains zero, true if otherwise
     */
    public boolean isContainsOnlyOne() {
        if (values == null || values.length == 0) {
            log.error("Array is null or has 0 elements");
            return false;
        }
        log.info("Check array for non contains zeros");
        return Arrays.stream(values).parallel()
                .noneMatch(this::isZero);
    }

    private boolean isZero(final int num) {
        return num == zero;
    }
}
