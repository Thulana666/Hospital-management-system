package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AppointmentModel;
import model.Patient_recordModel;
import services.AppointmentServices;
import services.PatientRecordServices;


@WebServlet("/PatientRecordServlet")
public class PatientRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public PatientRecordServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get patient ID from jsp file and store it in a variable
		int PatientID = Integer.parseInt(request.getParameter("Pat_ID"));

		List<Patient_recordModel> details = PatientRecordServices.getPatientById(PatientID);
        request.setAttribute("Details", details);
        
        RequestDispatcher rd = request.getRequestDispatcher("Patient_record.jsp"); 
        
        rd.forward(request, response);
	}

}
