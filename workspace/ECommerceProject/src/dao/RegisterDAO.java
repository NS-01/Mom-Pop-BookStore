package dao;

import java.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class RegisterDAO {
	
	DataSource ds;
	public RegisterDAO() throws ClassNotFoundException
	{
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
			} catch (NamingException e) {
			e.printStackTrace();
			}
	}
		//***** insert the registration *****///
	public void insert(String username, String password, String id, String fname, 
			String lname,String street,String province,String country, 
			String zip, String phone) throws
	SQLException{
		String query_user = "INSERT INTO Userfield (id,password,username) VALUES (" + id + 
		",'" + username + "','" + password+ "')";
		String query_address = "INSERT INTO Address (id, street, province, country, zip, phone) VALUES ("
				+ id + ",'" + street + "','" + province +"','" 
				+country + "','" + zip + "','" + phone + "')"; 
		Connection con = this.ds.getConnection();
		Statement statement = con.createStatement();
		statement.executeUpdate(query_address);
		statement.executeUpdate(query_user);
	
		
		statement.close();
		con.close();
}

    

}