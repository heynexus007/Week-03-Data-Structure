package filereader;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import static java.lang.System.*;

public class ReadFile {
    public static void main(String[] args) {
        try{
            FileReader fileRead=new FileReader("file1.txt");
            BufferedReader br=new BufferedReader(fileRead);
        String line="";
            while((line=br.readLine())!=null){
                out.println(line);
            }

            fileRead.close();
            br.close();
        }

        catch (IOException e){
            e.printStackTrace();
        }
    }
}
