class DListNode <E> {
	/* data attributes */
	private E element;
	private DListNode <E> next; 
	private DListNode <E> prev;

	/* constructors */
	public DListNode(E item) {
		this(item, null, null);
	}

	public DListNode(E item, DListNode <E> p, DListNode <E> n) {
		element = item; 
		prev = p;
		next = n;
	}

	/* get the prev DListNode */
	public DListNode getPrev() {
		return this.prev;
	}

	/* get the next DListNode */
	public DListNode getNext() {
		return this.next;
	}

	/* get the element of the DListNode */
	public E getElement() {
		return this.element;
	}

	/* set the prev reference */
	public void setPrev(DListNode <E> p) {
		prev = p;
	}

	/* set the next reference */
	public void setNext(DListNode <E> n) {
		next = n;
	}
}
