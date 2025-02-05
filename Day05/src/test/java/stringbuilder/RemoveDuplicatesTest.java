package stringbuilder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {
    @Test
    void removeDuplicate(){
        String s="wonderwoman";
        s=s.toLowerCase();
        String result=RemoveDuplicates.removeDuplicates(s);
        assertEquals("wonderma",result);
    }

}