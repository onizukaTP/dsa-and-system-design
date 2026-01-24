/**
 * #169 Leetcode: Majority Element
 *
 * Approach (Boyer–Moore Voting Algorithm)
 * - Maintain a candidate and a counter
 * - If count is 0, set the current element as the new candidate
 * - If the current element equals the candidate, increment the count
 * - Otherwise, decrement the count
 * - After one pass, the candidate is the majority element
 *   (problem guarantees that a majority element exists)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

package dsa.leetcode.array;

class MajorityElement {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int candidate = 0;
        for (int num : nums) {
            if (cnt == 0) candidate = num;
            cnt += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }
}