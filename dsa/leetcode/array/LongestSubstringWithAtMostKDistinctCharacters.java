/**
 * LeetCode 340: Longest Substring with At Most K Distinct Characters
 *
 * Pattern:
 * - Variable-size Sliding Window
 *
 * Key Insight:
 * - We maintain a window [left, right] that represents a substring.
 * - A HashMap is used to track the frequency of characters in the window.
 * - If the number of distinct characters exceeds k, the window becomes invalid.
 * - We shrink the window from the left until it becomes valid again.
 *
 * Invariant:
 * - After the shrinking step, the window always contains at most k distinct characters.
 *
 * Time Complexity:
 * - O(n): Each character is added and removed from the window at most once.
 *
 * Space Complexity:
 * - O(k): At most k distinct characters are stored in the map.
 */

package dsa.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int result = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            freq.put(r, freq.getOrDefault(r, 0)+1);

            while (freq.size() > k) {
                char l = s.charAt(left);
                freq.put(l, freq.get(l) - 1);

                if (freq.get(l) == 0) {
                    freq.remove(l);
                }

                left++;
            }

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}