package stringbuilder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {
    @Test
    void getReverse(){
        String s="hello";
        String reversed = ReverseString.getReversed(s);
        String getAns="olleh";
        assertEquals(getAns,reversed);
    }
}