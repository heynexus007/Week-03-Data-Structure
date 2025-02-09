package timecomplexity.fibonaccicomputation;

import static java.lang.System.*;
public class FibonacciSeries {
    public static void iterativeFibonacci(int n){
        int n1=0;
        int n2=1;
//        out.print("FibonacciSeries: "+n1+" "+n2+" ");
        for(int i=2;i<n;i++){
            int n3=n1+n2;
//            out.print(n3+" ");
            n1=n2;
            n2=n3;
        }
    }

    public static int recursiveFibonacci(int n){
        if(n<=1) return n;
        return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
    }
    public static void main(String[] args) {
        int n=20;

        // Array for Fibonacci 'N'
        int[] oper={10,30,40};
        // variable to keep track of timing
        long startTime;
        long endTime;

        //creating array for keeping tracks
        long[] iterativeTime=new long[3];
        long[] recursiveTime=new long[3];

        //keeping track of iterative performance for 'N'
        int i=0;
        for(int t: oper){
            startTime=System.nanoTime();
            iterativeFibonacci(t);
            endTime=System.nanoTime();
            iterativeTime[i++]=(endTime-startTime);
        }

        //keeping track of iterative performance for 'N'
        int j=0;
        for(int t: oper){
            startTime=System.nanoTime();
            recursiveFibonacci(t);
            endTime=System.nanoTime();
            recursiveTime[j++]=(endTime-startTime);
        }

        // Displaying Final output
        out.printf("-------------------------------------------------------%n");
        out.printf("| %16s | %16s | %16s |%n","Fibonacci (N)","Recursive O(2^n)","Iterative O(N)");
        out.printf("-------------------------------------------------------%n");
        out.printf("| %16s | %16s | %16s |%n","10       ",iterativeTime[0]+"ns     ",recursiveTime[0]+"ns    ");
        out.printf("-------------------------------------------------------%n");
        out.printf("| %16s | %16s | %16s |%n","30       ",iterativeTime[1]+"ns     ",recursiveTime[1]+"ns   ");
        out.printf("-------------------------------------------------------%n");
        out.printf("| %16s | %16s | %16s |%n","50       ",iterativeTime[2]+"ns     ",recursiveTime[2]+"ns  ");
        out.printf("-------------------------------------------------------%n");
    }
}
