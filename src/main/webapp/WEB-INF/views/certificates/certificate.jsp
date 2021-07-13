<%--
  Created by IntelliJ IDEA.
  User: hungt
  Date: 13-Jul-21
  Time: 8:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.6.0.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <title>Certificate</title>
    <style type='text/css'>
        body, html {
            margin: 0;
            padding: 0;
        }

        body {
            color: black;
            font-family: Georgia, serif;
            font-size: 24px;
            text-align: center;

        }

        .container {
            border: 20px solid tan;
            width: 670px;
            height: 950px;
            display: block;
            vertical-align: middle;
            margin: 0 auto;
        }

        .logo {
            color: tan;
        }

        .marquee {
            color: tan;
            font-size: 48px;
            margin: 20px;
        }

        .assignment {
            margin: 20px;
        }

        .person {
            border-bottom: 2px solid black;
            font-size: 32px;
            font-style: italic;
            margin: 20px auto;
            width: 400px;
        }

        .reason {
            margin: 20px;
        }

        .img-logo {
            width: 90%;
            height: 40%;
            text-align: center;
            margin: auto;
        }

        .download-btn{
        }
    </style>
</head>
<body>
<div class="container">
    <div class="logo">
<%--        <img id="logo-url" src="<c:url value="../../../resources/image/Skype_Picture_2021_02_04T03_37_54_609Z.jpeg"/>" alt="logo"--%>
<%--             class="img-logo">--%>
        <img id="logo-url" src="<c:url value="https://images.glints.com/unsafe/glints-dashboard.s3.amazonaws.com/company-logo/2bd2a080caf53b335dd5d4f3f89a5a1b.png"/>" alt="logo"
             class="img-logo">
        <%--        <img src=../../../resources/image/Skype_Picture_2021_02_04T03_37_54_609Z.jpeg" alt="logo" class="img-logo">--%>
        <br>
        NextPay Risk Organization
    </div>

    <c:forEach var="certificate" items="${certificates}">

    <div class="marquee">
        Certificate of Completion
        <br>
            ${certificate.nameSubject}
    </div>

    <div class="assignment">
        This certificate is presented to
    </div>

    <div class="person">
            ${certificate.nameStudent}
    </div>

    <div class="reason">
        Grade: ${certificate.grade}
    </div>

    <div class="assignment">
            ${certificate.dateOfDone}
    </div>
</div>
<br>
<div class="download-btn">
    <button class="btn btn-success" formmethod="get"><a
            href="<c:url value="/api/subjects/${certificate.id}/downloadPDF"/>"
            style="color: white; text-decoration: none; padding: 5px">Download as PDF</a></button>
</div>
</c:forEach>


</body>
</html>
