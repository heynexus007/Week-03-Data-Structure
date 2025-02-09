package timecomplexity.filereadingefficiency;

import java.io.*;
import static java.lang.System.*;
public class LargeFileReader {
    // Method to read a file using FileReader (Character Stream)
    public static long readUsingFileReader(String file) throws IOException {
        long startTime = System.currentTimeMillis(); // Start time

        try (FileReader fileReader = new FileReader(file)) {
            while (fileReader.read() != -1) {
                // Reads character by character
            }
        }

        long endTime = System.currentTimeMillis(); // End time
        return endTime - startTime; // Return execution time
    }

    // Method to read a file using InputStreamReader (Byte Stream)
    public static long readUsingInputStreamReader(String filePath) throws IOException {
        long startTime = System.currentTimeMillis(); // Start time

        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            while (inputStreamReader.read() != -1) {
                // Reads character by character
            }
        }

        long endTime = System.currentTimeMillis(); // End time
        return endTime - startTime; // Return execution time
    }

    public static void main(String[] args) {
        String[] fileSizes = {"1MB.txt", "30MB.txt", "50MB.txt"};

        //creating array for keeping tracks
        long[] fileReaderTime=new long[3];
        long[] inputStreamReaderTime=new long[3];

        out.println("Comparing FileReader vs InputStreamReader for different file sizes:\n");

        int i=0;
        int j=0;
        for (String f : fileSizes) {
            try {
                fileReaderTime[i++] = readUsingFileReader(f);
                inputStreamReaderTime[j++] = readUsingInputStreamReader(f);

            } catch (IOException e) {
                out.println("Error reading file: " + f);
                e.printStackTrace();
            }
        }

        // Displaying Final output
        out.printf("----------------------------------------------------------------%n");
        out.printf("| %14s | %16s | %24s |%n","File Size    ","FileReader Time","InputStreamReader Time ");
        out.printf("----------------------------------------------------------------%n");
        out.printf("| %14s | %16s | %24s |%n","1      ",fileReaderTime[0]+"ms      ",inputStreamReaderTime[0]+"ms          ");
        out.printf("----------------------------------------------------------------%n");
        out.printf("| %14s | %16s | %24s |%n","30      ",fileReaderTime[1]+"ms     ",inputStreamReaderTime[1]+"ms         ");
        out.printf("----------------------------------------------------------------%n");
        out.printf("| %14s | %16s | %24s |%n","50      ",fileReaderTime[2]+"ms     ",inputStreamReaderTime[2]+"ms         ");
        out.printf("----------------------------------------------------------------%n");

    }
}
