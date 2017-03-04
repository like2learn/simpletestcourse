package com.e16.task_008;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * New, functional style calculating primes
 */
public class PrimesFunc {
    private static final Logger log = LoggerFactory.getLogger(PrimesFunc.class);

    private final int limit;

    public PrimesFunc(int limit) {
        this.limit = limit;
        log.info("Call Primes constructor with limit \"{}\" ", limit);
    }

    /**
     * Generate list of primes from 2 to {@link #limit}, inclusive
     * @return list of primes
     */
    public List<Integer> calc() {
        log.info("Calculate list of primes");
        return IntStream.rangeClosed(2, limit)
                .filter(this::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * Check for prime number
     * @param num number 2+
     * @return true if num is Prime, otherwise false
     */
    private boolean isPrime(int num) {
        return num > 1 &&
                IntStream.rangeClosed(2, num / 2)
                        .noneMatch(index -> num % index == 0);
    }
}
