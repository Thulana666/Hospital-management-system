package model;

public class ReceptionistModel {
	
	private int		receptionId;
	private String 	name;
    private String 	email;
    private String 	phone;
    private String 	password;
    
    // Getters for ReceptionistModel all variables
	public int getReceptionId() {
		return receptionId;
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
	
	// Setters for ReceptionistModel all variables
	public void setReceptionId(int receptionId) {
		this.receptionId = receptionId;
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

}
