package ctrl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import bean.CartBean;
import bean.VisitEventBean;
import dao.BookDAO;
import dao.CartDAO;
import dao.PurchaseOrderDAO;
import dao.RegisterDAO;
import dao.UserDAO;
import dao.VisitEventDAO;

/**
 * Servlet implementation class main
 */
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			PurchaseOrderDAO po = new PurchaseOrderDAO();
			ArrayList<CartBean> list = null;
			CartBean b = new CartBean("planet",20,"Fantasy","b001");
			CartDAO a =new CartDAO();
			a.addToCart("b001", "sabir2002");
			for (Entry<Integer, CartBean> entry2 : a.displayCart().entrySet())
				list.add(entry2.getValue());
			po.submitOrder("sabir2002", "denied", list);

		}

		 catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
