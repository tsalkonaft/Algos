package org.tsalko.leetcode;

import java.util.*;

/**
 * Merge Intervals
 * <p>
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * <p>
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * <p>
 * Example 3:
 * Input: intervals = [[4,7],[1,4]]
 * Output: [[1,7]]
 * Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 * <p>
 * Constraints:
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class LeetCode056_MergeIntervals {

    public static final int MAX = 10000;

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }

        int[][] sorted = sort(intervals);

        List<int[]> result = new ArrayList<>();
        result.add(sorted[0]);

        for (int i = 1; i < sorted.length; i++) {
            int[] current = sorted[i];
            int[] lastResult = result.getLast();
            if (current[0] <= lastResult[1]) {
                lastResult[1] = Math.max(current[1], lastResult[1]);
            } else {
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    private int[][] sort(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]));
        return intervals;
    }

    public int[][] merge2(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        // Map intervals to BitSet and collect empty intervals
        TreeSet<Integer> emptyIntervalsIndexes = new TreeSet<>();
        BitSet bitSet = new BitSet(MAX);
        for (int[] interval : intervals) {
            bitSet.set(interval[0], interval[1]);
            if (interval[0] == interval[1]) {
                emptyIntervalsIndexes.add(interval[0]);
            }
        }

        int from = bitSet.nextSetBit(0);
        while (from != -1) {
            int to = bitSet.nextClearBit(from + 1);

            handleEmptyIntervals(emptyIntervalsIndexes, to, from, result);

            boolean finished = false;
            if (to == -1) {
                finished = true;
                to = MAX - 1;
            }
            result.add(new int[]{from, to});

            if (!finished) {
                from = bitSet.nextSetBit(to + 1);
            }
        }

        // handle empty intervals that are left
        for (Integer emptyIntervalsIndex : emptyIntervalsIndexes) {
            result.add(new int[]{emptyIntervalsIndex, emptyIntervalsIndex});
        }

        return result.toArray(new int[result.size()][]);
    }

    private static void handleEmptyIntervals(TreeSet<Integer> emptyIntervalsIndexes, int to, int from, List<int[]> result) {
        boolean foundEmptyInterval;
        do {
            foundEmptyInterval = false;
            if (!emptyIntervalsIndexes.isEmpty()) {
                Integer first = emptyIntervalsIndexes.getFirst();
                if (first <= to) {
                    if (first < from) {
                        result.add(new int[]{first, first});
                    }
                    emptyIntervalsIndexes.remove(first);
                    foundEmptyInterval = true;
                }
            }
        } while (foundEmptyInterval);
    }

}
