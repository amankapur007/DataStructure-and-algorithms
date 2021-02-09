package com.aman.stack.nearest_smallest_to_right;

import java.util.Stack;

/**
 * Date : 10 02 2021
 * Author : Aman Kapur
 * Nearest smallest to the right
 */
public class NearestSmallestToRight {
    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8};
        int[] res =  new int[arr.length];
        Stack <Integer> stack =  new Stack <>();
        for(int i=arr.length-1;i>=0;i--){
            {
                if(stack.isEmpty()){
                    res[i] = -1;
                    stack.push(arr[i]);
                }else if(stack.peek()<arr[i]){
                    res[i] = stack.peek();
                    stack.push(arr[i]);
                }else{
                    while (!stack.isEmpty() && stack.peek()>=arr[i]){
                        stack.pop();
                    }

                    if(stack.isEmpty()){
                        res[i] = -1;
                        stack.push(arr[i]);
                    }else if(stack.peek()<arr[i]){
                        res[i] = stack.peek();
                        stack.push(arr[i]);
                    }else{
                        res[i] = -1;
                        stack.push(arr[i]);
                    }
                }
            }
        }

        for(int i=0;i<arr.length;i++) {
            System.out.print(res[i] + " ");
        }
    }
}
