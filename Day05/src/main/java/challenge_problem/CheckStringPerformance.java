package challenge_problem;
import static java.lang.System.*;
public class CheckStringPerformance {
    public static void main(String[] args) {
        // Number of times concatenations
        int n = 1000000;
        String str = "hello";

        // Measuring time for StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        long endTime = System.nanoTime();
        out.println("StringBuilder takes time : " + (endTime - startTime) / n + " ms");

        // Measuring time for StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append(str);
        }
        endTime = System.nanoTime();
        out.println("StringBuffer takes time : " + (endTime - startTime) / n + " ms");
    }
}
