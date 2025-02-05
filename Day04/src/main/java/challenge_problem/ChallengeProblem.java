package challenge_problem;
import java.util.*;
import static java.lang.System.*;

public class ChallengeProblem {
    // Function to find the first missing positive integer using Linear Search
    public static int getFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Mark numbers by placing them in their correct index
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with the correct position nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // If all numbers are in correct positions
        return n + 1;
    }

    // function to find index of target using Binary Search
    public static int binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] == target) return mid; // Target found, return index

            else if (a[mid] < target) left = mid + 1; // Search in right part

            else right = mid - 1; // Search in left part

        }
        // If Target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] givArray = {2, 4, -1, 1, 5};

        // Find the first missing positive integer
        int missingNum = getFirstMissingPositive(givArray);
        out.println("First missing positive integer : " + missingNum);

        // Sort the array for binary search
        Arrays.sort(givArray);
        out.println("Sorted Array : " + Arrays.toString(givArray));

        // Search for a target number
        int target = 4;
        int idx = binarySearch(givArray, target);

        // Print result
        if (idx != -1) {
            out.println("Target \"" + target + "\" found at index : " + idx);
        }
        else {
            out.println("Target \"" + target + "\" not found!!!");
        }
    }
}
