package model;
public class Patient {
    private int doctorId;      // Use camelCase
    private String patientName;
    private String appDate;    // Use camelCase
    private String appTime;     // Use camelCase
    private String comments;
    private int appointmentId;

    public Patient(int doctorId, String patientName, String appDate, String appTime, String comments, int appointmentId) {
        this.doctorId = doctorId;  // Initialize with camelCase
        this.patientName = patientName;
        this.appDate = appDate;      // Initialize with camelCase
        this.appTime = appTime;      // Initialize with camelCase
        this.comments = comments;
        this.appointmentId=appointmentId;
    }

    // Getters
    public int getDoctorId() {    // Use camelCase
        return doctorId;           // Use camelCase
    }

    public String getPatientName() {
        return patientName;
    }

    public String getAppDate() {  // Use camelCase
        return appDate;            // Use camelCase
    }

    public String getAppTime() {  // Use camelCase
        return appTime;            // Use camelCase
    }

    public String getComments() {
        return comments;
    }


	public int getAppointmentId() {
		return appointmentId;
	}

	
	}
    

