package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.AdminServices;

@WebServlet("/DeleteDoctorServlet")
public class DeleteDoctorServlet extends HttpServlet {
	
	// This servlet (DeleteDoctorServlet) is for manage delete a selected doctor
	
	private static final long serialVersionUID = 1L;

    public DeleteDoctorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int docId = Integer.parseInt(request.getParameter("doctorId"));
		
		AdminServices.deleteDoctor(docId);
		
		RequestDispatcher rd = request.getRequestDispatcher("ViewDoctorServlet"); 
		
        System.out.print("Doctor records deleted successfully");
        
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
