package patterns.slidingwindow.problems;
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

        log.info(Utils.equal());
    }

    private static double[] findAverages(int k, int[] arr) {

    }
}
