/**
 * Leetcode #739: Daily Temperatures
 *
 * Pattern:
 * - Monotonic Decreasing Stack (stores indices)
 *
 * Invariant:
 * - Stack maintains indices of days with temperatures in strictly decreasing order.
 * - For any index in the stack, we have not yet found a warmer future day.
 *
 * Approach:
 * - Iterate from left to right.
 * - For each day i:
 *   - While the current temperature is warmer than the temperature at the index
 *     on top of the stack, we have found the "next warmer day" for that index.
 *     Pop it and record the distance.
 *   - Push the current index onto the stack.
 *
 * Time Complexity: O(n) — each index pushed and popped at most once
 * Space Complexity: O(n) — stack in worst case stores all indices
 */

package dsa.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        return answer;
    }
}
