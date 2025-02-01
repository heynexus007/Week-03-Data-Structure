package com.stackandqueue.slidingwindow;
import java.util.*;
public class SlidingWindow {
    public static int[] window(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // Removing the elements not in window
            while (!deq.isEmpty() && deq.peek() < i - k + 1) {
                deq.poll();
            }
            // Remove smaller elements
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
                deq.pollLast();
            }
            // Add current index
            deq.offer(i);
            // Get max elem for the window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deq.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] finalResult = window(nums, k);

        for (int res : finalResult) {
            System.out.print(res + " ");
            // Output: 3 3 5 5 6 7
        }
    }
}
