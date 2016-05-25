<%--@elvariable id="wall_entry" type="me.codaline.model.WallEntry"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="user" type="me.codaline.model.User"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/styleMain.css">
    <title>Profile</title>
    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/js/script.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>


    <script>
        function friendToHeader() {
            $('#friendsBlock').css('position', 'fixed');
            $('#friendsBlock').css('top', '0px');
        }

        function friendComeBack() {
            $('#friendsBlock').css('position', 'static');
        }
    </script>


</head>
<body>
<!-- <input type="text" id="search"> -->

<header>
    <div id="profile">
        <span id="nameProfile">${user.firstName} ${user.lastName}</span>
        <img src="/resources/img/${user.pathImage}" align="center" onmouseover="anichanged('#profileTools'); return false" alt="">
        <div id="profileTools" style="display: none">
            <a class="href" href="/home"><p class="tools">Моя сторінка</p></a>
            <a class="href" href="/edit"><p class="tools">Редагувати стрінку</p></a>
            <form action="/auth" method="get">
                <p class="tools">
                    <button class="button">Вийти</button>
                </p>
            </form>
        </div>
    </div>
    <a href="/search" class="link" id="searchLink">Пошук</a>
    <a href="/home" style="background-color: rgba(47, 44, 44, 0.8)" class="link">Моя Сторінка</a>
    <a href="/friends?userId=${my_id}" class="link">Мої Друзі</a>
    <a href="/messages" class="link">Мої Повідомлення</a>
</header>
<div id="globalBlock" onmouseover="unanichanged('#profileTools'); return false">
    <div id="leftSection">
        <div id="photoSection">
            <div id="profilePhoto"
                 style="background: url('/resources/img/${user.pathImage}') center; -webkit-background-size: cover;background-size: cover;">
            </div>
            <div id="profileGalary">
                <!--Цикл що виводить блоки фоток з бд-->
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <%--<img class="photo" src="/resources/img/profile.jpg">--%>
                <!-- Фотки -->
            </div>
        </div>
        <div id="profileName" onmouseover="anichanged('#actions');"
             onmouseleave="unanichanged('#actions'); return false">
            <span>${user.firstName} ${user.lastName}</span>
            <hr class="line">
            <span>${user.city}</span>
            <div id="actions" style="display: none;">
                <c:if test="${my_id != user.id}">
                    <c:if test="${friend == false}">
                    <img src="<c:url value="/resources/img/plus.png"/>" onclick="addToFriend(${user.id}, ${my_id})"
                         title="Додати до друзів"></c:if>
                    <c:if test="${friend}">
                    <img src="<c:url value="/resources/img/minus.png"/>" onclick="deleteFriend(${user.id}, ${my_id})"
                         title="Видалити з друзів">
                    </c:if>
                    <img src="<c:url value="/resources/img/message.png"/>" title="Надіслати повідомлення">
                </c:if>
                <div id="interests">
                    <span class="interests" onclick="anichange('#about'); return false">Про мене</span><br>
                    <div id="about" class="interese" style="display: none">
                        Нікнейм : ${user.nick}<br>
                        Дата народження : ${user.birth} <br>
                        Місто : ${user.city}<br>
                        Телефон : ${user.phone}<br>
                        Мої інтереси : ${user.interests}<br>
                        Улюблені цитати : ${user.citation}<br>
                        Про мене : ${user.about}<br>
                        Хоббі : ${user.hobby}<br>
                        Улюблені книги : ${user.books}<br>
                        Улюблені фільми : ${user.films}<br>
                    </div>
                    <span class="interests" onclick="anichange('#music'); return false">Аудіозаписи</span><br>
                    <div id="music" class="interese" style="display: none">
                        Тут sdfa<br>
                        Тут текст <br>
                        Тут текст <br>
                        Тут текст<br>
                    </div>
                    <span class="interests" onclick="anichange('#movie'); return false">Відеозаписи</span><br>
                    <div id="movie" class="interese" style="display: none">
                        Тут тукст<br>
                        Тут текст <br>
                        Тут текст <br>
                        Тут текст<br>
                    </div>
                    <span class="interests" onclick="anichange('#groups'); return false">Группи</span><br>
                    <div id="groups" class="interese" style="display: none">
                        Тут тукст<br>
                        Тут текст <br>
                        Тут текст <br>
                        Тут текст<br>
                    </div>
                </div>
            </div>
        </div>
        <div id="profileAttributs">
            <div id="friendsBlock">
                <a href="friends.jsp" style="text-decoration: none; color: #686868;">Друзі</a>
                <hr>
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <img class="photoFriends" src="/resources/img/profile.jpg">
                <!--<li>
                    Цикл що виводить блоки друзів з бд
                </li>-->
            </div>
            <div id="wallBlock">
                <label>Стіна</label>
                <hr>
                <textarea name="wall_messages" id="textbox"></textarea>
                <input type="button" id="writeInWall" onclick="addMessage(${user.id}, ${my_id})" value="Write">
            </div>
            <ul id="list"></ul>
        </div>
    </div>

    <script>
        <%--for (var i = 0; i < 10; i++) {--%>
        <%--var list = document.getElementById('list');--%>
        <%--var firstLi = list.getElementsByTagName('LI')[0];--%>
        <%--var newListElem = document.createElement('LI');--%>
        <%--newListElem.innerHTML = "${wall_list}";--%>
        <%--newListElem.className = "message";--%>
        <%--list.insertBefore(newListElem, firstLi)--%>
        <%--}--%>
        <c:forEach items="${wall_list}" var="wall_entry">
        var list = document.getElementById('list');
        var firstLi = list.getElementsByTagName('LI')[0];
        var newListElem = document.createElement('LI');
        newListElem.innerHTML = "${wall_entry.message}";
        newListElem.className = "message";
        list.insertBefore(newListElem, firstLi);
        </c:forEach>
    </script>
</div>
</body>
</html>