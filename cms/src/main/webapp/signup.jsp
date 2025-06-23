<%--
  Created by IntelliJ IDEA.
  User: lakshitha
  Date: 2025-06-23
  Time: 18.54
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f2f5;
        }
        .signup-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, .1);
            width: 350px;
        }
        .signup-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input, .form-group select {
            display: block;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            width: 100%;
            box-sizing: border-box;
        }
        .signup-btn {
            width: 100%;
            padding: 10px;
            background-color: #1877f2;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .signup-btn:hover {
            background-color: #1565c0;
        }
        .error, .success {
            text-align: center;
            margin-bottom: 10px;
        }
        .error {
            color: red;
        }
        .success {
            color: green;
        }
        .signin-link {
            text-align: center;
            margin-top: 15px;
        }
        .signin-link a {
            color: #1877f2;
            text-decoration: none;
        }
        .signin-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="signup-container">
    <h2>Sign Up</h2>
    <% if (request.getAttribute("message") != null) { %>
    <p class="<%= request.getAttribute("message").toString().startsWith("Failed") ? "error" : "success" %>">
        <%= request.getAttribute("message") %>
    </p>
    <% } %>
    <form action="signup" method="POST">
        <div class="form-group">
            <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId" required>
        </div>
        <div class="form-group">
            <label for="userName">Name:</label>
            <input type="text" id="userName" name="userName" required>
        </div>
        <div class="form-group">
            <label for="userEmail">Email:</label>
            <input type="email" id="userEmail" name="userEmail" required>
        </div>
        <div class="form-group">
            <label for="userRoll">Role:</label>
            <select id="userRoll" name="userRoll" required>
                <option value="" disabled selected>Select Role</option>
                <option value="admin">Admin</option>
                <option value="user">User</option>
            </select>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <ConfirmationAction>password</ConfirmationAction>
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
        </div>
        <button type="submit" class="signup-btn">Sign Up</button>
    </form>
    <div class="signin-link">
        <p>Already have an account? <a href="signin.jsp">Sign In</a></p>
    </div>
</div>
</body>
</html>