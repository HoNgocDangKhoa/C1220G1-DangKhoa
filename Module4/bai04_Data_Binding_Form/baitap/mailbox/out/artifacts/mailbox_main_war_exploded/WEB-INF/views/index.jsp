<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/31/2021
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form method="post" action="save" modelAttribute="mailbox">
    <table>
        <tr>
            <td>Languages</td>
            <td>
                <form:select path="languages" items="${languages}">
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td>
                <span>Show</span>
                <form:select path="size" items="${size}"/>
                <span>email per page</span>
            </td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td><form:checkbox path="filter"/>Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature" cols="30" rows="5"/></td>
        </tr>

    </table>
    <input type="submit" value="update">
    <input type="reset" value="cancel">

</form:form>
</body>
</html>
