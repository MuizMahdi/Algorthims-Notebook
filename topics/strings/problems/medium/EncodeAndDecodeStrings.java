package topics.strings.problems.medium;

import utils.Problem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/encode-and-decode-strings/">LeetCode</a>
 */
public class EncodeAndDecodeStrings extends Problem {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            // 4/word3/yes
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            // Find the next slash index
            int slashIndex = s.indexOf('/', i);
            // Get the word size numeric value
            int strSize = Integer.parseInt(s.substring(i, slashIndex));
            // Get after slash index
            int afterSlashIndex = slashIndex + 1;
            // Move index to after the word and slash
            i = afterSlashIndex + strSize;
            // Get the word
            String word = s.substring(afterSlashIndex, i);
            list.add(word);
        }

        return list;
    }
}
