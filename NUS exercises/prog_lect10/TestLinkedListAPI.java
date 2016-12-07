import java.util.*;

public class TestLinkedListAPI {

	static void printList(LinkedList <Integer> alist) {
		System.out.print("List is: ");
		for (int i = 0; i < alist.size(); i++)
			System.out.print(alist.get(i) + "\t");
		System.out.println();
	}

	// Print elements in the list and also delete them
	static void printListv2(LinkedList <Integer> alist) {
		System.out.print("List is: ");
		while (alist.size() != 0) {    
			System.out.print(alist.element() + "\t");
			alist.removeFirst();
		}
		System.out.println();
	}

	public static void main(String [] args) {
		LinkedList <Integer> alist = new LinkedList <Integer>();
		for (int i = 1; i <= 5; i++)
			alist.add(new Integer(i));

		printList(alist);

		System.out.println("First element: " + alist.getFirst());		
		System.out.println("Last element: "  + alist.getLast());		
		alist.addFirst(888);
		alist.addLast(999);
		printListv2(alist);
		printList(alist);
	}  
}
