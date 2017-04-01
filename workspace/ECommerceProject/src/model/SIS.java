package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.BookBean;
import bean.CartBean;
import bean.UserBean;
import dao.BookDAO;
import dao.CartDAO;
import dao.PurchaseOrderDAO;
import dao.RegisterDAO;
import dao.UserDAO;
import dao.VisitEventDAO;

public class SIS {
	
	private BookDAO book;
	private CartDAO cart;
	private PurchaseOrderDAO purchase;
	private RegisterDAO register;
	private UserDAO user;
	private VisitEventDAO visit;
	
	
	public SIS() throws ClassNotFoundException
	{
		book = new BookDAO();
		cart = new CartDAO();
		purchase = new PurchaseOrderDAO();
		register = new RegisterDAO();
		user = new UserDAO();
		visit = new VisitEventDAO();
		
	}
	
	public Map<String, BookBean>  retrieveAllBooks() throws SQLException
	{
		return book.retrieveAllBooks();
	}
	
	//******Do an advanced search*****//
	public Map<String, BookBean> retrieveAdvanceSearch(String title, String category,String author, String bid) throws SQLException
	{
		Map<String,BookBean> search = new HashMap<String, BookBean>();
		search.putAll(book.retrieveByAuthor(author));
		search.putAll(book.retrieveByBid(bid));
		search.putAll(book.retrieveByCategory(category));
		search.putAll(book.retrieveByTitle(title));
		return search;
		
		
	}
	public Map<String, BookBean> retrieveByAuthor(String author) throws SQLException
	{
		return book.retrieveByAuthor(author);
	}
	public Map<String, BookBean> retrieveByCategory(String category) throws SQLException
	{
		return book.retrieveByCategory(category);
	}
	public Map<String, BookBean> retrieveByTitle(String title) throws SQLException
	{
		return book.retrieveByTitle(title);
	}
	public Map<String, BookBean> retrieveByBID(String bid) throws SQLException
	{
		return book.retrieveByBid(bid);
	}
	public Map<String, BookBean> SortByPrice(String sort) throws SQLException
	{
		return book.sortByPrice(sort);
	}
	public void addToCart(String bid, String username) throws SQLException{
		cart.addToCart(bid, username);
	}
	
	public void EmptyCart() throws SQLException{
		cart.EmptyCart();
	}
	
	public Map<Integer, CartBean> displayCart() throws SQLException
	{
		return cart.displayCart();
		
	}
	
	public String submitOrder(String username, String status, ArrayList<CartBean> list) throws SQLException {
		return purchase.submitOrder(username, status, list);
	}
	public void updateStatus() throws SQLException {
		purchase.updateStatus();
	}
	public void registerCustomer(String username, String password, String fname, 
			String lname,String street,String province,String country,String city, 
			String zip, String phone) throws SQLException{
		if (username == "" || username ==null)
			System.out.println("no username entered");
		else if (checkDuplicateUser(username) == true)
		{
			int id = user.checkLatestID() +1;
			register.registerCustomer(id,username, password, fname, lname, street,city, province, country, zip, phone);
		}
		else
			System.out.println("User name already exists");
	}
	public boolean checkUser(String username, String password) throws SQLException{
		
		return user.checkUser(username, password);
	}
	
	public boolean checkDuplicateUser(String username) throws SQLException{
	
		return user.checkDuplicateUser(username);
	}
	public void insertEvent(String day, String bid,String eventtype, String username) throws SQLException{
		int id = checkCurrentUserID(username);
		visit.insertEvent(id, day, bid, eventtype, username);
	}
	public Map<String, UserBean> displayAllUsers() throws SQLException
	{
		return user.displayAllUsers();
		
	}
	public int checkIdNumber() throws SQLException
	{
		return user.checkLatestID();
	}
	public int checkCurrentUserID(String username) throws SQLException
	{
		return visit.checkCurrentUserID(username);
	}
	
}
