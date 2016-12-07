import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static boolean isBalanced(String expression) {
		Stack<Character> c = new Stack<Character>();

		for(int i=0; i<expression.length(); i++) {
			char curr = expression.charAt(i);
			if(c.empty()) c.push(curr);
			else if(matchBrack(c.peek(), curr)) {
				c.pop();
			} 
			else c.push(curr);
		}

		return (c.empty());
	}

	public static boolean matchBrack(char c1, char c2) {
		if(c1 == '(' && c2 == ')') return true;
		else if(c1 == '{' && c2 == '}') return true;
		else if(c1 == '[' && c2 == ']') return true;
		else return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
		}
	}
}
