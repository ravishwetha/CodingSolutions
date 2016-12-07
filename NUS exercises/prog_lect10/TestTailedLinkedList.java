import java.util.*;

public class TestTailedLinkedList {
	public static void main(String [] args) throws NoSuchElementException {

		TailedLinkedList <String> list = new TailedLinkedList <String>();

		System.out.println("Part 1");
		list.addFirst("aaa");
		list.addFirst("bbb");
		list.addFirst("ccc");
		list.print();

		System.out.println("Part 2");
		list.addLast("xxx");
		list.print();

		System.out.println("Part 3");
		list.removeAfter(null);
		list.print();
	}
}
