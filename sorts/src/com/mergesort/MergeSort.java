package com.mergesort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {15,5,24,8,1,3,16,10,20};
        mergeSort(arr, 0, arr.length-1);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int lb, int ub) {
        if(lb<ub){
            int mid = (lb+ub)/2;
            mergeSort(arr, lb, mid);
            mergeSort(arr, mid+1, ub);
            merge(arr, lb,ub, mid);
        }

    }

    private static void merge(int[] arr, int lb, int ub, int mid) {
        int[] b =new int[arr.length];
        int i =lb;
        int j = mid+1;
        int k = lb;
        while (i<mid+1 && j<=ub){
            if(arr[i]<arr[j]){
                b[k]= arr[i];
                i++;
            }else{
                b[k]= arr[j];
                j++;
            }
            k++;
        }

        if(i>=mid+1){
            while (j<=ub){
                b[k]=arr[j];
                k++;j++;
            }
        }else{
            while (i<mid+1){
                b[k]=arr[i];
                k++;i++;
            }
        }

        for(int l=lb;l<=ub;l++){
            arr[l]=b[l];
        }
    }
}
