package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.DBConnect;
import model.AppointmentModel;
import model.Patient_recordModel;

public class PatientRecordServices {
	//Get particular patient records by patientID 
	public static List<Patient_recordModel> getPatientById(int ID){
		List <Patient_recordModel> details = new ArrayList <Patient_recordModel>();
			try {
				Statement st, st2;
				Connection con =  DBConnect.getConnection();
				st = con.createStatement();
				ResultSet rs = st.executeQuery("select P.Patient_ID, P.Pat_Name, P.Age, PR.Diagnosis, PR.Treatment, PR.Med_Date "
						+ "from Patient P, Prescription PR " + "Where P.Patient_ID = PR.Patient_ID AND P.Patient_ID = " + ID + ";");
				
				while(rs.next()) {
					Patient_recordModel PatientDetails = new Patient_recordModel();	
					PatientDetails.setAge(rs.getInt("Age"));
					PatientDetails.setPatientName(rs.getString("Pat_Name"));
					PatientDetails.setDiagnosis(rs.getString("Diagnosis"));
					PatientDetails.setTreatment(rs.getString("Treatment"));
					PatientDetails.setMedDate(rs.getString("Med_Date"));
					
					details.add(PatientDetails);
					
				}
				System.out.print("DETAILS : "+details);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return details;
	}
}
