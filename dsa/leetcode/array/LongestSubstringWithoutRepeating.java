/**
 * LeetCode 3 — Longest Substring Without Repeating Characters
 *
 * Pattern:
 * - Variable Sliding Window
 *
 * Why Sliding Window:
 * - We are working with a contiguous substring
 * - Brute force checking all substrings would be O(n^2)
 * - The window validity (unique characters) can be maintained incrementally
 *
 * Window Invariant:
 * - The window [left, right] always contains unique characters
 *
 * Approach:
 * - Use a HashSet to track characters in the current window
 * - Expand the window by moving the right pointer
 * - If a duplicate character is found, shrink the window from the left
 *   until the duplicate is removed
 * - Update the maximum length when the window is valid
 *
 * Time Complexity:
 * - O(n), since each character is added and removed at most once
 *
 * Space Complexity:
 * - O(min(n, k)), where k is the character set size (worst case O(n))
 */

package dsa.leetcode.array;

import java.util.HashSet;
import java.util.Set;

class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}