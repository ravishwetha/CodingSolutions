import java.util.*;

public class TestListUsingArray {
	public static void main(String [] args) 
	                       throws NoSuchElementException {
		ListUsingArray <String> list = new ListUsingArray <String>();
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
