package topics.arraysandhashing.patterns.generic.medium;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/">LeetCode</a>
 * <p>
 * Given an array of strings, group the anagrams together. You can return the answer in any order.
 * Input: ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * </p>
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String sortedStr = new String(strChars);

            if (!anagrams.containsKey(sortedStr)) {
                anagrams.put(sortedStr, new ArrayList<>());
            }

            anagrams.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }
}
