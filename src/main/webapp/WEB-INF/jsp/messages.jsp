<!DOCTYPE html>
<html>
<head>
    <title>Messeges</title>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/styleMessages.css">
    <script type="text/javascript" src="/resources/js/script.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
</head>
<script>
    function addMessage() {
        if (message.value == "") return false;
        var list = document.getElementById('list');
        var firstLi = list.getElementsByTagName('LI')[0];
        var newListElem = document.createElement('LI');
        newListElem.innerHTML = message.value;
        newListElem.className = "message";
        list.insertBefore(newListElem, firstLi)
    }
</script>
<body>
<header>
    <div id="profile">
        <span id="nameProfile">Jonh Malkovich</span>
        <img src="/resources/img/profile.jpg" onmouseover="anichanged('#profileTools'); return false" alt="">
        <div id="profileTools" style="display: none">
            <a class="href" href="/home"><p class="tools">Profile</p></a>
            <a class="href" href="/edit"><p class="tools">Edit profile</p></a>
            <a class="href" href="/auth"><p class="tools">Exit</p></a>
        </div>
    </div>
    <a href="/search" class="link" id="searchLink">Search</a>
    <a href="/home" class="link">Profile</a>
    <a href="/friends" class="link">Friends</a>
    <a href="/messages" style="background-color: rgba(47, 44, 44, 0.8)" class="link">Messages</a>
</header>
<div style="width: 100%; height: 80vh;" onmouseover="unanichanged('#profileTools'); return false">
    <div id="globalBlock">
        <div id="friendsBlock">Dialogs
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
        </div>
        <div id="writeBlock">
            <textarea name="" id="message"></textarea>
            <button id="sendMessage" onclick="addMessage()">Send</button>
        </div>
        <div id="messageBlock">
            <ul id="list"></ul>
        </div>
    </div>
</div>
</body>
</html>