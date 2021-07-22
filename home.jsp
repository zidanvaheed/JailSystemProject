<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Inmate Display System</title>
    <!-- Inline css-->
    <style>
        body{
            background: beige;
        }
        .myDiv{
            position:absolute;
            top:0;
            right:0;
            padding: 5px 10px 5px;
        }
        a.one:link{
            color:red;
            text-decoration: none;
        }
        a.one:visited{
            color:red;
            text-decoration: none;
        }
        a.one:hover{
            color: darkorange;
            background-color: black;
        }
        a.two:link{
            color:red;
            text-decoration: none;
        }
        a.two:visited{
            color:red;
            text-decoration: none;
        }
        a.two:hover{
            color:black;
        }
        a.three:link{
            color:red;
            text-decoration: none;
        }
        a.three:visited{
            color:red;
            text-decoration: none;
        }
        a.three:hover{
            font-size: 150%;
            color: darkorange;
            background-color: black;
        }
        .styled-table {
            border-collapse: collapse;
            margin: 25px 0;
            font-size: 0.9em;
            font-family: sans-serif;
            min-width: 400px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
        }
        .styled-table thead tr {
            background-color: sandybrown;
            color: #ffffff;
            text-align: left;
        }
        .styled-table th,
        .styled-table td {
            padding: 12px 15px;
        }
        .tr1:hover{
            background-color: azure;
        }
    </style>
</head>
<body>
<div style="text-align: center;">
    <h1>Inmate Management</h1>
    <h2>
        <a class="one" href="${pageContext.request.contextPath}/new">Add New Entry</a>
        &nbsp;&nbsp;&nbsp;
        <a class="one" href="${pageContext.request.contextPath}/list">List All Entries</a>

    </h2>
</div>
<div align="center">
    <table class="styled-table" border="1" cellpadding="5">
        <caption><h2>Inmate Details</h2></caption>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Sex</th>
                <th>Age</th>
                <th>Address</th>
                <th>Country of Origin</th>
                <th>Offense</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="usr" items="${listJail}">
                <tr class="tr1">
                    <td><c:out value="${usr.id}" /></td>
                    <td><c:out value="${usr.name}" /></td>
                    <td><c:out value="${usr.sex}" /></td>
                    <td><c:out value="${usr.age}" /></td>
                    <td><c:out value="${usr.address}" /></td>
                    <td><c:out value="${usr.country}" /></td>
                    <td><c:out value="${usr.offense}" /></td>
                    <td><c:out value="${usr.description}" /></td>
                    <td>
                        <a class="two" href="${pageContext.request.contextPath}/edit?id=<c:out value='${usr.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="two" href="${pageContext.request.contextPath}/delete?id=<c:out value='${usr.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="myDiv">
    <a class="three" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>
</body>

</html>