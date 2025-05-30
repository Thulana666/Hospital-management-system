package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PatientModel;
import services.AdminServices;


@WebServlet("/ViewPatientServlet")
public class ViewPatientServlet extends HttpServlet {
	
	// This servlet (ViewPatientServlet) is for manage view Patient details
	
	private static final long serialVersionUID = 1L;

    public ViewPatientServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<PatientModel> details = AdminServices.viewPatients();
		
		request.setAttribute("pDetails", details);
		
		RequestDispatcher rd = request.getRequestDispatcher("manage_users.jsp"); 
        
        rd.forward(request, response);
	}

}
