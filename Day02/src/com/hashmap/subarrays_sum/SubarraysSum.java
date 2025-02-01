package com.hashmap.subarrays_sum;

import java.util.*;

public class SubarraysSum {
    public static void getZeroSumSubarrays(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        // Handles cases where subarray starts from index 0
        map.put(0, Arrays.asList(-1));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.println("Subarray : " + (start + 1) + " to " + i);
                }
            }

            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};
        getZeroSumSubarrays(arr);
    }
}

