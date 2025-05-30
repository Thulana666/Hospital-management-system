package read; // Make sure to use the correct package name

public class Appointment {
    private int Appointment_ID;
    private String Doctor_ID;
    private String PatientName;
    private String App_Date;
    private String App_Time;
    private String Comments;

    // Getters and Setters
    public int getAppointment_ID() {
        return Appointment_ID;
    }

    public void setAppointment_ID(int appointment_ID) {
        Appointment_ID = appointment_ID;
    }

    public String getDoctor_ID() {
        return Doctor_ID;
    }

    public void setDoctor_ID(String doctor_ID) {
        Doctor_ID = doctor_ID;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
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

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }
}
