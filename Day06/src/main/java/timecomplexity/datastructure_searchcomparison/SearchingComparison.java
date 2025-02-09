package timecomplexity.datastructure_searchcomparison;

import java.util.*;
import static java.lang.System.*;
public class SearchingComparison {
    // Linear search method for an array
    private static boolean linearSearch(Integer[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Define dataset sizes
        int[] sizes = {1000, 100000, 1000000};
        long[] arrayTime=new long[3];
        long[] hashSetTime=new long[3];
        long[] treeSetTime=new long[3];

        int x=0,y=0,z=0;
        for (int size : sizes) {
            System.out.println("\nDataset Size: " + size);

            // Generate random dataset
            Integer[] array = new Integer[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            Random rand = new Random();

            for (int i = 0; i < size; i++) {
                int num = rand.nextInt(size * 10); // Ensure unique and large range
                array[i] = num;
                hashSet.add(num);
                treeSet.add(num);
            }

            // Choose a random number to search
            int target = array[rand.nextInt(size)];

            // Measure search time in Array (O(N))
            long start = System.nanoTime();
            boolean foundInArray = linearSearch(array, target);
            arrayTime[x++] = System.nanoTime() - start;

            // Measure search time in HashSet (O(1))
            start = System.nanoTime();
            boolean foundInHashSet = hashSet.contains(target);
            hashSetTime[y++] = System.nanoTime() - start;

            // Measure search time in TreeSet (O(log N))
            start = System.nanoTime();
            boolean foundInTreeSet = treeSet.contains(target);
            treeSetTime[z++] = System.nanoTime() - start;
        }
        // Displaying Final output
        out.printf("-------------------------------------------------------------------------------------------%n");
        out.printf("| %15s | %20s | %20s | %23s |%n","Dataset Size  ","Array Search O(N)","HashSet Search O(1)","TreeSet Search O(log N)");
        out.printf("-------------------------------------------------------------------------------------------%n");
        out.printf("| %15s | %20s | %20s | %23s |%n","1,000     ",arrayTime[0]+"ns    ",hashSetTime[0]+"ns     ",treeSetTime[0] +"ns      ");
        out.printf("-------------------------------------------------------------------------------------------%n");
        out.printf("| %15s | %20s | %20s | %23s |%n","10,000     ",arrayTime[1]+"ns    ",hashSetTime[1]+"ns     ",treeSetTime[1] +"ns      ");
        out.printf("-------------------------------------------------------------------------------------------%n");
        out.printf("| %15s | %20s | %20s | %23s |%n","1,00,000    ",arrayTime[2]+"ns    ",hashSetTime[2]+"ns     ",treeSetTime[2] +"ns      ");
        out.printf("-------------------------------------------------------------------------------------------%n");
    }
}
