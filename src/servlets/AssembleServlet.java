package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secure/AssembleServlet")
public class AssembleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AssembleServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Reached assemble");
		String menu = request.getParameter("menu");
		System.out.println(menu);

		
		 
		 if(menu == null) {
			 response.sendRedirect("/MyMusic/index.jsp");
		 }
		 else if(menu.equals("logIn") || menu.equals("signUp") || menu.equals("player")) {
			 RequestDispatcher rd = request.getRequestDispatcher("/TypeServlet");
			 rd.include(request, response);
		 }	
		 else if(menu.equals("contact")) {
			 RequestDispatcher rd = request.getRequestDispatcher("/frame.jsp");
			 rd.include(request, response);
			 rd = request.getRequestDispatcher("/contactServer.jsp");
			 rd.include(request, response);
		 }
		 response.getWriter().println("</div></body></html>");
	}

}
