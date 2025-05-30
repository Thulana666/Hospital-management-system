package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegisterModel;
import services.RegisterServices;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterModel regModel = new RegisterModel();
		
		String username = request.getParameter("username");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		int mobile = Integer.parseInt(request.getParameter("tel"));
		String pwd = request.getParameter("password");
		String address = request.getParameter("address");
		
		regModel.setPatientName(username);
		regModel.setGender(gender);
		regModel.setAge(age);
		regModel.setEmail(email);
		regModel.setTel(mobile);
		regModel.setPwd(pwd);
		regModel.setAddress(address);
		
		RegisterServices services = new RegisterServices();
		
		services.insertData(regModel);
		
		doGet(request, response);
	}

}
