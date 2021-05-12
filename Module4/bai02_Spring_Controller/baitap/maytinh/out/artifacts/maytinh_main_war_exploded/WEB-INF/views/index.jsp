<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/30/2021
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        span{
            display: block;
        }
    </style>
</head>
<body>
<form action="computer" method="post">
    <h1>Calculation</h1>
    <span><input type="text" name="first" value="${first}">
        <input type="text" name="second" value="${second}">
    </span>
    <span>
        <input type="submit" name="calculation" value="addition(+)">
        <input type="submit" name="calculation" value="subtraction(-)">
        <input type="submit" name="calculation" value="multiplication(*)">
        <input type="submit" name="calculation" value="division(/)">
    </span>
</form>
<%--<c:if test="${result} != null">--%>
    <h2>Result ${calculation}: ${result}</h2>
<%--</c:if>--%>

</body>
</html>
