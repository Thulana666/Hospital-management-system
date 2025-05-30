package model;

public class DoctorPortalModel {
	private int patientID;
	private int doctorID;
	private int appointmentID;
	private int PatientCount;
	private int AppointmentCount;
	
	public int getAppointmentCount() {
		return AppointmentCount;
	}
	public void setAppointmentCount(int appointmentCount) {
		AppointmentCount = appointmentCount;
	}
	public int getPatientCount() {
		return PatientCount;
	}
	public void setPatientCount(int patientCount) {
		PatientCount = patientCount;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public int getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}
}
