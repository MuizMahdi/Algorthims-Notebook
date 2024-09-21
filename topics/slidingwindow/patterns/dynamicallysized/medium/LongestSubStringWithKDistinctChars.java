package topics.slidingwindow.patterns.dynamicallysized.medium;

import utils.Utils;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * Example:
 * Input:  String = "araaci", K = 2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 */
public class LongestSubStringWithKDistinctChars {
    private static final Logger log = Logger.getLogger(LongestSubStringWithKDistinctChars.class.getSimpleName());

    public static void main(String[] args) {
        log.info(Utils.equal(findLength("araaci", 2), 4));
        log.info(Utils.equal(findLength("cbbebi", 3), 5));
    }

    private static int findLength(String str, int k) {
        int maxSubStrLength = Integer.MIN_VALUE;
        var charFrequencies = new HashMap<Character, Integer>();

        int start = 0;
        for (int end = 0; end < str.length(); end++) {

            // Add character at end
            Character charAtEnd = str.charAt(end);
            charFrequencies.put(charAtEnd, charFrequencies.getOrDefault(charAtEnd, 0) + 1);

            while (charFrequencies.size() > k) {

                // Remove character at start
                Character charAtStart = str.charAt(start);
                charFrequencies.put(charAtStart, charFrequencies.get(charAtStart) - 1);

                if (charFrequencies.get(charAtStart) == 0) {
                    charFrequencies.remove(charAtStart);
                }

                start++;

            }

            int currentWindowLength = end - start + 1;
            maxSubStrLength = Math.max(maxSubStrLength, currentWindowLength);
        }

        return maxSubStrLength == Integer.MIN_VALUE ? 0 : maxSubStrLength;
    }
}
