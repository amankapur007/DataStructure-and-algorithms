package com.aman.stack.nearest_greatest_number_to_left;


import java.util.Stack;

public class NearestGreatestNumberToLeft {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        int[] res = new int[arr.length];
        Stack <Integer> stack= new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                res[i] = -1;
                stack.push(arr[i]);
            }else if(stack.peek()>arr[i]){
                res[i] = stack.peek();
                stack.push(arr[i]);
            }else{
                while (!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    res[i] = -1;
                    stack.push(arr[i]);
                }else if(stack.peek()>arr[i]){
                    res[i] = stack.peek();
                    stack.push(arr[i]);
                }else{
                    res[i] = -1;
                    stack.push(arr[i]);
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(res[i]+" ");
        }
    }
}
