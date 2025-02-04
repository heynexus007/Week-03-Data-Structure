package linearsearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpecificWordzTest {
    @Test
    void searchWord1(){
        String []sArray= {"Hello java", "having DSA", "searching by Binary Tree"};
        String want="java";
        String result= SpecificWordz.havingWordOrNot(sArray,want);
        assertEquals("hello java", result);
    }

    @Test
    void searchWord2(){
        String []sArray= {"Hello java", "having DSA", "searching by Binary Tree"};
        String want="java";
        String result= SpecificWordz.havingWordOrNot(sArray,want);
        assertEquals("having dsa", result);
    }

}