/**
 *  Name          : Ravi Shwetha
 *  Matric Number : A0146130W
 */

import java.util.*;

public class Pair {
	private static final int sumsMaxSize = 10000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();

		int[] players = new int[N];
		for(int i=0; i<N; i++) {
			players[i] = sc.nextInt();
		}
		sc.nextLine();

		System.out.println(findPairs(players));
	}

	private static int findPairs(int[] arr) {
		int n = arr.length;
		int[] sums = new int[sumsMaxSize];
		int countSums = 0;

		int sum = 0;
		int maxSum = 0;
		
		//find all possible team strengths
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				sum = arr[i] + arr[j];
				sums[sum]++;
				if(sum > maxSum) maxSum = sum;
			}
		}
		//look for repeated strengths to make balanced match possible
		for(int k=0; k<maxSum; k++) {
			if(sums[k] >= 2) {
				countSums += ((sums[k]-1)*(sums[k]))/2; //n teams with equal strength can be paired up (n-1)*(n)/2 ways
			}
		}
		return countSums*8; //each team pairing has 8 configurations
	}
}
