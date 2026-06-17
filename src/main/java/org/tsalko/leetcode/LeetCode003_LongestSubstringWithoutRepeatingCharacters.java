package org.tsalko.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest substring without duplicate characters.
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * <p>
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LeetCode003_LongestSubstringWithoutRepeatingCharacters {

    public static String getMaxUniqueSubStringNaive(String text) {
        String result = "";
        for (int i = 0; i < text.length() - result.length(); i++) {
            StringBuilder currentSequence = new StringBuilder();
            for (int j = i + currentSequence.length(); j < text.length(); j++) {
                char currentChar = text.charAt(j);
                if (!currentSequence.isEmpty() && currentSequence.toString().indexOf(currentChar) > -1) {
                    break;
                } else {
                    currentSequence.append(currentChar);
                }
            }
            result = currentSequence.length() > result.length() ? currentSequence.toString() : result;
        }
        return result;
    }

    public static String getMaxUniqueSubStringSlidingWindow(String s) {
        if (s == null || s.isEmpty()) {
            throw new RuntimeException("Wrong input data");
        }

        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currentChar);
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
        }
        return s.substring(start, start + maxLength);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currentChar);
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
            }
        }
        return maxLength;
    }

}
