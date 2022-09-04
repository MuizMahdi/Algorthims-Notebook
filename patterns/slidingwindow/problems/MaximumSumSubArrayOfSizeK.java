package patterns.slidingwindow.problems;
import java.util.logging.Logger;
import utils.Utils;

/**
 * Given an array of positive numbers and a positive number K,
 * find the maximum sum of any contiguous sub-array of size K.
 */
public class MaximumSumSubArrayOfSizeK {
    private static final Logger log = Logger.getLogger(MaximumSumSubArrayOfSizeK.class.getSimpleName());

    public static void main(String[] args) {
        log.info(Utils.equal(findMaxSum(3, new int[] {2, 1, 5, 1, 3, 2}), 9L));
        log.info(Utils.equal(findMaxSum(2, new int[] {2, 3, 4, 1, 5}), 7L));
    }

    private static long findMaxSum(int k, int[] arr) {
        long maxSum = 0;
        long winSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            winSum += arr[end];
            int firstWindowEndIdx = k - 1;
            if (end >= firstWindowEndIdx) {
                maxSum = Math.max(maxSum, winSum);
                winSum -= arr[start];
                start++;
            }
        }

        return maxSum;
    }
}
