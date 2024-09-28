package topics.arraysandhashing.patterns.bucketsort.problems.medium;

import topics.arraysandhashing.patterns.prefixsum.problems.medium.ProductOfArrayExceptSelf;

import java.util.*;
import java.util.logging.Logger;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/description/">LeetCode</a>
 */
public class TopKFrequentElements {
    private static final Logger log = Logger.getLogger(ProductOfArrayExceptSelf.class.getSimpleName());

    public static void main(String[] args) {
        int[] input = {1,1,1,2,2,3};
        int[] expectedOutput = {1,2};
        int[] actualOutput = topKFrequent(input, 2);
        boolean result = Arrays.equals(topKFrequent(input, 2), expectedOutput);
        log.info(Arrays.toString(actualOutput));
        log.info(String.valueOf(result));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        Map<Integer, Integer> frequencies = new HashMap<>();

        // Fill up the num:frequency map
        for (int num : nums) {
            frequencies.put(num, (frequencies.getOrDefault(num, 0) + 1));
        }

        // Fill up the frequency buckets with nums of that frequency
        // Looping on frequencies keyset because there are no duplicates
        for (int num : frequencies.keySet()) {
            int frequency = frequencies.get(num);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(num);
        }

        // Get k nums of highest frequencies, going backward because last freq is the highest
        List<Integer> res = new ArrayList<>();

        // We check for "res.size()<k" because, lets say k=2:
        // First loop: size=0 => size<k => add value to res => size=1
        // Second loop: size=1 => size<k => add value to res => size=2
        // DONE. No need for third loop. We have two elements (k=2) in res. So we do size<k to account for when size=0.
        // If we do res.size()<=k:
        // Third loop: size=2 => size<=k => Add value to res => size=3 ... BUT NOW WE HAVE 3 VALUES IN RES, we want 2 (k=2).
        for (int i = bucket.length-1; i>=0 && res.size()<k; i--) { // [1,2,3] k=2 => res.size == 1
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
