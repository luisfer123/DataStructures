package linkedList;

// Node class to build a linked list.
public class Node<T> {
	
	private Node<T> next;
	private T data;
	
	// ====================== Constructors ===========================
	
	public Node(Node<T> next, T data) {
		this.next = next;
		this.data = data;
	}

	public Node(Node<T> next) {
		this(next, null);
	}
	
	public Node(T data) {
		this(null, data);
	}
	
	public Node() {
		this(null, null);
	}
	
	// =================== Getters and Setters methods =================

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
