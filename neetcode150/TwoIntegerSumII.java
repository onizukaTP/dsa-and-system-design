package neetcode150;

import java.util.HashMap;
import java.util.Map;

public class TwoIntegerSumII {

    /**
     * Time: O(n)
     * Space: O(n)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoIntegerSumII1 (int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] {map.get(complement) + 1, i + 1};
            }

            map.put(nums[i], i);
        }
        return new int[] {};
    }

    /**
     * Time: O(n)
     * Space: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoIntegerSumII2 (int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return new int[] {left + 1, right + 1};
            else if (sum < target) left++;
            else right--;
        }
        return new int[]{};
    }
}
