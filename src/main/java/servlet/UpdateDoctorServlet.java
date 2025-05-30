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

@WebServlet("/UpdateDoctorServlet")
public class UpdateDoctorServlet extends HttpServlet {
	
	// This servlet (UpdateDoctorServlet) is for manage update doctors
	
	private static final long serialVersionUID = 1L;

    public UpdateDoctorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// To get doctor details from Doctor table to display in 'update form' values
		
		int docId = Integer.parseInt(request.getParameter("doctorId"));
		System.out.println("want-to-update-docId : " + docId);
		
		List<DoctorModel> updateList = AdminServices.viewDoctorById(docId);
		request.setAttribute("Details", updateList);

		RequestDispatcher rd = request.getRequestDispatcher("update_doc.jsp"); 
        
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Send new updated doctor info from 'doctor form'
		
		int		docId = Integer.parseInt(request.getParameter("Doctor_ID"));
		int		expe = Integer.parseInt(request.getParameter("Experience"));
		String 	name = request.getParameter("Doc_Name");
		String 	email = request.getParameter("Email");
		String 	contact = request.getParameter("Phone");
		String	special = request.getParameter("Specialization");
		String	address = request.getParameter("Doc_Address");
		String	password = request.getParameter("Password");
		
		DoctorModel docUpdate = new DoctorModel();
		
		docUpdate.setdoctorId(docId);
		docUpdate.setName(name);
		docUpdate.setSpecialization(special);
		docUpdate.setEmail(email);
		docUpdate.setContact(contact);
		docUpdate.setExperience(expe);
		docUpdate.setAddress(address);
		docUpdate.setAddress(password);
		
		AdminServices service = new AdminServices();
		
		service.updateDoctor(docUpdate);
		
		RequestDispatcher dis = request.getRequestDispatcher("ViewDoctorServlet");
		
		dis.forward(request, response);
	}

}
