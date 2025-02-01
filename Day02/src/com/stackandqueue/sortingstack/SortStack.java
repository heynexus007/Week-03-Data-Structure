package com.stackandqueue.sortingstack;
import java.util.Stack;
public class SortStack {
    // Creating 'sortStack' method for sorting the Stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int hold = stack.pop();
            sortStack(stack);
            insertSortedPart(stack, hold);
        }
    }
    // creating another to put sorted part
    private static void insertSortedPart(Stack<Integer> stack, int k) {
        if (stack.isEmpty() || k > stack.peek()) {
            stack.push(k);
        }
        else {
            int hold = stack.pop();
            insertSortedPart(stack, k);
            stack.push(hold);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
            // Output: -5 -3 14 18 30
        }
    }
}
