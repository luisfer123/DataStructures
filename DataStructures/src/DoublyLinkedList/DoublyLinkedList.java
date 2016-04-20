package DoublyLinkedList;

public class DoublyLinkedList<E> {
	
	private DoublyLinkedNode<E> firstNode;
	private DoublyLinkedNode<E> lastNode;
	private int size;

	/** ====================== Constructors =========================== */

	public DoublyLinkedList() {
		firstNode = new DoublyLinkedNode<>();
		lastNode = new DoublyLinkedNode<>();
		firstNode.setNext(lastNode);
		lastNode.setPrev(firstNode);
		size = 0;
	}

	public DoublyLinkedList(E data) {
		this();
		addFirst(data);
	}

	/** ====================== Appender Methods ============================= */

	public void addFirst(E data) {

		DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>(data);
		DoublyLinkedNode<E> temp = firstNode.getNext();

		firstNode.setNext(newNode);
		newNode.setPrev(firstNode);
		temp.setPrev(newNode);
		newNode.setNext(temp);
		size++;
	}

	public void addEnd(E data) {

		DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>(data);
		DoublyLinkedNode<E> temp = lastNode.getPrev();
		
		lastNode.setPrev(newNode);
		newNode.setNext(lastNode);
		temp.setNext(newNode);
		newNode.setPrev(temp);
		size++;
	}
	
	public void add(E data, int position) throws IndexOutOfBoundsException {
		
		if(isValidIndex(position))
			throw new IndexOutOfBoundsException("The index " + position + "is out fo bounds!");
		
		DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>(data);
		DoublyLinkedNode<E> temp;
		
		temp = firstNode;
		// The new node will be added as temp's next node.
		for(int i = 0; i < position; i++)
			temp = temp.getNext();
		newNode.setNext(temp.getNext());
		temp.getNext().setPrev(newNode);
		newNode.setPrev(temp);
		temp.setNext(newNode);
		size++;
	}

	
	/** ====================== Remover Methods ============================= */
	
	public E remove(int position) throws IndexOutOfBoundsException {
		
		if(!isValidIndex(position))
			throw new IndexOutOfBoundsException("The index " + position + " is out of bounds");
		
		DoublyLinkedNode<E> temp = firstNode;
		for(int i = 0; i < position; i++)
			temp = temp.getNext();
		
		E data = temp.getNext().getData();
		temp.setNext(temp.getNext().getNext());
		temp.getNext().setPrev(temp);
		size--;
		
		return data;
	}
	
	public E removeFirst() throws EmptyListException {
		
		if(isEmpty())
			throw new EmptyListException();
		
		DoublyLinkedNode<E> temp = firstNode.getNext().getNext();
		E data = firstNode.getNext().getData();
		temp.setPrev(firstNode);
		firstNode.setNext(temp);
		size--;
		
		return data;
	}
	
	public E removeLast() throws EmptyListException {
		
		if(isEmpty())
			throw new EmptyListException();
		
		DoublyLinkedNode<E> temp = lastNode.getPrev().getPrev();
		E data = lastNode.getPrev().getData();
		temp.setNext(lastNode);
		lastNode.setPrev(temp);
		size--;
		return data;
	}
	
	public void clear() {
		firstNode.setNext(lastNode);
		lastNode.setPrev(firstNode);
		size = 0;
	}
	
	/** ====================== Getter Methods ============================= */
	
	public E getElement(int index) throws IndexOutOfBoundsException {
		
		if(isValidIndex(index))
			throw new IndexOutOfBoundsException();
		
		DoublyLinkedNode<E> temp = firstNode;
		for(int i = 0; i < index; i++)
			temp = temp.getNext();
		
		return temp.getNext().getData();
	}
	
	public int getSize() {
		return size;
	}
	
	/** ====================== Other Methods ============================= */
	
	public String toString() {
		String list = "[ - ";
		DoublyLinkedNode<E> temp = firstNode;
		
		for(int i = 0; i < size; i++) {
			temp = temp.getNext();
			list = list + temp.getData().toString() + " - ";
		}
		
		list += "]";
		
		return list;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private boolean isValidIndex(int position) {
		if(position < 0 || position >= size) {
			return false;
		} else {
			return true; 
		}
	}

}
