package com.aman.stack.rain_water_trapping;

import java.util.Arrays;

public class RainWaterTrapping {
    public static void main(String[] args) {
        int[] arr = {3,0,0,2,0,4};
        int[] maxL = new int[arr.length];
        int[] maxR = new int[arr.length];
        maxL[0]=arr[0];
        maxR[arr.length-1] = arr[arr.length-1];

        for(int i=1;i<arr.length;i++){
            if(maxL[i-1]<arr[i]){
                maxL[i] = arr[i];
            }else {
                maxL[i] = maxL[i-1];
            }
        }

        for(int i=arr.length-2;i>=0;i--){
            if(maxR[i+1]<arr[i]){
                maxR[i] = arr[i];
            }else {
                maxR[i] = maxR[i+1];
            }
        }
        System.out.println("Maximum Left : "+ Arrays.toString(maxL));
        System.out.println("Maximum Right : "+ Arrays.toString(maxR));
        int[] rw = new int[arr.length];
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            rw[i] = Math.min(maxL[i], maxR[i])-arr[i];
            sum+=rw[i];
        }
        System.out.println("Rain water trapping array : "+ Arrays.toString(rw));
        System.out.println("Rain water trapping area:: "+sum);
    }
}
