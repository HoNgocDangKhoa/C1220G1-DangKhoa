<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/30/2021
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        h3 {
            display: inline;

        }
    </style>
</head>

<body>
<h1>Sandwich Condiments</h1>
<form action="/sandwich"  method="post">
    <div class="form-check form-check-inline">
        <input type="checkbox" name="condiment" value="Lettuce">Lettuce
        <input type="checkbox" name="condiment" value="Tomato">Tomato
        <input type="checkbox" name="condiment" value="Mustard">Mustard
        <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    </div>
    <hr>
    <input type="submit" value="save">
    <div>
    <h3>Selected Condiment :</h3>
    <c:forEach items="${listCondiment}" var="condiment">
        <h3> ${condiment}</h3>
    </c:forEach>
    </div>
</form>
</body>
</html>
