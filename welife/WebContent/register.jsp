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
<link rel="stylesheet" href="dist/css/bootstrap.css">
<!-- <link rel="stylesheet" href="layui/css/layui.css"> -->
<title>注册</title>
<style>
body {
	background-color: #1A4853;
}

#all {
	width: 450px;
	height: 385px;
	background-color: rgba(0, 0, 0, 0.2);
	margin: 50px auto;
}

h1 {
	color: #FFFFFF;
	text-align: center;
}

.input-group {
	width: 65%;
	margin: 25px auto;
}
</style>
</head>
<body id="mydiv">
	<div id="all">
		<header>
		<h1>欢迎注册</h1>
		</header>
		<hr />
		<form action="RegisterServlet" method="post">
			<!-- 用户名 -->
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-user"></span></span> <input type="text"
						class="form-control" id="username" name="username"
						placeholder="请输入用户名">
				</div>

				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-lock"></span></span> <input type="password"
						class="form-control" id="password1" name="password1"
						placeholder="请输入密码">
				</div>

				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-ok"></span></span> <input type="password"
						class="form-control" id="password2" name="password2"
						placeholder="确认密码">
				</div>

				<div class="input-group">
					<input type="submit" id="btn" value="注册"
						class="btn btn-block btn-primary">
				</div>
			</div>

		</form>
	</div>
	<script src="js/register/canvas-particle.js"></script>
	<script type="text/javascript">
		window.onload = function() {
			//配置
			var config = {
				vx : 4, //小球x轴速度,正为右，负为左
				vy : 4, //小球y轴速度
				height : 2, //小球高宽，其实为正方形，所以不宜太大
				width : 2,
				count : 200, //点个数
				color : "121, 162, 185", //点颜色
				stroke : "130,255,255", //线条颜色
				dist : 6000, //点吸附距离
				e_dist : 20000, //鼠标吸附加速距离
				max_conn : 10
			//点到点最大连接数
			}
			//调用
			CanvasParticle(config);
		}
	</script>
</body>
</html>