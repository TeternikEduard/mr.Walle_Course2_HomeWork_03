<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="utf-8">
      <title>Тег FORM</title>
   </head>
<body>

<form action="/homeWork03-1.0-SNAPSHOT/error" method="POST">
    <p><b>Неправильно! Попробуй. Еще. Раз!</b></p>
    <p><b>Нужно выбрать хотя бы одного исполнителя, от 3 до 7 жанров и хоть чуть-чуть рассказать о себе, ну пожалуйста!</b></p>
    <p><b>Попробуем?</b></p>

<c:forEach items="${choiceList}" var="item">
        <p><input type="radio" name="choice" value="${item}">${item}</p>
    </c:forEach>

<p><input type="submit"></p>

</form>
</body>
</html>
