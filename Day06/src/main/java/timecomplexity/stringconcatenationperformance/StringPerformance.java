package timecomplexity.stringconcatenationperformance;

import static java.lang.System.*;
public class StringPerformance {
    // Function to concating String
    public static void concateString(String s,int times){
        String temps = "";
        for(int i=0;i<times-1;i++){
            temps+=s;
        }
    }

    // Function to concating StringBuilder
    public static void concateStringBuilder(String sb,int times){
        StringBuilder temps = new StringBuilder("");
        for(int i=0;i<times;i++){
            temps.append(sb);
        }
    }

    // Function to concating StringBuffer
    public static void concateStringBuffer(String sbf,int times){
        StringBuffer temps = new StringBuffer("");
        for(int i=0;i<times;i++){
            temps.append(sbf);
        }
    }
    public static void main(String[] args) {
        // Array for
        int[] operCount={1000,10000,10000};
        // variable to keep track of timing
        long startTime;
        long endTime;

        //creating array for keeping tracks
        long[] stringTC=new long[3];
        long[] stringBuilderTC=new long[3];
        long[] stringBufferTC=new long[3];

        //keeping track of String performance for all datasets
        int i=0;
        for(int t: operCount){
            startTime=System.nanoTime();
            concateString("Java",t);
            endTime=System.nanoTime();
            stringTC[i++]=(endTime-startTime);
        }

        //keeping track of StringBuilder performance for all datasets
        int j=0;
        for(int t: operCount){
            startTime=System.nanoTime();
            concateStringBuilder("Java",t);
            endTime=System.nanoTime();
            stringBuilderTC[j++]=(endTime-startTime);
        }

        //keeping track of StringBuffer performance for all datasets
        int k=0;
        for(int t: operCount){
            startTime=System.nanoTime();
            concateStringBuffer("Java",t);
            endTime=System.nanoTime();
            stringBufferTC[k++]=(endTime-startTime);
        }

        // Displaying Final output
        out.printf("-------------------------------------------------------------------------%n");
        out.printf("| %15s | %15s | %15s | %15s |%n","Operation Count","String    ","String Builder","String Buffer ");
        out.printf("-------------------------------------------------------------------------%n");
        out.printf("| %15s | %15s | %15s | %15s |%n","1,000     ",stringTC[0]+"ns  ",stringBuilderTC[0]+"ns    ",stringBufferTC[0] +"ns    ");
        out.printf("-------------------------------------------------------------------------%n");
        out.printf("| %15s | %15s | %15s | %15s |%n","10,000     ",stringTC[1]+"ns  ",stringBuilderTC[1]+"ns     ",stringBufferTC[1] +"ns    ");
        out.printf("-------------------------------------------------------------------------%n");
        out.printf("| %15s | %15s | %15s | %15s |%n","1,00,000    ",stringTC[2]+"ns  ",stringBuilderTC[2]+"ns     ",stringBufferTC[2] +"ns    ");
        out.printf("-------------------------------------------------------------------------%n");
    }
}
