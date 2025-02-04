package binarysearch;
import static java.lang.System.*;
public class FindPeakElement {
    public static int getPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Calculate mid to prevent overflow
            int mid = left + (right - left) / 2;

            // If mid is less than the next element, move right
            if (arr[mid] < arr[mid + 1])
                left = mid + 1;
            // Otherwise, move left
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 20, 4, 1, 0};
        int peakIdx = getPeakElement(arr);
        out.println("Peak element is at index : " + peakIdx);
    }
}
