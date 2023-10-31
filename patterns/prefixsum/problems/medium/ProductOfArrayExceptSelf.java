package patterns.prefixsum.problems.medium;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">LeetCode</a>
 * <a href="https://www.youtube.com/watch?v=bNvIQI2wAjk">Video</a>
 */
public class ProductOfArrayExceptSelf {
	private static final Logger log = Logger.getLogger(ProductOfArrayExceptSelf.class.getSimpleName());

	public static void main(String[] args) {
		int[] input = {1,2,3,4};
		int[] output = {24,12,8,6};
		boolean result = Arrays.equals(productExceptSelf(input), output);
		log.info(String.valueOf(result));
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];

		int prefix = 1;
		for (int i = 0; i < nums.length; i++) {
			result[i] = prefix;
			prefix *= nums[i];
		}

		int postfix = 1;
		for (int i = nums.length-1; i >= 0; i--) {
			result[i] *= postfix;
			postfix *= nums[i];
		}

		return result;
	}

}
