package org.example.easy;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();

        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        for (int i=0; i<s.length(); i++) {
            Character character = s.charAt(i);

            if (stack.isEmpty() || map.get(character) == null) stack.push(character);
            else if(map.get(character) != stack.peek()) return false;
            else stack.pop();
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "[]";
        Boolean result = solution(input);
        Boolean expected = true;

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);
    }
}