package topics.intervals.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/insert-interval/description/">LeetCode</a>
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean isInserted = false;

        for (int[] interval : intervals) {
            int intervalStart = interval[0];
            int intervalEnd = interval[1];
            int newIntervalStart = newInterval[0];
            int newIntervalEnd = newInterval[1];

            // Interval before new interval
            if (intervalEnd < newIntervalStart) {
                result.add(interval);
            }
            // Interval after new interval
            else if (newIntervalEnd < intervalStart) {
                if (!isInserted) {
                    result.add(newInterval);
                    isInserted = true;
                }
                result.add(interval);
            }
            // Interval overlapping with new interval
            else {
                // Merge intervals
                newInterval[0] = Math.min(intervalStart, newIntervalStart);
                newInterval[1] = Math.max(intervalEnd, newIntervalEnd);
            }
        }

        if (!isInserted) {
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }
}
