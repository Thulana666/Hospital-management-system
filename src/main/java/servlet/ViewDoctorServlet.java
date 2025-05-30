package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DoctorModel;
import services.AdminServices;


@WebServlet("/ViewDoctorServlet")
public class ViewDoctorServlet extends HttpServlet {
	
	// This servlet (ViewDoctorServlet) is for manage view doctor details
	
	private static final long serialVersionUID = 1L;

    public ViewDoctorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<DoctorModel> details = AdminServices.viewDoctor();
        request.setAttribute("details", details);
		
        RequestDispatcher rd = request.getRequestDispatcher("manage_doc.jsp"); 
        
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<DoctorModel> details = AdminServices.viewDoctor();
        request.setAttribute("details", details);
		
        RequestDispatcher rd = request.getRequestDispatcher("manage_doc.jsp"); 
        
        rd.forward(request, response);
	}

}
