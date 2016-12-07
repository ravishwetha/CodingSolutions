// This program reads a string, removes all its heading and
// trailing spaces, and replaces every block of consecutive
// spaces with a single space.

// Add import statement(s) below
import java.util.*;

public class PrettyPrinter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a line below:");
		String line = sc.nextLine();
		String[] lineWords = line.split("\\s+");

		String newLine = lineWords[1];
		for(int i=2; i<lineWords.length; i++) {
			newLine = newLine.concat(" ");
			newLine = newLine.concat(lineWords[i]);
		}

		lineWords[0].replaceAll("\\s", "");
		System.out.println("Pretty-printed line:");
	    System.out.println("|" + lineWords[0] + " " + newLine + "|");
	}
}
