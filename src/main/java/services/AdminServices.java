package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.DBConnect;
import model.DoctorModel;
import model.PatientModel;
import model.ReceptionistModel;

public class AdminServices {
	
	// Implement all methods as services related to administrator
	
	// Insert new doctor into database
	public static void addDoctor(DoctorModel doc) {
		
		try {		
			String 	name = doc.getName();
			String 	special = doc.getSpecialization();
			String 	email = doc.getEmail();
			String 	contact = doc.getContact();
			String 	address	= doc.getAddress();
			String	password = doc.getPassword();
			int 	expe = doc.getExperience();	
			
			Statement stmt = DBConnect.getConnection().createStatement();
			
			// SQL query for add new doctor into Doctor table
			String sql = "INSERT INTO Doctor(Doc_Name, Specialization, Phone, Email, Doc_Address, Experience, Password) "
					+ "VALUES('"+name+"', '"+special+"', '"+contact+"', '"+email+"', '"+address+"'," +expe+", '"+password+"')";
			
			stmt.executeUpdate(sql);
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	// View all doctors from database
	public static List<DoctorModel> viewDoctor() {
		
        List<DoctorModel> doctorList = new ArrayList<>();

        try {
        	Connection con =  DBConnect.getConnection();
            Statement stmt = con.createStatement();
            
            // SQL query for select all doctors details from Doctor table
            ResultSet rs = stmt.executeQuery("SELECT * FROM Doctor ORDER BY Doc_Name ASC;");

            while (rs.next()) {
            	DoctorModel docDetails = new DoctorModel();
            	
            	docDetails.setdoctorId(rs.getInt("Doctor_ID"));
            	docDetails.setName(rs.getString("Doc_Name"));
            	docDetails.setContact(rs.getString("Phone"));
            	docDetails.setSpecialization(rs.getString("Specialization"));
            	docDetails.setEmail(rs.getString("Email"));
            	docDetails.setExperience(rs.getInt("Experience"));
            	docDetails.setAddress(rs.getString("Doc_Address"));
            	docDetails.setPassword(rs.getString("password"));
            	
            	doctorList.add(docDetails);
            }
            
            System.out.println("view-doc-details : " + doctorList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return doctorList;
    }
	
	
	// Get doctor details by doctor_id for update doctor details
	public static List<DoctorModel> viewDoctorById(int ID) {
		
        List<DoctorModel> docList = new ArrayList<DoctorModel>();

        try {
        	Connection con =  DBConnect.getConnection();
            Statement stmt = con.createStatement();
            
            // SQL query for select all doctors details from Doctor table
            ResultSet rs = stmt.executeQuery("SELECT * FROM Doctor where Doctor_ID = " + ID);

            while (rs.next()) {
            	DoctorModel doctorDetails = new DoctorModel();
            	
            	doctorDetails.setdoctorId(rs.getInt("Doctor_ID"));
            	doctorDetails.setName(rs.getString("Doc_Name"));
            	doctorDetails.setContact(rs.getString("Phone"));
            	doctorDetails.setSpecialization(rs.getString("Specialization"));
            	doctorDetails.setEmail(rs.getString("Email"));
            	doctorDetails.setExperience(rs.getInt("Experience"));
            	doctorDetails.setAddress(rs.getString("Doc_Address"));
            	doctorDetails.setPassword(rs.getString("password"));
            	
            	docList.add(doctorDetails);
            }
            
            System.out.println("view-doc-details-by-id : " + docList);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return docList;
    }
	
	
	// Update doctor details in database
	public void updateDoctor(DoctorModel updateDoc) {
		
		try {
			int 	docId = updateDoc.getdoctorId();
			String 	docName = updateDoc.getName();
			String 	docContact = updateDoc.getContact();
			String 	docEmail = updateDoc.getEmail();
			
			Statement stmt = DBConnect.getConnection().createStatement();
			
			// SQL query for update doctor details in Doctor table
			String sql = "UPDATE Doctor  SET Doc_Name = '" + docName + "'" + ",Phone = " + "'" + docContact + "'" + ",Email = " + "'" + docEmail + "'" 
			        + " WHERE Doctor_ID = " + docId + ";";
			
			System.out.print("sql-updated-info : " + sql);
			stmt.executeUpdate(sql);
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Delete all relevant doctor details in database
	public static void deleteDoctor(int id) {
		
		try {
			System.out.println("selected-docID : " + id);
			
			Statement stmt1 = DBConnect.getConnection().createStatement();
			Statement stmt2 = DBConnect.getConnection().createStatement();
			
			// SQL query for delete all records related to relevant doctor_id in Appointment table
			String query = "DELETE FROM Appointment  WHERE Doctor_ID =" + id + ";";
			stmt1.executeUpdate(query);
			
			// SQL query for delete doctor details related to relevant doctor_id in Doctor table
			String query2 = "DELETE FROM Doctor  WHERE Doctor_ID =" + id + ";";
			stmt2.executeUpdate(query2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// View all Receptionists from database
	public static List<ReceptionistModel> viewReceptionists() {
		
        List<ReceptionistModel> receptionList = new ArrayList<>();

        try {
        	Connection con =  DBConnect.getConnection();
            Statement stmt = con.createStatement();
            
            // SQL query for select all receptionists details from Receptionist table
            ResultSet rs = stmt.executeQuery("SELECT * FROM Receptionist");

            while (rs.next()) {
            	ReceptionistModel recDetails = new ReceptionistModel();
            	
            	recDetails.setReceptionId(rs.getInt("Recept_ID"));
            	recDetails.setName(rs.getString("Username"));
            	recDetails.setPhone(rs.getString("phone"));
            	recDetails.setEmail(rs.getString("email"));
            	recDetails.setPassword(rs.getString("password"));
            	
            	receptionList.add(recDetails);
            }
            
            System.out.println("view-rec-details : " + receptionList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return receptionList;
    }
	
	
	// View all Patient from database
	public static List<PatientModel> viewPatients() {
		
        List<PatientModel> patientList = new ArrayList<>();

        try {
        	Connection con =  DBConnect.getConnection();
            Statement stmt = con.createStatement();
            
            // SQL query for select all patient details from Patient table
            ResultSet rs = stmt.executeQuery("SELECT * FROM Patient");

            while (rs.next()) {
            	PatientModel paytionDetails = new PatientModel();
            	
            	paytionDetails.setPatientId(rs.getInt("Patient_ID"));
            	paytionDetails.setAge(rs.getInt("Age"));
            	paytionDetails.setName(rs.getString("Pat_Name"));
            	paytionDetails.setPhone(rs.getString("phone"));
            	paytionDetails.setEmail(rs.getString("Email"));
            	paytionDetails.setPassword(rs.getString("Password"));
            	paytionDetails.setGender(rs.getString("Gender"));
            	
            	patientList.add(paytionDetails);
            }
            
            System.out.println("view-patient-details : " + patientList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return patientList;
    }

}
