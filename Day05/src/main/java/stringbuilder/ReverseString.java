package stringbuilder;

public class ReverseString {
    public static String getReversed(String s){
        StringBuilder sb=new StringBuilder("");
        sb.append(s);   //string added to StringBuilder
        sb.reverse(); //using in-built reverse
        s=sb.toString(); // convert back to String
        return s;
    }
    public static void main(String[] args) {
        String s="hello";
        System.out.println("Original String : "+s);
        String reversedString=getReversed(s);
        System.out.println("Reversed String : "+reversedString);

//        //Easy way
//        StringBuilder rev=new StringBuilder(s).reverse();
//        System.out.println("Reversed String : "+rev.toString());
    }
}
