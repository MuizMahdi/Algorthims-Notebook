package topics.stack.problems.medium;

import utils.Problem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/description/">LeetCode</a>
 */
public class GenerateParentheses extends Problem {
    // O(4^n / √n) => O(4^n)
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();  // List to store all valid combinations
        backtrack(result, "", 0, 0, n);  // Start the backtracking process
        return result;
    }

    // current: the current string being built
    // open: count of opening parentheses in the current string
    // close: count of closing parentheses in the current string
    // max: the total number of pairs we need
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: if the current string has the correct length, it's complete
        if (open == max && close == max) {
            result.add(current);  // Add the completed string to our result
            return;  // End this branch of recursion
        }

        // We can add an opening parenthesis if we haven't used all (max)
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // We can add a closing parenthesis if it won't exceed opening parentheses
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
