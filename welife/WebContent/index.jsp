<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="css/layui.css">
<link rel="stylesheet" href="dist/css/bootstrap.css">
<title>登录</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div
				class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3">
				<h1>用户登录</h1>
				<hr>
				<form action="LoginServlet" method="post">
					<div class="form-group">
						<label>用户名</label> <input type="text" name="username"
							placeholder="请输入用户名" class="form-control">
					</div>

					<div class="form-group">
						<label>密码</label> <input type="password" name="password"
							placeholder="请输入密码" class="form-control">
					</div>

					<div class="btn-group btn-group-justified" role="group"
						aria-label="...">
						<div class="btn-group" role="group">
							<button type="submit" class="btn btn-primary">登录</button>
						</div>
						<div class="btn-group" role="group">
							<button type="reset" class="btn btn-primary">重置</button>
						</div>
					</div>
					<br>
					<div class="form-group">
						<a href="register.jsp"> <input type="button" value="还没有账号？去注册"
							class="btn btn-block btn-warning" />
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>