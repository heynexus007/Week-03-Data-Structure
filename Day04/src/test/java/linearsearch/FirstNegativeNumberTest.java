package linearsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNegativeNumberTest {
    @Test
    void firstNegative1(){
        int arr[]={5,2,9,-3,1,4,-1};
        int ans=FirstNegativeNumber.findNegative(arr);
        assertEquals(3,ans);
    }

    @Test
    void firstNegative2(){
        int arr[]={5,2,9,-3,1,4,-1};
        int ans=FirstNegativeNumber.findNegative(arr);
        assertEquals(4,ans);
    }

}