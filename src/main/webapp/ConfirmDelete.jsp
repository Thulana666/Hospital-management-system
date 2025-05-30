<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        body {
        	background-color: #dbe2ef;
         /* background: linear-gradient(135deg, #74b9ff, #000000); */
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            overflow: hidden;
        }

        .container {
            background-color: white;
            padding: 40px;
            border-radius: 16px;
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.2);
            width: 500px;
            max-width: 100%;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #2d3436;
            font-size: 24px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            color: #2d3436;
        }

        input {
            width: 100%;
            padding: 12px;
            border: 1px solid #dfe6e9;
            border-radius: 8px;
        }

        .btn-danger {
        	margin-top: 20px;
            width: 100%;
            padding: 12px;
            background-color: #d63031;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
        }

        .nav-buttons {
            display: flex;
            justify-content: space-between;
            margin-top: 15px;
        }

        .nav-button {
            padding: 10px 15px;
            border-radius: 8px;
            background-color: #3f72af;
            color: white;
            text-decoration: none;
            text-align: center;
            flex: 1;
            margin: 0 5px;
        }
    </style>
</head>
<body>
<header>
    <div class="logo-container">
      <img src="assets/logo.png" alt="LOGO">
    </div>
    <div class="navbar">
      <ul class="navbar-list">
        <li><a href="AddPayment.jsp">New Payments</a></li>
        <li><a href="ReadPaymentServlet">View Payments</a></li>
        <li><a href="ConfirmDelete.jsp" class="active">Delete Payments</a></li>
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
  
    <div class="container">
        <h2>Delete Payment</h2>
        <form action="DeletePaymentServlet" method="post">
            <div class="form-group">
                <label for="paymentID">Payment ID:</label>
                <input type="text" id="paymentID" name="paymentID" placeholder="Enter Payment ID" required>
            </div>
            <button type="submit" class="btn-danger">Delete Payment</button>
        </form>
        <div class="nav-buttons">
            <a href="AddPayment.jsp" class="nav-button">Create Payment</a>
            <a href="ViewRead.jsp" class="nav-button">View Payments</a>
            
        </div>
    </div>
    
    <script src="script/header.js"></script>
  	<script src="script/model.js"></script>
</body>
</html>
