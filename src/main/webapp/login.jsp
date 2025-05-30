<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="styles/login.css">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;400;500;700&display=swap" rel="stylesheet">
</head>

<body>
  <main>
    <div class="btn-container">
      <button id="loginBtn" class="active">Login</button>
      <button id="registerBtn">Register</button>
    </div>

    <div class="login-container active" id="loginContainer">
      <form action="LoginServlet" method="POST">
        <input class="textbox" type="text" name="username" placeholder="Username" required>
        <input class="textbox" type="password" name="password" placeholder="Password" required>
        <input class="login-btn" type="submit" value="LOGIN">
        <button class="login-btn" onclick="window.top.location.href='index.html'">LOGOUT</button>
      </form>
    </div>

    <div class="register-container" id="registerContainer">
      <form action="/Login/RegisterServlet" method="POST">
        <input class="textbox" type="text" name="username" placeholder="Username" required><br>
        <input type="radio" value="Male" name="gender">Male</input>
        <input type="radio" value="Female" name="gender">Female</input><br>
        <input class="textbox" type="number" name="age" placeholder="Age" required>
        <input class="textbox" type="email" name="email" placeholder="Email" required>
        <input class="textbox" type="text" name="address" placeholder="address" required>
        <input class="textbox" type="tel" name="tel" placeholder="Phone" required>
        <input id="password" class="textbox" type="password" name="password" placeholder="Password" required>
        <input id="repeat_password" class="textbox" type="password" name="repeat_password" placeholder="Repeat Password" required>
        <input class="login-btn" type="submit" value="REGISTER">
      </form>
      <p class="msg" id="errorMsg">Passwords do not match</p>
    </div>
  </main>

  <script src="script/login.js"></script>
  <script src="script/register.js"></script>
</body>

</html>