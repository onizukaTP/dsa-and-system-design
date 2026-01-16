/**
 * #643 LeetCode: Maximum Average Subarray I
 *
 * Approach:
 * - Compute the sum of the first window of size k.
 * - Initialize maxAvg using the average of this first valid window.
 * - Slide the window across the array:
 *     - Add the next element entering the window.
 *     - Remove the element leaving the window.
 *     - Update maxAvg with the maximum average seen so far.
 *
 * This ensures the window always contains exactly k elements
 * and avoids using arbitrary initial values.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

package dsa.leetcode.array;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        double maxAvg = (double) currSum / k;
        for (int i = k; i < nums.length; i++) {
            currSum += nums[i];
            currSum -= nums[i - k];
            maxAvg = Math.max(maxAvg, (double) currSum/k);
        }
        return maxAvg;
    }
}