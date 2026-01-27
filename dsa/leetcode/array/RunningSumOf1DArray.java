/**
 * LeetCode #1480: Running Sum of 1D Array
 *
 * Computes the prefix sum of the array.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for output array, O(1) auxiliary space
 */

package dsa.leetcode.array;

public class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans[i] = sum;
        }
        return ans;
    }
}
