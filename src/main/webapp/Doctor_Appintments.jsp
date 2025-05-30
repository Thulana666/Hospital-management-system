<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "model.AppointmentModel"  %>
<%@page import = "java.util.List"  %>
<!DOCTYPE html>
<html>

<head>
	<link rel="icon" type="image/png" sizes="32x32" href="assets/favicon.png">
    <link rel="Stylesheet" href="./styles/Appointments.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>eMEDI</title>
</head>

<body>
    <br>
    <form method="GET" action="Appointments">
		<%
		List<AppointmentModel> DetailList = (List<AppointmentModel>) request.getAttribute("Details");
		%>
	</form>
    <div id="menu" align="left">
        <img src="./asserts/Profile.png" class="Profile">
        <br>
        <label class="Name">
            <center><b>Ashwin</b></center>
        </label><br><br>
        <hr>
        <ul>
            <li><a href="/HospitalManagementSystem/DoctorPortalServlet">Dashboard</a></li>
            <hr>
            <li><a href="/HospitalManagementSystem/Appointments">Appointments</a></li>
            <hr>
            <li><a href="prescription.jsp">Add Prescritption</a></li>
            <hr>
            <li><a href="Patient_record.jsp">Patient record</a></li>
            <hr><br>
            <center><button class="font1" onclick="window.top.location.href='index.html'"><b>Logout</b></button></center>
        </ul>
    </div>
    <h1><b>
            <center>Appointments</center>
        </b></h1>
    <hr><br><br>
    <div class="">
        <table>
            <tr>
                <th>Appointment ID</th>
                <th>Venue</th>
                <th>Date</th>
                <th>Time</th>
                <th>Patient count</th>
                <th>Status</th>
            </tr>
             <%
	            for (AppointmentModel appointment : DetailList) {
	         %>
	            <tr>
	                <td><%= appointment.getApp_ID() %></td>
	                <td><%= appointment.getVenue() %></td>
	                <td><%= appointment.getApp_Date() %></td>
	                <td><%= appointment.getApp_Time() %></td>
	                <td><%= appointment.getPatientCount() %></td>
	                <td>
		                <div class="grid-container">
		                    <div class="grid-item">
		                         <form action="/HospitalManagementSystem/UpdateAppointmentServlet" method="GET">
		                         	  <input type="hidden" name="appId" value="<%= appointment.getApp_ID() %>"></input>
		                              <button class="statButton"><i class="fa fa-edit" style="font-size:24px"></i></i></button>
		                          </form>
		                    </div>
		                    <div class="grid-item">
		                    	<form action="/HospitalManagementSystem/DeleteAppointmentServlet" method="GET">
		                    		<input type="hidden" name="appId" value="<%= appointment.getApp_ID() %>"></input>
		                            <button class="delButton" href=""><i class="fa fa-trash-o" style="font-size:24px" onclick="myFunction()"></i></button>
		                        </form>
		                    </div>
	                    </div>
	                </td>
	            <%
	            }
            	%>
            </tr>
        </table>
    </div>
    <script src="./script/DeleteAppointment.js"></script>
</body>

</html>