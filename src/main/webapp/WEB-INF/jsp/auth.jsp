<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to our social network</title>
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
    <div id="headerTitle">Welcome to our social network</div>
</header>
<div id="globalBlock">
    <div id="auth">
        <div class="title">
            <span>Авторизація</span>
        </div>
        <hr>
        <form action="/home" method="post">
            <input class="input" type="text" placeholder="login" name="authLogin">
            <input class="input" type="password" placeholder="password" name="authPass">
            <span class="text">Не зараєстровані ?<br><a class="links"
                       onclick="anichange('#reg'); anichange('#auth'); return false;">Зареєструватись.</a>.</span>

            <%--<script>--%>
                <%--window.alert("sometext");--%>
            <%--</script>--%>
            <button class="submit">Sign in</button>
        </form>
    </div>
    <div id="reg" style="display: none;">
        <div class="title">
            <span>Реєстрація</span>
        </div>
        <hr>
        <form action="/auth" method="post">
            <input class="input" type="text" placeholder="login" name="regLogin">
            <input class="input" type="text" placeholder="first name" name="regFName">
            <input class="input" type="text" placeholder="last name" name="regLName">
            <input class="input" type="text" placeholder="email" name="regEmail">
            <input class="input" type="password" placeholder="password" name="regPass">
            <span class="text">Зареєстровані ?<br><a class="links"
                    onclick="anichange('#reg'); anichange('#auth'); return false;">Авторизуватись.</a></span>
            <button class="submit">Sign up</button>
        </form>
    </div>

</div>
</body>
</html>