<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon.png">
  <link rel="stylesheet" href="styles/model.css">
  <link rel="stylesheet" href="styles/payment.css">
  <link rel="stylesheet" href="styles/header.css">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;400;500;700&display=swap" rel="stylesheet">
    <title>eMEDI</title>
    <style>
        /* General Styles */
        body {
            font-family: Roboto, Arial;
            background-color: #dbe2ef;
		/*  background: linear-gradient(135deg, #dff9fb, #c7ecee); */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 80vh;
            margin: 0;
        }

        h3 {
            color: #2d3436;
            text-align: center;
            margin-bottom: 20px;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        /* Form Styles */
        form {
            background-color: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 300px;
        }

        button {
            background-color: #3f72af; /* Button background color */
            color: white; /* Button text color */
            border: none; /* No border */
            border-radius: 4px; /* Rounded corners */
            padding: 10px 20px; /* Padding for button */
            font-size: 16px; /* Button font size */
            cursor: pointer; /* Pointer cursor on hover */
            transition: background-color 0.3s; /* Transition for hover effect */
        }

        button:hover {
            background-color: #112d4e; /* Button background color on hover */
        }

        @media (max-width: 768px) {
            /* Responsive styles for smaller screens */
            form {
                width: 90%;
            }

            button {
                width: 100%; /* Full width button on smaller screens */
            }
        }
    </style>
</head>
<body>
    <form action="ReadPaymentServlet" method="get">
        <h3>View Table List</h3>
        <button type="submit">Click Me!!</button>
    </form>
</body>
</html>
