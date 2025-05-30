package services;

import java.sql.Statement;


import controller.DBConnect;
import model.PrescriptionModel;

public class HospitalServices {
	//Add prescription details to database by doctor
	public void insertData(PrescriptionModel prescriptMdl) {
		try {
			String type = prescriptMdl.getMedType();
			String name = prescriptMdl.getMedName();
			int mg = prescriptMdl.getMg();
			int dose = prescriptMdl.getDose();
			int days = prescriptMdl.getDays();
			String comment = prescriptMdl.getComments();
			String diagnosis = prescriptMdl.getDiagnosis();
			String treatment = prescriptMdl.getTreatment();
			String appDate = prescriptMdl.getMedDate();
			int patientID = prescriptMdl.getPatient_ID();
			
			Statement stmt = DBConnect.getConnection().createStatement();
			
			String sql = "Insert into Prescription(Patient_ID, Med_type, Medicine_name, MG, Dose, Med_Days, Comments, Diagnosis, Treatment, Med_Date)"
						+ "VALUES(" + patientID + ",'" + type + "'," + "'" + name + "'," + mg +","+ dose+"," + days+"," + "'" + comment + "'," + "'"+ diagnosis+"'," + "'" + treatment + "',"+ "'" + appDate + "'"+");";
			
			stmt.executeUpdate(sql);
			stmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showData() {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateData() {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteData() {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
