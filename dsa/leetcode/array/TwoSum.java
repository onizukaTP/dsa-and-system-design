/**
 * #1 Leetcode: Two Sum
 * 
 * Approach (Optimal):
 * - Use a HashMap to store each number as the key and its index as the value
 * - For each element, check if its complement (target - current number) exists in the map
 * - If found, return the indices of the complement and the current element
 * - Otherwise, store the current number and its index in the map
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
*/

package dsa.leetcode.array;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[] {map.get(complement), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }
}
