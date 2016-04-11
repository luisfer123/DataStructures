package linkedList;

public class EmptyListException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EmptyListException() {super("List is empty!"); }
	public EmptyListException(String message) { super(message); }
	public EmptyListException(String message, Throwable cause) { super(message, cause); }
	public EmptyListException(Throwable cause) { super(cause); }

}
