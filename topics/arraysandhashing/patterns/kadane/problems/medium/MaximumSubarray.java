package topics.arraysandhashing.patterns.kadane.problems.medium;

import utils.Problem;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * <p>
 * <a href="https://leetcode.com/problems/maximum-subarray/">LeetCode</a>
 */
public class MaximumSubarray extends Problem {
    public int maxSubArray(int[] nums) {
        int largestSum = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            currentSum = Math.max(currentSum, 0);
            currentSum += num;
            largestSum = Math.max(largestSum, currentSum);
        }

        return largestSum;
    }
}
