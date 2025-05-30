package UpdatePaymentServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import controller.DBConnect;

import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/UpdatePaymentServlet")  // Ensure mapping matches form action
public class UpdatePaymentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("EditPayment.jsp");  // Redirect to edit page
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Get parameters from the request
        String payID = request.getParameter("paymentID");
        String paymentMethod = request.getParameter("paymentMethod");
        String cardNumber = request.getParameter("cardNumber").trim();
        String expiryDate = request.getParameter("expiryDate");
        String amount = request.getParameter("amount");

        // Validate input fields
        if (isInvalid(payID, paymentMethod, expiryDate, amount) || 
            !isCardNumberValid(cardNumber)) {
            request.setAttribute("error", "Invalid input. Please fill all fields correctly.");
            request.getRequestDispatcher("EditPayment.jsp").forward(request, response);
            return;
        }

        try {
        	Connection conn = DBConnect.getConnection();
        	PreparedStatement stmt = conn.prepareStatement("UPDATE payment SET paymentMethod=?, cardNumber=?, expiryDate=?, amount=? WHERE payID=?");

            // Handle "N/A" card number
            if (cardNumber.equalsIgnoreCase("N/A")) {
                cardNumber = null;
            }

            // Set parameters for the query
            stmt.setString(1, paymentMethod);
            stmt.setString(2, cardNumber);
            stmt.setString(3, expiryDate);
            stmt.setString(4, amount);
            stmt.setString(5, payID);

            // Execute the update
//            int rowsAffected = stmt.executeUpdate();
            stmt.executeUpdate();

//            // Send response to the client
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.println("<html><body>");
//            if (rowsAffected > 0) {
//                out.println("<h3>Payment information updated successfully!</h3>");
//            } else {
//                out.println("<h3>No payment found with the given ID.</h3>");
//            }
//            out.println("</body></html>");
            
            // After updating, redirect to ReadPaymentServlet
            response.sendRedirect("ReadPaymentServlet");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error.");
        }
    }

    // Helper method to validate general fields (except card number)
    private boolean isInvalid(String... fields) {
        for (String field : fields) {
            if (field == null || field.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    // Helper method to validate card number ("N/A" or 16 digits)
    private boolean isCardNumberValid(String cardNumber) {
        return cardNumber.equalsIgnoreCase("N/A") || cardNumber.matches("\\d{16}");
    }
}
