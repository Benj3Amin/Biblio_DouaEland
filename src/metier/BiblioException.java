package metier;


public class BiblioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BiblioException() {
		this("");
	}
	
	
	public BiblioException(String message) {
		super(message);
	}

}
