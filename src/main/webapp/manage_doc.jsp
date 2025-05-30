<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.DoctorModel" %>
<%@ page import="java.util.List" %>


  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <title>eMEDI</title>
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
          <li><a href="ViewDoctorServlet" class="active">Add Doctors</a></li>
          <li id="navScrollBtn">View Doctors</li>
          <li><a href="viewReceptionServlet">Manage Users/Staff</a></li>
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
        <p>Add Doctors</p>
        <hr>
      </div>
      
      <div class="new_doc-body">
        <form action="AddDoctorServlet" method="post">
          <div>
            <p>Doctor Full Name</p>
            <input type="text" placeholder="ex: David" name="Doc_Name" required>
          </div>
          <div>
            <p>Specialization</p>
            <input type="text" placeholder="ex: Eye Surgeon" name="Specialization" required>
          </div>
          <div>
            <p>Email</p>
            <input type="email" placeholder="ex: david@gmail.com" name="Email" required>
          </div>
          <div>
            <p>Contact</p>
            <input type="tel" id="phone" placeholder="ex: 0710000000" name="Phone" required>
          </div>
          <div>
            <p>Years of Experience</p>
            <input type="number" id="experience" placeholder="ex: 1" min="1" name="Experience" required>
          </div>
          <div>
            <p>Address</p>
            <textarea placeholder="ex: No 1, Colombo" name="Doc_Address" required></textarea>
          </div>
          <input class="new_doc-submit" type="submit" id="submitBtn" value="Add New Doctor" disabled>
          <p class="msg" id="errorMsg1">Invalid contact number. It must be exactly 10 digits.</p>
          <p class="msg" id="errorMsg2">Experience must be 1 or greater.</p>
        </form>
      </div>
    </div>

    <div class="my-new_doc new_doc-container scroll-down">
      <div class="new_doc-header">
        <p>View Doctors</p>
        <hr>
      </div>
      <div class="new_doc-body new-doc-width">
        <div class="my-list">
          <div class="list-header">
            <p>Name</p>
            <p>Specilization</p>
            <p>Email</p>
            <p>Contact</p>
            <p>Experience</p>
            <p>Address</p>
            <p>Password</p>
          </div>
          
          <%
			    List<DoctorModel> detailList = (List<DoctorModel>) request.getAttribute("details");
			
			    if (detailList != null) {
			        if (detailList.size() > 0) {
			            for (DoctorModel model : detailList) {
			%>
			
			<div class="list-row">
			    <p><%= model.getName() %></p>
			    <p><%= model.getSpecialization() %></p>
			    <p><%= model.getEmail() %></p>
			    <p><%= model.getContact() %></p>
			    <p><%= model.getExperience() + " Years" %></p>
			    <p><%= model.getAddress() %></p>
			    <p><%= model.getPassword() %></p>
			    
			    <div class="btns">
			    	<form action="UpdateDoctorServlet" method="get">
					    <input type="hidden" name="doctorId" value="<%= model.getdoctorId() %>">
					    <button class="remove-new_doc" type="submit">
					        <span>&#9998;</span>
					    </button>
					</form>
			    </div>
			</div>
			
			<%
			            }
			        }
			    } else {
			%>
			<form method="post" action="ViewDoctorServlet">
		      	<input class="new_doc-submit" type="submit" value="View Doctors">
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

<!--     <script src="script/header.js"></script> -->
    <script src="script/scroll_down.js"></script>
    <script src="script/model.js"></script>
    <script src="script/manage_doc.js"></script>
    <script src="script/smooth_page.js"></script>
  </body>

  </html>