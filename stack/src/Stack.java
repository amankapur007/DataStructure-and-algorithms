/**
 * Dated : 9.02.2021
 * Author : Aman
 */
public class Stack {
    int[] arr;
    int capacity;
    int top=-1;

    Stack(int size){
        arr= new int[size];
        this.capacity =  size;
    }

    int size(){
        return  top+1;
    }

    public int peek(){
        return arr[top];
    }

    public int pop(){
        if(isEmpty())throw new IllegalStateException();
        int res = arr[top];
        top--;
        return res;
    }

    public void push(int data){
        if(capacity-1==top) {
            throw new StackOverflowError();
        }
        arr[++top]=data;
    }

    private boolean isEmpty(){
        return top==-1;
    }
}
