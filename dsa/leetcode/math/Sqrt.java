/**
 * LeetCode #69: Sqrt(x)
 *
 * Approach:
 * - Use binary search to find the integer square root of x.
 *
 * Time Complexity: O(log n) — binary search over the range [1, x].
 * Space Complexity: O(1) — constant extra space.
 */

package dsa.leetcode.math;

class Sqrt {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midSquared = (long) mid * mid;
            if (midSquared == x) return mid;
            else if (midSquared > x) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
}