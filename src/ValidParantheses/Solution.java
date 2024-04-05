package ValidParantheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Stack;

class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (final char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
