/**
 * LeetCode #125: Valid Palindrome
 *
 * Checks whether a given string is a palindrome, considering only
 * alphanumeric characters and ignoring case.
 *
 * Approach:
 * - Use two pointers starting from both ends of the string.
 * - Skip non-alphanumeric characters.
 * - Compare characters case-insensitively.
 *
 * Time Complexity: O(n), where n is the length of the string.
 * Space Complexity: O(1), constant extra space.
 */

package dsa.leetcode.string;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l)))
                l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r)))
                r--;
            char left = Character.toLowerCase(s.charAt(l));
            char right = Character.toLowerCase(s.charAt(r));
            if (left != right) return false;
            l++;
            r--;
        }
        return true;
    }
}
