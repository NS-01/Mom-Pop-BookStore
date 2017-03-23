package model;

import java.util.HashMap;

/**
 * A class that represents a shopping cart with books
 * Each book is associated with number of times it was put in the cart
 * @author Glib Sitiugin
 *
 */
public class ShoppingCart extends HashMap<Book, Integer> {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an empty Shopping Cart
	 */
	public ShoppingCart() {
		super();
	}
	
	/**
	 * Constructs a shallow copy of an other shopping cart 
	 * @param other other shopping cart
	 */
	public ShoppingCart(ShoppingCart other) {
		super();
		this.putAll(other);
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
	 * Removes a single book from the cart
	 * @param book book to be removed from the cart
	 */
	public void removeBook(Book book) {
		int count = this.containsKey(book) ? this.get(book) : 0;
		if (count > 0) {
			this.put(book, count - 1);
		}
		else {
			this.remove(book);
		}
	}
	
	/**
	 * Removes all copies of a given book from the cart
	 * @param book book whose copies are to be removed
	 */
	public void removeAll(Book book) {
		this.remove(book);
	}
}
