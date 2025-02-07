package inputstreamreader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import static java.lang.System.*;

public class ByteToCharacterStream {
    public static void main(String[] args) {
        // File with encoded text
        String fileName = "file2.txt";

        try (FileInputStream fileIn = new FileInputStream(fileName);
             InputStreamReader in = new InputStreamReader(fileIn, "UTF-8");
             BufferedReader br = new BufferedReader(in)) {

            String line;
            while ((line = br.readLine()) != null) {
                // Print each line
                out.println(line);
            }

        } catch (IOException e) {
            out.println(e.getMessage());
        }
    }
}
