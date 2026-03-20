package neetcode150;

import java.util.Stack;

public class DailyTemperatures {
    /**
     * Time: O(n^2)
     * Space: O(1)
     * 
     * @param temps
     * @return
     */
    public int[] dailyTemperatures1 (int[] temps) {
        int n = temps.length;
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temps[i] < temps[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * 
     * @param temps
     * @return
     */
    public int[] dailyTemperatures2 (int[] temps) {
        int n = temps.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     * 
     * @param temps
     * @return
     */
    public int[] dailyTemperatures3 (int[] temps) {
        int n = temps.length;
        int[] res = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && temps[j] <= temps[i]) {
                if (res[j] == 0) {
                    j = n; // no warmer days
                } else {
                    j = j + res[j]; // jump forward
                }
            }
            if (j < n) {
                res[i] = j - i;
            }
        }
        return res;
    }
}
