package stringbuffer;

public class ConcatenateStrings {
    public static String doingConcatenate(String []s){
        //Initialize a StringBuffer
        StringBuffer newString=new StringBuffer("");
        //Iterating and add Strings to StringBuffer
        for(int i=0;i<s.length;i++){
            newString.append(s[i]);
        }
        return newString.toString();
    }
    public static void main(String[] args) {
        String [] sArray={"You ", "are ", "doing ", "Concatenating"};
        //calling methods
        System.out.println("After concatenation : "+doingConcatenate(sArray));
    }
}
