<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>eMEDI</title>
  <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon.png">
  <link rel="stylesheet" href="styles/model.css">
  <link rel="stylesheet" href="styles/appointment.css">
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
      	<li><a href="index.html">Dashboard</a></li>
        <li><a href="Create.jsp" class="active">New Appointment</a></li>
        <li><a href="${pageContext.request.contextPath}/Readservlet">View Appointments</a></li>
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

  <div class="appointment-container">
    <div class="appointment-header">
      <p>New Appointment</p>
      <hr class="hr hr-create">
    </div>
    <div class="appointment-body">
      <form id="appointmentForm" action="Createservlet" method="post" onsubmit="return validateForm()">
        <div class="appointment-date">
          <p>Appointment Date</p>
          <input type="date" name="App_Date" required>
        </div>
        <hr>
        <div>
          <p>Patient Name</p>
          <input type="text" placeholder="Mr. David" name="PatientName" id="PatientName" required oninput="validatePatientName()">
        </div>
        <div>
          <p>Appointment Time</p>
          <input type="time" name="App_Time" required>
        </div>
        <div>
          <p>Select Doctor</p>
          <input type="text" placeholder="Doctor_ID" name="Doctor_ID" id="Doctor_ID" required oninput="validateDoctorID()">
        </div>
        <div>
          <p>Comments</p>
          <textarea placeholder="Describe your illness briefly" name="Comments"></textarea>
        </div>
        <input class="appointment-submit" type="submit" value="Submit">
      </form>

      <br>
      <form action="${pageContext.request.contextPath}/Readservlet" method="get">
        <button class="appointment-submit" for="readappoin">View Appointment</button><br>
      </form>
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

