package com.bubblesort;

import java.util.Arrays;

/**
 * Bubble Sort
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {15,16,6,8,5};
        for(int i=0;i<arr.length-1;i++){
            int flag=0;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag=1;
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]= temp;
                }
            }
            if(flag==0){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
