/**
 * LeetCode #287: Find the Duplicate Number
 *
 * Key idea:
 * - Treat the array as a linked list where index -> nums[index]
 * - A duplicate value creates a cycle in this structure
 *
 * Approach:
 * - Use Floyd’s Tortoise and Hare algorithm
 *   Phase 1: Detect a meeting point inside the cycle
 *   Phase 2: Reset one pointer to the start and move both pointers
 *            one step at a time to find the cycle entry (duplicate)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

package dsa.leetcode.linkedlist;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}