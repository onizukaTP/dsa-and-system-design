/**
 * #9 Leetcode : Palindrome Number
 *
 * Approach:
 * - Store each digit in a list
 * - Use left and right pointers to check equality
 * - Negative numbers are not palindromes
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */


package dsa.leetcode.array;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome (int x) {
        if (x < 0) return false;
        List<Integer> digits = new ArrayList<>();
        int temp = x;
        while (temp > 0) {
            digits.add(temp % 10);
            temp /= 10;
        }
        int left = 0;
        int right = digits.size() - 1;
        while (left < right) {
            if (digits.get(left) != digits.get(right))
                return false;
            left++;
            right--;
        }
        return true;
    } 
}
