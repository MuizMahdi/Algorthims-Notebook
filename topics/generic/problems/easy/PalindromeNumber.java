package topics.generic.problems.easy;

import utils.Utils;

import java.util.logging.Logger;

/**
 * <a href="https://leetcode.com/problems/palindrome-number/description/">LeetCode</a>
 */
public class PalindromeNumber {
	private static final Logger log = Logger.getLogger(PalindromeNumber.class.getSimpleName());

	public static void main(String[] args) {
		log.info(Utils.equal(isPalindrome(121), true));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0) return false;
		return x == reverseNumber(x);
	}

	private static int reverseNumber(int number) {
		int reversed = 0;
		while (number != 0) {
			int digit = number % 10; // Get the last digit of the number
			reversed = reversed * 10 + digit; // Append the digit to the reversed number
			number /= 10; // Remove the last digit from the original number
		}
		return reversed;
	}
}
