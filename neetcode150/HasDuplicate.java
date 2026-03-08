package neetcode150;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true 
 * if any value appears more than once in the array, 
 * otherwise return false.
 */

public class HasDuplicate {
    public boolean hasDuplicate(int[] nums) {
       Set<Integer> set = new HashSet<>();
       for (int num : nums) set.add(num);
       return set.size() != nums.length;
    }
}
