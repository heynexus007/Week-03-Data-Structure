package timecomplexity.filereadingefficiency;

import java.io.*;
public class FileGenerator {
    public static void generateFile(String fileName, long sizeInMB) {
        File file = new File(fileName);
        long totalBytes = sizeInMB * 1024 * 1024; // Convert MB to bytes
        String content = "This is a test line for a time comparison by File reader and InputStream reader file.\n"; // Example content
        int lineBytes = content.getBytes().length;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (long i = 0; i < totalBytes / lineBytes; i++) {
                writer.write(content);
            }
            System.out.println(fileName + " generated (" + sizeInMB + "MB)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generateFile("1MB.txt", 1);
        generateFile("100MB.txt", 100);
        generateFile("500MB.txt", 500);
    }
}
