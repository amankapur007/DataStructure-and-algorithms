package com.aman.algorithms.backtracking;

import java.util.ArrayList;

public class nPrimsSum {

	private static ArrayList<Integer> primes = new ArrayList<>();
	private static int count = 0;
	private static ArrayList<Integer> primesSum = new ArrayList<>();

	public static void main(String[] args) {
		int n = 4;
		int prime = 3;
		int sum = 54;
		getPrimeNumbers(prime + 1, sum);
		System.out.println(primes);
		if (getPrimeForSum(sum, n, primes, 0, 0)) {
			display(primesSum);
		}

	}

	private static void display(ArrayList<Integer> primesSum2) {
		for (int i : primesSum2) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static boolean getPrimeForSum(int sum, int n, ArrayList<Integer> primes2, int index, int customSum) {
		if (customSum == sum && count == n) {
			display(primesSum);
			return true;
		}

		for (int i = index; i < primes2.size(); i++) {
			if (customSum < sum) {
				customSum = customSum + primes2.get(i);
				count = count + 1;
				primesSum.add(primes2.get(i));
				getPrimeForSum(sum, n, primes2, i + 1, customSum);
				primesSum.remove(primes2.get(i));
				customSum = customSum - primes2.get(i);
				count = count - 1;
				/*
				 * if (getPrimeForSum(sum, n, primes2, i + 1, customSum)) { return true; } else
				 * { primesSum.remove(primes2.get(i)); customSum = customSum - primes2.get(i);
				 * count = count - 1; }
				 */
			}
		}

		return false;
	}

	private static boolean getPrimeNumbers(int i, int sum) {
		if (i >= sum) {
			return true;
		}

		if ((i == 2 || i == 3 || i == 5 || i == 7) || (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0)) {
			primes.add(i);
			return getPrimeNumbers(i + 1, sum);
		} else {
			return getPrimeNumbers(i + 1, sum);
		}
	}
}
