package patterns.prefixsum.problems.easy;

import utils.Problem;

/**
 * <p>
 * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
 * The biker starts his trip on point 0 with altitude equal 0. You are given an integer array gain of length n where
 * gain[i] is the net gain in altitude between points i and i + 1 for all (0 <= i < n).
 * Return the highest altitude of a point.
 * </p>
 *
 * <p>
 * Example 1:
 * Input: gain = [-5,1,5,0,-7]
 * Output: 1
 * Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
 * </p>
 *
 * <p>
 * Example 2:
 * Input: gain = [-4,-3,-2,-1,4,3,2]
 * Output: 0
 * Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 * </p>
 */
public class FindTheHighestAltitude extends Problem {
	public static void main(String[] args) {
		int[] input = {-4,-3,-2,-1,4,3,2};
		int output = 0;
		log(largestAltitudeB(input) == output);
	}

	public static int largestAltitude(int[] gain) {
		int[] prefixSum = new int[gain.length+1];
		prefixSum[0] = 0;
		prefixSum[1] = gain[0];
		int largestAltitude = Math.max(prefixSum[0], prefixSum[1]);

		for (int i = 2; i < gain.length+1; i++) {
			prefixSum[i] = prefixSum[i - 1] + gain[i - 1];
			largestAltitude = Math.max(prefixSum[i], largestAltitude);
		}

		return largestAltitude;
	}

	public static int largestAltitudeB(int[] gain) {
		// Here we do the same as before, but on the fly without storing the prefix sums in an array
		int max = Integer.MIN_VALUE;
		int sum = 0;

		for(int num : gain) {
			sum += num;
			max = Math.max(max, sum);
		}

		// Return max between current max and zero in case max is a negative number
		return Math.max(max, 0);
	}
}
