package marcotumminia.esercizioJPA.exceptions;

public class ItemNotFoundException extends RuntimeException {

	public ItemNotFoundException(int id) {
		super("Item with id " + id + " not found!");
	}

}
