/**
 * LeetCode #20: Valid Parentheses
 *
 * Problem:
 * Given a string containing only the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * Approach:
 * Use a stack to track opening brackets.
 * - Push opening brackets onto the stack.
 * - For each closing bracket, check if it matches the top of the stack.
 * - If at any point there is a mismatch or the stack is empty when a closing
 *   bracket appears, the string is invalid.
 * - At the end, the stack must be empty for the string to be valid.
 *
 * Time Complexity: O(n)
 *   Each character is processed once; each bracket is pushed and popped at most once.
 *
 * Space Complexity: O(n)
 *   In the worst case (all opening brackets), the stack stores all n characters.
 */

package dsa.leetcode.stack;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}