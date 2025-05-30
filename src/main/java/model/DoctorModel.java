package model;

public class DoctorModel {
	
	private int		doctorId;
	private int		experience;
	private String 	name;
    private String 	specialization;
    private String 	email;
    private String 	contact;
    private String 	address;
    private String 	password;
    
	public DoctorModel() {
		super();
	}

	public DoctorModel(int doctorId, String name, String specialization, String email, String contact, int experience,
			String address, String password) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.specialization = specialization;
		this.email = email;
		this.contact = contact;
		this.experience = experience;
		this.address = address;
		this.password = password;
	}
	
	// Getters for DoctorModel all variables
	public int getdoctorId() {
		return doctorId;
	}
	public String getName() {
		return name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public String getEmail() {
		return email;
	}
	public String getContact() {
		return contact;
	}
	public int getExperience() {
		return experience;
	}
	public String getAddress() {
		return address;
	}
	public String getPassword() {
		return password;
	}
	
	// Setters for DoctorModel all variables
	public void setdoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
