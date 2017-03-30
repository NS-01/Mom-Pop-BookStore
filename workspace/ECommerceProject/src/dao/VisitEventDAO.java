package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class VisitEventDAO {
	DataSource ds;
	public VisitEventDAO() throws ClassNotFoundException
	{
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
			} catch (NamingException e) {
			e.printStackTrace();
			}
	}
	//**** inserting an event when customer logs in ******//
	public void insertEvent(String day, String bid,String eventtype, String username) throws
	SQLException{
		String query_cart = "INSERT INTO VisitEvent(day,bid,eventtype,username) VALUES ('"
	 + day + "','" + bid + "','" + eventtype + "','" + username + "')";
		Connection con = this.ds.getConnection();
		Statement statement = con.createStatement();
		statement.executeUpdate(query_cart);
	
		
		statement.close();
		con.close();
}

}
