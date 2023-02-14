<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Smart
  Date: 14.02.2023
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Conformation</title>
</head>
<body>

The student is confirmed: ${student.firstName} ${student.lastName}

<br>
<br>

Country: ${student.country}

<br>
<br>

FavoriteLanguage: ${student.favoriteLanguage}

<br>
<br>

OperatingSystems:

<ul>

    <c:forEach var="temp"
               items="${student.operatingSystems}">

        <li>${temp}</li>

    </c:forEach>

</ul>

</body>
</html>
