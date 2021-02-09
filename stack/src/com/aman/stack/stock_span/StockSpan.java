package com.aman.stack.stock_span;

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
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 * Using NGL(Nearest greatest left)
 */
public class StockSpan {
    public static void main(String[] args) {
        int[] arr = { 10, 4, 5, 90, 120, 80 }; //{100,80, 60,70,60, 75, 85};
        Stack<Pair> stack =  new Stack <>();
        int[] res =  new int[arr.length];

        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                res[i] = -1;
                stack.push(new Pair(arr[i],i));
            }else if(stack.peek().data>arr[i]){
                res[i] = stack.peek().index;
                stack.push(new Pair(arr[i], i));
            }else{
                while (!stack.isEmpty() && stack.peek().data<=arr[i]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    res[i] = -1;
                    stack.push(new Pair(arr[i],i));
                }else if(stack.peek().data>arr[i]){
                    res[i] = stack.peek().index;
                    stack.push(new Pair(arr[i], i));
                }else{
                    res[i] = -1;
                    stack.push(new Pair(arr[i],i));
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print((i - res[i]) +" ");
        }
    }
}
