
package linkedList;

public class List<T> {
	
	private Node<T> firstNode;  // This node is not actually part of the list, it is use to handle easier an empty list.
	private int size; // The number of nodes in the list.
	
	/** ====================== Constructors =========================== */
	
	/**
	 * Create a empty list.
	 */
	public List() {
		firstNode = new Node<>();
		size = 0;
	}
	
	public List(T data) {
		firstNode = new Node<>();
		Node<T> temp = new Node<>(data);
		firstNode.setNext(temp);
		size = 1;
	}
	
	/** ====================== Appender Methods ============================= */
	
	public void add(T data, int position) throws IndexOutOfBoundsException {
		
		Node<T> newNode = new Node<>(data);
		
		if(!isEmpty() && position >= 0 && position < size) {
			Node<T> temp = firstNode;
			for(int i = 0; i < position; i++) 
				temp = temp.getNext();
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
			size++;
		} else {
			throw new IndexOutOfBoundsException("Index " + position + " is out of bounds!");
		}
	}
	
	/**
	 * Append a new node at the end of the list with element data.
	 * @param data
	 */
	public void addEnd(T data) {
		
		// The element which will be append to the list.
		Node<T> newNode = new Node<>(data);
		size++; 
		
		if(isEmpty()) {
			firstNode.setNext(newNode);
		} else {
			Node<T> temp = firstNode;
			
			do {
				temp = temp.getNext();
			} while(temp.getNext() != null);
			
			temp.setNext(newNode);
		}
	}
	
	/**
	 * Append a new node to the list with the element data.
	 * @param data
	 */
	public void addFirst(T data) {
		
		Node<T> newNode = new Node<>(data);
		size++;
		
		if(isEmpty()) {
			firstNode.setNext(newNode);
		} else {
			Node<T> temp = new Node<>();
			temp.setNext(firstNode.getNext());
			firstNode.setNext(newNode);
			newNode.setNext(temp.getNext());
		}
		
	}
	
	/** ====================== Remover Methods ============================= */
	
	public void clear() {
		firstNode.setNext(null);
		size = 0;
	}
	
	/**
	 * Remove the first element of the list.
	 * @return the data of the first element of the list
	 * @throws EmptyDataStructureException
	 */
	public T removeFirst() throws EmptyListException {
		
		if(isEmpty()) {
			throw new EmptyListException();
		} else {
			Node<T> temp = firstNode.getNext();
			firstNode.setNext(temp.getNext());
			size--;
			return temp.getData();
		}
	}
	
	/**
	 * Remove the last element of the list.
	 * @return
	 * @throws EmptyDataStructureException
	 */
	public T removeLast() throws EmptyListException {
	
		if(isEmpty()) {
			throw new EmptyListException();
		} else {
			Node<T> temp = firstNode;
			T data;
			for(int i = 0; i < size-1; i++)
				temp = temp.getNext();
			data = temp.getNext().getData();
			temp.setNext(null);
			size--;
			return data;
		}
	}
	
	public T remove(int index) throws EmptyListException, EmptyListException {
		if(isEmpty()) {
			throw new EmptyListException();
		} else if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		} else {
			Node<T> temp = firstNode;
			T data;
			for(int i = 0; i < index; i++)
				temp = temp.getNext();
			data = temp.getNext().getData();
			temp.setNext(temp.getNext().getNext());
			size--;
			return data;
		}
	}
	
	/** ====================== Getter Methods ============================= */
	
	/**
	 * 
	 * The list is indexed since 0 to size-1
	 * @param index
	 * @return The data of the element in the position index.
	 * @throws IndexOutOfBoundsException
	 */
	public T getElement(int index) throws IndexOutOfBoundsException, EmptyListException {
		Node<T> temp = firstNode;
		
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");			
		} else if(isEmpty()) {
			throw new EmptyListException();
		} else {
			for(int i = 0; i <= index; i++ )
				temp = temp.getNext();
			
			return temp.getData();
		}
	}
	
	/**
	 * 
	 * @return number of elements of the list.
	 */
	public int getSize() {
		return size;
	}	
	
	/** ====================== Other Methods ============================= */
	
	public String toString() {
		String list = "[ - ";
		Node<T> temp = firstNode;
		
		for(int i = 0; i < size; i++) {
			temp = temp.getNext();
			list = list + temp.getData().toString() + " - ";
		}
		
		list += "]";
		
		return list;
	}
	
	/**
	 * 
	 * @return true if the list is empty, false other way.
	 */
	public boolean isEmpty() {
		return firstNode.getNext() == null;
	}
	
}
