<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.DoctorModel" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>eMEDI Admin Update Doctors</title>
  <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon.png">
  <link rel="stylesheet" href="styles/model.css">
  <link rel="stylesheet" href="styles/manage_doc.css">
  <link rel="stylesheet" href="styles/header.css">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;400;500;700&display=swap" rel="stylesheet">
</head>

<body>
  <header>
    <div class="logo-container">
      <img src="assets/logo.png" alt="LOGO">
    </div>
    <div class="navbar">
      <ul class="navbar-list">
        <li><a href="ViewDoctorServlet">Add/View Doctors</a></li>
        <li><a href="viewReceptionServlet">Manage Users/Staff</a></li>
        <li><a href="#" class="active">Update Doctor</a></li>
      </ul>
    </div>
    <div>
      <button class="navbar-login-btn" id="openModalBtn">ADMINISTRATOR</button>
    </div>
  </header>

  <div id="loginModal" class="modal">
    <div class="modal-content">
      <span class="close-btn">&times;</span>
      <iframe src="login.jsp" style="width:100%; height:600px;" frameborder="0"></iframe>
    </div>
  </div>

  <div class="new_doc-container">
    <div class="new_doc-header">
      <p>Update Doctor Details</p>
      <hr>
    </div>
    
    <div class="new_doc-body">
    	<form action="UpdateDoctorServlet" method="get">
    	
    	<%
		    List<DoctorModel> detailList = (List<DoctorModel>) request.getAttribute("Details");
	    	if (detailList != null) {
		        if (detailList.size() > 0) {
		            for (DoctorModel model : detailList) {
		%>
		
		</form>
		
      <form action="UpdateDoctorServlet" method="post">
        <div>
          <p>Doctor ID</p>
          <input type="text" placeholder="Doctor ID" name="Doctor_ID" value="<%= model.getdoctorId() %>" readonly>
        </div>
        <div>
          <p>Doctor Full Name</p>
          <input type="text" placeholder="Doctor Name" name="Doc_Name" value="<%= model.getName() %>" required>
        </div>
        <div>
          <p>Email</p>
          <input type="email" placeholder="Email" name="Email" value="<%= model.getEmail() %>" required>
        </div>
        <div>
          <p>Contact</p>
          <input type="tel" placeholder="Contact Number" id="phone" name="Phone" value="<%= model.getContact() %>" required>
        </div>
        <div>
          <p>Specialization</p>
          <input type="text" placeholder="Specialization" name="Specialization" value="<%= model.getSpecialization() %>" required>
        </div>
        <div>
          <p>Years of Experience</p>
          <input type="number" placeholder="Years of experience" min="0" id="experience" name="Experience" value="<%= model.getExperience() %>" required>
        </div>
        <div>
          <p>Password</p>
          <input type="text" placeholder="Password" id="passwordInput" name="Password" value="<%= model.getPassword() %>" maxlength="9" required>
        </div>
        <div>
          <p>Address</p>
          <textarea placeholder="Address" name="Doc_Address" required><%= model.getAddress() %></textarea>
        </div>
        <p class="msg" id="errorMsg3">Password must be Maximum Eight characters.</p>
        <p class="msg" id="errorMsg1">Invalid contact number. It must be exactly 10 digits.</p>
        <p class="msg" id="errorMsg2">Experience must be 1 or greater.</p>
        <input class="new_doc-submit" type="submit" id="submitBtn" value="Update" onclick="window.location.href='manage_doc.jsp'">
		</form>
		
        <form action="DeleteDoctorServlet" method="get">
    		<input type="hidden" name="doctorId" value="<%= model.getdoctorId() %>">
        	<input class="new_doc-submit" type="submit" value="Delete" onclick="return confirmDeletion(event)">
        </form>
      
    </div>
  </div>
  
  <%
			            }
			        }
			    } else {
			%>
			<div>No doctors found.</div>
			<%
		    	}
			%>

  <footer>
    <p class="footer-title">
      Hospital Management System
    </p>
    <p class="footer-body">
      2024 &#169; eMEDI. All rights reserved.
    </p>
  </footer>

  <script src="script/model.js"></script>
  <script src="script/manage_doc.js"></script>
  <script src="script/update_doc.js"></script>
  <script src="script/smooth_page.js"></script>
</body>

</html>