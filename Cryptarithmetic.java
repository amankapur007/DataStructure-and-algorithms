package com.aman.algorithms.backtracking;

import java.util.HashMap;
import java.util.Map.Entry;

public class Cryptarthmetic {
	private static int assigned = 0;

	public static void main(String[] args) {
		String s1 = "BASE";
		String s2 = "BALL";
		String s3 = "GAMES";
		// String arr[] = { "S", "E", "N", "D", "M", "O", "R", "Y" };
		String arr[] = { "B", "A", "S", "E", "L", "G", "M" };

		String arrNo[] = { "", "", "", "", "", "", "", "", "", "" };
		//int arrNo[] = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		HashMap<String, Integer> map = new HashMap<>();
		/*
		 * map.put("S", -1); 
		 * map.put("E", -1); 
		 * map.put("N", -1); 
		 * map.put("D", -1);
		 * map.put("M", -1); 
		 * map.put("O", -1); 
		 * map.put("R", -1); 
		 * map.put("Y", -1);
		 */
		/*
		 * map.put("B", -1); 
		 * map.put("A", -1); 
		 * map.put("S", -1); 
		 * map.put("E", -1);
		 * map.put("L", -1); 
		 * map.put("G", -1); 
		 * map.put("M", -1);
		 */
		start(s1, s2, s3, map, arr, 0, arrNo);
		for (int i = 0; i < arrNo.length; i++) {
			if (!arrNo[i].equals("")) {
				System.out.println(arrNo[i]+"="+i);
			}
		}
		/*
		 * for(Entry<String, Integer> s:map.entrySet()) {
		 * System.out.println(s.getKey()+":"+s.getValue()); }
		 */
	}

	private static boolean start(String s1, String s2, String s3, HashMap<String, Integer> map, String[] arr, int index,
			String[] arrNo) {
		if (assigned == arr.length) {
			return checkAirthmetic(s1, s2, s3);
		}
		for (int digit = 0; digit <= 9; digit++) {
			if (checkIfDigitToLetterAssign(digit, arrNo)) {
				s1 = s1.replace(arr[index], digit + "");
				s2 = s2.replace(arr[index], digit + "");
				s3 = s3.replace(arr[index], digit + "");
				//map.put(arr[index], digit);
				//arrNo[digit] = 1;
				arrNo[digit] = arr[index];
				assigned = assigned + 1;
				if (start(s1, s2, s3, map, arr, index + 1, arrNo)) {
					return true;
				} else {
					s1 = s1.replace(digit + "", arr[index]);
					s2 = s2.replace(digit + "", arr[index]);
					s3 = s3.replace(digit + "", arr[index]);
					assigned = assigned - 1;
					//arrNo[digit] = -1;
					arrNo[digit] = "";
					//map.put(arr[index], -1);
				}
			}
		}

		return false;
	}

	private static boolean checkIfDigitToLetterAssign(int digit, String[] arrNo) {
		// TODO Auto-generated method stub
		//if(arrNo == -1) {
		if (arrNo[digit].equals("")) {
			return true;
		}
		return false;
	}

	private static boolean checkAirthmetic(String s1, String s2, String s3) {
		int sn1 = Integer.parseInt(s1);
		int sn2 = Integer.parseInt(s2);
		int sn3 = Integer.parseInt(s3);
		return ((sn1 + sn2) == sn3 && (s3.charAt(0) != '0'));
	}
}
