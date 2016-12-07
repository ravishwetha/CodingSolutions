mport java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static int numberNeeded(String first, String second) {
		int num = 0;
		boolean isFound = false;
		char[] f = first.toCharArray();   
		char[] s = second.toCharArray();

		final char invC = '?';

		for(int i=0; i<f.length; i++) {
			char c = f[i];

			for(int j=0; j<s.length; j++) {
				if(s[j] == c) {
					isFound = true;
					f[i] = invC;
					s[j] = invC;
					break;
				}
			}
		}

		for(int l=0; l<f.length; l++) {
			if(f[l] != invC) num++;
		}   
		for(int l=0; l<s.length; l++) {
			if(s[l] != invC) num++;
		}

		return num;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
}
