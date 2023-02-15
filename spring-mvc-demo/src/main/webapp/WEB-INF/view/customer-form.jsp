<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Smart
  Date: 14.02.2023
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Registration Form</title>

    <style>

        .ui-state-error{color:darkred}

    </style>
</head>
<body>

    <form:form action="processForm" modelAttribute="customer">

        First name: <form:input path="firstName"/>

        <br><br>

        Last name (*): <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="ui-state-error"/>

        <br><br>

        FreePasses: <form:input path="freePasses" />
        <form:errors path="freePasses" cssClass="ui-state-error"/>

        <br><br>

        Postal Code: <form:input path="postalCode"/>
        <form:errors path="postalCode" cssClass="ui-state-error"/>

        <br><br>

        <input type="submit" value="Submit">

    </form:form>

</body>
</html>
