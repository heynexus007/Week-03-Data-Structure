package stringbuffer;

public class PerformanceComparison {
    public static void main(String[] args) {
        // variable to store start and end time
        long startTiming,endTiming;
        //record its start time of StringBuilder
        startTiming=System.nanoTime();
        StringBuilder sb=new StringBuilder("StringBuilder");
        for(int i=1;i<100000;i++){
            sb.append(" Performance test");
        }
        endTiming=System.nanoTime(); //record its end time of StringBuilder
        System.out.println("String builder performance time : "+(endTiming-startTiming)+"ns");

        //record its start time of StringBuffer
        startTiming=System.nanoTime();
        StringBuffer sBuf=new StringBuffer("StringBuffer");
        for(int j=1;j<100000;j++){
            sBuf.append(" Performance test");
        }
        //record its end time of StringBuffer
        endTiming=System.nanoTime();
        System.out.println("String buffer performance time : "+(endTiming-startTiming)+"ns");
    }
}
