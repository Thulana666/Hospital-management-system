package model;

public class Patient_recordModel {
	private int PatientID;
	private String patientName;
	private String gender;
	private int age;
	private String diagnosis;
	private String treatment;
	private String medDate;
	
	
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getMedDate() {
		return medDate;
	}
	public void setMedDate(String medDate) {
		this.medDate = medDate;
	}
	public void setPatientID(int patientID) {
		PatientID = patientID;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPatientID() {
		return PatientID;
	}
	public String getPatientName() {
		return patientName;
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	
	
}
