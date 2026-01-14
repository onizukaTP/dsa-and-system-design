/**
 * #169 Leetcode: Majority Element
 * 
 * Approach 
 * - Make a frequency map for the element
 * - Check for every entry if it's greater than size / 2
 * - If yes, return that element
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
*/

package dsa.leetcode.array;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("No solution");
    }
}