<%--
  Created by IntelliJ IDEA.
  User: rusik
  Date: 31.05.2025
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Аккаунт создан</title>
</head>
<body>
<center>
    <H2>Вы создали аккаунт</h2>
    <h2>ID : ${requestScope.get("id")}</h2>
    <h2>Имя : ${name}</h2>
    <h2>Пароль : ${password}</h2>
    <h2>Почта : ${mail}</h2>

    <form action="/login">
        <input type="submit" value="Login" />
    </form>
</center>

</body>
</html>
