package timecomplexity.sortingalgorithms;

import static java.lang.System.*;
public class ComparingTimeOfSortingAlgo {
    //Function for Bubble sort
    public static void bubbleSort(int[] a){
        int n=a.length;
        for(int turn=0;turn<n;turn++){
            for(int i=0;i<n-1-turn;i++){
                if(a[i]>a[i+1]){
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                }
            }
        }
    }

    //Function for Merge sort
    public static void mergeSort(int[] a,int si, int ei){
        if(si<=ei) return;
        int mid=si+(ei-si)/2;
        mergeSort(a,si,mid);
        mergeSort(a,mid+1,ei);
        merge(a,si,mid,ei);

    }
    public static void merge(int[] a,int si, int mid, int ei){
        int[] hold=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=ei){
            if(a[i]<a[j]){
                hold[k]=a[i];
                i++;
            }
            else{
                hold[k]=a[j];
                j++;
            }
            k++;
        }

        while(i<=mid) hold[k++]=a[i++];
        while(j<=ei) hold[k++]=a[j++];

        for(i=si,k=0;k<hold.length;i++,k++){
            a[i]=hold[k];
        }
    }

    //Function for Quick Sort
    public static int partition(int[] a,int si, int ei){
        int pivot=a[ei];
        int i=si-1;
        for(int j=0;j<a.length;j++){
            if(a[j]>pivot){
                i++;
                int hold=a[i];
                a[i]=a[j];
                a[j]=hold;
            }
        }
        i++;
        int hold=pivot;
        a[ei]=a[i];
        a[i]=hold;
        return i;
    }
    public static void quickSort(int[] a,int si, int ei){
         if(si<=ei)
             return;

        int pIdx= partition(a,si,ei);
        quickSort(a,si,pIdx-1);
        quickSort(a,pIdx+1,ei);
    }

    public static void main(String[] args) {
        int[] thousand = new int[1000];
        int[] tenThousand = new int[10000];
        int[] lakh = new int[100000];
        // variable to keep track of timing
        long startTime;
        long endTime;

        long[] bubbleSortTC=new long[3];
        long[] mergeSortTC=new long[3];
        long[] quickSortTC=new long[3];

        for(int i=0;i<1000;i++){
            thousand[i]=(int) (Math.random()*999)+1;
        }
        for(int i=0;i<10000;i++){
            tenThousand[i]=(int) (Math.random()*9999)+1;
        }
        for(int i=0;i<100000;i++){
            lakh[i]=(int) (Math.random()*99999)+1;
        }

        // Here I created a copies of array for merge and quick sort:
        int[] thousand1=new int[thousand.length];
        System.arraycopy(thousand,0,thousand1,0,thousand.length-1);

        int[] tenThousand1=new int[tenThousand.length];
        System.arraycopy(tenThousand,0,tenThousand1,0,tenThousand.length-1);

        int[] lakh1=new int[lakh.length];
        System.arraycopy(lakh,0,lakh1,0,lakh.length-1);

        int[] thousand2=new int[thousand.length];
        System.arraycopy(thousand,0,thousand2,0,thousand.length-1);

        int[] tenThousand2=new int[tenThousand.length];
        System.arraycopy(tenThousand,0,tenThousand2,0,tenThousand.length-1);

        int[] lakh2=new int[lakh.length];
        System.arraycopy(lakh,0,lakh2,0,lakh.length-1);


        // Execution Time of BubbleSort for Different Datasets
        startTime=System.nanoTime();
        bubbleSort(thousand);
        endTime=System.nanoTime();
        bubbleSortTC[0]=(endTime-startTime);

        startTime=System.nanoTime();
        bubbleSort(tenThousand);
        endTime=System.nanoTime();
        bubbleSortTC[1]=(endTime-startTime);

        startTime=System.nanoTime();
        bubbleSort(lakh);
        endTime=System.nanoTime();
        bubbleSortTC[2]=(endTime-startTime);

        // Execution Time of MergeSort for Different Datasets
        startTime=System.nanoTime();
        mergeSort(thousand1,0,thousand1.length-1);
        endTime=System.nanoTime();
        mergeSortTC[0]=(endTime-startTime);

        startTime=System.nanoTime();
        mergeSort(tenThousand1,0,tenThousand1.length-1);
        endTime=System.nanoTime();
        mergeSortTC[1]=(endTime-startTime);

        startTime=System.nanoTime();
        mergeSort(lakh1,0, lakh1.length-1);
        endTime=System.nanoTime();
        mergeSortTC[2]=(endTime-startTime);

        // Execution Time of QuickSort for Different Datasets
        startTime=System.nanoTime();
        mergeSort(thousand2,0,thousand2.length-1);
        endTime=System.nanoTime();
        quickSortTC[0]=(endTime-startTime);

        startTime=System.nanoTime();
        mergeSort(tenThousand2,0,tenThousand2.length-1);
        endTime=System.nanoTime();
        quickSortTC[1]=(endTime-startTime);

        startTime=System.nanoTime();
        mergeSort(lakh2,0, lakh2.length-1);
        endTime=System.nanoTime();
        quickSortTC[2]=(endTime-startTime);

        // Displaying Final output
        out.printf("-------------------------------------------------------------------------%n");
        out.printf("| %15s | %15s | %15s | %15s |%n","Dataset Size  ","Bubble Sort  ","Merge Sort  ","Quick Sort  ");
        out.printf("-------------------------------------------------------------------------%n");
        out.printf("| %15s | %15s | %15s | %15s |%n","1,000     ",bubbleSortTC[0]+"ns  ",mergeSortTC[0]+"ns    ",quickSortTC[0] +"ns    ");
        out.printf("-------------------------------------------------------------------------%n");
        out.printf("| %15s | %15s | %15s | %15s |%n","10,000     ",bubbleSortTC[1]+"ns  ",mergeSortTC[1]+"ns     ",quickSortTC[1] +"ns    ");
        out.printf("-------------------------------------------------------------------------%n");
        out.printf("| %15s | %15s | %15s | %15s |%n","1,00,000    ",bubbleSortTC[2]+"ns  ",mergeSortTC[2]+"ns     ",quickSortTC[2] +"ns    ");
        out.printf("-------------------------------------------------------------------------%n");
    }
}
