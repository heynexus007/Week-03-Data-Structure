package binarysearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchTargetTest {
    @Test
    void searchTarget1(){
        int[][] matrix = {
                {1, 3, 4, 8},
                {10, 12, 16, 20},
                {21, 22, 24, 29} };
        int targ=16;
        boolean result=SearchTarget.searchTarget(matrix,targ);
        assertEquals(true,result);
    }

    @Test
    void searchTarget2(){
        int[][] matrix = {
                {1, 3, 4, 8},
                {10, 12, 16, 20},
                {21, 22, 24, 29} };
        int targ=16;
        boolean result=SearchTarget.searchTarget(matrix,targ);
        assertEquals(false,result);
    }
}