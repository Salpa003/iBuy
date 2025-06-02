<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>ConfirmMail</title>
</head>
<body>
    <center>
        <h2>На почту ${requestScope.mail} был отправлен код</h2>
        <form action="/confirmMail" method="post">
            <input type="number" name="code">
            <input type="submit" value="SEND">
        </form>
        <c:if test="${requestScope.errorMessage!=null}">
            <h2 style="color: red"> ${requestScope.errorMessage}</h2>
        </c:if>
    </center>
</body>
</html>
