package com.sortingalgorithms.insertionsort;
import java.util.*;
public class EmployeeIds {
    public static void insertionSort(int a[]){
        for(int i=1;i< a.length;i++){
            int curr=a[i];
            int prev=i-1;
            // finding the right position to place
            while(prev>=0 && a[prev]>curr){
                a[prev+1]=a[prev];
                prev--;
            }
            // insertion of current element
            a[prev+1]=curr;
        }
    }
    public static void main(String[] args) {
        int employeeId []= {7,4,2,6,9,3,1,5,8};
        insertionSort(employeeId);
        System.out.println(Arrays.toString(employeeId));
    }
}
