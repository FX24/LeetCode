package org.example.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class MinStack {
    public static void solution(String[] commands) {
        MinStackModel minStack = null;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "MinStack" -> {
                    result.add("null");
                    minStack = new MinStackModel();
                }
                case "push" -> {
                    result.add("null");
                    i++;

                    minStack.push(i);
                    result.add("null");
                }
                case "pop" -> {
                    result.add("null");
                    i++;

                    result.add("null");
                    minStack.pop();
                }
                case "top" -> {
                    result.add(String.valueOf(minStack.top()));
                }
                case "getMin" -> {
                    result.add(String.valueOf(minStack.getMin()));
                }
            }
        }
    }

    public static void main(String[] args) {
        MinStackModel minStack = new MinStackModel();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
        minStack.push(2);
        minStack.push(-4);
        minStack.push(3);
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }


    public static class MinStackModel {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        private Integer min;

        public MinStackModel() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) min = val;
            else min = Math.min(min, val);

            stack.push(val);
            minStack.push(min);
        }

        public void pop() {
            if (stack.isEmpty()) return;
            minStack.pop();
            if (Objects.equals(stack.pop(), min) && !stack.isEmpty()) min = minStack.peek();

        }

        public int top() {
            if (stack.isEmpty()) return 0;
            return stack.peek();
        }

        public int getMin() {
            if (stack.isEmpty()) return 0;
            return minStack.peek();
        }
    }
}
