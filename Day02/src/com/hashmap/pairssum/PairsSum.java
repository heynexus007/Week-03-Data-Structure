package com.hashmap.pairssum;
import java.util.*;
public class PairsSum {
    public static boolean hasPairsSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int e : arr) {
            if (set.contains(target - e)) {
                System.out.println("Pairs found : (" + e + ", " + (target - e) + ")");
                return true;
            }
            set.add(e);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;
        if (!hasPairsSum(arr, target)) {
            System.out.println("No pair found!!!");
        }
    }
}
