/**
 * #344 Leetcode: Reverse string
 * 
 * Approach 
 * - Use two pointers: one at the beginning and one at the end.
 * - Swap both and increment left pointer and decrement right pointer.
 * - Do this till the left pointer is less than the right pointer.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
*/

package dsa.leetcode.array;

class ReverseString {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}