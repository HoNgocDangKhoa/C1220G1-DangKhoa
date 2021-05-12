<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/31/2021
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form action="/" method="get">
<table border="1">
    <tr>
        <td>Languages</td>
        <td>${language}</td>
    </tr>
    <tr>
        <td>Page Size:</td>
        <td>
            <span>Show</span>
            ${size}
            <span>email per page</span>
        </td>
    </tr>
    <tr>
        <td>Spams filter</td>
        <td>${filter}</td>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${signature}</td>
    </tr>

</table>
<input type="submit" value="back">
</form>
</body>
</html>
