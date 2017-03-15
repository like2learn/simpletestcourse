package com.e16.task_020;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    private static final Logger log =
            LoggerFactory.getLogger(Combine.class);
    private static final String ARRAY_IS_NULL = "Array is null";
    private static final String ARRAY_HAS_ZERO_LENGTH =
            "Array has zero length, return list of zero length";
    private final int[] values;

    public Combine(final int[] values) {
        this.values = values;
        log.info("Call Combine constructor");
    }

    /**
     * Return all permutations of {@link #values}
     *
     * @return all permutations
     * @throws IllegalStateException if values is null
     */
    public List<List<Integer>> generate() throws IllegalStateException {
        if (values == null) {
            log.error(ARRAY_IS_NULL);
            throw new IllegalStateException(ARRAY_IS_NULL);
        }

        List<List<Integer>> result = new ArrayList<>();
        if (values.length == 0) {
            log.error(ARRAY_HAS_ZERO_LENGTH);
            return result;
        }

        log.info("generate permutations");
        result = generateHelper(values);

        return result;
    }

    /**
     * Generate all permutations
     * with {@link #dfs(int[], List, List)}
     *
     * @param nums inbound array
     * @return list of lists all permutation
     */
    private List<List<Integer>> generateHelper(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        dfs(nums, results, result);
        return results;
    }

    /**
     * Recursively fills the list with permutation lists
     * @param nums inbound array
     * @param results list with permutation lists
     * @param result permutation list
     */
    private void dfs(int[] nums, List<List<Integer>> results, List<Integer> result) {
        if (nums.length == result.size()) {
            List<Integer> temp = new ArrayList<>(result);
            results.add(temp);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!result.contains(nums[i])) {
                result.add(nums[i]);
                dfs(nums, results, result);
                result.remove(result.size() - 1);
            }
        }
    }
}
