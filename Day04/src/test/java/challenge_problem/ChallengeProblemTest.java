package challenge_problem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChallengeProblemTest {
    @Test
    void binaryS(){
        int[] givArray = {2, 4, -1, 1, 5};
        int target=5;
        int res1=ChallengeProblem.binarySearch(givArray,target);
        assertEquals(4,res1);
    }

    @Test
    void firstMissingInt(){
        int[] givArray = {2, 4, -1, 1, 5};
        int res2=ChallengeProblem.getFirstMissingPositive(givArray);
        assertEquals(3,res2);
    }
}