<%--
  Created by IntelliJ IDEA.
  User: hungt
  Date: 14-Jul-21
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input Page</title>
</head>
<body style="text-align: center">

<html>
<body>

<form action = "/result" method = "GET">
    USD: <input type = "text" name = "usd">
    <br />
    <input type = "submit" value = "Submit" />
</form>

<br>
<form action = "/uploadFile" method = "POST" enctype="multipart/form-data">
    Image: <input type="file" name="multipartFile" />
    <br />
    <input type = "submit" value = "Submit" />
</form>

<h1>${msg}</h1>
</body>
</html>
</body>
</html>
