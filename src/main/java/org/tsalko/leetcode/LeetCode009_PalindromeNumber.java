package org.tsalko.leetcode;

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 */
public class LeetCode009_PalindromeNumber {

    public static boolean isPalindromeUsingString(int x) {
        String value = String.valueOf(x);
        if (value.length() == 1) {
            return true;
        }

        int left = 0;
        int right = value.length() - 1;
        while (left < right) {
            if (value.charAt(left++) != value.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long leftMultiplier = getLeftMultiplier(x);
        long rightMultiplier = 10;
        while (leftMultiplier > rightMultiplier) {
            byte leftDigit = (byte) (x * 10L / leftMultiplier % 10);
            byte rightDigit = (byte) (x % rightMultiplier * 10 / rightMultiplier);
            if (leftDigit != rightDigit) {
                return false;
            }
            leftMultiplier /= 10;
            rightMultiplier = rightMultiplier > 0 ? rightMultiplier * 10 : 10;
        }
        return true;
    }

    private static long getLeftMultiplier(int x) {
        long multiplier = 10;
        while (x >= multiplier) {
            multiplier *= 10;
        }
        return multiplier;
    }

}
