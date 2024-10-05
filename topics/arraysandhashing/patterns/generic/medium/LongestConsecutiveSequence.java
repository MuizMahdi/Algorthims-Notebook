package topics.arraysandhashing.patterns.generic.medium;

import utils.Problem;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence extends Problem {

    public static void main(String[] args) {
        int[] input = {0,3,7,2,5,8,4,6,0,1};
        int output = 9;
        log(longestConsecutive(input) == output);
    }

    public static int longestConsecutive(int[] nums) {

        // Fill up the set
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;
        for (int num : nums) {
            boolean isSequenceStart = !numSet.contains(num-1);

            if (isSequenceStart) {
                int currentNum = num;
                int currentStreak = 1;

                while(numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }

        return longestStreak;
    }
}
