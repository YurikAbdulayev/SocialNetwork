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
    <a href="/friends" style="background-color: rgba(47, 44, 44, 0.8)" class="link">Friends</a>
    <a href="/messages" class="link">Messages</a>
</header>
<div id="globalBlock" onmouseover="unanichanged('#profileTools'); return false">
    <div id="search">
        <input type="text" id="searchLine" placeholder="what are u search?">
        <button id="searchButton">Search</button>
    </div>
    <div class="friendsList" onmouseover="sendMessageShow('#sendMessage'); return false;"
         onmouseleave="sendMessageHide('#sendMessage'); return false">
        <div class="avatarFriend"><img src="/resources/img/profile.jpg" alt=""></div>
        <div class="nameFriend">
            <span>Bruce Uyllis</span>
            <hr>
            <span>Los Angelise</span>
            <span><img id="sendMessage" style="display: none; width: 8%; margin-left: 10px;"
                       src="/resources/img/message.png" alt=""></span>
        </div>
    </div>

</div>
</body>
</html>