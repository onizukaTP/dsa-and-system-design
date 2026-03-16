package neetcode150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    /**
     * Time: O(n log n)
     * Space: O(1)
     * 
     * @param nums
     * @return
     */
    public int longestConsequtive1 (int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 1;
        int curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] == nums[i - 1] + 1) curr++;
            else {
                longest = Math.max(curr, longest);
                curr = 1;
            }
        }
        return Math.max(longest, curr);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * 
     * @param nums
     * @return
     */
    public int longestConsequtive2 (int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int length = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    length++;
                }

                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}
