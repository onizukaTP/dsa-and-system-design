package dsa.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Leetcode 118: PascalTriangle
 */
public class PascalTriangle {
    static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> rows = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    rows.add(1);
                } else {
                    List<Integer> prev = triangle.get(i - 1);
                    rows.add(prev.get(j - 1) + prev.get(j));
                }
            }
            triangle.add(rows);
        }

        return triangle;
    }
}
