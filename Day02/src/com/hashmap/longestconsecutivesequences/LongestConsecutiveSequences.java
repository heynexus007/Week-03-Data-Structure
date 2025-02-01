package com.hashmap.longestconsecutivesequences;
import java.util.HashSet;
public class LongestConsecutiveSequences {
    public static int getLongestConsecutiveSequence(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int e : arr) {
            set.add(e);
        }

        int maxLength = 0;
        for (int e : arr) {
            if (!set.contains(e - 1)) { // Start of a sequence
                int currentNum = e;
                int length = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {100, 40, 200, 10, 31, 2};
        System.out.println("Longest Consecutive Sequence Length : " + getLongestConsecutiveSequence(arr));
    }
}
