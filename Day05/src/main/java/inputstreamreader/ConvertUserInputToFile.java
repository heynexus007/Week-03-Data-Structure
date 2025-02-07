package inputstreamreader;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import static java.lang.System.*;
import java.io.IOException;

public class ConvertUserInputToFile {
    public static void main(String[] args) {
        String fileName = "output.txt";

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(fileName)) {

            out.println("Enter text (type 'exit' to stop):");
            String line;

            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                // Write input to file
                fw.write(line + System.lineSeparator());
            }
            out.println("Data written to " + fileName);

        } catch (IOException e) {
            out.println(e.getMessage());
        }
    }
}
