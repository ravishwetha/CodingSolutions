import java.util.*;

public interface EnhancedListInterface <E> {

	public boolean  isEmpty();
	public int      size();
	public E        getFirst() throws NoSuchElementException; 
	public boolean  contains(E item);
	public void     addFirst(E item);
	public E        removeFirst() throws NoSuchElementException;  
	public void     print();

	public ListNode <E> getHead();
	public void     addAfter(ListNode <E> current, E item);
	public E        removeAfter(ListNode <E> current) throws NoSuchElementException;  
	public E        remove(E item) throws NoSuchElementException;  
}
