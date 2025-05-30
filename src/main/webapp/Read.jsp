<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
  <title>eMEDI</title>
  <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon.png">
    <link rel="stylesheet" href="styles/model.css">
    <link rel="stylesheet" href="styles/appointment.css">
    <link rel="stylesheet" href="styles/header.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;400;500;700&display=swap" rel="stylesheet">
  <style>
    table {
      width: 80%;
      border-collapse: collapse;
      background-color: #fff;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      margin: 30px auto 150px auto;
    }

    th, td {
      padding: 12px;
      text-align: left;
      border: 1px solid #ddd;
    }

    th {
      background-color: #3f72af;
      color: white;
    }

    tr:nth-child(even) {
      background-color: #dbe2ef;
    }

    button {
      background-color: #3f72af;
      color: white;
      border: none;
      padding: 8px 12px;
      cursor: pointer;
    }

    button:hover {
      background-color: #112d4e;
    }

    form {
      display: inline;
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
                <li><a href="Create.jsp">New Appointments</a></li>
                <li><a href="${pageContext.request.contextPath}/Readservlet" class="active">View Appointments</a></li>
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
    
  <h2 class="h2">Appointment List</h2>
  <hr class="hr">
  <table>
    <tr>
      <th>Doctor ID</th>
      <th>Patient Name</th>
      <th>Appointment Date</th>
      <th>Appointment Time</th>
      <th>Comments</th>
      <th>Appointment ID</th>
      <th>Update</th>
      <th>Delete</th>
    </tr>
    <c:forEach var="appointment" items="${appointments}">
      <tr>
        <td>${appointment.doctorId}</td>
        <td>${appointment.patientName}</td>
        <td>${appointment.appDate}</td>
        <td>${appointment.appTime}</td>
        <td>${appointment.comments}</td>
        <td>${appointment.appointmentId}</td>

        <td>
          <form action="${pageContext.request.contextPath}/Updateservlet" method="get">
            <input type="hidden" name="Appointment_ID" value="${appointment.appointmentId}">
            <button type="submit">Update</button>
          </form>
        </td>
        <td>
          <form action="${pageContext.request.contextPath}/Deleteservlet" method="post">
            <input type="hidden" name="Appointment_ID" value="${appointment.appointmentId}">
            <button type="submit">Delete</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
  <footer>
    <p class="footer-title">
      Hospital Management System
    </p>
    <p class="footer-body">
      2024 &#169; eMEDI. All rights reserved.
    </p>
  </footer>
  
  <script src="script/model.js"></script>
  <script src="script/header.js"></script>
  <script src="script/smooth_page.js"></script>
</body>

</html>
    