package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public void insertEvent(int id,String day, String bid,String eventtype, String username) throws
	SQLException{
		String query_cart = "INSERT INTO VisitEvent(id,day,bid,eventtype,username) VALUES (?,?,?,?,?)";
		Connection con = this.ds.getConnection();
		PreparedStatement statement = con.prepareStatement(query_cart);
		statement.setInt(1, id);
		statement.setString(2, day);
		statement.setString(3, bid);
		statement.setString(4, eventtype);
		statement.setString(5, username);
		statement.executeUpdate();
	
		
		statement.close();
		con.close();
}
	// *****check the id number of logged in use *****//
	public int checkCurrentUserID(String username) throws SQLException {
		int check = 0;
		String query = "select * from UserField where username=?";

		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		p.setString(1, username);
		ResultSet r = p.executeQuery();
		
		while (r.next()) {
			
			
			int id= r.getInt("id");
			check =id;
		

		}

		r.close();
		p.close();
		con.close();
	return check;
	}

}
