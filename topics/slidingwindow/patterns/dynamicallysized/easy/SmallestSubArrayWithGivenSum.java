package topics.slidingwindow.patterns.dynamicallysized.easy;

import utils.Utils;

import java.util.logging.Logger;

/**
 * Given an array of positive numbers and a positive number S,
 * find the length of the smallest contiguous sub-array whose sum is greater than or equal to S.
 * Return 0, if no such sub-array exists.
 * <p>
 * Example:
 * Input:  arr = [2, 1, 5, 2, 3, 2], S = 7
 * Output: 2
 * Explanation: The smallest sub-array with a sum greater than or equal to '7' is [5, 2].
 */
public class SmallestSubArrayWithGivenSum {
    private static final Logger log = Logger.getLogger(SmallestSubArrayWithGivenSum.class.getSimpleName());

    public static void main(String[] args) {
        log.info(Utils.equal(findMinSubArrayLengthForSum(7, new int[] {2, 1, 5, 2, 3, 2}), 2));
        log.info(Utils.equal(findMinSubArrayLengthForSum(8, new int[] {3, 4, 1, 1, 6}), 3));
    }

    private static int findMinSubArrayLengthForSum(int s, int[] arr) {
        int sum = 0, minWindowLength = Integer.MAX_VALUE;

        int start = 0;
        for (int end = 0; end < arr.length; end++) {

            // Add the end
            sum += arr[end];

            // Once [the window's sum is greater than or equal to s], and along (that's when window starts sliding)
            while(sum >= s) {

                // Compare current window length and min window length
                int currentWindowLength = end - start + 1; // +1 cuz we start from 0, and we want length to start from 1
                minWindowLength = Math.min(minWindowLength, currentWindowLength);

                // Remove ths start
                sum -= arr[start];

                // Slide
                start++;

            }
        }

        return minWindowLength == Integer.MAX_VALUE ? 0 : minWindowLength;
    }
}
