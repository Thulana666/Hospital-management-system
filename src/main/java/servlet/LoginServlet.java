package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.LoginService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        LoginService userService = new LoginService();
        
        boolean isValidUser = userService.validateUser(username, password);
        boolean isValidDoctor = userService.validateDoctor(username, password);
        boolean isValidReceptionist = userService.validateReceptionist(username, password);
        boolean isValidAdmin = userService.validateAdmin(username, password);
        
        
        if (isValidDoctor) {
        	response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("window.top.location.href = 'Doctor_Portal.jsp';");
            out.println("</script>");
        } 
        
        else if (isValidUser) {
        	response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("window.top.location.href = 'Create.jsp';");
            out.println("</script>");
        }
        
        else if (isValidReceptionist) {
        	response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("window.top.location.href = 'AddPayment.jsp';");
            out.println("</script>");
        }
        
        else if (isValidAdmin) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("window.top.location.href = 'ViewDoctorServlet';");
            out.println("</script>");
        }
        
        else {
            response.sendRedirect("login.jsp?error=Invalid credentialUSER");
        }
		
	}

}
