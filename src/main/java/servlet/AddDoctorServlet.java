package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DoctorModel;
import services.AdminServices;


@WebServlet("/AddDoctorServlet")
public class AddDoctorServlet extends HttpServlet {
	
	// This servlet (AddDoctorServlet) is for manage create new doctor
	
	private static final long serialVersionUID = 1L;      
    
    public AddDoctorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DoctorModel docModel = new DoctorModel();
		
		// Get doctor details from form(manage_doc.jsp)
		String 	name = request.getParameter("Doc_Name");
		String 	special = request.getParameter("Specialization");
		String 	email = request.getParameter("Email");
		String 	contact = request.getParameter("Phone");
		String 	address = request.getParameter("Doc_Address");
		int		expe = Integer.parseInt(request.getParameter("Experience"));

		docModel.setName(name);
		docModel.setSpecialization(special);
		docModel.setEmail(email);
		docModel.setContact(contact);
		docModel.setExperience(expe);
		docModel.setAddress(address);
		
		// Generate a sample system generated password
		name = name.toLowerCase();	// Convert the username to lowercase
				
		name = name.replaceAll("\\s+", "");	// Remove all spaces from the username
		
		String password = "";

		if (name.length() < 8) {
		    password = name + "12345";				// If username is less than 8 characters, append "12345" to make it 8 characters
		    password = password.substring(0, 8);	// Trim it to exactly 8 characters
		} else {
		    password = name.substring(0, 8);		// If username is 8 characters or more, take the first 8 characters
		}

		docModel.setPassword(password);
		System.out.println("Generated Password: " + password);
		
		AdminServices.addDoctor(docModel);
		
		RequestDispatcher dis = request.getRequestDispatcher("ViewDoctorServlet");
		
		dis.forward(request, response);
	}

}
