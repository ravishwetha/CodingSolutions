import java.util.*;

class ListUsingArray <E> implements ListInterface <E> {
	private static final int MAXSIZE = 1;
	private int num_nodes = 0;
	private E[] arr = (E[]) new Object[MAXSIZE];

	public boolean isEmpty() { return num_nodes==0; }
	public int size()        { return num_nodes; }

	public E getFirst() throws NoSuchElementException {
		if (num_nodes == 0) 
			throw new NoSuchElementException("can't get from an empty list");
		else return arr[0];
	}

	public boolean contains(E item) {
		for (int i = 0; i < num_nodes; i++)
			if (arr[i].equals(item)) return true;

		return false;
	}

	public void addFirst(E item) throws IndexOutOfBoundsException {
		if (num_nodes == MAXSIZE)
			throw new IndexOutOfBoundsException("insufficient space for add");

		for (int i = num_nodes-1; i >= 0; i--)
			arr[i+1] = arr[i]; // to shift elements to the right

		arr[0] = item;
		num_nodes++; // update num_nodes
	}

	public E removeFirst() throws NoSuchElementException {
		if (num_nodes == 0) 
			throw new NoSuchElementException("can't remove from an empty list");
		else { 
			E tmp = arr[0];
			for (int i = 0; i<num_nodes-1; i++)
				arr[i] = arr[i+1]; // to shift elements to the left
	 		num_nodes--; // update num_nodes
			return tmp;
		}
	}

	public void print() throws NoSuchElementException {
		if (num_nodes == 0)
			throw new NoSuchElementException("Nothing to print...");

		System.out.print("List is: \n" + arr[0]);
		for (int i = 1; i < num_nodes; i++) 
			System.out.print (", " + arr[i]);
		System.out.println(".");
	}
}
