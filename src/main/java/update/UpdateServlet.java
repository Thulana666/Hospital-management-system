package update;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import controller.DBConnect;

import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/Updateservlet")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the Appointment_ID from the request
        String appointmentID = request.getParameter("Appointment_ID");

        if (appointmentID == null || appointmentID.trim().isEmpty()) {
            request.setAttribute("error", "Appointment ID is required.");
            request.getRequestDispatcher("/Readservlet").forward(request, response); // Redirect to appointment list
            return;
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
        	Connection conn = DBConnect.getConnection();

            // Query to fetch the appointment details
            String sql = "SELECT * FROM appointment WHERE Appointment_ID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, appointmentID);

            rs = stmt.executeQuery();

            if (rs.next()) {
                // Populate request attributes with appointment data
                request.setAttribute("Appointment_ID", rs.getString("Appointment_ID"));
                request.setAttribute("Doctor_ID", rs.getString("Doctor_ID"));
                request.setAttribute("PatientName", rs.getString("PatientName"));
                request.setAttribute("App_Date", rs.getString("App_Date"));
                request.setAttribute("App_Time", rs.getString("App_Time"));
                request.setAttribute("Comments", rs.getString("Comments"));

                // Forward the request to Update.jsp to show the form pre-filled
                request.getRequestDispatcher("Update.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Appointment not found.");
                request.getRequestDispatcher("/Readservlet").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error occurred: " + e.getMessage());
            request.getRequestDispatcher("/Readservlet").forward(request, response);
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String appointmentID = request.getParameter("Appointment_ID");
        String doctorID = request.getParameter("Doctor_ID");
        String patientName = request.getParameter("PatientName");
        String appDate = request.getParameter("App_Date");
        String appTime = request.getParameter("App_Time");
        String comments = request.getParameter("Comments");

        PreparedStatement stmt = null;

        try {
            // Connect to the database
            Connection conn = DBConnect.getConnection();

            // SQL query to update the appointment details
            String sql = "UPDATE appointment SET Doctor_ID=?, PatientName=?, App_Date=?, App_Time=?, Comments=? WHERE Appointment_ID=?";
            stmt = conn.prepareStatement(sql);

            // Set the parameters for the SQL query
            stmt.setString(1, doctorID);
            stmt.setString(2, patientName);
            stmt.setString(3, appDate);
            stmt.setString(4, appTime);
            stmt.setString(5, comments);
            stmt.setString(6, appointmentID);

            // Execute the update
            int rowsAffected = stmt.executeUpdate();

            // If the update is successful, redirect to the list page (ReadServlet)
            if (rowsAffected > 0) {
                response.sendRedirect(request.getContextPath() + "/Readservlet");  // Redirect to list appointments page
            } else {
                // If no rows were updated, show an error message
                request.setAttribute("error", "Failed to update. Appointment ID not found.");
                request.getRequestDispatcher("Update.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error occurred: " + e.getMessage());
            request.getRequestDispatcher("Update.jsp").forward(request, response);
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



