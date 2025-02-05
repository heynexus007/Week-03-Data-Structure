package stringbuilder;

import java.util.HashSet;

public class RemoveDuplicates {
    public static String removeDuplicates(String s){
        StringBuilder sb=new StringBuilder("");
        HashSet<Character> set=new HashSet<>();

        //Adding string character in Hashset
        for(char c: s.toCharArray()){
            set.add(c);
        }

        for(int i=0;i<s.length();i++){
            char k=s.charAt(i);
            //checking character contains in set
            if(set.contains(k)){
                sb.append(k); //add to StringBuilder
                set.remove(k); // after adding remove key from HashSet
            }
        }
        //Convert into string
        return sb.toString();
    }
    public static void main(String[] args) {
        String s="wonderwoman";
        s=s.toLowerCase();
        System.out.println("Original String : "+s);
        System.out.println("String after removing duplicates characters : "+removeDuplicates(s));
    }
}
