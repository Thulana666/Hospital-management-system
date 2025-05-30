<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>eMEDI</title>
    <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon.png">
    <link rel="stylesheet" href="styles/model.css">
    <link rel="stylesheet" href="styles/appointment.css">
    <link rel="stylesheet" href="styles/header.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: Roboto, Arial;
            background-color: #f7f7f7;
            margin: 0;
    		padding-top: 92px;
        }

        h2 {
        	font-size: 32px;
		    font-weight: 500;
            text-align: center;
            color: #333;
            margin-bottom: 20px;
            margin-top: 50px;
        }
        
        hr {
		    width: 10%;
		    border: 2px solid black;
		    margin-bottom: 40px;
		}

        form {
            background-color: #dbe2ef;
            padding: 20px;
            max-width: 600px;
            margin: 0 auto;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        label {
            font-weight: bold;
            margin-top: 10px;
            display: block;
            color: #555;
        }

        input, textarea {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border-radius: 4px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        input[type="submit"], .button {
            background-color: #3f72af;
            color: white;
            border: none;
            padding: 10px;
            margin-top: 10px;
            cursor: pointer;
            border-radius: 4px;
            width: 100%;
        }

        input[type="submit"]:hover, .button:hover {
            background-color: #112d4e;
        }

        .button {
            margin-top: 20px;
        }

        .error-message {
            color: red;
            text-align: center;
            margin-top: 10px;
        }

        @media (max-width: 600px) {
            form {
                padding: 15px;
                margin: 10px;
            }
        }
    </style>
</head>

<body>
    <!-- Header -->
    <header>
        <div class="logo-container">
            <img src="assets/logo.png" alt="LOGO">
        </div>
        <div class="navbar">
            <ul class="navbar-list">
                <li><a href="index.html">Dashboard</a></li>
                <li><a href="Create.jsp">New Appointment</a></li>
                <li><a href="${pageContext.request.contextPath}/Readservlet">View Appointments</a></li>
                <li><a href="index.html"  class="active">Update Appointment</a></li>
            </ul>
        </div>
        <div>
            <button class="navbar-login-btn" id="openModalBtn">LOGIN</button>
        </div>
    </header>
    
    <div id="loginModal" class="modal">
    <div class="modal-content">
      <span class="close-btn">&times;</span>
      <iframe src="login.jsp" style="width:100%; height:600px;" frameborder="0"></iframe>
    </div>
  </div>

    <h2 class="header">Update Appointment</h2>
    <hr>

    <!-- Update form with pre-filled data -->
    <form id="updateForm" action="${pageContext.request.contextPath}/Updateservlet" method="post" onsubmit="return validateForm()">
        <label for="Appointment_ID">Appointment ID:</label>
        <input type="text" id="Appointment_ID" name="Appointment_ID" value="${Appointment_ID}" readonly required><br>

        <label for="Doctor_ID">Doctor ID:</label>
        <input type="text" name="Doctor_ID" value="${Doctor_ID}"  id="Doctor_ID" required oninput="validateDoctorID()"><br>

        <label for="PatientName">Patient Name:</label>
        <input type="text" name="PatientName" value="${PatientName}" id="PatientName" required oninput="validatePatientName()"><br>

        <label for="App_Date">Appointment Date:</label>
        <input type="date" id="App_Date" name="App_Date" value="${App_Date}" required><br>

        <label for="App_Time">Appointment Time:</label>
        <input type="time" id="App_Time" name="App_Time" value="${App_Time}" required><br>

        <label for="Comments">Comments:</label>
        <textarea id="Comments" name="Comments" required>${Comments}</textarea><br>

        <input type="submit" value="Update">
    </form>

    <!-- Link back to View All Appointments -->
    <form action="${pageContext.request.contextPath}/Readservlet" method="get">
        <button class="button" type="submit">View Appointments</button>
    </form>

    <!-- Display error message if present -->
    <c:if test="${not empty error}">
        <p class="error-message">${error}</p>
    </c:if>

    <!-- Footer -->
    <footer>
        <p class="footer-title">
            Hospital Management System
        </p>
        <p class="footer-body">
            2024 &#169; eMEDI. All rights reserved.
        </p>
    </footer>

    <!-- Script for form validation -->
    <script>
    function validatePatientName() {
      var input = document.getElementById("PatientName");

      // Allow only letters and spaces
      input.value = input.value.replace(/[^a-zA-Z\s]/g, '');
    }

    function validateDoctorID() {
      var input = document.getElementById("Doctor_ID");

      // Allow only numbers
      input.value = input.value.replace(/[^0-9]/g, '');
    }

    function validateForm() {
      var doctorID = document.getElementById("Doctor_ID").value;

      // Check if Doctor_ID contains only numbers
      if (!/^\d+$/.test(doctorID)) {
        alert("Doctor ID must contain only numbers.");
        return false;  // Prevent form submission if Doctor_ID is invalid
      }

      return true;  // Allow form submission if Doctor_ID is valid
    }
  </script>

    <script src="script/model.js"></script>
    <script src="script/smooth_page.js"></script>
</body>
</html>






