<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Wecome to our social network</title>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/styleAuth.css">
    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
    <script>
        function anichange(objName) {
            if ($(objName).css('display') == 'none') {
                $(objName).animate({height: 'show'}, 500);
            } else {
                $(objName).animate({height: 'hide'}, 500);
            }
        }
    </script>
</head>
<body>
<header>
    <div id="headerTitle">Wecome to our social network</div>
</header>
<div id="globalBlock">
    <div id="auth">
        <div class="title">
            <span>Auth</span>
        </div>
        <hr>
        <form action="index.jsp">
            <input class="input" type="text" placeholder="login">
            <input class="input" type="text" placeholder="email">
            <input class="input" type="password" placeholder="password">
            <span class="text">Are not registered? <br><a class="links"
                                                          onclick="anichange('#reg'); anichange('#auth'); return false;">Check in</a>.</span>
            <button class="submit">Sign in</button>
        </form>
    </div>
    <div id="reg" style="display: none;">
        <div class="title">
            <span>Registration</span>
        </div>
        <hr>
        <form action="createProfile.jsp">
            <input class="input" type="text" placeholder="login">
            <input class="input" type="text" placeholder="email">
            <input class="input" type="password" placeholder="password">
            <span class="text">Already registered?<br><a class="links" <a
                    onclick="anichange('#reg'); anichange('#auth'); return false;">Login</a>.</span>
            <button class="submit">Sign up</button>
        </form>
    </div>

</div>
</body>
</html>