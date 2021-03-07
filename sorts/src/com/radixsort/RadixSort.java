package com.radixsort;

import java.util.Arrays;

/**
 * It uses counting sort
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {15,1,321,10,802,2,123,90,109,11};
        int max = calculateMax(arr);
        int lengthOfDigit = lengthOfDigit(max);
        int placeValue = 1;
        while (lengthOfDigit!=0){
            redisSort(arr, arr.length, placeValue);
            placeValue = placeValue*10;
            lengthOfDigit--;
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void redisSort(int[] arr, int n, int placeValue) {
        int[] count = new int[10];
        Arrays.fill(count,0);
        for(int i=0;i<n;i++){
            int num = arr[i];
            int val = (num/placeValue)%10;
            ++count[val];
        }
        for(int i=1;i<10;i++){
            count[i] = count[i]+count[i-1];
        }
        int[] b = new int[n];
        for(int i = n-1;i>=0;i--){
            int num =arr[i];
            int val = (num/placeValue)%10;
            b[--count[val]]  =arr[i];
        }
        System.arraycopy(b, 0, arr, 0, arr.length);
    }

    /**
     * Length - 321 -> 3, 21 -> 2. 0 -> 1
     * @param num -
     * @return -
     */
    private static int lengthOfDigit(int num) {
        return (int) Math.floor(Math.log10(num)+1);
    }

    /**
     * Get the max number from arr
     * @param arr-
     * @return -
     */
    private static int calculateMax(int[] arr){
        int max= arr[0];
        for(int num:arr){
            if(num>max){
                max = num;
            }
        }
        return max;
    }
}
