package read;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import controller.DBConnect;

import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Patient;

@WebServlet("/Readservlet")  
public class ReadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

//    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost/hospitalmanagamenetsystem";
//    static final String USER = "root";
//    static final String PASS = "admin";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	

        ResultSet rs = null;
        List<Patient> appo = new ArrayList<>();

        try {
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);

            Statement stmt = DBConnect.getConnection().createStatement();

            String sql = "SELECT * FROM appointment";

            rs = stmt.executeQuery(sql);

            int id;
            int doctorId;  // Declare doctorId here
            String name;
            String date;
            String time;
            String com;

            while (rs.next()) {
                id = rs.getInt("Appointment_ID");
                doctorId = rs.getInt("Doctor_ID");  // Use the declared variable
                name = rs.getString("PatientName");
                date = rs.getString("App_Date");
                time = rs.getString("App_Time");
                com = rs.getString("Comments");
                
                Patient a1 = new Patient(doctorId, name, date, time, com, id); // Ensure constructor matches
                appo.add(a1);
            }
            
           
            
            request.setAttribute("appointments", appo);
           try {
        	   RequestDispatcher dispatcher = request.getRequestDispatcher("Read.jsp");
               dispatcher.forward(request, response);
           }
           catch(Exception e) {
        	   e.printStackTrace();
           }
           

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServletException("Database error", e);
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                throw new ServletException("Database error", e);
            }
        }
    }
}
