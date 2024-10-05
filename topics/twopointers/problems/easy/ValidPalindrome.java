package topics.twopointers.problems.easy;

import utils.Problem;

public class ValidPalindrome extends Problem {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        boolean output = true;
        log(isPalindrome(input) == output);
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty() || s.isBlank()) {
            return true;
        }

        String truncatedString = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int leftPointer = 0;
        int rightPointer = truncatedString.length() - 1;

        while (leftPointer < rightPointer) {
            if (truncatedString.charAt(leftPointer) != truncatedString.charAt(rightPointer)) return false;
            leftPointer++;
            rightPointer--;
        }

        return true;
    }
}
