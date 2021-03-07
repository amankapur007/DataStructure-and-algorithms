package com.redixsort.queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class RedixSort_Queue {
    public static void main(String[] args) {
        int[] arr = {15,1,321,10,802,2,123,90,109,11};
        redixSort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void redixSort(int[] arr) {
        int max = getLargest(arr);
        System.out.println("max = " + max);
        int digit = calculateDigit(max);
        System.out.println("digit = " + digit);
        int place = 1;
        for(int i=0;i<digit;i++){
            applySort(arr, place);
            place = place*10;
        }

    }

    private static void applySort(int[] arr, int place) {
        Queue<Integer>[] bucket = new Queue[10];
        for(int i=0;i<10;i++){
            bucket[i] = new LinkedList<>();
        }
        for (int num : arr) {
            int v = (num / place) % 10;
            bucket[v].add(num);
        }
        int j= 0;
        for(int i=0;i<10;i++){
            while (bucket[i].size()!=0){
                arr[j] = bucket[i].remove();
                j++;
            }
        }
    }

    private static int calculateDigit(int max) {
        String num = Integer.toString(max);
        //Math.floor(Math.log10(max)+1);
        return num.length();
    }

    private static int getLargest(int[] arr) {
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
}
