
/**
*	Name		:
*	Matric No.	:
*/

import java.util.*;

public class Browser {
	public static void main(String[] args) {

	}
}

class LinkedList<E> {
	protected ListNode head = null;

	public void addAfter(E item, E after) {

	}

	public int findIndex(E item) {
		return 0;
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
