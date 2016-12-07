import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		double limit = Math.pow(10, m);

		int sum = 0;
		for(int i=11; i<limit; i++) {
			String str = Integer.toString(i);
			if(potentialDivisor(str) && rightRotate(str)%i == 0) sum += i;
		}

		System.out.println(last5Digits(sum));
	}

	private static boolean potentialDivisor(String str) {
		if(str.charAt(0)*2 <= str.charAt(1)) return false;
		else return true;
	}

	private static int rightRotate(String str) {
		int len = str.length();
		String r = str.charAt(len-1) + str.substring(0, len-1);
		//System.out.println(r);    
		return Integer.parseInt(String.valueOf(r));
	}

	private static String last5Digits(int num) {
		String str = Integer.toString(num);
		int digits = Math.min(5, str.length());
		return str.substring(str.length() - digits);
	}
}
