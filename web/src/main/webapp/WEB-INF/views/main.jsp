<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>Main page</title>
</head>
<body>

<div>
    <form method="post" action="/count">
        <div>
            <span>Введите числа через пробел: </span><input type="text" name="numbers"/>
        </div>
        <div>
            <span>Введите размер площадки: </span><input type="text" name="platformSize"/>
        </div>
        <div>
            <input type="submit" value="Отправить"/>
        </div>
    </form>
</div>

</body>
</html>
