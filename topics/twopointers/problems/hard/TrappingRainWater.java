package topics.twopointers.problems.hard;

import utils.Problem;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/">LeetCode</a>
 */
public class TrappingRainWater extends Problem {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int leftPointer = 0, rightPointer = height.length - 1;
        int maxLeft = height[leftPointer], maxRight = height[rightPointer];
        int waterArea = 0;

        while (leftPointer < rightPointer) {
            if (maxRight < maxLeft) {
                // We move first because the firstmost and lastmost pointers are either
                // empty, or blocks, but no water because they're on the edges.
                rightPointer--;
                int rightHeight = height[rightPointer];
                maxRight = Math.max(maxRight, rightHeight);
                int area = maxRight - rightHeight;
                if (area > 0) {
                    waterArea += area;
                }
            } else {
                leftPointer++;
                int leftHeight = height[leftPointer];
                maxLeft = Math.max(maxLeft, leftHeight);
                int area = maxLeft - leftHeight;
                if (area > 0) {
                    waterArea += area;
                }
            }
        }

        return waterArea;
    }
}
