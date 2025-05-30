package model;

public class PatientModel {
	
	private int		patientId;
	private int		age;
	private String 	name;
    private String 	email;
    private String 	phone;
    private String 	password;
    private String 	gender;
    
    // Getters for PatientModel all variables
	public int getPatientId() {
		return patientId;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getPassword() {
		return password;
	}
	public String getGender() {
		return gender;
	}
	
	// Setters for PatientModel all variables
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
