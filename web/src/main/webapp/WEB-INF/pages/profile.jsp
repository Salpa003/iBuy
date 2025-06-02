<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <center>
        <h2>Ваш профиль</h2>
        <c:choose>
        <c:when test="${requestScope.user != null}">
            <h2>Name: ${requestScope.user.name}</h2>
            <h2>Password: ${requestScope.user.password}</h2>
            <h2>Mail: ${requestScope.user.mail}</h2>
            <form action="/leaveAkk" method="get">
                <input type="submit" value="Выйти из аккаунта">
            </form>
        </c:when>
            <c:otherwise>
                <h2>Вы не вошли в аккаунт</h2>
                <form action="/login" method="get">
                    <input type="submit" value="Login">
                </form>
            </c:otherwise>
        </c:choose>

    </center>
</body>
</html>
