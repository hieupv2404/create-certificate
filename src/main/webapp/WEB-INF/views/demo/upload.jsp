<%--
  Created by IntelliJ IDEA.
  User: hungt
  Date: 19-Jul-21
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src="<c:url value="${path}" /> " alt="image">
<h3>${result}</h3>
</body>
</html>
