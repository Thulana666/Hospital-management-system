package ReadPaymentServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import controller.DBConnect;
import model.Payment;

import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ReadPaymentServlet")
public class ReadPaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Statement stmt = null;
        ResultSet rs = null;
        List<Payment> payments = new ArrayList<>();
        
        try {
        	// Connect to the database
            Connection conn = DBConnect.getConnection();

            String sql = "SELECT * FROM payment";  // Corrected SQL query
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int payID = rs.getInt("payID");
                String paymentMethod = rs.getString("paymentMethod");
                String cardNumber = rs.getString("cardNumber");
                Date expiryDate = rs.getDate("expiryDate");
                double amount = rs.getDouble("amount");
                Payment payment = new Payment(payID, paymentMethod, cardNumber, expiryDate, amount);
                payments.add(payment);
            }

            request.setAttribute("payments", payments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewPayments.jsp");
            dispatcher.forward(request, response);
            
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Database error", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                throw new ServletException("Database error", e);
            }
        }
    }
}
