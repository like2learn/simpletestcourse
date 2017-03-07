package com.e16.task_015;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiftArray {
    private static final Logger log =
            LoggerFactory.getLogger(ShiftArray.class);

    private final int[] values;

    public ShiftArray(final int[] values) {
        this.values = values;
        log.info("Call ShiftArray constructor with \"{}\" ", values);
    }

    public int[] shift(final int position) {
        if (values == null || values.length < 2) {
            log.error("Array is null or contains less than two elements");
            return values;
        }

        for (int i = 0; i < position; i++) {
            shiftOne();
        }

        return values;
    }

    private void shiftOne() {
        final int lastElem = values[values.length - 1];
        System.arraycopy(values, 0, values, 1, values.length - 1);
        values[0] = lastElem;
    }
}
