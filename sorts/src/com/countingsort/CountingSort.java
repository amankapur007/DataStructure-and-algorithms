package com.countingsort;

import java.util.Arrays;

/**
 * Same thing will be used for redix sort
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {1,0,2,1,0,1,1,5,6,7,5,4,2,2,0,0,1};
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        countSort(arr, arr.length);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void countSort(int[] arr, int n) {
        //Step 1: create empty cunt array
        int[] count = new int[10];
        //Step 2: insert 0 to it
        Arrays.fill(count, 0);
        // Step 3: freq of digit
        for(int i = 0;i<n;i++){
            ++count[arr[i]];
        }
        //System.out.println("Arrays.toString(count) = " + Arrays.toString(count));
        // Step 4:  sum
        for(int i=1;i<10;i++){
            count[i] = count[i]+count[i-1];
        }
        //System.out.println("Arrays.toString(count) = " + Arrays.toString(count));
        int[] b = new int[n];
        for(int i = n-1;i>=0;i--){
            b[--count[arr[i]]] = arr[i];
        }
        //System.out.println("Arrays.toString(b) = " + Arrays.toString(b));
        for(int i=0;i<arr.length;i++){
            arr[i] = b[i];
        }
    }
}
