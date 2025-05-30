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
            font-family: Roboto, Arial;
            background-color: #dbe2ef;
         /* background: linear-gradient(135deg, #74b9ff, #000000); */
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background-color: white;
            padding: 30px;
            border-radius: 16px;
            width: 600px;
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.2);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #2d3436;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 6px;
        }

        input{
            width: 96%;
            padding: 12px;
            border-radius: 8px;
            border: 1px solid #dfe6e9;
        }
        
        select {
        	width: 100%;
            padding: 12px;
            border-radius: 8px;
            border: 1px solid #dfe6e9;
        }

        .btn-primary {
        	margin-top: 30px;
            width: 100%;
            padding: 12px;
            background-color: #112d4e;
            color: white;
            border: none;
            border-radius: 8px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn-primary:hover {
            background-color: #74b9ff;
        }

        .navigation {
            margin-top: 20px;
            text-align: center;
        }

        .nav-button {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            background-color: #3f72af;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            transition: transform 0.3s, background-color 0.3s;
            font-weight: bold;
        }

        .nav-button:hover {
            background-color: #74b9ff;
            transform: scale(1.05);
        }

        .nav-button:active {
            transform: scale(0.95);
        }
    </style>

    <script>
        function validateForm() {
            const cardNumber = document.getElementById("cardNumber").value;

            // Check if card number is either "N/A" or exactly 16 digits
            const cardNumberValid = cardNumber === "N/A" || /^\d{16}$/.test(cardNumber);

            if (!cardNumberValid) {
                alert("Please enter a valid card number (16 digits) or 'N/A'.");
                return false;
            }

            return true;
        }
    </script>
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
        <li><a href="ConfirmDelete.jsp">Delete Payments</a></li>
        <li><a href="#" class="active">Update Payments</a></li>
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
        <h2>Edit Payment</h2>
        <form action="UpdatePaymentServlet" method="post" onsubmit="return validateForm();">
            <div class="form-group">
                <label for="paymentID">Payment ID:</label>
                <input type="text" id="paymentID" name="paymentID" value="${param.payID}" readonly required>
            </div>
            <div class="form-group">
                <label for="paymentMethod">Payment Method:</label>
                <select id="paymentMethod" name="paymentMethod" required>
                    <option value="Cash" ${param.paymentMethod == 'Cash' ? 'selected' : ''}>Cash</option>
                    <option value="Debit Card" ${param.paymentMethod == 'Debit Card' ? 'selected' : ''}>Debit Card</option>
                    <option value="Credit Card" ${param.paymentMethod == 'Credit Card' ? 'selected' : ''}>Credit Card</option>
                    <option value="PayPal" ${param.paymentMethod == 'PayPal' ? 'selected' : ''}>PayPal</option>
                    <option value="Bank Transfer" ${param.paymentMethod == 'Bank Transfer' ? 'selected' : ''}>Bank Transfer</option>
                </select>
            </div>
            <div class="form-group">
                <label for="cardNumber">Card Number:(If there's no card enter N/A)</label>
                <input type="text" id="cardNumber" name="cardNumber" value="${param.cardNumber}">
            </div>
            <div class="form-group">
                <label for="expiryDate">Expire Date:</label>
                <input type="date" id="expiryDate" name="expiryDate" value="${param.expiryDate}" required>
            </div>
            <div class="form-group">
                <label for="amount">Amount:</label>
                <input type="number" step="0.01" id="amount" name="amount" value="${param.amount}" required>
            </div>
            <button type="submit" class="btn-primary">Update Payment</button>
        </form>

        <div class="navigation">
            <a href="AddPayment.jsp" class="nav-button">Create Payment</a>
            <a href="ViewRead.jsp" class="nav-button">View Payments</a>
            <a href="ConfirmDelete.jsp" class="nav-button">Delete Payment</a>
        </div>
    </div>
    
    <script src="script/header.js"></script>
  	<script src="script/model.js"></script>
</body>
</html>
