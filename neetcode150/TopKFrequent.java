package neetcode150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time: O(n log n) -> sorting occurs
 * Space: O(n)
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) 
            map.put(num, map.getOrDefault(nums, 0) + 1);

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> map.get(b) - map.get(a));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) 
            res[i] = list.get(i);

        return res;
    }
}
