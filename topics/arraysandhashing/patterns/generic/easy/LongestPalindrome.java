package topics.arraysandhashing.patterns.generic.easy;

import utils.Problem;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome extends Problem {
    public int longestPalindrome(String s) {
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();

        for (char letter : s.toCharArray()) {
            if (charSet.contains(letter)) { // On 2nd encounter (even number), add two, then "reset the count"
                maxLength += 2;
                charSet.remove(letter);
            } else {
                charSet.add(letter);
            }
        }

        if (!charSet.isEmpty()) { // In case there's still a character left (odd number), add one to account for it
            maxLength++;
        }

        return maxLength;
    }
}
