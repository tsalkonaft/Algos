package org.tsalko.leetcode;

/**
 * Median of two sorted arrays
 * <p>
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class LeetCode004_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        if (nums1.length == 0) {
            if (nums2.length % 2 == 1) {
                return nums2[nums2.length / 2];
            } else {
                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
            }
        }

        int low = 0;
        int high = nums1.length;
        int partition1 = (low + high + 1) / 2;                                  // nums1 divider
        int partition2 = (nums1.length + nums2.length + 1) / 2 - partition1;    // nums2 divider

        while (partition1 >= low && partition1 <= high) {                       // iteratively apply binary search to find correct dividers
            partition2 = (nums1.length + nums2.length + 1) / 2 - partition1;    // we only manage partition1, partition2 depends on partition1

            if (ensureMinValue(nums1, partition1 - 1) > ensureMaxValue(nums2, partition2)) {
                high = partition1 - 1;
            } else if (ensureMinValue(nums2, partition2 - 1) > ensureMaxValue(nums1, partition1)) {
                low = partition1 + 1;
            } else {
                break;
            }
            partition1 = (low + high + 1) / 2;
        }

        if ((nums1.length + nums2.length) % 2 == 1) { // if total number of two arrays is odd
            return Math.max(
                    ensureMinValue(nums1, partition1 - 1),
                    nums2[partition2 - 1]
            );
        } else {
            return (Math.max(
                    ensureMinValue(nums1, partition1 - 1),
                    ensureMinValue(nums2, partition2 - 1)
            ) + Math.min(
                    ensureMaxValue(nums1, partition1),
                    ensureMaxValue(nums2, partition2))
            ) / 2.0;
        }
    }

    private static int ensureMinValue(int[] nums, int index) {
        return index >= 0 ? nums[index] : Integer.MIN_VALUE;
    }

    private static int ensureMaxValue(int[] nums, int index) {
        return index < nums.length ? nums[index] : Integer.MAX_VALUE;
    }

    public double findMedianSortedArraysByMerge(int[] nums1, int[] nums2) {
        int i1 = 0, i2 = 0, i = 0;
        int[] nums = new int[nums1.length + nums2.length];
        while (i1 < nums1.length || i2 < nums2.length) {
            if (i1 == nums1.length) {
                nums[i] = nums2[i2++];
            } else if (i2 == nums2.length) {
                nums[i] = nums1[i1++];
            } else {
                nums[i] = nums1[i1] <= nums2[i2] ? nums1[i1++] : nums2[i2++];
            }
            i++;
        }

        if (i % 2 == 1) {
            return nums[i / 2];
        } else {
            return (nums[i / 2 - 1] + nums[i / 2]) / 2.0;
        }
    }
}
