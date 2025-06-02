<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div style="display: flex; justify-content: space-between; align-items: center; padding: 10px; background-color: darkgray;">
    <!-- Переключатель языка слева;  пока что не знаю как локализацию добавить -->
    <form method="post" action="changeLanguage" style="margin: 0; display: flex;">
        <button type="submit" name="lang" value="ru" style="margin-right: 5px;">RU</button>
        <button type="submit" name="lang" value="en">EN</button>
    </form>

    <!-- Блок с кнопками справа -->
    <div style="display: flex; gap: 15px;">
        <form action="/home" method="get" style="display: inline;">
            <button type="submit" style="width: 40px ; height: 40px">🏠</button>
        </form>
        <form action="/search" method="get" style="display: inline;">
            <button type="submit" style="width: 40px ; height: 40px">🔎</button>
        </form>
        <form action="/basket" method="get" style="display: inline;">
            <button type="submit" style="width: 40px ; height: 40px">🛒</button>
        </form>
        <form action="/profile" method="get" style="display: inline;">
            <button type="submit" style="width: 40px ; height: 40px">🙎🏻‍♂️</button>
        </form>
    </div>
</div>

</body>
</html>