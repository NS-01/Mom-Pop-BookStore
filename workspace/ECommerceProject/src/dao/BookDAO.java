package dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import bean.BookBean;


public class BookDAO {
	
	DataSource ds;
	public BookDAO() throws ClassNotFoundException
	{
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
			} catch (NamingException e) {
			e.printStackTrace();
			}
	}
	//*****Search for a book*****//
	public Map<String, BookBean> retrieveSearch(String title, String category,String author) 
			throws SQLException {

		String query = "select * from Book Where title like '%" + title + "%' or " + " author like '%" + author + "%' or "
				+ "category = '" + category + "'" ;
		Map<String, BookBean> rv = new HashMap<String, BookBean>();

		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		String title_retrieve;
		String category_retrieve;
		while (r.next()) {
			String synopsis = r.getString("synopsis");
			String pic_url = r.getString("pic_url");
			title_retrieve = r.getString("title");
			category_retrieve = r.getString("category");
			String bid = r.getString("bid");
			int price = Integer.parseInt(r.getString("price"));
			BookBean book = new BookBean(bid, title_retrieve, price, category_retrieve,author,pic_url,synopsis);
			rv.put(bid, book);
			

		}
		
	
		r.close();
		p.close();
		con.close();
		return rv;
}

	//*****display all the books*****//
		public Map<String, BookBean> retrieveAllBooks() 
				throws SQLException {

			String query = "select * from Book";
			Map<String, BookBean> rv = new HashMap<String, BookBean>();

			Connection con = this.ds.getConnection();
			PreparedStatement p = con.prepareStatement(query);
			ResultSet r = p.executeQuery();
			String title_retrieve;
			String category_retrieve;
			while (r.next()) {
				String synopsis = r.getString("synopsis");
				String pic_url = r.getString("pic_url");
				title_retrieve = r.getString("title");
				category_retrieve = r.getString("category");
				String bid = r.getString("bid");
				String author = r.getString("author");
				int price = Integer.parseInt(r.getString("price"));
				BookBean book = new BookBean(bid, title_retrieve, price, category_retrieve,author,pic_url,synopsis);
				rv.put(bid, book);
				

			}

			
			
		
			r.close();
			p.close();
			con.close();
			return rv;
	}
		//*****Sort by price*****//
		
		public Map<String, BookBean> sortByPrice(String sort) 
				throws SQLException {

			String query = "";
			
			if (sort.equals("asc"))
			{
					query ="select * from Book order by price asc";
			}
			else if (sort.equals("desc"))
			{
				query ="select * from Book order by price desc";
			}
			else 
			{
				query ="select * from Book";
			}
			Map<String, BookBean> rv = new HashMap<String, BookBean>();

			Connection con = this.ds.getConnection();
			PreparedStatement p = con.prepareStatement(query);
			ResultSet r = p.executeQuery();
			String title_retrieve;
			String category_retrieve;
			while (r.next()) {
				
				String synopsis = r.getString("synopsis");
				String pic_url = r.getString("pic_url");
				title_retrieve = r.getString("title");
				category_retrieve = r.getString("category");
				String bid = r.getString("bid");
				String author = r.getString("author");
				int price = Integer.parseInt(r.getString("price"));
				BookBean book = new BookBean(bid, title_retrieve, price, category_retrieve,author,pic_url,synopsis);
				rv.put(bid, book);

			}

			
			
		
			r.close();
			p.close();
			con.close();
			return rv;
	}
		
		
		//*****display by category*****//
				public Map<String, BookBean> retrieveByCategory(String category) 
						throws SQLException {

					String query = "select * from Book where category='" +category + "'";
					Map<String, BookBean> rv = new HashMap<String, BookBean>();

					Connection con = this.ds.getConnection();
					PreparedStatement p = con.prepareStatement(query);
					ResultSet r = p.executeQuery();
					String title_retrieve;
					String category_retrieve;
					while (r.next()) {
						String synopsis = r.getString("synopsis");
						String pic_url = r.getString("pic_url");
						title_retrieve = r.getString("title");
						category_retrieve = r.getString("category");
						String bid = r.getString("bid");
						int price = Integer.parseInt(r.getString("price"));
						String author = r.getString("author");
						BookBean book = new BookBean(bid, title_retrieve, price, category_retrieve,author,pic_url,synopsis);
						rv.put(bid, book);
						

					}

					
					
				
					r.close();
					p.close();
					con.close();
					return rv;
			}	

}