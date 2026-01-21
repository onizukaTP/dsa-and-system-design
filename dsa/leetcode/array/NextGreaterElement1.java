/**
 * Leetcode #496: Next Greater Element I
 *
 * Pattern:
 * - Monotonic Decreasing Stack (Next Greater Element to the Right)
 *
 * Approach:
 * - Scan nums2 from right to left
 * - Maintain a decreasing stack of candidates
 * - Map each value in nums2 to its next greater element
 * - Answer queries from nums1 using the map
 *
 * Time Complexity:
 * - O(n + m)
 *   - O(m) to process nums2 with amortized stack operations
 *   - O(n) to fill the answer from the map
 *
 * Space Complexity:
 * - O(n + m)
 *   - Stack up to m
 *   - HashMap up to m
 *   - Answer array size n
 *
 * Assumption:
 * - nums2 contains unique elements (required for value-based mapping)
 */

package dsa.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            int nextGreater = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], nextGreater);
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}