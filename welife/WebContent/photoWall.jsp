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
<title>照片墙</title>
<style>
#main {
	width: 100%;
	height: auto;
	margin: 0 auto;
	margin-top: 20%;
}

.pin {
	width: 225px;
	padding: 15px 0px 0px 15px;
	float: left;
}

.box {
	width: 215px;
	height: auto;
	padding: 5px;
	background: #fff;
	border: 1px solid #ccc;
	box-shadow: 0px 0px 6px #ccc;
	border-radius: 5px;
}

.box img {
	width: 215px;
}

@media ( max-width : 600px) {
	.pin {
		width: 150px;
		padding: 15px 0px 0px 15px;
		float: left;
	}
	.box {
		width: 140px;
		height: auto;
		padding: 5px;
		background: #fff;
		border: 1px solid #ccc;
		box-shadow: 0px 0px 6px #ccc;
		border-radius: 5px;
	}
	.box img {
		width: 140px;
	}
}
</style>
</head>
<body>

	<div id="main"></div>

	<script src="js/jquery.js"></script>
	<script src="js/photoWall.js"></script>
	<script src="js/waterFall.js"></script>
	<script>
		window.onload = function() {
			ajaxFunction();
			setTimeout(runT, 1000);
		}
	</script>
</body>
</html>