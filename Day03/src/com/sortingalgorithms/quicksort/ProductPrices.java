package com.sortingalgorithms.quicksort;
import java.util.*;
public class ProductPrices {
    // Find the right position of pivot index
    public static int partition(int a[],int si, int ei){
        int pivot=a[ei]; //making last element PIVOT
        int i=si-1;
        for(int j=si;j<a.length;j++){
            if(a[j]<=pivot){
                i++;
                int temp=a[j];
                a[j]=a[i];
                a[i]=temp;
            }
            i++;
            int temp=pivot;
            a[ei]=a[j];
            a[j]=temp;
        }
        return i;
    }
    // Creating quick sort method to sort productPrices
    public static void quickSort(int a[], int si, int ei){
        if(si<=ei)
            return;
        // getting pivot index
        int pIdx= partition(a,si,ei);
        quickSort(a,si,pIdx-1);
        quickSort(a,pIdx+1,ei);
    }

    public static void main(String[] args) {
        int productPrices[]={50, 60, 100, 200, 399, 499, 749};
        quickSort(productPrices,0,productPrices.length-1);
        System.out.println(Arrays.toString(productPrices));

    }
}
