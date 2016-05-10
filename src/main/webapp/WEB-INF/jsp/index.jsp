<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/resources/css/style.css">
	<link rel="stylesheet" href="/resources/css/styleMain.css">
	<title>Profile</title>
	<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/js/script.js"></script>
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
				<span id="nameProfile">Jonh Malkovich</span>
				<img src="/resources/img/profile.jpg" onmouseover="anichanged('#profileTools'); return false" alt="">
				<div id="profileTools" style="display: none">
					<a class="href" href="index.jsp"><p class="tools">Profile</p></a>
					<a class="href" href="editProfile.jsp"><p class="tools">Edit profile</p></a>
					<a class="href" href="auth.jsp"><p class="tools">Exit</p></a>
				</div>
			</div>
			<a href="search.jsp" class="link" id="searchLink">Search</a>
			<a href="index.jsp" style="background-color: rgba(47, 44, 44, 0.8)" class="link">Profile</a>
			<a href="friends.jsp" class="link">Friends</a>
			<a href="messages.jsp" class="link">Messages</a>
		</header>
		<div id="globalBlock" onmouseover="unanichanged('#profileTools'); return false">
			<div id="leftSection">
				<div id="photoSection">
					<div id="profilePhoto" style="background: url('/resources/img/profile.jpg') center; -webkit-background-size: cover;background-size: cover;">
					</div>
					<div id="profileGalary">
						<!--Цикл що виводить блоки фоток з бд-->
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<img class="photo" src="/resources/img/profile.jpg">
						<!-- Фотки -->
					</div>
				</div>
				<div id="profileName" onmouseover="anichanged('#actions');" onmouseleave="unanichanged('#actions'); return false">
					<span>Jonh Malkovich</span>
					<hr class="line">
					<span>New York</span>
					<div id="actions" style="display: none;">
						<img src="/resources/img/plus.png" title="add to your friends">
						<img src="/resources/img/message.png" title="send message">
					</div>
				</div>
				<div id="profileAttributs">
					<div id="friendsBlock">
						<a href="friends.jsp" style="text-decoration: none; color: #686868;">Friends</a>
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
							<label>Wall</label>
							<hr>
							<textarea name="" id="textbox"></textarea>
							<input type="button" id="writeInWall" onclick="addMessage()"value="Write">
						</div>
						<ul id="list">
						</ul>
				</div>
			</div>
			<div id="rightSection">
				<div id="interests">
					<span class="interests" onclick="anichange('#about'); return false">About me</span><br>
					<div id="about" class="interese"style="display: none">
					Тут тукст<br>
					Тут текст <br>
					Тут текст <br>
					Тут текст<br>
					</div> 
					<span class="interests" onclick="anichange('#music'); return false">My audio</span><br>
					<div id="music" class="interese" style="display: none">
					Тут sdfa<br>
					Тут текст <br>
					Тут текст <br>
					Тут текст<br>
					</div> 
					<span class="interests" onclick="anichange('#movie'); return false">My video</span><br>
					<div id="movie" class="interese" style="display: none">
					Тут тукст<br>
					Тут текст <br>
					Тут текст <br>
					Тут текст<br>
					</div> 
					<span class="interests" onclick="anichange('#groups'); return false">My groups</span><br>
					<div id="groups" class="interese" style="display: none">
					Тут тукст<br>
					Тут текст <br>
					Тут текст <br>
					Тут текст<br>
					</div> 
				</div>
			</div>
			</div>
</body>
</html>