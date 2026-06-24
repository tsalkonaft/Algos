package org.tsalko.leetcode;

/**
 * Zigzag conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I     N
 * A   L S   I G
 * Y A   H R
 * P     I
 * <p>
 * Example 3:
 * Input: s = "A", numRows = 1
 * Output: "A"
 */
public class LeetCode006_ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        // we will not build matrix, lets have it virtual and find a result by one go through the string
        int length = s.length();

        // iterate virtual matrix
        char[] result = new char[length];
        int i = 0;

        for (int x = 0; x * 2 < length; x += numRows - 1) {
            result[i++] = s.charAt(x * 2);
        }

        for (int y = 1; y < numRows - 1; y++) {
            for (int x = 0; x * 2 + y < length; x += x % (numRows - 1) == 0 ? numRows - y - 1 : y) {
                result[i++] = s.charAt(x * 2 + y);
            }
        }

        for (int x = 0, y = numRows - 1; x * 2 + y < length; x += numRows - 1) {
            result[i++] = s.charAt(x * 2 + y);
        }

        return new String(result);
    }
}
