package stack;

/**
 * Last In First Out
 */
public class Stack {
    private int[] arr;
    private int top;
    private int stackSize;

    Stack(){
        stackSize=1;
        top=-1;
        arr= new int[stackSize];
    }

    public void push(int data){
        if(top>=stackSize-1){
            resize();
        }
        arr[++top] = data;
    }

    public Integer pop(){
        if(top<0){
            return null;
        }
        return arr[top--];
    }
    private void resize() {
        int[] temp = arr;
        stackSize = stackSize*2;
        arr = new int[stackSize];
        int i=0;
        for(int data:temp){
            arr[++i]= data;
        }
    }

}
