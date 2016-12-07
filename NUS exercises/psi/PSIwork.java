// Name: Ravi Shwetha
// Matric number: A0146130W

import java.util.*;

public class PSI {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();

		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		sc.nextLine();

		//System.out.println("N = " + N);
		//printArr(nums);

		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {
		int len = nums.length;
		int[] sums = new int[len*len];
		int sum = 0;
		int sumsID = 0;

		for(int i=0; i<len; i++) {
			sum = 0;
			for(int j=i; j<len; j++) {
				sum += nums[j];
				if(sum > 0) {
					sums[sumsID] = sum;
					sumsID++;
				}
			}
		}
		//printArr(sums);
		return sumsID;
	}

	private static void printArr(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
