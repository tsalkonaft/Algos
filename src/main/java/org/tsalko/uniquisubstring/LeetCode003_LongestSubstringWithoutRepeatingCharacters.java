package org.tsalko.uniquisubstring;

import java.util.HashSet;
import java.util.Set;

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
