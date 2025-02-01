package com.sortingalgorithms.mergesort;
import java.util.*;
public class BookPrices {
    // merging the sub arrays
    public static void merge(int a[], int si, int mid, int ei){
    int temp[]=new int[ei-si+1];
    int i=si;
    int j=mid+1;
    int k=0;

    while(i<=mid && j<=ei){
        if(a[i]<a[j]){
            temp[k]=a[i];
            i++;
        }
        else {
            temp[k]=a[j];
            j++;
        }
        k++;
    }
    while(i<=mid){
        temp[k++]=a[i++];
        }
    while(j<=ei){
        temp[k++]=a[j++];
    }

    for(k=0,i=si;k<temp.length;k++,i++){
        a[i]=temp[k];
        }
    }

    //Creating method for mergeSort
    public static void mergeSort(int a[],int si, int ei){
        if(si>=ei)
            return;
        //finding mid
        int mid=si+(ei-si)/2;
        mergeSort(a,si, mid);
        mergeSort(a,mid+1,ei);
        merge(a,si,mid,ei);
    }

    public static void main(String[] args) {
        //Given array book prices
        int bookPrices []= {749,499,200,60,399,100,50};
        mergeSort(bookPrices,0,bookPrices.length-1);
        System.out.print(Arrays.toString(bookPrices));
    }
}
