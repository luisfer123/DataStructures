package DoublyLinkedList;

public class DoublyLinkedNode<E> {
	
	DoublyLinkedNode<E> prev;
	DoublyLinkedNode<E> next;
	E data;
	
	/** ====================== Constructors =========================== */
	
	public DoublyLinkedNode(DoublyLinkedNode<E> prev, DoublyLinkedNode<E> next, E data) {
		this.prev = prev;
		this.next = next;
		this.data = data;
	}
	
	public DoublyLinkedNode(E data) {
		this(null, null, data);
	}
	
	public DoublyLinkedNode() {
		this(null);
	}
	
	/** =============== Getters and setters methods =========================== */

	public DoublyLinkedNode<E> getPrev() {
		return prev;
	}

	public void setPrev(DoublyLinkedNode<E> prev) {
		this.prev = prev;
	}

	public DoublyLinkedNode<E> getNext() {
		return next;
	}

	public void setNext(DoublyLinkedNode<E> next) {
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

}
