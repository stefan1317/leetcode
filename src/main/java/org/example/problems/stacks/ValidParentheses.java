package org.example.problems.stacks;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(validParentheses("]]"));
    }

    public static boolean validParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c == ')' && stack.pop() != '(') {
                return false;
            } else if (c == '}' && stack.pop() != '{') {
                return false;
            } else if (c == ']' && stack.pop() != '[') {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
