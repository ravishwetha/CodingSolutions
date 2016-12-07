/**
 *	name	  : Ravi Shwetha
 *	matric no.: A0146130W
 */

import java.util.*;

class Result {
    // declare the member field
	private int[] nums;

    // declare the constructor
	public Result(int[] nums) {
		this.nums = nums;
	}

	/**
	 * 	solveMin		: to find the minimum product of triplets.
	 * 	Pre-condition  	:
	 * 	Post-condition 	:
	 */	
	public int solveMin(int[] data) {

		return 0;
	}

	/**
	 *	solveMax		: to find the maximum product of triplets.
	 * 	Pre-condition  	:
	 * 	Post-condition 	:
	 */	
	public int solveMax(int[] data) {

		return 0;
	}
}

public class Triplet {

	public static void main(String[] args) {

		// declare the necessary variables

		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
		int N = sc.nextInt();
		sc.nextLine();

		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}

		Result question = new Result();
		System.out.println(question.solveMin(nums));
		System.out.println(question.solveMax(nums));
	}
}
