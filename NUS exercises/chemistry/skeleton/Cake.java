/**
 * Name          : Ravi Shwetha
 * Matric number : A0146130W
 */

import java.util.*;
import java.text.*;

public class Cake {
	private static int N;
	private static int K;

	public static void main(String[] args) {
		StackBLL<Block> stack = new StackBLL<Block>();
		
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine();

		for(int i=0; i<N; i++) {
			String BlockLine = sc.nextLine();
			String[] BlockDesc = BlockLine.split("\\s+");

			String type = BlockDesc[0];

			String chocUnits = BlockDesc[1];
			int chocs = Integer.parseInt(chocUnits);

			Block block = new Block(type, chocs);

			stack.push(block);
		}
        System.out.println(sumMaxChocs(stack));
	}

	private static int sumMaxChocs(StackBLL<Block> stack) {
		if(stack.empty()) {
			System.out.println(0);
		}
		LinkNode<Block> anchor = stack.getHead();
		if(anchor == null) {
			return 0;
		}
		int sum = 0;
		int max = 0;
		int limit;
		boolean hitBottom = false;
		sum = 0;
		LinkNode<Block> temp = anchor;
		limit = K;

		//removes the top element of stack and adds the difference between it and the incoming element to the sum
		while(hitBottom == false) {

			while(limit > 0 || temp.getElem().getT().equals("C")) {
				sum +=  temp.getElem().getC();
				if(temp.getElem().getT().equals("R")) {
					limit--;
				}

				temp = temp.getNext();
				if(temp == null) {
					hitBottom = true;
					break;
				}
			}

			if(sum > max) {
				max = sum;
			}
			if(hitBottom == true) {
				break;
			}
			//removes value of top element
			sum -= anchor.getElem().getC();

			//if top value had been raisin block, limit is adjusted upwards by 1
			if (anchor.getElem().getT().equals("R"))
			{ 
				limit++;
			}
			anchor = anchor.getNext();
		}
		return max;
	}
}

class Block {
	private String T;
	private int C;

	public Block(String T, int C) {
		this.T = T;
		this.C = C;
	}

	public String getT() {
		return this.T;
	}

	public int getC() {
		return this.C;
	}
}

class StackBLL<E> extends LinkedList<E> {
	private LinkedList<E> list;

	public StackBLL() {
		list = new LinkedList<E>();
	}

	public boolean empty() {
		return isEmpty();
	}

	public void push(E elem) {
		addFirst(elem);
	}

	public E peek() throws EmptyStackException {
		try {
			return head.getElem();
		}
		catch (NoSuchElementException e) {
			throw new EmptyStackException();
		}
	}

	public E pop() throws EmptyStackException {
		E obj = peek();
		removeHead();
		return obj;
	}
}

class LinkedList<E> {
	protected LinkNode<E> head;

	public LinkedList() {
		head = null;
	}

	public LinkedList(E elem) {
		head = new LinkNode<E>(elem);
	}

	public void addFirst(E elem) {
		LinkNode<E> node = new LinkNode<E>(elem, head);
		head = node;
	}

	public LinkNode<E> getHead() {
		if(head == null) {
			throw new NoSuchElementException();
		}
		return this.head;
	}

	public void removeHead() {
		if(head.getNext() == null) {
			head = null;
		}
		else if(head != null) {
			head = head.getNext();
		}
	}

	public boolean isEmpty() {
		return (head == null);
	}
}
	
class LinkNode<E> {
	private E element;
	private LinkNode<E> next;

	public LinkNode() {
		next = null;
	}

	public LinkNode(E elem) {
		element = elem;
	}

	public LinkNode(E elem, LinkNode<E> next) {
		element = elem;
		this.next = next;
	}

	public E getElem() {
		return this.element;
	}

	public void setElem(E elem) {
		this.element = elem;
	}

	public LinkNode<E> getNext() {
		return this.next;
	}

	public void setNext(LinkNode<E> next) {
		this.next = next;
	}
}
