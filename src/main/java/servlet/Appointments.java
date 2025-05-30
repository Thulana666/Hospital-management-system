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
import services.AppointmentServices;

@WebServlet("/Appointments")
public class Appointments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Appointments() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Store return list from the method to AppDetails list
		List<AppointmentModel> AppDetails = AppointmentServices.getAppointment();
        request.setAttribute("Details", AppDetails);
        
        RequestDispatcher rd = request.getRequestDispatcher("Doctor_Appintments.jsp"); 
        
        rd.forward(request, response);
        
        System.out.println("APP DETAILS : "+AppDetails);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

	}

}
