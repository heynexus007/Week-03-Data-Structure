package challenge_problem;
import java.io.*;
import static java.lang.System.*;
public class WordCountAndTime {
    public static void main(String[] args) {
        // Specify large file path
        String fileName = "file2.txt";

        // Count words using FileReader
        long startTime = System.nanoTime();
        int wordCountFileReader = countWordsWithFileReader(fileName);
        long endTime = System.nanoTime();
        out.println("Word Count (FileReader) : " + wordCountFileReader);
        out.println("FileReader Time : " + (endTime - startTime) / 1000000 + " ms");

        // Count words using InputStreamReader
        startTime = System.nanoTime();
        int wordCountInputStream = countWordsWithInputStreamReader(fileName);
        endTime = System.nanoTime();
        out.println("Word Count (InputStreamReader) : " + wordCountInputStream);
        out.println("InputStreamReader Time : " + (endTime - startTime) / 1000000 + " ms");
    }

    // Count words using FileReader
    public static int countWordsWithFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Split by whitespace
            }
        }
        catch (IOException e) {
            out.println(e.getMessage());
        }
        return wordCount;
    }

    // Count words using InputStreamReader
    public static int countWordsWithInputStreamReader(String filePath) {
        int wordCount = 0;
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split by whitespace
                wordCount += line.split(" ").length;
            }
        }
        catch (IOException e) {
            out.println(e.getMessage());
        }
        return wordCount;
    }
}
