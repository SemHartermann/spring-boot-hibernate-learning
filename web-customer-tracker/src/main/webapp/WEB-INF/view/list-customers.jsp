<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List Customers</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/style.css"
          type="text/css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Add Customer"
               onclick="window.location.href='showFormAdd'; return false;"
               class="add-button"/>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>

            <c:forEach var="tempCustomer" items="${customers}">

                <tr>
                    <td> ${tempCustomer.firstName} </td>
                    <td> ${tempCustomer.lastName} </td>
                    <td> ${tempCustomer.email} </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>

</html>
