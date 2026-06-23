package org.tsalko.leetcode;

/**
 * Longest palindromic substring
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LeetCode005_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxLen = 1;
        int maxFrom = 0;
        int maxTo = 1;

        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);

            // check the same symbols prior current
            int j = i - 1;
            char prev = s.charAt(j);
            while (j >= 0 && prev == current) {
                j--;
                prev = j >= 0 ? s.charAt(j) : ' ';
            }
            if (i - j > maxLen) {
                maxLen = i - j;
                maxFrom = j + 1;
                maxTo = i + 1;
            }

            // check backward and forward, using current as center (k==2) or two similar current in center (k==2)
            for (int k = 1, leftOffset = k, rightOffset = 1;
                 k <= 2 && (k == 1 || i >= 2 && current == s.charAt(i - 1));
                 k++, rightOffset = 1, leftOffset = k) {

                prev = s.charAt(i - leftOffset);
                char next = i + rightOffset < s.length() ? s.charAt(i + rightOffset) : ' ';
                while (i - leftOffset >= 0 && i + rightOffset < s.length() && prev == next) {
                    leftOffset++;
                    rightOffset++;
                    prev = i - leftOffset >= 0 ? s.charAt(i - leftOffset) : ' ';
                    next = i + rightOffset < s.length() ? s.charAt(i + rightOffset) : ' ';
                }
                if (leftOffset + rightOffset - 1 > maxLen) {
                    maxLen = leftOffset + rightOffset - 1;
                    maxFrom = i - leftOffset + 1;
                    maxTo = i + rightOffset;
                }
            }
        }

        return s.substring(maxFrom, maxTo);
    }
}