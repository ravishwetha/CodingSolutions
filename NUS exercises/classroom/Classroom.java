/**
 *	Name		: Ravi Shwetha
 *	Matric No.	: A0146130W
 */

import java.util.*;

public class Classroom {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();

		ListNode<String> head = new ListNode<String>("Sharon");
		LinkedList<ListNode> students = new LinkedList<ListNode>(head);

		for(int i=0; i<N; i++) {
			String QueryLine = sc.nextLine();
			String[] Query = QueryLine.split("\\s+");
			switch(Query[0]) {
				case "enter": ListNode<String> student1 = new ListNode<String>(Query[1]);
				              students.addAfter(student1, student2);
				              break;

				default: System.out.println(Query[0] + " is invalid");
			}
			students.toString();
		}
    }
}

class LinkedList<E> {
    protected ListNode head = null;
	protected int size = 0;

	public LinkedList() {
		this.head = null;
		this.size = 1;
	}

	public LinkedList(E head) {
		this.head = head;
		this.size = 1;
	}

    public void addAfter(E item, E after) {
		after.setNext(item);
		this.size++;
    }

	private LinkNode<E> findByElement(E item) 
    
    private int findIndex(E item) {
		//index starts from 1
		int index = -1;
		E node = head;
		while(!node.getElement().equals(item)) {
			index++;
			if(node == null) {
				return -1;
			}
		}
        return index;
    }

	public void toString() {
		E node = head;
		while(node != null) {
			System.out.print(node.getElement());
			node = node.getNext();
			if(node != null) {
				System.out.println("\\s");
			}
		}
	}
}

class ListNode<E> {
    protected E element;
    protected ListNode<E> next;
    
    /* constructor */
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
