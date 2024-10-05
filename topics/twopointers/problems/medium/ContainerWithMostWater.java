package topics.twopointers.problems.medium;

import utils.Problem;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">LeetCode</a>
 */
public class ContainerWithMostWater extends Problem {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;

        while (leftPointer < rightPointer) {
            int leftHeight = height[leftPointer];
            int rightHeight = height[rightPointer];
            int heightsDistance = rightPointer - leftPointer;
            int area = Math.min(leftHeight, rightHeight) * heightsDistance;
            maxArea = Math.max(area, maxArea);

            if (leftHeight < rightHeight) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return maxArea;
    }
}
