import java.util.*;

public class TestBasicLinkedList1 {
	public static void main(String [] args) 
	                       throws NoSuchElementException {
		BasicLinkedList <String> list = new BasicLinkedList <String>();
		list.addFirst("aaa");
		list.addFirst("bbb");
		list.addFirst("ccc");
		list.print();

		System.out.println("Testing removal");
		list.removeFirst();
		list.print();

		if (list.contains("aaa")) 
			list.addFirst("xxxx");
		list.print();
	}
}
