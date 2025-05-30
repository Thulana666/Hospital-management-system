<%@page import="model.Patient_recordModel"%>
<%@page import="model.AppointmentModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "model.Patient_recordModel"  %>
<%@page import = "java.util.List"  %>
<!DOCTYPE html>
<html>

<head>
    <title>eMEDI</title>
    <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon.png">
    <link rel="stylesheet" href="./styles/Patient_record.css">
</head>

<body>
    <div id="menu" align="left">
        <img src="./asserts/Profile.png" class="Profile">
        
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
    </div><br>
    <h1>
        <center><b>Patient record</b></center>
    </h1>
    <hr><br><br>
    <div class="container">
        <br>
        	<form action="/HospitalManagementSystem/PatientRecordServlet" method="post">
        		<input type="search" class="bigInput" placeholder="Search by Patient ID" name="Pat_ID" required="true"></input>
        		<input type="submit" value="search" class="submit2"></input>
    		</form>
        <br>
        <br>

        <div class="innerh3">
            <img src="./asserts/patient.png" class="innerImg"><h3><b>Search Results</b></h3>
            <table>
            
               <tr>
                    <th>Patient name</th>
                    <th>Age</th>
                    <th>Diagnosis</th>
                    <th>Treatment</th>
                    <th>Date</th>
                </tr>
               <%
               		List<Patient_recordModel> DetailList = (List<Patient_recordModel>) request.getAttribute("Details");
					
					if(DetailList != null){
						if(DetailList.size() > 0){
               				for(Patient_recordModel model : DetailList){
               %>
                <tr>
                    <td><%= model.getPatientName() %></td>
                    <td><%= model.getAge() %></td>
                    <td><%= model.getDiagnosis() %></td>
                    <td><%= model.getTreatment() %></td>
                    <td><%= model.getMedDate() %></td>
                </tr>
               <%
               				}
						}else{	
				%>
				<tr>
					<td colspan=5 style="text-align:center">No result found !</td>
				</tr>
				<%
						}
               		}			
               %>
            </table>
        </div>
    </div>
</body>

</html>