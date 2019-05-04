<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.text.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="dist/css/bootstrap.css">
<link rel="stylesheet" href="layui/css/layui.css">
<style>
body {
	background: url("img/write_diary_bg.jpg") no-repeat right top #fff;
}

.all {
	width: 88%;
	margin: 2% auto;
}

.formStyle {
	margin-top: 4%;
}
</style>
<title>忆生活</title>
</head>
<body>
	<jsp:include page="nav.jsp" flush="true" />
	<div class="all">
		<span class="label label-primary" style="font-size: 25px;">留下你的足迹吧
			。。。</span>
		<form action="recallLifeServlet" method="post" class="formStyle">
			<div class="form-group">
				<label>日记标题</label> <input type="text" name="title"
					placeholder="请输入标题" class="form-control">
			</div>
			<%
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String value = format.format(new Date());
			%>
			<div class="form-group">
				<label>日期</label> <input type="text" class="layui-input" name="time"
					id="test1" value="<%=value%>">
			</div>

			<div class="form-group">
				<label>你今天发生了啥</label>
				<div id="editor"></div>
				<textarea id="area" name="area" hidden></textarea>
			</div>

			<div class="form-group">
				<input type="submit" value="提交" class="btn btn-block btn-primary">
				<br> <input type="button" value="取消"
					class="btn btn-block btn-warning">
			</div>
		</form>
	</div>


	<script type="text/javascript" src="wangEditor/wangEditor.js"></script>
	<script type="text/javascript" src="js/recallLife.js"></script>
	<script src="js/jquery.js"></script>
	<script type="text/javascript" src="dist/js/bootstrap.js"></script>
	<script src="layui/layui.js"></script>
	<script>
		layui.use('laydate', function() {
			var laydate = layui.laydate;

			//常规用法
			laydate.render({
				elem : '#test1'
			});
		});
	</script>
</body>
</html>