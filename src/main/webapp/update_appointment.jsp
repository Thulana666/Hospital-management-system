<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "model.AppointmentModel"  %>
<%@page import = "java.util.List"  %>
<!DOCTYPE html>

<html>
    <head>
        <title>eMEDI</title>
        <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon.png">
        <link rel="Stylesheet" href="./styles/update_appointment.css">
        
    </head>
    <body>
    	<form method="GET" action="/HospitalManagementSystem/UpdateAppointmentServlet">
		<%
		List<AppointmentModel> DetailList = (List<AppointmentModel>) request.getAttribute("Details");
		//out.print("DETAILS : "+DetailList);
		%>
		</form>
        <div id="menu" align="left">
            <img src="./asserts/Profile.png" class="Profile">
            <br>
            <label class="Name"><center><b>Ashwin</b></center></label><br><br>
            <hr>
            <ul>
                <li><a href="/HospitalManagementSystem/DoctorPortalServlet">Dashboard</a></li><hr>
                <li><a href="/HospitalManagementSystem/Appointments">Appointments</a></li><hr>
               <li><a href="prescription.jsp">Add Prescritption</a></li><hr>
               <li><a href="Patient_record.jsp">Patient record</a></li><hr><br>
               <center><button class="font1" onclick="window.top.location.href='index.html'"><b>Logout</b></button></center>
            </ul>
        </div><br>
        <h1><center><b>Update appointment</b></center></h1>
        <hr><br><br>
        <div class="container">
            <form method="post" action="/HospitalManagementSystem/UpdateAppointmentServlet">
                <fieldset class="field">
                <%
	            for (AppointmentModel appointment : DetailList) {
	         	%>
                    <legend><b>Update Details</b></legend><br><br>
                    <label>AppointmentID</label><input type="text" class="smallInput" name="App_ID" value="<%= appointment.getApp_ID() %>" readonly></input><br><br>
                    <label>Venue : </label><input type="text" class="smallInput" name="venue" id="venueInput" onchange="validateVenue()" value="<%= appointment.getVenue() %>"></input><br><br>
                    <label>Date : </label><input type="date" class="smallInput" name="appDate" value="<%= appointment.getApp_Date() %>"></input><br><br>
                    <label>Time : </label><input type="text" class="smallInput" id="timeInput" onchange="validateTime()" name="appTime" value="<%= appointment.getApp_Time() %>"></input><br><br>
                    <label>Patient Count : </label><input type="number" class="smallInput" name="Count" value="<%= appointment.getPatientCount() %>" readonly></input><br><br><br>
					<p id="message" style="color: red;"></p>
					<p id="venueMessage" style="color: red;"></p>
                   	<input type="submit" value="Update" onclick="myFunction()" class="submit submit1"></input>
                   	<input type="submit" value="Cancel" class="submit submit1"></input>
				<%
	            }
                %>
                </fieldset>
            </form>
            <script src="./script/UpdateAppointment.js"></script>
        </div>
        
    </body>
</html>