<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List Subject</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.6.0.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h2>Subjects List</h2>
        <hr />

        <input type="button" value="Add Subject"
               onclick="window.location.href='showForm'; return false;"
               class="btn btn-primary" />
        <br/><br/>
        <div class="panel panel-info">
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Score</th>
                        <th>Process</th>
                        <th>Action</th>
                    </tr>

                    <!-- loop over and print our students -->
                    <c:forEach var="tempSubject" items="${subjects}">
                        <tr>
                            <td>${tempSubject.id}</td>
                            <td>${tempSubject.name}</td>
                            <td>${tempSubject.score}</td>
                            <td>${tempSubject.process}</td>
                            <td>
                            <c:choose>
                                <c:when test="${tempSubject.process<100}">
                                    <button type="button" class="btn btn-primary">Continue</button>
                                </c:when>
                                <c:otherwise>
                                    <button class="btn btn-success" formmethod="get"><a href="<c:url value="/api/subjects/${tempSubject.id}/viewCertificate"/>"  style="color: white; text-decoration: none; padding: 5px">View Certificate</a></button>
                                </c:otherwise>
                            </c:choose>
                            </td>
                        </tr>

                    </c:forEach>

                </table>

            </div>
        </div>
    </div>

</div>
</body>
</html>