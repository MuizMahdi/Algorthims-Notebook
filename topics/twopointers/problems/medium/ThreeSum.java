package topics.twopointers.problems.medium;

import utils.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/3sum/description/">LeetCode</a>
 */
public class ThreeSum extends Problem {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        // Last element for i is nums.length -2, because the other two will be occupied by left and right pointers.
        for (int i=0; i<nums.length-2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;

            while (leftPointer < rightPointer) {
                int leftNum = nums[leftPointer];
                int rightNum = nums[rightPointer];
                int sum = nums[i] + leftNum + rightNum;

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], leftNum, rightNum));

                    // Skip duplicate values for leftPointer
                    while (leftPointer < rightPointer && leftNum == nums[leftPointer + 1]) {
                        leftPointer++;
                    }

                    // Skip duplicate values for rightPointer
                    while (leftPointer < rightPointer && rightNum == nums[rightPointer - 1]) {
                        rightPointer--;
                    }

                    leftPointer++;
                    rightPointer--;
                } else if (sum < 0) {
                    leftPointer++;
                } else {
                    rightPointer--;
                }
            }
        }

        return result;
    }
}
