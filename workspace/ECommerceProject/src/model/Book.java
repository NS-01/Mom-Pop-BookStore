package model;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A class that represents a book with author, title and a cover picture
 * @author Glib Sitiugin
 */
public class Book {
	
	private String id;
	private String author;
	private String title;
	private Image cover;
	
	private static final String UNKNOWN_AUTHOR = "Unknown Author";
	private static final String UNKNOWN_TITLE = "Unknown Title";
	private static final String NO_COVER_PATH = "./res/catalog/book.png";
	/**
	 * Constructs a default book unknown author, unknown title and default cover
	 */
	public Book() {
		this.id = "0000";
		this.author = UNKNOWN_AUTHOR;
		this.title = UNKNOWN_TITLE;
		try {
			this.cover = ImageIO.read(new File(NO_COVER_PATH));
		} catch (IOException e) {
		}
	}
	
	/**
	 * @param author book author
	 * @param title book title
	 * @param cover link to book cover image
	 */
	public Book(String id, String author, String title, String cover) {
		this.id = id;
		this.author = author;
		this.title = title;
		try {
			this.cover = ImageIO.read(new File(cover));
		} catch (IOException e) {
			
		}
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}
	
	public Image getCover() {
		return cover;
	}
}
