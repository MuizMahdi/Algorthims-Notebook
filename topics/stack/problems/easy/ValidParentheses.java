package topics.stack.problems.easy;

import utils.Problem;

import java.util.Stack;

public class ValidParentheses extends Problem {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char bracket : s.toCharArray()) {
            boolean isClosingBracket = bracket == ')' || bracket == '}' || bracket == ']';

            // Open brakcet
            if (!isClosingBracket) {
                stack.push(bracket);
                // Close bracket
            } else {
                char oppositeBracket = (bracket == ')') ? '(' : ((bracket == '}') ? '{' : '[');
                if (!stack.isEmpty() && stack.peek() == oppositeBracket) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (bracket == '(') stack.push(')');
            else if (bracket == '{') stack.push('}');
            else if (bracket == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != bracket) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
