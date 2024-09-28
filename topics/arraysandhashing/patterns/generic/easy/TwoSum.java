package topics.arraysandhashing.patterns.generic.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/">LeetCode</a>
 */
public class TwoSum {
    Map<Integer, Integer> numsIndexes = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int numTarget = target - num;

            if (numsIndexes.containsKey(numTarget)) {
                int numTargetIndex = numsIndexes.get(numTarget);
                return new int[] {numTargetIndex , i};
            } else {
                numsIndexes.put(num, i);
            }
        }

        return new int[] {};
    }
}
