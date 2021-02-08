package com.aman.stack.balanced_parentheses;

import java.util.ArrayDeque;

/**
 * Given an expression string exp, write a program to examine
 * whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
 */
public class BalancedParentheses {
    public static void main(String[] args) {
        String s = "[()]{}{[()()]()}";
        if(isBalanced(s)){
            System.out.println(s+" : Balanced");
        }else{
            System.out.println(s+" : Not balanced");
        }
        s= "[(])";
        if(isBalanced(s)){
            System.out.println(s+" : Balanced");
        }else{
            System.out.println(s+" : Not balanced");
        }
    }

    public static boolean isBalanced(String s) {
        ArrayDeque <Character> stack = new ArrayDeque <>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                else if(!isMatching(stack.peek(),s.charAt(i))){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatching(char a, char b){
        return (a == '(' && b ==')' || a == '{' && b =='}' || a == '[' && b ==']');
    }
}
