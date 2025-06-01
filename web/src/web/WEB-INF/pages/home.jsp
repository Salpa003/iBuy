<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>It is home</h2>
<center>
    <c:if test="${requestScope.user != null}">
        <h2>Name: ${requestScope.get("name")}</h2>
        <h2>Mail: ${requestScope.get("mail")}</h2>
    </c:if>
</center>
</body>
</html>
