/**
 *	name	  : Ravi Shwetha
 *	matric no.: A0146130W
 */

import java.util.*;

class Instruction {
	private static int N;
	private static int K;
	private static int[] nums = new int[16];
	private static char[] ops = new char[16];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine();

		int num;
		char op;
		for(int i=0; i<N; i++) {
			op = sc.next().charAt(0);
			num = sc.nextInt();
			sc.nextLine();

			nums[i] = num;
			ops[i] = op;
		}

		System.out.println(tryInstruct(0, 0));
	}

	private static int tryInstruct(int curr, int totOps) {
		if(curr == K || totOps == N) {
			return curr;
		}
		else {
			int newCurr = performInstruct(curr, nums[totOps], ops[totOps]);
			return findClosestToK((tryInstruct(curr, totOps+1)), (tryInstruct(newCurr, totOps+1)));
		}
	}

	private static int performInstruct(int curr, int num, char op) {
		int old = curr;
		if(op == '+') {
			curr += num;
		}
		else if(op == '-') {
			curr -= num;
		}
		else if(op == '*') {
			curr *= num;
		}
		else if(op == '/') {
			curr /= num;
		}
		else {
			System.out.println("error");
		}
		return curr;
	}

	private static int findClosestToK(int num1, int num2) {
		if(Math.abs(K-num1) == Math.abs(K-num2)) {
			return Math.min(num1, num2);
		}
		else {
			int dist1 = Math.abs(K-num1);
			int dist2 = Math.abs(K-num2);
			if(Math.min(dist1, dist2) == dist1) {
				return num1;
			}
			else {
				return num2;
			}
		}
	}
}
