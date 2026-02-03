/*
 LeetCode 325: Maximum Size Subarray Sum Equals k
 ------------------------------------------------
 Problem:
 Given an integer array nums (can contain negative numbers)
 and an integer k, return the maximum length of a subarray
 whose sum equals k.

 Key Observations:
 - Subarray → contiguous
 - Negative numbers allowed → sliding window DOES NOT work
 - We need an O(n) solution

 Core Pattern:
 Prefix Sum + HashMap (store earliest index)

 Prefix Sum Idea:
 prefixSum[j] = nums[0] + nums[1] + ... + nums[j]

 If:
 prefixSum[j] - prefixSum[i] = k

 Then:
 Subarray from (i + 1) to j has sum k
 Length = j - i

 Why HashMap?
 - To quickly check if (prefixSum - k) has appeared before
 - We store the EARLIEST index to maximize subarray length

  Time Complexity:
 O(n) — single pass through the array

 Space Complexity:
 O(n) — hashmap stores prefix sums

 Why Sliding Window Fails:
 - Negative numbers break monotonicity of sum

 When to Use This Pattern:
 - Subarray problems
 - Sum equals k / divisible by k
 - Negative numbers allowed
 - Asked for longest or count
*/
package dsa.leetcode.prefixsum_hashmap;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarraySumEqualsK {
    public static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int prefixSum = 0;
        for (int j = 0; j < nums.length; j++) {
            prefixSum += nums[j];
            if (map.containsKey(prefixSum - k)) {
                int i = map.get(prefixSum - k);
                maxLen = Math.max(maxLen, j - i);
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, j);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArrayLen(new int[] {1,2,3,-1,5,-2,7}, 9));
    }
}
