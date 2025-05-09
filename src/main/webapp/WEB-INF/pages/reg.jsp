<%--
  Created by IntelliJ IDEA.
  User: rusik
  Date: 09.05.2025
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<center>
    <H3 style="text-align: -moz-center">Регистрация</H3>
    <form action="/reg" method="post">
        <label> Name:
            <input type="text" name="name" required>
        </label> <br>
        <label> Password:
            <input type="password" name="password" required>
        </label> <br>
        <label> Mail:
            <input type="email" name="mail" required>
        </label> <br>
        <label>
            <input type="submit" value="Send">
        </label>
    </form>
</center>
</body>
</html>
