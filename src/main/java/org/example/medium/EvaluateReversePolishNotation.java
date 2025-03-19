package org.example.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int solution(String[] tokens) {
        Stack<String> numberStack = new Stack<>();
        Stack<String> operandStack = new Stack<>();
        Integer total = Integer.valueOf(tokens[0]);

        for (int i=tokens.length-1; i>0; i--) {
            String token = tokens[i];
            if (isOperand(token)) operandStack.push(token);
            else numberStack.push(token);
        }

        while (numberStack.isEmpty() == false) {
            String operand = operandStack.pop();
            Integer nextDigit = Integer.valueOf(numberStack.pop());

            System.out.println("CurrDigit : " + total);
            System.out.println("Operand : " + operand);
            System.out.println("nextDigit : " + nextDigit);

            total = calculate(total, operand, nextDigit);
            System.out.println("Total : " + total);
            System.out.println();
        }

        return total;
    }

    public static boolean isOperand(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) return true;
        return false;
    }

    public static int calculate(int total, String token, int number) {
        if (token.equals("+")) return total += number;
        if (token.equals("-")) return total -= number;
        if (token.equals("*")) return total *= number;
        if (token.equals("/")) {
            total /= number;
            return total == 0 ? 1 : total;
        }
        return total;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"1","2","+","3","*","4","-"};
        int result = solution(input);
        int expected = 5;

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);
    }
}