package com.quicksort;

import java.util.Arrays;

/**
 * Quick sort
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7,6,10,5,9,2,1,15,7};
        quickSort(arr, 0, arr.length-1);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int lb, int ub) {
        if(lb<ub){
            int loc = partition(arr, lb, ub);
            quickSort(arr, lb,loc-1);
            quickSort(arr, loc+1,ub);
        }
    }

    private static int partition(int[] arr, int lb, int ub) {
        int pivot = arr[lb];
        int start = lb;
        int end = ub;
        while (start<end){
            while (start<arr.length && arr[start]<=pivot){
                start++;
            }
            while (end>=0 && arr[end]>pivot){
                end--;
            }
            if(start<end){
                swap(arr, start, end);
            }
        }
        swap(arr, lb, end);
        return end;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
