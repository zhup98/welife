<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
	<nav class="navbar navbar-inverse" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#example-navbar-collapse">
				<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">WELIFE</a>
		</div>
		<div class="collapse navbar-collapse" id="example-navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="home.jsp">网站首页</a></li>
				<li><a href="myDiary.jsp">个人日记</a></li>
				<li><a href="recallLife.jsp">忆生活</a></li>
				<li><a href="diaryWall2.jsp">日记墙</a></li>
				<li><a href="photoWall.jsp">照片墙</a></li>
				<li><a href="#">时间轴</a></li>
				<li><a href="liuYan.jsp">留言</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> 更多 <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="logout.jsp">退出</a></li>
						<li><a href="modelHtml/me.html">关于站长</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	</nav>
</body>
</html>