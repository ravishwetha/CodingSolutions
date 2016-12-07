/**
 *	name	  : Ravi Shwetha
 *	matric no.: A0146130W
 */

import java.util.*;

public class Stick {
	private static int N;
	private static int X;
	private static int[] sticks;
	private static final int maxNum = 16;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
		N = sc.nextInt();
		X = sc.nextInt();
		sc.nextLine();

		sticks = new int[N];
		for(int i=0; i<N; i++) {
			sticks[i] = sc.nextInt();
		}
		sc.nextLine();

		if(X == 0) System.out.println(0);
		else {
			int ans = solve(-1, 0, 0);
			if(ans == 16) System.out.println(-1);
			else System.out.println(ans);
		}
	}

	private static int solve(int ID, int count, int sum) {
		if(sum == X) return count;
		else if(sum > X) return maxNum;
		else if(ID == sticks.length-1) return maxNum;
		else {
			int newSum = sum + sticks[ID+1];
			return Math.min(solve(ID+1, count, sum), solve(ID+1, count+1, newSum));
		}
	}
}
