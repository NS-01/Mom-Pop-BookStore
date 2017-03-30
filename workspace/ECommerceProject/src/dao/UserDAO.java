package dao;

import java.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class UserDAO {
	
	DataSource ds;
	public UserDAO() throws ClassNotFoundException
	{
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
			} catch (NamingException e) {
			e.printStackTrace();
			}
	}
   //*****check is the user and password is correct *****//
	public void checkUser(String username, String password) throws
	SQLException{
		String query = "select username, password from UserField Where username ='" + username + "' and "
				+ "password = '" + password + "'";

		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		String name = null;
		String passwordresult = null;
		while (r.next()) {
			
			name = r.getString("username");
			passwordresult = r.getString("password");

		}
		
	
		r.close();
		p.close();
		con.close();
		System.out.println(name + passwordresult + "worked");
}

    

}