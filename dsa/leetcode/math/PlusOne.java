/**
 * #66 Leetcode: Plus One
 * 
 * Approach 
 * - Traverse the array from right to left
 * - If the digit is less than 9, increment it and return
 * - If the digit is 9, set it to 0 and continue carrying
 * - If all digits are 9, create a new array with a leading 1
 * 
 * Time complexity: O(n)
 * Space complexity: O(n) in the worst case, O(1) otherwise
*/

package dsa.leetcode.math;

class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        for (int j = n; j >= 0; j--) {
            if (digits[j] == 9) {
                digits[j] = 0;
                if (j == 0) {
                    int[] res = new int[digits.length + 1];
                    res[0] = 1;
                    return res;
                }
            }
            else {
                digits[j] += 1;
                break;
            }
        }
        return digits;
    }
}