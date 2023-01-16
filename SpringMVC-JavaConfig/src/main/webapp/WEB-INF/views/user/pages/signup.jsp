<%--
  Created by IntelliJ IDEA.
  User: VietPhuocIT
  Date: 1/16/2023
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<core:import url="../layouts/header.jsp"/>
<form class="w-25 border rounded p-4 m-auto bg-light bg-gradient"
      action="/SpringMVC_JavaConfig_war/user/signup"
      method="post">
    <div class="mb-3">
        <label for="inputName" class="form-label">Name</label>
        <input type="text" class="form-control" id="inputName" name="name"/>
    </div>
    <div class="mb-3">
        <label for="inputUsername" class="form-label">Username</label>
        <input type="text" class="form-control" id="inputUsername" name="username"/>
    </div>
    <div class="mb-3">
        <label for="inputPassword" class="form-label">Password</label>
        <input type="password" class="form-control" id="inputPassword" name="password"/>
    </div>
    <div class="mb-3">
        <label for="inputRePassword" class="form-label">Remember password</label>
        <input type="password" class="form-control" id="inputRePassword">
    </div>
    <div class="text-center">
        <button type="submit" class="btn btn-success">Sign up</button>
    </div>
</form>
</body>
</html>
