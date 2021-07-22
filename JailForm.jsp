<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Inmate Display System</title>
    <!-- Bootstrap link for css-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <!-- inline css-->
    <style>
        body{
            background: beige;
        }
        .btn1{
            border: none;
            outline: none;
            height: 50px;
            width: 50%;
            background-color: black;
            color: white;
            border-radius: 4px;
            font-weight: bold;
        }
        .btn1:hover{
            background: white;
            border: 1px solid;
            color: black;
        }
        .div1{
            padding-top: 10px;
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
        caption{
            text-align: center;
            padding: 10px;
            caption-side: top;
            color: black;
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
<div class="div1" align="center">
    <c:if test="${jail != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${jail == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${jail != null}">
                            Edit Entry
                        </c:if>
                        <c:if test="${jail == null}">
                            Add New Entry
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${jail != null}">
                    <input type="hidden" name="id" value="<c:out value='${jail.id}' />" />
                </c:if>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${jail.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Sex: </th>
                    <td>
                        <input type="text" name="sex" size="45"
                               value="<c:out value='${jail.sex}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Age: </th>
                    <td>
                        <input type="text" name="age" size="5"
                               value="<c:out value='${jail.age}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Address: </th>
                    <td>
                        <input type="text" name="address" size="45"
                               value="<c:out value='${jail.address}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Country of Origin: </th>
                    <td>
                        <input type="text" name="country" size="45"
                               value="<c:out value='${jail.country}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Offense: </th>
                    <td>
                        <input type="text" name="offense" size="45"
                               value="<c:out value='${jail.offense}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Description: </th>
                    <td>
                        <input type="text" name="description" size="45"
                               value="<c:out value='${jail.description}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" class="btn1" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>