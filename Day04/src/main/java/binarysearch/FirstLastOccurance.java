package binarysearch;

import static java.lang.System.*;
public class FirstLastOccurance {
    public static int getFirstOccurance(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                first = mid; // Update first occurrence
                right = mid - 1; // Search in left side
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return first;
    }

    public static int getLastOccurance(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                last = mid; // Update last occurrence
                left = mid + 1; // Search in right side
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 7, 8, 8, 9, 10};
        int target = 8;
        int res1 = getFirstOccurance(arr, target);
        int res2 = getLastOccurance(arr, target);
        System.out.println("First occurrence: " + res1);
        System.out.println("Last occurrence: " + res2);
    }
}
