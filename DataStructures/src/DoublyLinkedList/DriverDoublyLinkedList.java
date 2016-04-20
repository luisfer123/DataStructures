package DoublyLinkedList;

public class DriverDoublyLinkedList {
	
	static DoublyLinkedList<Integer> list1;
	static DoublyLinkedList<Integer> list2;
	static DoublyLinkedList<Integer> list3;
	
	public static void main(String[] args) {
		
		list1 = new DoublyLinkedList<>();
		list2 = new DoublyLinkedList<>();
		list3 = new DoublyLinkedList<>();
		
		startList1();
		startList2();
		
		System.out.println("This list was create using addFirst and has " + list1.getSize() + " elements\n" + list1.toString() + "\n");
		System.out.println("This list was create using addEnd and has " + list1.getSize() + " elements\n" + list2.toString() + "\n");
		
		try {
			list3.remove(0);
		} catch(IndexOutOfBoundsException exception) {
			System.out.println(exception.getMessage());
		} 
		
		try {
			list3.removeFirst();
		} catch (EmptyListException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			list3.removeLast();
		} catch (EmptyListException e) {
			System.out.println(e.getMessage() + "\n");
		}
		
		list1.removeFirst();
		System.out.println("list1 after remove the first node has size " + list1.getSize() + " and is:\n" + list1.toString() + "\n");

		list1.removeLast();
		System.out.println("list1 after remove the last node has size " + list1.getSize() + " and is:\n" + list1.toString() + "\n");

		removeOfList1(3);
		removeOfList1(4);
		try {
			removeOfList1(4);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
				
	}
	
	public static void removeOfList1(int index) {
		list1.remove(index);
		System.out.println("List1 after remove the node in the positon " + index + " has size " + list1.getSize() + " and is:\n" + list1.toString() + "\n");
	}
	
	public static void startList1() {
		list1.addFirst(0);
		list1.addFirst(1);
		list1.addFirst(2);
		list1.addFirst(3);
		list1.addFirst(4);
		list1.addFirst(5);
		list1.addFirst(6);
		list1.addFirst(7);
	}
	
	public static void startList2() {
		list2.addEnd(0);
		list2.addEnd(1);
		list2.addEnd(2);
		list2.addEnd(3);
		list2.addEnd(4);
		list2.addEnd(5);
		list2.addEnd(6);
		list2.addEnd(7);
	}

}
