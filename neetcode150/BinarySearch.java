package neetcode150;

/**
 * Time: O(log n)
 * Space: O(1) (iterative)
 */
public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
