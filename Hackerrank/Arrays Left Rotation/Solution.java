import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		for(int a_i=0; a_i < n; a_i++){
			a[a_i] = in.nextInt();

			int b_i = (a_i - d) % n;
			if((a_i - d) < 0) b_i = n + b_i;

			b[b_i] = a[a_i];
		}
		for(int b_i=0; b_i < n; b_i++){
			System.out.print(b[b_i] + " ");
		}
	}
}
