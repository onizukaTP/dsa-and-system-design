/**
 * LeetCode 560: Subarray Sum Equals K
 *
 * Problem:
 * Given an integer array nums (can contain negative numbers)
 * and an integer k, return the total number of continuous
 * subarrays whose sum equals k.
 *
 * Pattern:
 * Prefix Sum + HashMap (Frequency Map)
 *
 * Key Insight:
 * Let prefixSum[j] be the sum of elements from index 0 to j.
 * If prefixSum[j] - prefixSum[i] = k,
 * then the subarray (i + 1) to j has sum k.
 *
 * For counting subarrays:
 * - We store how many times each prefix sum has appeared
 * - Each occurrence of (prefixSum - k) contributes to the count
 *
 * Why HashMap:
 * - Enables O(1) lookup of previous prefix sums
 * - Handles negative numbers (sliding window fails)
 *
 * Initialization:
 * map.put(0, 1) handles subarrays that start at index 0
 *
 * Time Complexity:
 * O(n) — single pass through the array
 *
 * Space Complexity:
 * O(n) — hashmap stores prefix sum frequencies
 */

package dsa.leetcode.prefixsum_hashmap;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            prefixSum += nums[j];
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
