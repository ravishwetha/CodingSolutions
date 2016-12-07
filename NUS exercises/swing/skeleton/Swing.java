/**
* Name: Ravi Shwetha
* Matric Number: A0146130W
*/

import java.util.*;

public class Swing {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();

		ArrayList<Integer> trees = new ArrayList<Integer>();

		for(int i=0; i<N; i++) {
			int tree = 
			trees.add(
		}
    }
}

public class Queue<E> {
	protected LinkedList<E> list;

	public Queue() {
		list = new LinkedList<E>();
	}

	public boolean empty() {
		if(list.getFirst() == null) {
			return true;
		}
		return false;
	}

	public void add(E e) {
		list.addLast(e);
	}

	public E peek() {
		if(list.getLast() == null) {
			return null;
		}
		return list.getLast();
	}

	public void E poll() {
		if(list.getLast() == null) {
			return null;
		}
		E obj = list.peek();
		list.removeLast();
	}
}
