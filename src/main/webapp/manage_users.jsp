<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ReceptionistModel" %>
<%@ page import="model.PatientModel" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>eMEDI</title>
  <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon.png">
  <link rel="stylesheet" href="styles/model.css">
  <link rel="stylesheet" href="styles/manage_user.css">
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
        <li><a href="ViewDoctorServlet">Add Doctors</a></li>
        <li><a href="viewReceptionServlet" class="active">Manage Users/Staff</a></li>
        <li id="navScrollBtn">Patients</li>
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
      <p>Staff Members</p>
      <hr>
    </div>
    <div class="new_doc-body">
      <div class="my-list">
        <div class="list-header">
          <p>ID</p>
          <p>Name</p>
          <p>Contact</p>
          <p>Email</p>
          <p>Password</p>
          <p>Role</p>
        </div>
        
        <%
		    List<ReceptionistModel> detailList = (List<ReceptionistModel>) request.getAttribute("details");
		
		    if (detailList != null) {
		        if (detailList.size() > 0) {
		            for (ReceptionistModel model : detailList) {
		%>
        
        <div class="list-row">
          <p><%= model.getReceptionId() %></p>
          <p><%= model.getName() %></p>
          <p><%= model.getPhone() %></p>
          <p><%= model.getEmail() %></p>
          <p><%= model.getPassword() %></p>
          <p>Reception</p>
<!--           <div class="btns"> -->
<!--             <button class="remove-new_doc"> -->
<!--               <span>&times;</span> -->
<!--             </button> -->
<!--             <button class="remove-new_doc"> -->
<!--               <span>&#9998;</span> -->
<!--             </button> -->
<!--           </div> -->
        </div>
        
        <%
		            }
		        }
		    } else {
		%>
		<form method="post" action="viewReceptionServlet">
	   		<input class="new_doc-submit" type="submit" value="View Staff">
	   	</form>
		<%
	    	}
		%>

      </div>     
    </div>
  </div>

  <div class="new_doc-container new-doc scroll-down">
    <div class="new_doc-header">
      <p>Users/Patients</p>
      <hr>
    </div>
    <div class="new_doc-body pati-body"> 
      <div class="my-list">
        <div class="list-header">
          <p>ID</p>
          <p>Name</p>
          <p>Contact</p>
          <p>Email</p>
          <p>Age</p>
          <p>Gender</p>
          <p>Password</p>
        </div>
        
        <%
		    List<PatientModel> patientList = (List<PatientModel>) request.getAttribute("pDetails");
		
		    if (patientList != null) {
		        if (patientList.size() > 0) {
		            for (PatientModel model : patientList) {
		%>
        
        <div class="list-row">
          <p><%= model.getPatientId() %></p>
          <p><%= model.getName() %></p>
          <p><%= model.getPhone() %></p>
          <p><%= model.getEmail() %></p>
          <p><%= model.getAge() %></p>
          <p><%= model.getGender() %></p>
          <p><%= model.getPassword() %></p>
<!--           <div class="btns"> -->
<!--             <button class="remove-new_doc"> -->
<!--               <span>&times;</span> -->
<!--             </button> -->
<!--             <button class="remove-new_doc"> -->
<!--               <span>&#9998;</span> -->
<!--             </button> -->
<!--           </div> -->
        </div>
        
        <%
		            }
		        }
		    } else {
		%>
		<form method="post" action="ViewPatientServlet">
      		<input class="new_doc-submit" type="submit" value="View Patients">
      	</form>
		<%
	    	}
		%>

      </div>
    </div>
  </div>

  <footer>
    <p class="footer-title">
      Hospital Management System
    </p>
    <p class="footer-body">
      2024 &#169; eMEDI. All rights reserved.
    </p>
  </footer>

  <script src="script/header.js"></script>
  <script src="script/scroll_down.js"></script>
  <script src="script/model.js"></script>
  <script src="script/smooth_page.js"></script>
</body>

</html>