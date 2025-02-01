package com.hashmap.twosum;
import java.util.HashMap;
public class TwoSumm {
    public static int[] getTwoSum(int[] arr, int target) {
        //Creating a HashMap having key and value
        HashMap<Integer, Integer> hMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int hold = target - arr[i];

            if (hMap.containsKey(hold)) {
                // Return indices
                return new int[]{hMap.get(hold), i};
            }
            /// put values in map
            hMap.put(arr[i], i);
        }
        // No solution
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = getTwoSum(arr, target);

        if (result[0] != -1)
            System.out.println("Indices : " + result[0] + ", " + result[1]);

        else
            System.out.println("No any valid pair found!!!");
    }
}
