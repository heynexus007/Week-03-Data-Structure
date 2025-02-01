package com.sortingalgorithms.selectionsort;
import java.util.*;
public class ExamScores {
    // making function for selection sort
    public static void selectionSort(int a[]){
        for(int i=0;i<a.length-1;i++){
            int minPos=i; // assume min Element
            for(int j=i+1;j< a.length;j++){
                if(a[minPos]>a[j])
                    minPos=j;
            }
            // Swap and add min element to sorted part
            int hold=a[minPos];
            a[minPos]=a[i];
            a[i]=hold;
        }
    }
    public static void main(String[] args) {
        // given Exam Scores
        int scores[]={87,50,92,67,42,74,30};
        selectionSort(scores);
        System.out.println(Arrays.toString(scores));
    }
}
