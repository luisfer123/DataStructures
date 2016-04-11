package linkedList;

public class DriverList {
    
    static List<String> list1;
    static List<String> list2;
    static List<String> list3;
	
	public static void main(String[] args) {
		list1 = new List<>();
		list2 = new List<>();
		list3 = new List<>();
                
        startList1();
        startList2();
        startList3();
		
		System.out.println("The list1 has " + list1.getSize() + " Elements\n");
		printList(list1);
		
		System.out.println("The list2 has " + list2.getSize() + " Elements\n");
		printList(list2);
		
		System.out.println("The list3 has " + list3.getSize() + " Elements\n");
		printList(list3);
		
		try {
			list1.add("addPos", 0);
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage() + "\n");
		}
		
		System.out.println("The list1 has " + list1.getSize() + " Elements\n");
			
		printList(list1);
		
		try {
			System.out.println("Removing " + list3.remove(3) + " from the list");
			//System.out.println("Removing " + list3.removeLast() + " from the list");
			System.out.println("\n");
		} catch(EmptyListException e) {
			System.out.println(e.getMessage() + "\n");
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage() + "\n");
		}
		
		System.out.println("The list3 has " + list3.getSize() + " Elements\n");
		printList(list3);
		
	}
	
	/** ========================= Methods ====================================== */
	
	public static void printList(List<?> list) {
		
		String outPut = "[";
		for(int i = 0; i < list.getSize(); i++) {
			try {
				outPut += " - " + list.getElement(i);
			} catch(IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			} catch(EmptyListException e) {
				System.out.println(e.getMessage());
			}
		}
		
		outPut += " - ]";
		System.out.println(outPut + "\n");
	}
        
        public static void startList1() {
            list1.addEnd("Zero");
            list1.addEnd("one");
            list1.addEnd("two");
            list1.addEnd("three");
            list1.addEnd("four");
            list1.addEnd("five");
            list1.addEnd("six");
        }
        
        public static void startList2() {
            list2.addEnd("Zero");
            list2.addFirst("one");
            list2.addFirst("two");
            list2.addFirst("three");
            list2.addFirst("four");
            list2.addFirst("five");
            list2.addFirst("six");
        }
        
        public static void startList3() {
            list3.addEnd("Zero");
            list3.addEnd("One");
            list3.addEnd("Two");
            list3.addEnd("Trhee");
        }

}

