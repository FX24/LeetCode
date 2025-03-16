package org.example.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0,0, n, result, stack);
        return result;
    }

    private static void backtrack(int openCount, int closeCount, int target, List<String> result, StringBuilder stack) {
        if (openCount == closeCount && openCount == target) {
            String parentheses = stack.toString();
            result.add(parentheses);
        }

        if (openCount < target) {
            stack.append("(");
            backtrack(openCount + 1, closeCount, target, result, stack);
            stack.deleteCharAt(stack.length() - 1); // It's used to clear first generated parentheses (after backtrack is done)
        }

        if (closeCount < openCount) {
            stack.append(")");
            backtrack(openCount, closeCount + 1, target, result, stack);
            stack.deleteCharAt(stack.length() - 1); // It's used to clear first generated parentheses (after backtrack is done)
        }
    }

    public static void main(String[] args) {
        int input = 3;
        List<String> result = solution(input);
        List<String> expected = List.of("((()))","(()())","(())()","()(())","()()()");

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);
    }
}