<%--@elvariable id="user" type="me.codaline.model.User"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="friend" type="me.codaline.model.User"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Friends</title>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/styleFriends.css">
    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/js/script.js"></script>
</head>
<script>
    function sendMessageShow(objName) {
        if ($(objName).css('display') == 'none') {
            $(objName).animate({height: 'show'}, 0);
        }
    }


    function sendMessageHide(objName) {
        if ($(objName).css('display') != 'none') {
            $(objName).animate({height: 'hide'}, 200);
        }
    }
</script>
<body>
<header>
    <div id="profile">
        <span id="nameProfile">${user.firstName} ${user.lastName}</span>
        <img align="center" style="background: url('/getImg?id=${user.id}') center no-repeat; background-size: cover;"
             onmouseover="anichanged('#profileTools'); return false" >
        <div id="profileTools" style="display: none">
            <a class="href" href="/home"><p class="tools">Моя Сторінка</p></a>
            <a class="href" href="/edit"><p class="tools">Редагувати профіль</p></a>
            <a class="href" href="/auth"><p class="tools">Вихід</p></a>
        </div>
    </div>
    <a href="/search" class="link" id="searchLink">Пошук</a>
    <a href="/home" class="link">Моя Сторінка</a>
    <a href="/friends?userId=${user.id}" style="background-color: rgba(47, 44, 44, 0.8)" class="link">Мої Друзі</a>
    <a href="/messages" class="link">Мої Повідомлення</a>
</header>
<div id="globalBlock" onmouseover="unanichanged('#profileTools'); return false">
    <div id="search">
        <input type="text" id="searchLine" placeholder="what are u search?">
        <button id="searchButton">Search</button>
    </div>

    <c:forEach items="${friends}" var="friend">
        <%--<c:out value="${name}"/><p>--%>
        <div class="friendsList" onmouseover="sendMessageShow('#sendMessage${friend.id}'); return false;"
             onmouseleave="sendMessageHide('#sendMessage${user.id}'); return false">
            <a href="/user?id=${friend.id}">
            <div class="avatarFriend" style="background: url('/getImg?id=${friend.id}') center no-repeat; background-size: cover;">
            </div>
            </a>
            <div class="nameFriend">
                <span>${friend.firstName} ${friend.lastName}</span>
                <hr>
                <span>${friend.city}</span>
            <span>
                <a href="/message?dialog=${friend.id}">
                    <img id="sendMessage${friend.id}" style="display: none; width: 8%; margin-left: 10px;"
                         src="/resources/img/message.png" alt="">
                </a>
            </span>

            </div>
        </div>
    </c:forEach>

</div>
</body>
</html>