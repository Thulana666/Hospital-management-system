package create;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DBConnect;

@WebServlet("/Createservlet")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Please submit the form using POST method.</h3>");
        out.println("</body></html>");
        out.close();
    }

    // Handle POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Doctor_ID = request.getParameter("Doctor_ID");
        String PatientName = request.getParameter("PatientName");
        String App_Date = request.getParameter("App_Date");
        String App_Time = request.getParameter("App_Time");
        String Comments = request.getParameter("Comments");

        PreparedStatement stmt = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
        	// Connect to the database
            Connection conn = DBConnect.getConnection();

            // Create a prepared statement to insert the data
            String sql = "INSERT INTO appointment (Doctor_ID, PatientName, App_Date, App_Time, Comments) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            // Set the parameters
            stmt.setString(1, Doctor_ID);
            stmt.setString(2, PatientName);
            stmt.setString(3, App_Date);
            stmt.setString(4, App_Time);
            stmt.setString(5, Comments);

            // Execute the query
            int rowsAffected = stmt.executeUpdate();

            // Check if the insertion was successful
            out.println("<html><body>");
            if (rowsAffected > 0) {
            	RequestDispatcher dispatcher = request.getRequestDispatcher("Create.jsp");
                dispatcher.forward(request, response);
//                out.println("<h3>Appointment added successfully!</h3>");
            } else {
                out.println("<h3>Failed to add the appointment.</h3>");
            }
            out.println("</body></html>");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<h3>MySQL JDBC Driver not found!</h3>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h3>Database connection failed: " + e.getMessage() + "</h3>");
        } finally {
            // Ensure the resources are closed
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.close();
        }
    }
}
