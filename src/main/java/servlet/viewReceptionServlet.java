package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReceptionistModel;
import services.AdminServices;


@WebServlet("/viewReceptionServlet")
public class viewReceptionServlet extends HttpServlet {
	
	// This servlet (viewReceptionServlet) is for manage view Receptionist details
	
	private static final long serialVersionUID = 1L;

    public viewReceptionServlet() {
        super();
    }

    // doGet used for navigation bar
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ReceptionistModel> details = AdminServices.viewReceptionists();
		request.setAttribute("details", details);
		
		RequestDispatcher rd = request.getRequestDispatcher("manage_users.jsp"); 
        
        rd.forward(request, response);
	}

	// doPost used for form button
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ReceptionistModel> details = AdminServices.viewReceptionists();
		request.setAttribute("details", details);
		
		RequestDispatcher rd = request.getRequestDispatcher("manage_users.jsp"); 
        
        rd.forward(request, response);
	}

}
