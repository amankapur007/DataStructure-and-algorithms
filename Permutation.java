package com.aman.algorithms.backtracking;

import java.util.HashSet;
import java.util.TreeSet;

public class MyPEr {
	private static TreeSet<String> sa = new TreeSet<String>();
	public static void main(String[] args) {
		String s = "AAB";
		perm(s, 3, 0);
		for(String i:sa) {
			System.out.println(i);			
		}
	}

	private static void perm(String s, int size, int fix) {
		for (int i = fix; i < size; i++) {
			s = swap(s,i,fix);
			sa.add(s);
			perm(s, size, fix+1);
			s = swap(s,i,fix);
		}
	}

	private static String swap(String s, int i, int j) {
	     char temp;
	     char[] charArray = s.toCharArray();
	     temp = charArray[i] ;
	     charArray[i] = charArray[j];
	     charArray[j] = temp;
	     //System.out.println("Swap : "+charArray[i]+":"+charArray[j]);
	     return String.valueOf(charArray);
	 }

}
