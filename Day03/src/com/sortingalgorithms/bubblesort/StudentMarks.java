package com.sortingalgorithms.bubblesort;

import java.util.*;
public class StudentMarks {
    //Applying bubble sort algo
    public static void bubbleSort(int givenArr[]){
        int len=givenArr.length;
        boolean swapped;
        for(int turn=0;turn<len;turn++){
            swapped =false;
            for(int i=0;i<len-1-turn;i++){
                if(givenArr[i]>givenArr[i+1]){
                    int hold=givenArr[i];
                    givenArr[i]=givenArr[i+1];
                    givenArr[i+1]=hold;
                    swapped=true;
                }
            }
            //Optimization; if No swap occurred
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        // given array having student's Marks
        int marks[]={87,50,92,67,42,74,30};
        // calling 'bubbleSort' method
        bubbleSort(marks);

        System.out.println(Arrays.toString(marks));
    }
}
