package services;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import controller.DBConnect;

import model.AppointmentModel;
import model.PrescriptionModel;

public class AppointmentServices {
	//Get all appointments details
	public static List<AppointmentModel> getAppointment(){
		List <AppointmentModel> details = new ArrayList <AppointmentModel>();
		Connection con = null;
			try {
				Statement st, st2;
				con =  DBConnect.getConnection();
				st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM Appointment");
				
				//read results until last record in database table
				while(rs.next()) {
					AppointmentModel appDetails = new AppointmentModel();
					appDetails.setApp_ID(rs.getInt("Appointment_ID"));
					appDetails.setApp_Time(rs.getString("App_Time"));
					appDetails.setComments(rs.getString("Comments"));
					appDetails.setApp_Date(rs.getString("App_Date"));
					appDetails.setVenue(rs.getString("Venue"));
					
					st2 = con.createStatement();
	                
	                String patientQry = "SELECT Appointment_ID,COUNT(Patient_ID) AS 'Patient_Count'  FROM Patient WHERE Appointment_ID = " +  rs.getInt("Appointment_ID") + "GROUP BY Appointment_ID;";
	                ResultSet patientCountResult = st2.executeQuery(patientQry);
	                appDetails.setPatientCount(0);
	                
	                //Get the patient count for an appointment
	                while(patientCountResult.next()) {
	                	appDetails.setPatientCount(patientCountResult.getInt("Patient_Count"));
	                }
				
					details.add(appDetails);
					
				}
				
				//System.out.print("DETAILS : "+details);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return details;
	}
	
	
	//Get appointment details by appointment ID
	public static List<AppointmentModel> getAppointmentById(int ID){
		List <AppointmentModel> details = new ArrayList <AppointmentModel>();
			try {
				Statement st, st2;
				Connection con =  DBConnect.getConnection();
				st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM Appointment WHERE Appointment_ID = "+ID);
				
				//read results until last record in database table
				while(rs.next()) {
					AppointmentModel appDetails = new AppointmentModel();
					
					appDetails.setApp_ID(rs.getInt("Appointment_ID"));
					appDetails.setApp_Time(rs.getString("App_Time"));
					appDetails.setComments(rs.getString("Comments"));
					appDetails.setApp_Date(rs.getString("App_Date"));
					appDetails.setVenue(rs.getString("Venue"));
					
					st2 = con.createStatement();
	                
	                String patientQry = "SELECT Appointment_ID,COUNT(Patient_ID) AS 'Patient_Count'  FROM Patient WHERE Appointment_ID = " +  rs.getInt("Appointment_ID") + "GROUP BY Appointment_ID;";
	                ResultSet patientCountResult = st2.executeQuery(patientQry);
	                appDetails.setPatientCount(0);
	                
	                //Get patient count for particular appointment
	                while(patientCountResult.next()) {
	                	appDetails.setPatientCount(patientCountResult.getInt("Patient_Count"));
	                }
	                
					details.add(appDetails);
					
				}
				//System.out.print("DETAILS : "+details);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return details;
	}
	//Method to update appointment details
	public void updateAppointmentData(AppointmentModel UpdateModel) {
		try {
			int appID = UpdateModel.getApp_ID();
			String date = UpdateModel.getApp_Date();
			String time = UpdateModel.getApp_Time();
			String venue = UpdateModel.getVenue();

			Statement stmt = DBConnect.getConnection().createStatement();
			
			String sql = "UPDATE Appointment SET App_Date = '" + date + "'" + ",App_Time = " + "'" + time + "'" + ",Venue = " + "'" + venue + "'"
						+ " WHERE Appointment_ID = "+ appID +";";
			
//			System.out.print("DETAILS : "+sql);
			stmt.executeUpdate(sql);
			stmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Delete appointment by given ID
	public static void deleteAppointmentByID(int id) {
		try {
			Statement stmt1 = DBConnect.getConnection().createStatement();
			Statement stmt2 = DBConnect.getConnection().createStatement();
			ResultSet patientDetail = null;
		
			String query2 = "SELECT Patient_ID FROM Patient WHERE Appointment_ID =" + id + ";";
			patientDetail = stmt1.executeQuery(query2);
			
			//Check if return result has values
			if(patientDetail != null) {
				//Set Patient appointment ID to null in before deleting the appointment(FK REFERENCES)
				while(patientDetail.next())
				{
					String query3 = "UPDATE Patient SET Appointment_ID = NULL WHERE Appointment_ID =" + id + ";";
					stmt1.executeQuery(query3);
				}
			}
			
			//Delete appointment by ID
			String query3 = "DELETE FROM Appointment WHERE Appointment_ID =" + id + ";";
			stmt2.execute(query3);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
