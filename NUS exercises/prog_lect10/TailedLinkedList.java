import java.util.*;

class TailedLinkedList <E> implements EnhancedListInterface <E> {

	// Data attributes
	private ListNode <E> head = null;
	private ListNode <E> tail = null;
	private int num_nodes = 0;

	// Return true if list is empty; otherwise return false.
	public boolean isEmpty() { 
		return (num_nodes == 0); 
	}

	// Return number of nodes in list.
	public int size() { 
		return num_nodes; 
	}

	// Return value in the first node.
	public E getFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("can't get from an empty list");
		else return head.getElement();
	}

	// Return true if list contains item, otherwise return false.
	public boolean contains(E item) {
		for (ListNode <E> n = head; n != null; n = n.getNext())
			if (n.getElement().equals(item)) return true;

		return false;
	}

	// Add item to front of list.
	public void addFirst(E item) {
		head = new ListNode <E> (item, head);
		num_nodes++;
		if (num_nodes == 1) 
			tail = head;
	}

	// Print values of nodes in list.
	public void print() throws NoSuchElementException {
		if (head == null)
			throw new NoSuchElementException("Nothing to print...");

		ListNode <E> ln = head;
		System.out.print("List is: " + ln.getElement());
		for (int i=1; i < num_nodes; i++) {
			ln = ln.getNext();
			System.out.print(", " + ln.getElement());
		}
		System.out.println(".");
	}

	// Return reference to first node.
	public ListNode <E> getHead() { 
		return head; 
	}

	// Return reference to last node of list.
	public ListNode <E> getTail() {
		return tail;
	}

	// Add item to end of list.
	public void addLast(E item) {
		if (head != null) {    
			tail.setNext(new ListNode <E> (item));
			tail = tail.getNext();
		} else {
			tail = new ListNode <E> (item);
			head = tail;
		}
		num_nodes++;
	}

	// Add item after node referenced by current
	public void addAfter(ListNode <E> current, E item) {
		if (current != null) {
			current.setNext(new ListNode <E> (item, current.getNext()));
			if (current == tail)  
				tail = current.getNext();
		} else { // add to the front of the list
			head = new ListNode <E> (item, head);
			if (tail == null) 
				tail = head;
		}
		num_nodes++;
	}

	// Remove node after node referenced by current
	public E removeAfter(ListNode <E> current) throws NoSuchElementException {
		E temp;
		if (current != null) {  
			ListNode <E> nextPtr = current.getNext();
			if (nextPtr != null) {
				temp = nextPtr.getElement();
				current.setNext(nextPtr.getNext());
				num_nodes--;
				if (nextPtr.getNext() == null) // last node is removed
					tail = current;
				return temp;
			} else throw new NoSuchElementException("No next node to remove");
		} else { // if current is null, we want to remove head
			if (head != null) {
				temp = head.getElement();
				head = head.getNext(); 
				num_nodes--;
				if (head == null)
					tail = null;
				return temp;
			} else throw new NoSuchElementException("No next node to remove");
		}
	}

	// Remove first node of list.
	public E removeFirst() throws NoSuchElementException {
		return removeAfter(null);
	}

	// Remove item from list
	public E remove(E item) throws NoSuchElementException {
		// write your code below...
		// should make use of removeAfter() method.






		return item;
	}
}

