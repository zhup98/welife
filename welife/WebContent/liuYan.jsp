<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="css/liuYan.css">
<title>留言</title>
</head>
<body>
	<div id="wrap">
		<h1>Send a message</h1>
		<div id='form_wrap'>
			<form action="LiuYanServlet" method="post">
				<p>Hello</p>
				<label for="email">你想说点啥: </label>
				<textarea name="message" value="Your Message" id="message"></textarea>
				<label for="name">留个名字吧: </label> <input type="text" name="name"
					value="" id="name" /> <input type="submit" name="submit"
					value="发送" />
					
				<!-- <label for="email">联系方式: </label> <input
					type="text" name="email" value="" id="email" placeholder="任何形式" /> -->
			
			</form>
		</div>
	</div>
	<script src="js/jquery.js"></script>
</body>
</html>