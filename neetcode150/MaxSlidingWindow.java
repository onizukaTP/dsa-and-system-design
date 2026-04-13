package neetcode150;

import java.util.List;
import java.util.ArrayList;

public class MaxSlidingWindow {
    public static List<Integer> maxSlidingWindow (int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = k - 1;

        while (right != nums.length) {
            int max = subArrayMax(nums, left, right);
            list.add(max);

            left++;
            right++;
        }

        return list;
    }

    public static int subArrayMax (int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        while (left <= right) {
            max = Math.max(max, nums[left]);
            left++;
        }
        return max;
    }

    public static void main (String[] args) {


        System.out.println(maxSlidingWindow(new int[] {1,2,1,0,4,2,6}, 3));
    }
}
