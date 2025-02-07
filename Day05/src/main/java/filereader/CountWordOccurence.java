package filereader;
import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import static java.lang.System.*;

public class CountWordOccurence {
    public static void main(String[] args) {
        String and="and"; //Target String or Word

        //Try block to handle exception
    try(FileReader filename=new FileReader("file2.txt");
        BufferedReader br=new BufferedReader(filename)){

        String words;
        //Creating HashMap to keep Tracks of word and their occurrence count
        Map<String,Integer> keepTrack=new HashMap<>();
        String[] arrOfWords= new String[10000];

        while((words=br.readLine())!=null){
            out.println(words); //Print all word in files
            //Split word where space occur and stored in String Array
            arrOfWords=words.split(" ");
        }

        for(String w: arrOfWords){
            //Traversing in String array and count frequency of words by HashMap
            keepTrack.put(w, keepTrack.getOrDefault(w,0)+1);
        }

        //If HashMap contains Target String, then return it frequency
        if(keepTrack.containsKey(and)){
            out.println("\""+and+"\" occurs \""+keepTrack.get(and)+"\" times");
        }

    }

    catch(IOException e){
        e.printStackTrace();
        }
    }
}
