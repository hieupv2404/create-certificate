<%--
  Created by IntelliJ IDEA.
  User: hungt
  Date: 10-Jul-21
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">

    <script src="<c:url value="/resources/js/jquery-3.6.0.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <link href="<c:url value="login.css" />"
          rel="stylesheet">
</head>
<body>
<div>

    <div class="wrapper fadeInDown text-center">
        <div id="formContent">
            <!-- Tabs Titles -->

        <h2>Login</h2>

            <!-- Login Form -->
            <form:form modelAttribute="loginForm" servletRelativeAction="/processLogin" method="POST">
                Username: <form:input type="text" id="login" class="fadeIn second" name="login" placeholder="Username" path="username"/>
                <br>
                <br>

                Password: <form:input type="text" id="password" class="fadeIn third" name="login" placeholder="Password" path="password"/>
                <br>
                <br>
                <input type="submit" class="fadeIn fourth" value="Log In">
            </form:form>

            <!-- Remind Passowrd -->
            <div id="formFooter">
                <a class="underlineHover" href="#">Forgot Password?</a>
            </div>
            <div id="formFooter">
                <h4>Create Certificate</h4>
            </div>

        </div>
    </div>
</div>

</body>
</html>
