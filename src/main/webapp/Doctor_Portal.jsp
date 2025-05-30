<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.DoctorPortalModel" %>
<%@ page import="servlet.DoctorPortalServlet" %>
<!DOCTYPE html>

<html>
    <head>
        <title>eMEDI</title>
        <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon.png">
        <link rel="Stylesheet" href="./styles/Doctor_Portal.css">
    </head>
    <body>
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
        <h1><center><b>Dashboard</b></center></h1>
        <hr><br><br>
        <%
        DoctorPortalModel DetailList = (DoctorPortalModel) request.getAttribute("patientCount");
		
		DoctorPortalModel Appointments = (DoctorPortalModel) request.getAttribute("AppointmentCount");
		
		%>
        <div class="container">
                <br>
                <table>
                    <tr>
                        <td>
                            <div class="innerh3">
                                <h3><b>Patients count</b></h3><hr>
                                <table>
                                    <tr>
                                        <td>
                                            <img src="./asserts/patient.png" class="innerImg">
                                        </td>
                                        <td>
                                        <%if(DetailList != null){ %>
                                            <h2><%= DetailList.getPatientCount() %></h2>
                                         <%}else {%>
                                    		<h2>000</h2>
                                    	<%} %>
                                        </td>
                                    </tr>
                                </table>
                                <h3>Till today</h3>
                            </div>
                        </td>   
                        <td>
                            <div class="innerh3">
                                <h3><b>Appointments</b></h3><hr>
                                <table>
                                    <tr>
                                        <td>
                                            <img src="./asserts/schedule.png" class="innerImg">
                                        </td>
                                        <td>
                                        <%if(Appointments != null){ %>
                                            <h2><%= Appointments.getAppointmentCount() %></h2>
                                         <%}else {%>
                                    		<h2>000</h2>
                                    	<%} %>
                                        </td>
                                    </tr>
                                </table>
                                <h3>Total</h3><br><br>
                            </div>
                        </td> 
                        <td>
                            <div class="innerh3">
                                <h3><b>Completed Appointments</b></h3><hr>
                                <table>
                                    <tr>
                                        <td>
                                            <img src="./asserts/calendar.png" class="innerImg">
                                        </td>
                                        <td>
                                            <h2>000</h2>
                                        </td>
                                    </tr>
                                </table>
                                <h3>Total</h3><br><br>
                            </div>
                        </td>                
                    </tr><br><br><br>
                </table><br>
        </div>
        <label>Patient review : </label>   
        
        <script src="script/UpdateAppointment.js"></script>    
    </body>
</html>