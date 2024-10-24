package topics.stack.problems.hard;

import utils.Problem;

/**
 * <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">LeetCode</a>
 */
public class LargestHistogram extends Problem {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int totalBars = heights.length;

        // Iterate through bars + one addition iteration
        for (int i=0; i<totalBars; i++) {
            int currentHeight = heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int poppedBarHeight = heights[stack.pop()];

                int areaWidth = stack.isEmpty() ? i : i-stack.peek();
                int area = poppedBarHeight * areaWidth;

                maxArea = Math.max(maxArea, area);
            }

            if (i < totalBars) {
                stack.push(i);
            }
        }

        return maxArea;
    }
}
