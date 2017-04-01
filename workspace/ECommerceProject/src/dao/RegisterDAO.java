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
	public void registerCustomer(int id, String username, String password,String fname, 
			String lname,String street,String city,String province,String country, 
			String zip, String phone) throws
	SQLException{
		String query_user = "INSERT INTO Userfield (id,password,username,fname,lname) VALUES (?,?,?,?,?)";
		String query_address = "INSERT INTO Address (id,street,city, province, country, zip, phone) VALUES (?,?,?,?,?,?,?)"; 
		Connection con = this.ds.getConnection();
		PreparedStatement statement = con.prepareStatement(query_address);
		statement.setInt(1, id);
		statement.setString(2, street);
		statement.setString(3, city);
		statement.setString(4, province);
		statement.setString(5, country);
		statement.setString(6, zip);
		statement.setString(7, phone);
		statement.executeUpdate();
		statement.close();
		PreparedStatement statement2 = con.prepareStatement(query_user);
		statement2.setInt(1, id);
		statement2.setString(2, password);
		statement2.setString(3, username);
		statement2.setString(4, fname);
		statement2.setString(5, lname);
		statement2.executeUpdate();
		statement2.close();
		con.close();
}

    

}