<!DOCTYPE html>
<html>
<head>
    <title>Search</title>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/styleSearch.css">
</head>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/script.js"></script>

<script>
    function anichange(objName) {
        if ($(objName).css('display') == 'none') {
            $(objName).animate({height: 'show'}, 400);
        } else {
            $(objName).animate({height: 'hide'}, 200);
            $(objName).animate({height: 'show'}, 400);
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
    <a href="/search" style="background-color: rgba(47, 44, 44, 0.8)" class="link" id="searchLink">Search</a>
    <a href="/home" class="link">Profile</a>
    <a href="/friends" class="link">Friends</a>
    <a href="/messages" class="link">Messages</a>
</header>
<div style="width: 100%; height: 80vh;" onmouseover="unanichanged('#profileTools'); return false">
    <div id="globalBlock">
        <div id="searchBlock">
            <input type="text" id="searchLine" placeholder="what are u search?">
            <button id="searchButton" onclick="anichange('#result'); return false">Search</button>
        </div>
        <!-- <span class="interests" onclick="anichange('#about'); return false">About me</span><br> -->
        <div id="result" style="background-color: #f7f7f7;display: none">
            fnkeujfkernvkej<br>
            fnkeujfkernvkej <br>
            fnkeujfkernvkej <br>
            fnkeujfkernvkej<br>
        </div>
    </div>
</div>
</body>
</html>