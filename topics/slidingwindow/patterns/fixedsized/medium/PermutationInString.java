package topics.slidingwindow.patterns.fixedsized.medium;

import utils.Problem;

import java.util.Arrays;

public class PermutationInString extends Problem {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1LetterCount = new int[26];
        int[] s2LetterCount = new int[26];

        for (int i=0; i<s1.length(); i++) {
            int s1LetterValue = s1.charAt(i) - 'a';
            s1LetterCount[s1LetterValue]++;
        }

        int start = 0;
        for (int end = 0; end < s2.length(); end++) {
            int endLetterVal = s2.charAt(end) - 'a';
            s2LetterCount[endLetterVal]++;

            int firstWindowIndex = s1.length() - 1;
            if (end > firstWindowIndex) {
                int startLetterVal = s2.charAt(start) - 'a';
                s2LetterCount[startLetterVal]--;
                start++;
            }

            if (Arrays.equals(s1LetterCount, s2LetterCount)) { // O(1) operation because arrays are always int[26]
                return true;
            }
        }

        return false;
    }
}
