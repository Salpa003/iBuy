<%--
  Created by IntelliJ IDEA.
  User: rusik
  Date: 31.05.2025
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<center>
    <h2>Регистрация</h2>
    <form action="/registration" method="post">
        <label> Name
            <input name="name" type="text" required>
        </label> <br> <br>
        <label> Email
            <input name="mail" type="email" required>
        </label> <br> <br>
        <label> Password
            <input name="password" type="password" required>
        </label> <br> <br>
        <label>
            <input type="submit" value="SEND">
        </label>
    </form>
    <form action="/login" method="get">
        <label>
            <input type="submit" value="Back">
        </label>
    </form>
</center>
</body>
</html>
