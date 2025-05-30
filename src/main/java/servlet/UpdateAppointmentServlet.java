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
import services.HospitalServices;


@WebServlet("/UpdateAppointmentServlet")
public class UpdateAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateAppointmentServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Get particular appointment ID needed to be updated
		int appID = Integer.parseInt(request.getParameter("appId"));
		
		//Store return list from function to AppDetails list
		List<AppointmentModel> AppDetails = AppointmentServices.getAppointmentById(appID);
        request.setAttribute("Details", AppDetails); 
        
        RequestDispatcher rd = request.getRequestDispatcher("update_appointment.jsp"); 
        System.out.print("1 APP ID : "+AppDetails);
        
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get updated data from jsp and store them in variables
		 int AppID = Integer.parseInt(request.getParameter("App_ID"));
		 String venue = request.getParameter("venue");
		 String appDate = request.getParameter("appDate");
		 String appTime = request.getParameter("appTime");
		 int Count = Integer.parseInt(request.getParameter("Count"));
		 
		 //Set the updated data to the model using setters
		 AppointmentModel UpdateModel = new AppointmentModel();
		 UpdateModel.setApp_Date(appDate);
		 UpdateModel.setApp_Time(appTime);
		 UpdateModel.setVenue(venue);
		 UpdateModel.setPatientCount(Count);
		 UpdateModel.setApp_ID(AppID);
		 
		 AppointmentServices services = new AppointmentServices();
			
		services.updateAppointmentData(UpdateModel);

		RequestDispatcher dis = request.getRequestDispatcher("Doctor_Portal.jsp");
			
		dis.forward(request, response);
	}

}
