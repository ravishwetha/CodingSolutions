// This program computes the maximum contiguous subsequence sum
// of an integer array.

import java.util.*;

public class MaxSubSum {
	public static void main(String[] args) { 

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int size = sc.nextInt();
		int[] arr = new int[size];

		System.out.print("Enter " + size + " integers: ");
		for (int i=0; i<size; i++)
			arr[i] = sc.nextInt();

		//System.out.println("Answer = " + maxSubSumV1(arr));
		// System.out.println("Answer = " + maxSubSumV2(arr));
		System.out.println("Answer = " + maxSubSumV3(arr));
	}

	// This version has running-time of O(n^3)
	public static int maxSubSumV1(int[] arr) {
		int maxSum = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int thisSum = 0;
				for (int k = i; k <= j; k++)
					thisSum += arr[k];
				if (thisSum > maxSum)
					maxSum = thisSum;
			}
		}
		return maxSum;
	}

	// This version has running-time of O(n^2)
	public static int maxSubSumV2(int[] arr) {
		int maxSum = 0;

		for (int i = 0; i < arr.length; i++) {
			int thisSum = 0;
			for (int j = i; j < arr.length; j++) {
				thisSum += arr[j];
				if (thisSum > maxSum)
					maxSum = thisSum;
			}
		}
		return maxSum;
	}

	// This version should have running-time of O(n)
	public static int maxSubSumV3(int[] arr) {
		int maxSum = 0;
		int thisSum = 0;
		int start = -1;
		int stop = -1;

		for(int i=0, j=0; j<arr.length; j++) {
			thisSum += arr[j];

			if(thisSum > maxSum) {
				maxSum = thisSum;
				start = i;
				stop = j;
			}
			else if(thisSum < 0) {
				i = j+1;
				thisSum = 0;
			}
		}
		return maxSum;
	}
}
