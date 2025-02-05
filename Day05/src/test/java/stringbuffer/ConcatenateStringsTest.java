package stringbuffer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConcatenateStringsTest {
    @Test
    void concate(){
        String [] sArray={"You ", "are ", "doing ", "Concatenating"};
        String hold=ConcatenateStrings.doingConcatenate(sArray);
        assertEquals("You are doing Concatenating",hold);
    }

}