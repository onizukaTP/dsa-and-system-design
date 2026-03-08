package neetcode150;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true
 * if the two strings are anagrams of each other, 
 * otherwise return false.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }
        return map.isEmpty();
    }
}
