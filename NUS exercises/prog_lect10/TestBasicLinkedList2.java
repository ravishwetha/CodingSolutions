import java.util.*;

public class TestBasicLinkedList2 {
	public static void main(String [] args) 
		                      throws NoSuchElementException {
		BasicLinkedList <Integer> list = new BasicLinkedList <Integer>();

		list.addFirst(34);
		list.addFirst(12);
		list.addFirst(9);
		list.print();

		System.out.println("Testing removal");
		list.removeFirst();
		list.print();
	}
}
