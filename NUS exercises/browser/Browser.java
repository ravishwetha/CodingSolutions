/**
*	Name		: Ravi Shwetha
*	Matric No.	: A0146130W
*/

import java.util.*;

public class Browser {
	public static LinkedList<String> tabs;
	public static final int MAX_N = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		tabs = new LinkedList<String>();
		String defTab = "http://www.comp.nus.edu.sg";
		tabs.setHead(defTab);

		int Q = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<Q; i++) {
			String QueryLine = sc.nextLine();
			String[] Query = QueryLine.split("\\s+");

			switch(Query[0]) {

				case "NEWTAB" : tabs.add(defTab);
				                break;

				case "CLOSETAB" : tabs.removeCurrent();
				                  break;

				case "NEXTTAB" : tabs.nextNode();
				                 break;

				case "PREVTAB" : tabs.prevNode();
				                 break;

				case "OPENHERE" : tabs.getCurrent().setElement(Query[1]);
				                  break;

				case "OPENNEW" : tabs.add(Query[1]);
				                 break;

				default : System.out.println("invalid query");
			}
			String url = "";
			if(Query.length > 1) {
				url = Query[1];
			}
			//System.out.println(tabs.toString());
			//System.out.print(Query[0] + " " + url + " - ");
			//System.out.println(" index: " + tabs.findCurrentIndex() + " size: " + tabs.getSize() + " current: " + tabs.getCurrentElement());
			//System.out.println();
            System.out.println(tabs.getCurrentElement());
		}
	}
}

class LinkedList<E> {
	protected ListNode<E> head = null;
	protected ListNode<E> newest = null;
	protected ListNode<E> current = null;
	protected int size;

	public void setHead(E item) {
		head = new ListNode<E>(item);
		current = head;
		size = 0;
	}

	public E getCurrentElement() {
		return this.current.getElement();
	}

	public ListNode<E> getCurrent() {
		return this.current;
	}

	public int getSize() {
		return this.size;
	}

	public String toString() {
		String result = "[" + head.getElement();
		ListNode<E> node = head.getNext();
		while(node != null) {
			result = result + ", " + node.getElement();
			node = node.getNext();
		}
		return result + "]";
	}

	public void add(E item) {
		newest = new ListNode<E>(item, current.getNext());
		current.setNext(newest);
		size++;
	}

	public void removeCurrent() {
		ListNode<E> prevnode = findPrevNode();
		int currentIndex = findCurrentIndex();
		if(currentIndex == 0) {
			head = current.getNext();
			current = head;
		}
		else if(currentIndex == size) {
			current = prevnode;
			current.setNext(null);
		}
		else {
			current = current.getNext();
			prevnode.setNext(current);
		}
		size--;
	}

	public void nextNode() {
		if(current.getNext() != null) {
			current = current.getNext();
		}
	}

	public void prevNode() {
		ListNode<E> prevnode = findPrevNode();
		if(prevnode != null) {
			current = prevnode;
		}
	}

	private int findCurrentIndex() {
		ListNode<E> node = current;
		int index = size+1;
		while(node != null) {
			node = node.getNext();
			index--;
		}
		return index;
	}

	private ListNode<E> findPrevNode() {
		ListNode<E> prev = head;
		int previndex = findCurrentIndex()-1;
		if(previndex == -1) {
			return current;
		}
		for(int i=0; i<previndex; i++) {
			prev = prev.getNext();
		}
		return prev;
	}
}

class ListNode<E> {
	protected E element;
	protected ListNode<E> next;

	/* constructors */
	public ListNode(E item) {
		element = item;
		next = null;
	}

	public ListNode(E item, ListNode<E> n) {
		element = item;
		next = n;
	}

	/* get the next ListNode */
	public ListNode<E> getNext() {
		return this.next;
	}

	/* get the element of the ListNode */
	public E getElement() {
		return this.element;
	}

	public void setNext(ListNode<E> item) {
		this.next = item;
	}

	public void setElement(E item) {
		this.element = item;
	}
}
