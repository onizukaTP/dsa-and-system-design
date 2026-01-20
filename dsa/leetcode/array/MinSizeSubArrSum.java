package dsa.leetcode.array;

/**
 * LeetCode 209 — Minimum Size Subarray Sum
 *
 * Pattern:
 * - Variable Sliding Window
 *
 * Why Sliding Window:
 * - We are working with a contiguous subarray
 * - All numbers are positive, so expanding the window increases the sum
 * - This allows us to shrink the window greedily once it becomes valid
 *
 * Window Invariant:
 * - The window [left, right] is valid when sum >= target
 *
 * Approach:
 * - Expand the window by moving the right pointer and adding to sum
 * - Once sum >= target, shrink the window from the left
 *   to find the minimum length while maintaining validity
 * - Update the minimum length during the shrinking phase
 *
 * Time Complexity:
 * - O(n), since both left and right pointers move forward at most n times
 *
 * Space Complexity:
 * - O(1), only constant extra variables are used
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, (right - left) + 1);
                sum -= nums[left];
                left++;
            }                
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
