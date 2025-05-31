<%--
  Created by IntelliJ IDEA.
  User: rusik
  Date: 31.05.2025
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <center>
        <h2>Вход в аккаунт</h2>
        <form action="/login" method="post">
            <label> Name
                <input name="name" type="text" required>
            </label> <br> <br>
            <label> Password
                <input name="password" type="password" required>
            </label> <br> <br>
            <label>
                <input type="submit" value="SEND">
            </label>
        </form>
        <form action="/registration">
            <input type="submit" value="Registration" />
        </form>
    </center>
</body>
</html>
