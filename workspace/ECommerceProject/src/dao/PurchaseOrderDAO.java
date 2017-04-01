package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.CartBean;

public class PurchaseOrderDAO {
	DataSource ds;

	public PurchaseOrderDAO() throws ClassNotFoundException {

		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
		//****** submit the cart order****//
	public String submitOrder(String username, String status, ArrayList<CartBean> list) throws SQLException {
		String result = "";
		try {
			Connection con = this.ds.getConnection();
			Statement statement = con.createStatement();
			ResultSet po = statement.executeQuery("SELECT count(*) FROM po");
			po.next();
			int count_row = po.getInt(1);
			if (count_row % 3 == 0) {
				result = "Credit Card Authorization Failed.";
			} else {
				result = "Order Successfully Completed.";
			}
			po.close();
			ResultSet poitem = statement.executeQuery("SELECT count(*) FROM poitem");
			poitem.next();
			int count_row_poitem = poitem.getInt(1);
			poitem.close();

			count_row++;
			
			statement.executeUpdate("Insert Into po (username,status,address) Values ('" + username
					+ "', '" + status + "'," + 1 +")" );

			for (CartBean cart : list) {
				count_row_poitem++;
				statement.executeUpdate("Insert Into poitem VALUES (" + count_row_poitem + ", '" + cart.getBid() + "', "
						+ cart.getPrice() + ")");
			}

			statement.close();
			con.close();

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
		//***** update the status of the order 
	public void updateStatus() throws SQLException {
		Connection con = this.ds.getConnection();

		Statement stmt = con.createStatement();

		String query = "Update PO Set status='denied' WHERE MOD(ind, 3) = 0";
		stmt.executeUpdate(query);
		query = "Update PO Set status='processed' WHERE status='ordered'";
		stmt.executeUpdate(query);
	}

}
