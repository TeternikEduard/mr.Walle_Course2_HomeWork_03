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


<form action="/homeWork03-1.0-SNAPSHOT/vote" method="POST">
    <p><b>Какая у Вас любимая музыкальная группа?</b></p>
    <c:forEach items="${artistsList}" var="item">
        <p><input type="radio" name="artist" value="${item}">${item}</p>
    </c:forEach>


    <p><b>А какие у Вас любимые жанры? Выберите от 3 до 7, пожалуйста!</b></p>
    <c:forEach items="${genresList}" var="item">
        <p><input type="checkbox" name="genre" value="${item}">${item}</p>
    </c:forEach>


    <p><b>Расскажите немного о себе:</b></p>
    <textarea name="about"></textarea>
    <p><input type="submit"></p>
</form>


</body>
</html>
