import java.util.*;

/* Getting length of the longest substring without repeated characters in a string */

public class LongestSubstring {

	public static void main(String[] args) {	
		Scanner sc = new Scanner (System.in);
		String inStr = new String(sc.next().toLowerCase());
		int maxSubstrLength = -1;

		// startPos is the starting index of the current substring without repeated characters in the string
		int startPos = 0;

		while (true) {
			int endPos = startPos+1;
			int newStartPos = 0;
			int curLength = 0;

			// keep extending current substring until hit a repeated character
			while (endPos < inStr.length()) {
				boolean stop = false;

				// check if current character is repeated before further extending the substring
				for (int counter = endPos-1; counter >= startPos; counter--)
					if (inStr.charAt(counter) == inStr.charAt(endPos)) {
						stop = true;
						newStartPos = counter+1; // new starting position for next longest substring candidate
						break;
					}
				if (stop)					
					break;
				endPos++;
			}
			curLength = endPos-startPos;
			startPos = newStartPos;

			// update the longest length if current substring is the longest
			if (curLength > maxSubstrLength)
				maxSubstrLength = curLength;
			if (endPos >= inStr.length()) // no more candidates to test for
				break;
		}
		System.out.println(maxSubstrLength);
	}
}
