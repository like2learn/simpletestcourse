package com.e16.task_012;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequenceArray {
    private static final Logger log =
            LoggerFactory.getLogger(SequenceArray.class);

    private final int[] values;
    private final int permissibleElement = 1;
    private final int minSequenceLength = 3;

    public SequenceArray(final int[] values) {
        this.values = values;
        log.info("Call SequenceArray constructor with \"{}\" ", values);
    }

    /**
     * Check {@link #values} for sequence of {@link #permissibleElement},
     * with minimal length {@link #minSequenceLength}
     * @return true if sequence exists, otherwise false
     */
    public boolean isContainsSequence() {
        if (values == null || values.length < minSequenceLength) {
            log.error("Array is null or has small length");
            return false;
        }
        log.info("Checking array for sequence of the right length");
        int sequenceLength = 0;
        for (int elem : values) {
            if (elem == permissibleElement) {
                sequenceLength++;
            } else {
                sequenceLength = 0;
            }
            if (sequenceLength == minSequenceLength) {
                return true;
            }
        }
        /* If not found sequence of the right length */
        return false;
    }
}
