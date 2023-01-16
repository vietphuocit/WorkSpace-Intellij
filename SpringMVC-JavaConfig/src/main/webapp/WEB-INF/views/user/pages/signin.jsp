<%--
  Created by IntelliJ IDEA.
  User: VietPhuocIT
  Date: 1/16/2023
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
<core:import url="../layouts/header.jsp"/>
<h3 class="p-3 text-center">Sign in to Website</h3>
<form class="w-25 border rounded p-4 m-auto bg-light bg-gradient">
    <div class="mb-3">
        <label for="inputUsername" class="form-label">Username</label>
        <input type="email" class="form-control" id="inputUsername">
    </div>
    <div class="mb-3">
        <label for="inputPassword" class="form-label">Password</label>
        <input type="password" class="form-control" id="inputPassword">
    </div>
    <div class="mb-3">
        <a href="#">Forgot password?</a>
    </div>
    <div class="text-center">
        <button type="submit" class="btn btn-success">Sign in</button>
    </div>
</form>
<div class="mt-3 w-25 border rounded p-4 m-auto ">
    Don't have account? <a href="#">Create an account</a>.
</div>
</body>
</html>
