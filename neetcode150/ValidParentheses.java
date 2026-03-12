package neetcode150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time: O(n)
 * Space: O(n)
 */
public class ValidParentheses {
    public boolean validParantheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (ch == '}' && top != '{' ||
                    ch == ']' && top != '[' ||
                    ch == ')' && top != '(' 
                ) return false;
            }
        }
        return stack.isEmpty();
    }
}
