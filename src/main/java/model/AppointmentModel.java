package model;

public class AppointmentModel {
	private int app_ID;
	private String App_Date;
	private String App_Time;
	private String Venue;
	private String Comments;
	private int patientCount;

	public int getPatientCount() {
		return patientCount;
	}
	public void setPatientCount(int patientCount) {
		this.patientCount = patientCount;
	}
	public AppointmentModel() {
	}
	public AppointmentModel(int app_ID, String app_Date, String app_Time, String venue, String comments) {
		this.app_ID = app_ID;
		App_Date = app_Date;
		App_Time = app_Time;
		Venue = venue;
		Comments = comments;
	}
	public int getApp_ID() {
		return app_ID;
	}
	public void setApp_ID(int app_ID) {
		this.app_ID = app_ID;
	}
	public String getApp_Date() {
		return App_Date;
	}
	public void setApp_Date(String app_Date) {
		App_Date = app_Date;
	}
	public String getApp_Time() {
		return App_Time;
	}
	public void setApp_Time(String app_Time) {
		App_Time = app_Time;
	}
	public String getVenue() {
		return Venue;
	}
	public void setVenue(String venue) {
		Venue = venue;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	
	
}
