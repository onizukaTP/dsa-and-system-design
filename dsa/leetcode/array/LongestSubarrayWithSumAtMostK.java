/**
 * Longest Subarray with Sum At Most K
 *
 * Pattern:
 * - Variable-size Sliding Window
 *
 * Key Insight:
 * - All numbers in the array are positive.
 * - Expanding the window (moving `right`) increases the sum.
 * - Shrinking the window (moving `left`) decreases the sum.
 * - This monotonic behavior allows a sliding window approach.
 *
 * Invariant:
 * - The window [left, right] always represents a subarray
 *   whose sum is <= k after the while-loop finishes.
 *
 * Time Complexity:
 * - O(n): each pointer moves forward at most n times.
 *
 * Space Complexity:
 * - O(1): constant extra space.
 *
 * Note:
 * - This approach does NOT work if the array contains negative numbers.
 */
package dsa.leetcode.array;

public class LongestSubarrayWithSumAtMostK {
    public int longestSubarrayWithSumAtMostK(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int result = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}