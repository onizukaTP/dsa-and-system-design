/**
 * Leetcode 11: Container With Most Water
 *
 * Problem:
 * - Given an array where each element represents the height of a vertical line,
 *   find two lines that together with the x-axis form a container that holds the most water.
 *
 * Approach (Two Pointers):
 * - Initialize two pointers: one at the start (left) and one at the end (right) of the array.
 * - At each step, compute the area formed by the lines at these two pointers:
 *     area = (right - left) * min(height[left], height[right])
 * - Update the maximum area found so far.
 * - Move the pointer that points to the shorter line inward, since moving the taller line
 *   cannot increase the area when the limiting height is unchanged.
 * - Continue until the two pointers meet.
 *
 * Time Complexity: O(n)
 * - Each pointer moves inward at most n times, and each step does constant work.
 *
 * Space Complexity: O(1)
 * - Uses only constant extra space.
 */

package dsa.leetcode.array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right -left) * (Math.min(height[right], height[left]));
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right])
                left++;
            else right--;
        }
        return maxArea;
    }
}
