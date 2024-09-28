package topics.arraysandhashing.patterns.bucketsort.problems.medium;

import java.util.*;
import java.util.logging.Logger;

public class SortCharactersByFrequency {
    private static final Logger log = Logger.getLogger(SortCharactersByFrequency.class.getSimpleName());

    public static void main(String[] args) {
        String input = "tree";
        String expectedOutput = "eert";
        String actualOutput = frequencySort(input);
        boolean result = frequencySort(input).equals(expectedOutput);
        log.info(actualOutput);
        log.info(String.valueOf(result));
    }

    public static String frequencySort(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        // Create and fill up frequencies map
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char letter : s.toCharArray()) {
            frequencies.put(letter, frequencies.getOrDefault(letter, 0) + 1);
        }

        // Create and fill up frequencies buckets
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char letter : frequencies.keySet()) {
            int letterFrequency = frequencies.get(letter);

            if (buckets[letterFrequency] == null) {
                buckets[letterFrequency] = new ArrayList<>();
            }

            buckets[letterFrequency].add(letter);
        }

        // Create a string based on frequencies
        StringBuilder resultBuilder = new StringBuilder();
        for (int i=buckets.length-1; i>=0; i--) {
            if (buckets[i] != null) {
                for (char letter : buckets[i]) { // For each letter in the bucket
                    for (int j=0; j<i; j++) { // Loop through frequency (i)
                        // Append a character to the result a number of times equal to its frequency
                        resultBuilder.append(letter);
                    }
                }
            }
        }

        return resultBuilder.toString();
    }
}
