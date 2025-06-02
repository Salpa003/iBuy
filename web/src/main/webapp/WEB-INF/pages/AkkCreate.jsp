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
    <h2>ID : ${requestScope.user.id}</h2>
    <h2>Имя : ${requestScope.user.name}</h2>
    <h2>Пароль : ${requestScope.user.password}</h2>
    <h2>Почта : ${requestScope.user.mail}</h2>

    <form action="/login" method="get">
        <input type="submit" value="Login" />
    </form>
</center>

</body>
</html>
