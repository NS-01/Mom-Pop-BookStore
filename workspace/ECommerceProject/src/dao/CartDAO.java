package dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.CartBean;



public class CartDAO {
	
	DataSource ds;
	public CartDAO() throws ClassNotFoundException
	{
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
			} catch (NamingException e) {
			e.printStackTrace();
			}
	}
		//*****Add to Cart****///
	public void addToCart(String bid, String username) throws
	SQLException{
		String query_cart = "INSERT INTO Cart(bid,username) VALUES ('" + bid + 
		"','" + username + "')";
		Connection con = this.ds.getConnection();
		Statement statement = con.createStatement();
		statement.executeUpdate(query_cart);
	
		
		statement.close();
		con.close();
}
	
		//******* Empty Cart ******//
	public void EmptyCart(String bid) throws
	SQLException{
		String query_cart = "TRUNCATE TABLE CART";
		Connection con = this.ds.getConnection();
		Statement statement = con.createStatement();
		statement.executeUpdate(query_cart);
	
		
		statement.close();
		con.close();
}
		//******* Display the cart*****//
	public Map<Integer, CartBean> displayCart() 
			throws SQLException {

		String query = "select b.bid as bid, b.title as title, b.category as category, b.price as price"
				+ " from book b, cart c, userfield u "
				+ "where u.username = c.username and b.bid = c.bid";
		Map<Integer, CartBean> rv = new HashMap<Integer, CartBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		String title_retrieve;
		String category_retrieve;
		int count =0;
		while (r.next()) {
			String bid = r.getString(1);
			title_retrieve = r.getString(2);
			category_retrieve = r.getString(3);
			int price = Integer.parseInt(r.getString(4));
			
			CartBean cart = new CartBean(title_retrieve, price, category_retrieve,bid);
			rv.put(count, cart);
			count++;

		}
		
	
		r.close();
		p.close();
		con.close();
		return rv;
}

	
}