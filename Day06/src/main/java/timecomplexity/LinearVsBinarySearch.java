package timecomplexity;
import static java.lang.System.*;
public class LinearVsBinarySearch {
    // Method for Linear Search
    public static int linearSearch(int []a,int targ){
        for(int i=0;i<a.length;i++){
        if(a[i]==targ)
            return i;
        }
        return -1;
    }

    // Method for Binary Search
    public static int binarySearch(int[]a, int key){
        int si=0;
        int ei=a.length-1;

        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(a[mid]==key) return mid;
            else if(a[mid]<key) si=mid+1;
            else ei=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] thosnd = new int[1000];
        int[] tenThosnd = new int[10000];
        int[] million = new int[10000];
        // variable to keep track of timing
        long startTime;
        long endTime;

        long[] linearTC=new long[3];
        long[] binaryTC=new long[3];

        // Time Complexity for Linear Search with different DataSizes
        startTime=System.nanoTime();
        linearSearch(thosnd,1000);
        endTime=System.nanoTime();
        linearTC[0]=(endTime-startTime);

        startTime=System.nanoTime();
        linearSearch(tenThosnd,10000);
        endTime=System.nanoTime();
        linearTC[1]=(endTime-startTime);

        startTime=System.nanoTime();
        linearSearch(million,1000000);
        endTime=System.nanoTime();
        linearTC[2]=(endTime-startTime);

        // Time Complexity for Binary Search with different DataSizes
        startTime=System.nanoTime();
        binarySearch(thosnd,1000);
        endTime=System.nanoTime();
        binaryTC[0]=(endTime-startTime);

        startTime=System.nanoTime();
        binarySearch(tenThosnd,10000);
        endTime=System.nanoTime();
        binaryTC[1]=(endTime-startTime);

        startTime=System.nanoTime();
        binarySearch(million,1000000);
        endTime=System.nanoTime();
        binaryTC[2]=(endTime-startTime);

        // Displaying Final output
        out.printf("-------------------------------------------------------%n");
        out.printf("| %15s | %15s | %15s |%n","Dataset Size  ","Linear Search  ","Binary Search  ");
        out.printf("-------------------------------------------------------%n");
        out.printf("| %15s | %15s | %15s |%n","1000      ",linearTC[0]+"ns    ",binaryTC[0]+"ns    ");
        out.printf("-------------------------------------------------------%n");
        out.printf("| %15s | %15s | %15s |%n","10000     ",linearTC[1]+"ns    ",binaryTC[1]+"ns     ");
        out.printf("-------------------------------------------------------%n");
        out.printf("| %15s | %15s | %15s |%n","1000000    ",linearTC[2]+"ns    ",binaryTC[2]+"ns     ");
        out.printf("-------------------------------------------------------%n");

    }
}
