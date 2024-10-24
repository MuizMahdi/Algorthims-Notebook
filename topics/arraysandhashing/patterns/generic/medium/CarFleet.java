package topics.arraysandhashing.patterns.generic.medium;

import utils.Problem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/car-fleet/">LeetCode</a>
 */
public class CarFleet extends Problem {
    // O(nlogn)
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2]; // position-speed pairs

        // Construct cars array by combining positions and speeds
        for (int i=0; i<n; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }

        // Sort cars in descending order by position
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        int fleetCount = 0;
        double slowestTime = 0;

        for (int[] car : cars) {
            int carPosition = car[0];
            int carSpeed = car[1];

            // Calculate time to reach target for car >>> Time = Distance/Speed.
            // Time needs to be in double for precision
            double timeToTarget = (double) (target - carPosition) / carSpeed;

            // If this car is slower (takes longer) than previous slowest
            if (timeToTarget > slowestTime) {
                // It becomes the lead car of a new fleet
                fleetCount++;
                // It becomes the slowest
                slowestTime = timeToTarget;
            }
        }

        return fleetCount;
    }

    // O(n)
    public int carFleetB(int target, int[] position, int[] speed) {
        int fleets = 0;
        double[] timeArr = new double[target];

        // Populate the time array
        for (int i=0; i<position.length; i++) {
            timeArr[position[i]] = (double)(target - position[i]) / speed[i];
        }

        double slowestTime = 0.0;
        // Iterate from target to start, checking for new fleets
        for (int i = target-1; i>=0; i--) {
            double cur = timeArr[i];
            if (cur > slowestTime) {
                slowestTime = cur;
                fleets++;
            }
        }

        return fleets;
    }
}
