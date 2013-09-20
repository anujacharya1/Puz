package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author aacharya Find the longest increasing subsequence in an array
 */

public class LongestIncreasingSubsequence {

	public static void main(String args[]) {
		int choice;
		Scanner scan = new Scanner(System.in);
		System.out
				.println("Enter choice : \n1:To use Test Cases 2: To give input");
		choice = scan.nextInt();
		switch (choice) {
		case 1:
			testCaseRunner();
			break;
		case 2:
			userInput();
		default:
			break;
		}
	}

	private static void userInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int number = scan.nextInt();
		int elements[] = new int[number];
		System.out.println("Enter the integers : ");
		for (int i = 0; i < number; i++) {
			elements[i] = scan.nextInt();
		}
		LIS(elements);
	}

	public static List<Integer> LIS(int[] a) {
		// Convert int to Integer
		Integer[] A = new Integer[a.length];
		for (int i = 0; i < a.length; i++) {
			A[i] = Integer.valueOf(a[i]);
		}
		
		// Initialize m to find which is maximum
		int[] m = new int[A.length];
		Arrays.fill(m, 1);

		for (int x = 1; x < A.length; x++)
			for (int y = 0; y < x; y++)
				if (m[y] >= m[x] && A[y] < A[x])
					m[x]++;

		int max = m[0]; // Index pointing to the max subarray
		
		for (int i = 0; i < m.length; i++)
			if (max < m[i])
				max = m[i];

		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = m.length - 1; i >= 0; i--)
			if (max == m[i]) {
				result.add(A[i]);
				max--;
			}

		Collections.reverse(result);
		System.out.println(result.toString());
		return result;
	}

	private static void testCaseRunner() {

		int integerArray[][] = { { 1, 33, 2, 5, 11, 13, 4 },
				{ 33, 31, 30, 35 }, { 63, 60, -1, 67, 68 },
				{ 170, 102, 04, 55 } };
		for (int i = 0; i < integerArray.length; i++) {
			LIS(integerArray[i]);
		}
	}
}