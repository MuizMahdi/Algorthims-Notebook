package patterns.slidingwindow.problems;
import utils.Utils;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Given an array of positive numbers and a positive number K,
 * find the average of all contiguous sub-arrays of size K in it.
 */
public class AveragesOfSubArraysOfSizeK {
    private static final Logger log = Logger.getLogger(AveragesOfSubArraysOfSizeK.class.getSimpleName());

    public static void main(String[] args) {
        int size = 5;
        var arr = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
        var result = new double[] {2.2, 2.8, 2.4, 3.6, 2.8};
        log.info(Utils.equal(Arrays.toString(findAverages(size, arr)), Arrays.toString(result)));
    }

    private static double[] findAverages(int k, int[] arr) {
        int numOfWindows = arr.length - k + 1;
        double[] averages = new double[numOfWindows];

        int start = 0;
        double sum = 0;

        for (int end = 0; end < arr.length; end++) {

            // Update sum as we go
            sum += arr[end];

            // Once we reach, and starting from the end of first window and along (that's when window starts sliding)
            int firstWindowEndIdx = k - 1;
            if (end >= firstWindowEndIdx) {

                // Get and add the current window's average to the averages list
                double windowAverage = sum / k;
                averages[start] = windowAverage;

                // Subtract the element exiting the window (from the start)
                sum -= arr[start];

                // Slide the window
                start++;

            }
        }

        return averages;
    }
}
