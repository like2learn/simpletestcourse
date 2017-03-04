package com.e16.task_008;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Old style calculating primes
 */
public class Primes {
    private static final Logger log = LoggerFactory.getLogger(Primes.class);

    private final int limit;

    public Primes(int limit) {
        this.limit = limit;
        log.info("Call Primes constructor with limit \"{}\" ", limit);
    }

    /**
     * Generate list of primes from 2 to {@link #limit}, inclusive
     * @return list of primes
     */
    public List<Integer> calc() {
        log.info("Calculate list of primes");
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * Check for prime number
     * @param num number 2+
     * @return true if num is Prime, otherwise false
     */
    private boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return num > 1;
    }
}
