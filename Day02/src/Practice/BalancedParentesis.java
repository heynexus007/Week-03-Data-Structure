package Practice;

import java.util.Stack;

public class BalancedParentesis {
    public static boolean isBalanced(String s){ //s="({([)]})";
        Stack<Character> st=new Stack<>();
       for (char c : s.toCharArray()){
           if (c=='(' || c=='{' || c=='['){
               st.push(c);
           }
           else if (c==')' || c=='}' || c==']'){
               if(st.isEmpty())
               return false;

               char top=st.pop();
               if(!isMatched(top, c)){
                  return false;
               }
           }
       }
       return true;
    }

    public static boolean isMatched(char open, char close){
        return (open=='(' && close==')' || open=='{'&& close=='}' || open=='['&& close==']');
    }
    public static void main(String[] args) {
        String s="({([)]})";
        if(isBalanced(s)){
            System.out.println("String is Balanced");
        }

        else
            System.out.println("String is unbalanced");
    }
}
