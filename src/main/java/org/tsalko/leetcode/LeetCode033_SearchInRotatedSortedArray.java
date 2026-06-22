package org.tsalko.leetcode;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * <p>
 * Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
 * <p>
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * <p>
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 */
public class LeetCode033_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        // Find rotation index
        int low = 0;
        int high = nums.length - 1;
        int rotationIndex = 0;

        int mid = -1;
        if (nums[low] > nums[high]) {
            while (low < high) {
                mid = (high + low) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < nums[0]) {
                    high = mid;
                } else if (nums[mid] > nums[nums.length - 1]) {
                    low = mid;
                } else {
                    rotationIndex = mid;
                    break;
                }
                if (high - low == 1) {
                    rotationIndex = nums[mid] < nums[high] ? mid : high;
                    break;
                }
            }
        }

        if (nums[rotationIndex] == target) {
            return rotationIndex;
        }

        // Determine which sub array to use let or right from rotationIndex
        if (target <= nums[nums.length - 1]) {
            low = rotationIndex;
            high = nums.length;
        } else {
            low = 0;
            high = rotationIndex;
        }

        // Find target in sorted subarray
        while (low < high) {
            mid = (high + low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }

        return -1;
    }
}
