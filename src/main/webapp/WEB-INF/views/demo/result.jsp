<%--
  Created by IntelliJ IDEA.
  User: hungt
  Date: 14-Jul-21
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Page</title>
</head>
<body style="text-align: center">
<h1>Convert USD to VND</h1>
<ul style="list-style-type: none">
    <li><p><b>USD:</b>
        <%= request.getParameter("usd")%>
    </p></li>
    <li><p><b>VND:</b>
        ${vnd}
    </p></li>
</ul>
<h1>${id}</h1>

</body>
</html>
