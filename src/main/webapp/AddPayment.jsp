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
        /* General Reset */
        * {
            box-sizing: border-box;
        }

        body {
        	background-color: #dbe2ef;
/*             background: linear-gradient(135deg, #74b9ff, #0039a6); */
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            overflow: hidden;
        }

        .container {
            background-color: white;
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.2);
            width: 45%;
            max-width: 100%;
            animation: fadeIn 1s ease-in-out;
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

        input, select {
            width: 100%;
            padding: 12px;
            border: 1px solid #dfe6e9;
            border-radius: 8px;
            font-size: 14px;
        }

        input:focus, select:focus {
            border-color: #0984e3;
            outline: none;
            box-shadow: 0 0 5px rgba(9, 132, 227, 0.5);
            transform: scale(1.01);
        }

        .btn-primary {
            width: 100%;
            margin: 30px 0;
            padding: 12px;
            background-color: #112d43;	/* #112d43 */
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
        }

        .btn-primary:hover {
            background-color: #3f72af;
        }

        .nav-buttons {
            display: flex;
            justify-content: left;
        }

        .nav-button {
            padding: 10px 15px;
            border-radius: 8px;
            background-color: #3f72af;	/*#0984e3*/
            color: white;
            font-weight: bold;
            text-align: center;
            margin: 0 5px;
            text-decoration: none;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-10px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>

    <script>
        function validateForm() {
            const paymentMethod = document.getElementById('paymentMethod').value;
            const cardNumberInput = document.getElementById('cardNumber');
            const cardNumber = cardNumberInput.value.trim();

            // Check if payment method requires a card number
            if (paymentMethod === 'Credit Card' || paymentMethod === 'Debit Card') {
                if (!/^\d{16}$/.test(cardNumber)) {
                    alert('Please enter a valid 16-digit card number.');
                    cardNumberInput.focus();
                    return false; // Prevent form submission
                }
            } else {
                // If other payment methods are chosen, clear card number to avoid confusion
                cardNumberInput.value = '';
            }

            return true; // Allow form submission
        }

        function toggleCardNumberField() {
            const paymentMethod = document.getElementById('paymentMethod').value;
            const cardNumberGroup = document.getElementById('cardNumberGroup');

            // Show card number field only for credit or debit card
            if (paymentMethod === 'Credit Card' || paymentMethod === 'Debit Card') {
                cardNumberGroup.style.display = 'block';
            } else {
                cardNumberGroup.style.display = 'none';
            }
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
        <li><a href="AddPayment.jsp" class="active">New Payments</a></li>
        <li><a href="ReadPaymentServlet">View Payments</a></li>
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
  
    <div class="container">
        <h2>Add Payment</h2>
        <form action="CreatePaymentServlet" method="post" onsubmit="return validateForm()">
            <div class="form-group">
                <label for="paymentMethod">Payment Method:</label>
                <select class="form-select" id="paymentMethod" name="paymentMethod" required onchange="toggleCardNumberField()">
                    <option value="" selected disabled>Choose a payment method</option>
                    <option value="Cash">Cash</option>
                    <option value="Debit Card">Debit Card</option>
                    <option value="Credit Card">Credit Card</option>
                    <option value="PayPal">PayPal</option>
                    <option value="Bank Transfer">Bank Transfer</option>
                    <option value="Online">Online</option>
                    <option value="Mobile">Mobile</option>
                </select>
            </div>

            <div class="form-group" id="cardNumberGroup" style="display: none;">
                <label for="cardNumber">Card Number:</label>
                <input type="text" class="form-control" id="cardNumber" name="cardNumber" placeholder="Enter your 16-digit Card Number">
            </div>

            <div class="form-group">
                <label for="expiryDate">Expire Date:</label>
                <input type="date" class="form-control" id="expiryDate" name="expiryDate" required>
            </div>

            <div class="form-group">
                <label for="amount">Amount:</label>
                <input type="number" step="0.01" class="form-control" id="amount" name="amount" placeholder="Enter the Amount" required>
            </div>

            <button type="submit" class="btn-primary">Submit Payment</button>
        </form>

        <div class="nav-buttons">
            <a href="ViewRead.jsp" class="nav-button">View Payments</a>
            <a href="ConfirmDelete.jsp" class="nav-button">Delete Payment</a>
        </div>
    </div>
    
    <script src="script/header.js"></script>
  	<script src="script/model.js"></script>
</body>
</html>
