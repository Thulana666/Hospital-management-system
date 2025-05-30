 package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PrescriptionModel;
import services.HospitalServices;

@WebServlet("/AddPrescriptionServlet")
public class AddPrescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddPrescriptionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrescriptionModel prescriptMdl = new PrescriptionModel();
		
		//Get input values from jsp file and assign them to variables
		String type = request.getParameter("MedType");
		String name = request.getParameter("medName");
		int mg = Integer.parseInt(request.getParameter("MG"));
		int dose = Integer.parseInt(request.getParameter("dose"));
		int days = Integer.parseInt(request.getParameter("days"));
		String comment = request.getParameter("comments");
		String diagnosis = request.getParameter("diagnosis");
		String treatment = request.getParameter("treatment");
		String appDate = request.getParameter("appointmentDate");
		int patientID = Integer.parseInt(request.getParameter("Pat_ID"));
		
		//Assign above variables to PrescriptionModel using setters
		prescriptMdl.setPatient_ID(patientID);
		prescriptMdl.setMedType(type);
		prescriptMdl.setMedName(name);
		prescriptMdl.setMg(mg);
		prescriptMdl.setDose(dose);
		prescriptMdl.setDays(days);
		prescriptMdl.setComments(comment);
		prescriptMdl.setDiagnosis(diagnosis);
		prescriptMdl.setTreatment(treatment);
		prescriptMdl.setMedDate(appDate);
		
		//Declare an object from HospitalServices and call function to insert data
		HospitalServices services = new HospitalServices();
		services.insertData(prescriptMdl);
		
		RequestDispatcher dis = request.getRequestDispatcher("Doctor_Portal.jsp");
		
		dis.forward(request, response);
	}

}
