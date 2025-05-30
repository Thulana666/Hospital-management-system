package CreatePaymentServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import controller.DBConnect;

import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/CreatePaymentServlet")
public class CreatePaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String paymentMethod = request.getParameter("paymentMethod");
        String cardNumber = request.getParameter("cardNumber");
        String expiryDate = request.getParameter("expiryDate");
        double amount = Double.parseDouble(request.getParameter("amount"));

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
        	// Connect to the database
            Connection conn = DBConnect.getConnection();

            // SQL query
            String sql = "INSERT INTO payment (paymentMethod, cardNumber, expiryDate, amount) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, paymentMethod);
            stmt.setString(2, cardNumber);
            stmt.setString(3, expiryDate);
            stmt.setDouble(4, amount);

            // Execute query
            int rowsAffected = stmt.executeUpdate();

            // Generate JavaScript alert based on result
            out.println("<html><body>");
            if (rowsAffected > 0) {
                out.println("<script>alert('Payment Added Successfully!'); window.location.href='ReadPaymentServlet';</script>");
            } else {
                out.println("<script>alert('Failed to add the payment.'); window.location.href='CreatePayment.jsp';</script>");
            }
            out.println("</body></html>");

            // Close resources
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("<html><body>");
            out.println("<script>alert('Database connection failed: " + e.getMessage() + "'); window.location.href='CreatePayment.jsp';</script>");
            out.println("</body></html>");
        }
    }
}
