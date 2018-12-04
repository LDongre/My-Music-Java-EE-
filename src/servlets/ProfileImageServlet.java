package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileImageServlet")
public class ProfileImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfileImageServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Code to store image
		System.out.println("ProfileImageServlet is called");
		
		String data = request.getParameter("fileInput");
		
		if(data == null) {
			System.out.println("no image file selected hhh");
		}
		else {
			System.out.println("file exists");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/ProfileImageServer.jsp");
		rd.include(request, response);
	}

}
