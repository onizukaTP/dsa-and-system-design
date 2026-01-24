/**
 * #35 Leetcode: Search Insert Position
 * 
 * Approach 
 * - Binary search to find the target
 * - If found return the index
 * - If not found, the loop ends with left pointing to the correct insertion index.
 * 
 * Time complexity: O(log n)
 * Space complexity: O(1)
*/

package dsa.leetcode.array;

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;  
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}