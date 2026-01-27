/**
 * Leetcode #977: Squares of a sorted array
 * 
 * Uses two-pointer technique to fill result from largest to smallest square.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for output array, O(1) auxiliary space
 */

package dsa.leetcode.array;

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n-1;
        int idx = n-1;
        while(left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];
            if (leftSq > rightSq) {
                res[idx--] = leftSq;
                left++;
            } else {
                res[idx--] = rightSq;
                right--;
            }
        }
        return res;
    }
}
