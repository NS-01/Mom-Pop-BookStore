package dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.BookBean;
import bean.UserBean;

public class UserDAO {

	DataSource ds;

	public UserDAO() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// *****check is the user and password is correct *****//
	public boolean checkUser(String username, String password) throws SQLException {
		String query = "select username, password from UserField Where username = ? and " + " password = ?";

		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		p.setString(1, username);
		p.setString(2, password);
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
		if (name == null && passwordresult == null)
			return false;
		if (name.equals(username) && passwordresult.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	//**** display all the users****//
	public Map<String, UserBean> displayAllUsers() throws SQLException {
		String query = "select * from UserField";
		Map<String, UserBean> rv = new HashMap<String, UserBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();

		while (r.next()) {

			String username = r.getString("username");
			String fname = r.getString("fname");
			String lname = r.getString("lname");
			String password = r.getString("password");
			int id = r.getInt("id");
			UserBean user = new UserBean(username, password, fname, lname, id);
			rv.put(username, user);
		}

		r.close();
		p.close();
		con.close();
		return rv;
		}
		
	// *****check is the user and password is correct *****//
	public boolean checkDuplicateUser(String username) throws SQLException {
		boolean check = true;
		String query = "select username from UserField Where username = ?";

		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		p.setString(1, username);
		ResultSet r = p.executeQuery();
		String name = null;
		while (r.next()) {
			
			
			name = r.getString("username");
			if(name == null)
				check= false;
			else if(!name.equals(username))
				check = true;
			else
				check= false;
		

		}

		r.close();
		p.close();
		con.close();
	return check;
	}
	// *****check is the id number *****//
		public int checkLatestID() throws SQLException {
			int check = 0;
			String query = "select * from UserField";

			Connection con = this.ds.getConnection();
			PreparedStatement p = con.prepareStatement(query);
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

