package DeletePaymentServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import controller.DBConnect;

import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/DeletePaymentServlet")
public class DeletePaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the payment ID from the request
        String paymentID = request.getParameter("paymentID");

        // Validate input
        if (paymentID == null || paymentID.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Payment ID is required.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(paymentID);  // Convert ID to integer
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Payment ID format.");
            return;
        }

        // Initialize database resources
        try{
        	Connection conn = DBConnect.getConnection();
        	PreparedStatement stmt = conn.prepareStatement("DELETE FROM payment WHERE payID = ?");
            // Set the parameter and execute the SQL statement
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            // After updating, redirect to ReadPaymentServlet
            response.sendRedirect("ReadPaymentServlet");


        } catch (Exception e) {
            throw new ServletException("Database operation failed.", e);
        }
    }

    // Helper method to establish a database connection
//    private Connection getConnection() throws ServletException {
//    	Connection conn;
//        try {
//            conn = DBConnect.getConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//		return conn;
//    }
}
