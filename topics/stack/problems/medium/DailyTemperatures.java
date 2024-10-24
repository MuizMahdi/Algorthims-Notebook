package topics.stack.problems.medium;

import utils.Problem;

import java.util.Stack;

/**.
 * <a href="https://leetcode.com/problems/daily-temperatures/">LeetCode</a>
 */
public class DailyTemperatures extends Problem {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int currentTempIndex=0; currentTempIndex<temperatures.length; currentTempIndex++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[currentTempIndex]) {
                int previousTempIndex = stack.pop();
                result[previousTempIndex] = currentTempIndex - previousTempIndex;
            }

            stack.push(currentTempIndex);
        }

        return result;
    }
}
