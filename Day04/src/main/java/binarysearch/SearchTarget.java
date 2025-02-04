package binarysearch;
import static java.lang.System.*;
public class SearchTarget {
    public static boolean searchTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            // Calculate mid index
            int mid = left + (right - left) / 2;
            // Convert 1D index to 2D
            int middleVal = matrix[mid / cols][mid % cols];

            // Found the target
            if (middleVal == target) return true;
            else if (middleVal < target) left = mid + 1; // Search in right half
            else right = mid - 1; // Search in left half
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 4, 8},
                {10, 12, 16, 20},
                {21, 22, 24, 29} };
        int target = 16;
        out.println("Target found : " + searchTarget(matrix, target));
    }
}
