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
        int[] input = {1,2,3,4};
        int[] output = {24,12,8,6};
        boolean result = Arrays.equals(topKFrequent(input, 2), output);
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

        for (int i = bucket.length-1; i>=0 && res.size()<k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
