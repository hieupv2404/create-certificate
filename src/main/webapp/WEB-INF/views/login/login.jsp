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
</head>
<body>
<div>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">

                <%--@elvariable id="loginForm" type=""--%>
                <form:form modelAttribute="loginForm" servletRelativeAction="/processLogin" method="POST">
                    <h1>Login</h1>
                    <div>
                        <form:input path="username" cssClass="form-control" placeholder="Username"/>
                        <div class="has-error">
                            <form:errors path="username" cssClass="help-block"></form:errors>
                        </div>
                    </div>
                    <div>
                        <form:password path="password" cssClass="form-control" placeholder="Password"/>
                        <div class="has-error">
                            <form:errors path="password" cssClass="help-block"></form:errors>
                        </div>
                    </div>
                    <div>
                        <button class="btn btn-default submit" type="submit">Log in</button>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">

                        <div class="clearfix"></div>
                        <br/>

                        <div>
                            <h1><i class="fa fa-paw"></i> Create Certificate </h1>
                        </div>
                    </div>
                </form:form>
            </section>
        </div>


    </div>
</div>

</body>
</html>
