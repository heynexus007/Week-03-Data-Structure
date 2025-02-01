package Practice;
import java.util.*;
public class Hashmapp {
    public static void main(String[] args) {
        String s="$won$de$rwom$en";
        StringBuilder sb=new StringBuilder("");
        //HashMap<Character,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='$')
                count++;
        }

        for(int i=0;i<count;i++){
            sb.append('$');
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='$')
                sb.append(s.charAt(i));
        }

        System.out.println(sb);
    }
}
