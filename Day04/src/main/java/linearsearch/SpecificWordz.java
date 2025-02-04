package linearsearch;
import java.util.*;
import static java.lang.System.*;
public class SpecificWordz {
    public static String havingWordOrNot(String []a,String word){
        word=word.toLowerCase();
        for(int i=0;i<a.length;i++){
            a[i]=a[i].toLowerCase();
            String sent=a[i];
            if(sent.contains(word))
                return sent;
        }
        return "Not Found!!!";
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String []sArray= {"Hello java", "having DSA", "searching by Binary Tree"};

        out.print("Enter word you want to find : ");
        String searchWord=input.next();

        out.println("Given word in Sentences : "+ havingWordOrNot(sArray,searchWord));
    }
}
