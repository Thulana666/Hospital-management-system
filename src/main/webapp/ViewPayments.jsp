<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>eMEDI</title>
    <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon.png">
  <link rel="stylesheet" href="styles/model.css">
  <link rel="stylesheet" href="styles/payment.css">
  <link rel="stylesheet" href="styles/header.css">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;400;500;700&display=swap" rel="stylesheet">
    <style>
        .body {
        	background-color: #f9f7f7;
        }

        h2 {
            text-align: center;
            margin-top: 50px;
            margin-bottom: 20px;
            font-size: 32px;
    		font-weight: 500;
        }
        
        hr {
        	width: 10%;
    		border: 2px solid black;
    		margin-bottom: 50px;
        }

        table {
        	background-color: #dbe2ef;
            width: 80%;
            border-collapse: collapse;
            margin: 0 auto;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        thead tr {
            background-color: #3f72af;
            color: white;
        }

        th, td {
            padding: 12px 15px;
            border-bottom: 1px solid #dfe6e9;
            text-align: center;
            
        }

        tbody tr:hover {
            background-color: #3f72af;
            color: white;
        }

        .update-btn {
            padding: 8px 12px;
            background-color: #0984e3;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            display: inline-block;
        }

        /* Navigation Buttons */
        .nav-buttons {
            margin: 60px auto;
            text-align: center;
        }

        .nav-buttons a {
            text-decoration: none;
            padding: 10px 15px;
            margin: 0 10px;
            background-color: #3f72af;
            color: white;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .nav-buttons a:hover {
            background-color: #112d4e;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            table {
                width: 100%;
            }

            th, td {
                font-size: 14px;
                padding: 10px;
            }

            .nav-buttons a {
                margin: 10px 5px;
                padding: 8px 12px;
            }
        }
    </style>
</head>

<body class="body">
<header>
    <div class="logo-container">
      <img src="assets/logo.png" alt="LOGO">
    </div>
    <div class="navbar">
      <ul class="navbar-list">
        <li><a href="AddPayment.jsp">New Payments</a></li>
        <li><a href="ReadPaymentServlet" class="active">View Payments</a></li>
        <li><a href="ConfirmDelete.jsp">Delete Payments</a></li>
      </ul>
    </div>
    <div>
      <button class="navbar-login-btn" id="openModalBtn">RECEPTION</button>
    </div>
  </header>

  <div id="loginModal" class="modal">
    <div class="modal-content">
      <span class="close-btn">&times;</span>
      <iframe src="login.jsp" style="width:100%; height:600px;" frameborder="0"></iframe>
    </div>
  </div>
  
    <h2>Payment List</h2>
    <hr>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Payment Method</th>
                <th>Card Number</th>
                <th>Expire Date</th>
                <th>Amount</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="payment" items="${payments}">
                <tr>
                    <td>${payment.payID}</td>
                    <td>${payment.paymentMethod}</td>
                    <td>${payment.cardNumber}</td>
                    <td>${payment.expiryDate}</td>
                    <td>${payment.amount}</td>
                    <td>
                        <a href="EditPayment.jsp?payID=${payment.payID}&paymentMethod=${payment.paymentMethod}&cardNumber=${payment.cardNumber}&expiryDate=${payment.expiryDate}&amount=${payment.amount}" 
                           class="update-btn">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Navigation Buttons -->
    <div class="nav-buttons">
        <a href="AddPayment.jsp">Create Payment</a>
        <a href="ConfirmDelete.jsp">Delete Payment</a>
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
  <script src="script/model.js"></script>
</body>

</html>
