<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="user" type="me.codaline.model.User"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Profile</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/styleCreateProfile.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js"/>"></script>
</head>
<body>
<header>
    <div id="headerTitle">Редагування профілю</div>
</header>
<div id="globalBlock">
    <div class="title"><span>Додайте більше інформації</span></div>
    <hr>
    <div id="profile">
        <img src="/resources/img/${user.pathImage}">
    </div>
    <form method="POST" action="uploadFile?userImageId=${user.id}" enctype="multipart/form-data">
        Оберіть фото профілю: <input type="file" name="file"><br/>
        <%--Name: <input type="text" name="name"><br/> <br/>--%>
        <%--<input type="hidden" id="userImageId" value="${user.id}">--%>
        <input type="submit" value="Застосувати..."> Натисніть для збереження
    </form>

    <form action="/edit" method="post">
        <input class="input" type="text" placeholder="Ім'я" name="e_name" value="${user.firstName}">
        <input class="input" type="text" placeholder="Прізвище" name="e_surname" value="${user.lastName}">
        <input class="input" type="text" placeholder="Нік" name="e_nick" value="${user.nick}">
        <input class="input" type="text" placeholder="Рік народження" name="e_birth" value="${user.birth}">
        <input class="input" type="text" placeholder="E-Mail" name="e_mail" value="${user.email}">
        <input class="input" type="text" placeholder="Пароль" name="e_pass" value="${user.pass}">
        <input class="input" type="text" placeholder="Місто" name="e_city" value="${user.city}">
        <input class="input" type="text" placeholder="Мобільний телефон" name="e_phone" value="${user.phone}">
        <input class="input" type="text" placeholder="Інтереси" name="e_interests" value="${user.interests}">
        <input class="input" type="text" placeholder="Цитати" name="e_citations" value="${user.citation}">
        <input class="input" type="text" placeholder="Цікаве про себе" name="e_about" value="${user.about}">
        <input class="input" type="text" placeholder="Хоббі" name="e_hobby" value="${user.hobby}">
        <input class="input" type="text" placeholder="Улюблені книги" name="e_books" value="${user.books}">
        <input class="input" type="text" placeholder="Улюблені фільми" name="e_films" value="${user.films}">
        <button class="submit">Збрегти</button>
    </form>
    <form action="/home" method="get">
        <p class="tools"> <button class="button">Повернутись до профілю</button></p>
    </form>
</div>
</body>
</html>