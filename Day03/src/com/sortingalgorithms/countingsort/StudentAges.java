package com.sortingalgorithms.countingsort;
import java.util.*;
public class StudentAges {
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int count[] = new int[range];
        int output[] = new int[ages.length];

        // Count occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Compute frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in their right positions
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copying sorted values back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Main
    public static void main(String args[]) {
        // given ages
        int stuAges[] = {18, 11, 19, 15, 20, 10, 16, 14, 17};
        countingSort(stuAges, 10, 20);

        System.out.println("Sorted Ages : " + Arrays.toString(stuAges));
    }
}
