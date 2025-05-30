package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.DBConnect;
import model.DoctorPortalModel;

public class DoctorPortalServices {
	//Get patient count assigned for a doctor
	public static DoctorPortalModel getPatientCount(){
		DoctorPortalModel PatientResult = new DoctorPortalModel();
		try {
			Statement st1;
			Connection con = DBConnect.getConnection();
			st1 = con.createStatement();
			int ID = 4;

			String query = "SELECT COUNT(P.Patient_ID) AS 'PatientCount'" + " FROM Patient P, Appointment A"
					+ " WHERE P.Appointment_ID = A.Appointment_ID AND A.Doctor_ID = " + ID + " GROUP BY A.Doctor_ID";

			ResultSet PatientCount = st1.executeQuery(query);

			while (PatientCount.next()) {
				PatientResult.setPatientCount(PatientCount.getInt("PatientCount"));

			} 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return PatientResult;
	}
	
	//Get appointments count to a particular doctor
	public static DoctorPortalModel getAppointmentCount(){
		DoctorPortalModel AppointmentsCount = new DoctorPortalModel();
		try {
			Statement st1;
			Connection con = DBConnect.getConnection();
			st1 = con.createStatement();
			int ID = 4;

			String query = "SELECT COUNT(Appointment_ID) AS 'AppointmentCount' FROM Appointment "
							+ " WHERE Doctor_ID = " + ID +" GROUP BY Doctor_ID;";

			ResultSet AppointmentResult = st1.executeQuery(query);

			while (AppointmentResult.next()) {
				AppointmentsCount.setAppointmentCount(AppointmentResult.getInt("AppointmentCount"));

			} 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return AppointmentsCount;
	}
	
	
}
