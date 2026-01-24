/**
 * #283 Leetcode
 * 
 * Approach 
 * - Two pointers with conditional advance and swapping
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
*/

package dsa.leetcode.array;

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == 0 && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            } else if (nums[i] != 0 && nums[j] == 0) i++;
            else j++;
        }
    }
}