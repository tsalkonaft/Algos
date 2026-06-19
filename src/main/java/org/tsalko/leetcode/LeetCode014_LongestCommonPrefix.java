package org.tsalko.leetcode;

/**
 * Longest common prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters if it is non-empty.
 */
public class LeetCode014_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int index = 0;

        while (true) {
            if (index == strs[0].length()) {
                return result.toString();
            }
            char currentChar = strs[0].charAt(index);

            for (int i = 1; i < strs.length; i++) {
                if (index == strs[i].length() || strs[i].charAt(index) != currentChar) {
                    return result.toString();
                }
            }

            result.append(currentChar);
            index++;
        }
    }
}
