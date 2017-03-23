package model;

import java.util.HashMap;

/**
 * A class that represents a bookstore catalog
 * @author Glib Sitiugin
 *
 */
public class Catalog extends HashMap<Book, Integer> {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an empty Catalog
	 */
	public Catalog() {
		super();
	}
	
	/**
	 * Puts a book in the cart
	 * @param book book to be put in the cart
	 */
	public void addBook(Book book) {
		int count = this.containsKey(book) ? this.get(book) : 0;
		this.put(book, count + 1);
	}
	
	/**
	 * Put qty number of book in the catalog
	 * @param book
	 * @param qty
	 */
	public void addBook(Book book, int qty)
	{
		int count = this.containsKey(book) ? this.get(book) : 0;
		this.put(book, count + qty);
	}
	
	/**
	 * Removes a single book from the catalog
	 * @param book book to be removed from the catalog
	 */
	public void removeBook(Book book) {
		int count = this.containsKey(book) ? this.get(book) : 0;
		if (count > 0) {
			this.put(book, count - 1);
		}
		else if (count == 0)
		{
			this.remove(book);
		}
		else
		{
			
		}
	}
	
	/**
	 * Removes all copies of a given book from the catalog
	 * @param book book whose copies are to be removed
	 */
	public void removeAll(Book book) {
		this.remove(book);
	}
}