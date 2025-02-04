package binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstLastOccuranceTest {
    @Test
    void FirstOccurance(){
        int[] a = {3, 5, 6, 7, 8, 8, 9, 10};
        int target=8;
        int result1=FirstLastOccurance.getFirstOccurance(a,target);
        assertEquals(4,result1);
    }

    @Test
    void LastOccurance(){
        int[] a = {3, 5, 6, 7, 8, 8, 9, 10};
        int target=8;
        int result2=FirstLastOccurance.getLastOccurance(a,target);
        assertEquals(5,result2);
    }

}