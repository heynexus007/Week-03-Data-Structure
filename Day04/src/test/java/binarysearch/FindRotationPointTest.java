package binarysearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FindRotationPointTest {
    @Test
    void getRotate(){
        int []a={3,5,7,9,12,14,1,2};
        int result=FindRotationPoint.rotate(a);
        assertEquals(1,result);
    }
}