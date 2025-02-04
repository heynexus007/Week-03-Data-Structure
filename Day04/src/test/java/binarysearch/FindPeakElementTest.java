package binarysearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FindPeakElementTest {
    @Test
    void getPeak(){
        int[] arr = {1, 6, 20, 4, 1, 0};
        int res=FindPeakElement.getPeakElement(arr);
        assertEquals(2,res);
    }

}