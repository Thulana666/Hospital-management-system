package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DoctorPortalModel;
import services.DoctorPortalServices;


@WebServlet("/DoctorPortalServlet")
public class DoctorPortalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DoctorPortalServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Store return model from function to PatientCountResult
		DoctorPortalModel PatientCountResult = DoctorPortalServices.getPatientCount();
		request.setAttribute("patientCount", PatientCountResult);
		
		DoctorPortalModel AppointmentsCount = DoctorPortalServices.getAppointmentCount();
		request.setAttribute("AppointmentCount", AppointmentsCount);
		
		RequestDispatcher rd = request.getRequestDispatcher("Doctor_Portal.jsp"); 
        
        rd.forward(request, response);
        
//        System.out.println("Patient count : " + PatientCountResult);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
