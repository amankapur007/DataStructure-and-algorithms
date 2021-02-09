package com.aman.stack.maximum_area_histogram;

import java.util.Arrays;
import java.util.Stack;



/**
 * Pair class
 */
class Pair{
    int data;
    int index;
    Pair(int data, int index){
        this.data = data;
        this.index = index;
    }
}

/**
 * Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit.
 * For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 1, 6}. The largest possible rectangle possible is 12
 *
 * Use NSL(if value is not less in left the  -1) and NSR(valie is  not less in right then arr.length)
 * calculate width = right- left-1
 * area = width[i[ * arr[i]
 * */
public class MAH {

    public static void main(String[] args) {
        int[] arr = {6,2,5,4,5,1,6};
        int[] left = NSL(arr,-1);
        int[] right = NSR(arr,arr.length);
        System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(left));
        int[] width = new int[arr.length];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            width[i] = right[i] - left[i] -1;
            if(maxArea<width[i]*arr[i]){
                maxArea = width[i]*arr[i];
            }
        }
        System.out.println("Maximum Area Histogram : "+maxArea);
    }

    private static int[] NSL(int[] arr, int defaultValue) {
        int[] res = new  int[arr.length];
        Stack<Pair> stack = new Stack <>();
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                res[i] = defaultValue;
                stack.push(new Pair(arr[i],i));
            }else if(stack.peek().data<arr[i]){
                res[i] = stack.peek().index;
                stack.push(new Pair(arr[i],i));
            }else{
                while (!stack.isEmpty() && stack.peek().data>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = defaultValue;
                    stack.push(new Pair(arr[i],i));
                }else if(stack.peek().data<arr[i]){
                    res[i] = stack.peek().index;
                    stack.push(new Pair(arr[i],i));
                }else{
                    res[i] = defaultValue;
                    stack.push(new Pair(arr[i],i));
                }
            }
        }
        return res;
    }

    private static int[] NSR(int[] arr, int defaultValue) {
        int[] res = new  int[arr.length];
        Stack<Pair> stack = new Stack <>();
        for(int i=arr.length-1;i>=0;i--){
            if(stack.isEmpty()){
                res[i] = defaultValue;
                stack.push(new Pair(arr[i],i));
            }else if(stack.peek().data<arr[i]){
                res[i] = stack.peek().index;
                stack.push(new Pair(arr[i],i));
            }else{
                while (!stack.isEmpty() && stack.peek().data>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = defaultValue;
                    stack.push(new Pair(arr[i],i));
                }else if(stack.peek().data<arr[i]){
                    res[i] = res[i] = stack.peek().index;
                    stack.push(new Pair(arr[i],i));
                }else{
                    res[i] = defaultValue;
                    stack.push(new Pair(arr[i],i));
                }
            }
        }
        return res;
    }
}
