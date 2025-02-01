package com.stackandqueue.stockspan;
import java.util.Stack;
public class StockSpanProblem {
    public static int[] calculatingSpan(int[] cost) {
        int n = cost.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && cost[stack.peek()] <= cost[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculatingSpan(prices);

        for (int s : span) {
            System.out.print(s + " ");
            // Output: 1 1 1 2 1 4 6
        }
    }
}
