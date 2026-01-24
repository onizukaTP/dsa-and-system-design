/**
 * #9 Leetcode : Palindrome Number
 *
 * Approach:
 * - Handle edge cases: negative numbers and numbers ending with 0 (except 0 itself)
 * - Reverse only half of the number by comparing reverse with the remaining part
 * - If the number has an odd number of digits, remove the middle digit from reverse
 * - Compare the two halves to determine if the number is a palindrome
 *
 * Time complexity: O(d), where d is the number of digits
 * Space complexity: O(1)
 */

package dsa.leetcode.array;

class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int temp = x;
        int reverse = 0;
        while (reverse < temp) {
            int digit = temp % 10;
            reverse = reverse * 10 + digit;
            temp /= 10;
        }
        if (reverse > temp) {
            reverse /= 10;
        }
        return reverse == temp;
    }
}
