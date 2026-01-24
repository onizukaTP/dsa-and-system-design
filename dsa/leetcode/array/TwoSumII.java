/**
 * Leetcode 167: Two Sum II (Input array is sorted)
 *
 * Approach:
 * - Since the array is sorted, use two pointers.
 * - Initialize left at index 0 and right at index n - 1.
 * - While left < right:
 *     - If nums[left] + nums[right] == target, return the 1-based indices.
 *     - If the sum is smaller than target, move left right to increase the sum.
 *     - If the sum is larger than target, move right left to decrease the sum.
 *
 * Time Complexity: O(n)
 * - Each pointer moves at most n times, and each step does O(1) work.
 *
 * Space Complexity: O(1)
 * - Only constant extra space is used.
 */

package dsa.leetcode.array;

public class TwoSumII {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target)
                return new int[] {i+1, j+1};
            else if (nums[i] + nums[j] < target)
                i++;
            else j--;
        }
        return new int[0];
    }
}
