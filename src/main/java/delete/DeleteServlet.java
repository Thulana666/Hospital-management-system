package delete;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import controller.DBConnect;

import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/Deleteservlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String appointmentIdStr = request.getParameter("Appointment_ID");

        if (appointmentIdStr == null || appointmentIdStr.trim().isEmpty()) {
            throw new ServletException("Invalid Appointment ID");
        }

        int appointmentId;
        try {
            appointmentId = Integer.parseInt(appointmentIdStr);
        } catch (NumberFormatException e) {
            throw new ServletException("Invalid Appointment ID format", e);
        }

        PreparedStatement stmt = null;

        try {
        	// Connect to the database
            Connection conn = DBConnect.getConnection();

            String sql = "DELETE FROM appointment WHERE Appointment_ID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, appointmentId);

            int rowsAffected = stmt.executeUpdate();
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("Readservlet");
            dispatcher.forward(request, response);
//            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (rowsAffected > 0) {
                out.println("<h3>Appointment deleted successfully!</h3>");
            } else {
                out.println("<h3>Failed to delete appointment. Appointment ID not found.</h3>");
            }
            out.println("</body></html>");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Database error", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                throw new ServletException("Database error during close", e);
            }
        }
    }
} 
