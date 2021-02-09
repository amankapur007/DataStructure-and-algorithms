package com.aman.stack.next_greater_number_to_right;

import java.util.Stack;

/**
 * Date 9 02 2021
 * Author Aman
 */
public class NGR {
    public static void main(String[] args) {
        int[] arr = {98, 23, 54, 12, 20, 7, 27};//{1,3,0,0,1,2,4};
        int size = arr.length;
        int[] res = new int[arr.length];
        Stack<Integer> stack =  new Stack<>();
        for(int i = size-1;i>=0;i--){
            if(stack.isEmpty()){
                res[i]=-1;
                stack.push(arr[i]);
            }else if(stack.peek()>arr[i]){
                res[i]=stack.peek();
                stack.push(arr[i]);
            }else{
                while (!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i]=-1;
                    stack.push(arr[i]);
                }else if(stack.peek()>arr[i]){
                    res[i]=stack.peek();
                    stack.push(arr[i]);
                }else{
                    res[i]=-1;
                    stack.push(arr[i]);
                }
            }
        }

        for(int i=0;i<size;i++){
            System.out.print(res[i]+ " ");
        }
    }
}
