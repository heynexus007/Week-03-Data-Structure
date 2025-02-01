package com.sortingalgorithms.heapsort;
import java.util.*;
public class JobApplicants {
    // Heapify a sub-tree rooted at index i
    public static void heapify(int arr[], int n, int i) {
        int largest = i; // Root node
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // Checking if left child is larger
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Checking if right child is larger
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying process
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // function to perform heap sort
    public static void heapSort(int arr[]) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extracting elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Re-heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void main(String args[]) {
        int salaries[] = {70000, 38000, 60000, 40000, 69000, 49000};
        System.out.println("Original Salaries Array : " + Arrays.toString(salaries));
        heapSort(salaries);
        System.out.println("Sorted Salaries Array : " + Arrays.toString(salaries));
    }
}
