package org.tsalko.leetcode;

import java.util.*;

public class AllSubstringsOfGivenLengthWithUniqueChars {

    /**
     * Input: s = "abcabcbb", k = 3
     * Output: ["abc", "bca", "cab"]
     * <p>
     * Input: s = "aaabc", k = 3
     * Output: ["abc"]
     *
     */
    public static Set<String> findSubstringsWithUniqueChars(String s, int k) {
        int textLength = s.length();
        if (k > textLength) {
            return Collections.emptySet();
        }
        Set<String> result = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            addNewCharToMap(s, map, i);
        }

        for (int i = 0; i <= textLength - k; i++) {
            if (map.size() == k) {
                result.add(s.substring(i, i + k));
            }

            removeFirstCharFromMap(s, map, i);

            if (i + k < textLength) {
                addNewCharToMap(s, map, i + k);
            }
        }
        return result;
    }

    private static void removeFirstCharFromMap(String s, Map<Character, Integer> map, int i) {
        Integer count = map.get(s.charAt(i));
        if (count == 1) {
            map.remove(s.charAt(i));
        } else {
            map.put(s.charAt(i), count - 1);
        }

    }

    private static void addNewCharToMap(String s, Map<Character, Integer> map, int i) {
        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
}
