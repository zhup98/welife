<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link rel="stylesheet" href="layui/css/layui.css">
<style>
#all {
	font-size: 11px;
}

.title {
	font-size: 11px;
}

#demo1 {
	font-size: 11px;
	text-align: center;
}

label {
	font-size: 11px;
}
</style>
</head>
<body>
	<div id="all"></div>
	<div id="demo1"></div>

	<script src="js/jquery.js"></script>
	<script src="layui/layui.js"></script>
	<script>
		window.onload = function() {
			getMyDiaryList();
		}
		function getMyDiaryList() {
			var length;
			$.ajax({
				type : "post",
				url : "ShowLiuYanServlet",
				data : "",
				async : true,
				dataType : "json",
				success : function(dataObj) {
					console.info(dataObj.liuYanMessages);
					length = dataObj.liuYanMessages.length;

					layui.use('laypage', function() {
						var laypage = layui.laypage;
						//总页数大于页码总数
						laypage.render({
							elem : 'demo1',
							layout : [ 'prev', 'page', 'next', 'count' ],
							count : length, //数据总数
							limit : 5,
							jump : function(obj) {
								console.log(obj)
								console.log(obj.curr);
								clearDiv(); // 用来清除原来的HTML内容
								creatDiv2(dataObj.liuYanMessages, obj.curr, 5);
							}
						});
					});
				}
			});
		}

		function creatDiv2(DiaryList, start, num) {
			var all = document.getElementById("all");
			var htmls = "";
			if (DiaryList.length == 0) {
				htmls = "<h3 style='text-align: center'>亲，暂时还没有任何留言哟！<h3>";
			} else {
				var myDiarys = DiaryList.slice((start - 1) * num, start * num);

				for (var i = 0; i < myDiarys.length; i++) {
					var diary = myDiarys[i];
					var html = "<div class='layui-card'><div class='layui-card-header'><div class='title'><label>名字：</label>"
							+ diary.name
							+ "</div></div><div class='layui-card-body'><label>内容：</label>"
							+ diary.message + "</div></div>";
					htmls = htmls + html;
				}
			}
			all.innerHTML = htmls;
		}

		function clearDiv() {
			var all = document.getElementById("all");
			all.innerHTML = "";
		}
	</script>
</body>
</html>