package topics.intervals.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals based on start time
        Arrays.sort(intervals, (intervalA, intervalB) -> Integer.compare(intervalA[0], intervalB[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int[] interval : intervals) {
            int[] lastAddedInterval = result.get(result.size() - 1);
            int intervalStart = interval[0];
            int intervalEnd = interval[1];
            int lastAddedIntervalEnd = lastAddedInterval[1];

            boolean isOverlapping = intervalStart <= lastAddedIntervalEnd;
            if (isOverlapping) {
                // Merge the intervals (by stretching the last added interval)
                lastAddedInterval[1] = Math.max(lastAddedIntervalEnd, intervalEnd);
            } else {
                // Add the non-overlapping interval
                result.add(interval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
