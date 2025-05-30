<html>
<head>
    <title>eMEDI</title>
    <style>
        /* General page styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        p {
            text-align: center;
            color: #555;
        }

        /* Card styling */
        .delete-card {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
        }

        strong {
            color: #d9534f;
        }

        /* Button styling */
        .btn {
            display: inline-block;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            margin-top: 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn-delete {
            background-color: #d9534f;
            color: white;
            border: none;
        }

        .btn-delete:hover {
            background-color: #c9302c;
        }

        .btn-cancel {
            background-color: #5bc0de;
            color: white;
            text-decoration: none;
        }

        .btn-cancel:hover {
            background-color: #31b0d5;
        }

        /* Error message styling */
        .error {
            color: red;
            margin-top: 20px;
        }

        /* Responsive design for smaller screens */
        @media (max-width: 600px) {
            .delete-card {
                width: 100%;
                padding: 20px;
                box-sizing: border-box;
            }
        }
    </style>
</head>
<body>
    <div class="delete-card">
        <h2>Delete Appointment</h2>
        <p>Are you sure you want to delete the appointment with ID: <strong>${appointment.Appointment_ID}</strong>?</p>
        
        <form action="Deleteservlet" method="post">
            <input type="hidden" name="Appointment_ID" value="${appointment.Appointment_ID}">
            <input type="submit" class="btn btn-delete" value="Delete">
            <a href="ReadServlet" class="btn btn-cancel">Cancel</a>
        </form>

        <!-- Display error message if there's an error -->
        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>
        
        <a href="ReadServlet" class="btn btn-cancel">View Appointment</a>
    </div>
</body>
</html>  






