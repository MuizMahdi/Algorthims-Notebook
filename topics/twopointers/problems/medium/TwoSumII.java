package topics.twopointers.problems.medium;

import utils.Problem;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">LeetCode</a>
 */
public class TwoSumII extends Problem {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while (leftPointer <= rightPointer) {
            int sum = numbers[leftPointer] + numbers[rightPointer];

            if (sum == target) {
                result[0] = leftPointer + 1;
                result[1] = rightPointer + 1;
                return result;
            } else if (sum < target) {
                leftPointer++;
            } else if (sum > target) {
                rightPointer--;
            }
        }

        return result;
    }
}
