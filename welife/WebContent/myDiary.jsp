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
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="dist/css/bootstrap.css">
<title>个人日记</title>
<style>
.layui-card {
	margin: 25px 0 0 0; /* 上 右 下 左 */
}

.layui-card-header .title {
	float: left;
	font-size: 13px;
}

.layui-card-body {
	font-size: 13px;
}

.layui-card-header .date {
	float: right;
	font-size: 12px;
	color: #222222;
}

.title Label, .layui-card-body Label {
	color: red;
}

#demo1 {
	text-align: center;
}

.mydate {
	margin-right: 3px;
	font-size: 12px;
}
</style>
</head>
<body>
	<jsp:include page="nav.jsp" flush="true" />
	<div id="all"></div>
	<div id="demo1"></div>

	<script src="js/jquery.js"></script>
	<script type="text/javascript" src="dist/js/bootstrap.js"></script>
	<script src="layui/layui.js"></script>
	<script>
		window.onload = function() {
			getMyDiaryList();
		}
		function getMyDiaryList() {
			var length;
			$.ajax({
				type : "post",
				url : "MyDiaryServlet",
				data : "",
				async : true,
				dataType : "json",
				success : function(dataObj) {
					console.info(dataObj.myDiary);
					length = dataObj.myDiary.length;
					//creatDiv(dataObj.myDiary);

					layui.use('laypage', function() {
						var laypage = layui.laypage;
						//总页数大于页码总数
						laypage.render({
							elem : 'demo1',
							layout: ['prev', 'page', 'next','count','skip'],
							count : length, //数据总数
							limit : 5,
							jump : function(obj) {
								console.log(obj)
								console.log(obj.curr);
								clearDiv(); // 用来清除原来的HTML内容
								creatDiv2(dataObj.myDiary, obj.curr, 5);
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
				//alert("亲，您还没有日记记录哟！");
				htmls = "<h3 style='text-align: center'>亲，您还没有日记记录哟！<h3>";
			} else {
				var myDiarys = DiaryList.slice((start - 1) * num, start * num);

				for (var i = 0; i < myDiarys.length; i++) {
					var diary = myDiarys[i];
					var html = "<div class='layui-card'><div class='layui-card-header'><div class='title'><label>标题：</label>"
							+ diary.title
							+ "</div><div class='date'><span class='glyphicon glyphicon-time mydate'></span>"
							+ diary.date
							+ "</div></div><div class='layui-card-body'><label>内容：</label>"
							+ diary.content
							+ "</div></div><hr class='layui-bg-blue'>";
					htmls = htmls + html;
				}
			}
			all.innerHTML = htmls;
		}

		function creatDiv(DiaryList, start, num) {
			var all = document.getElementById("all");
			var myDiarys = DiaryList.slice((start - 1) * num, start * num);
			for (var i = 0; i < myDiarys.length; i++) {
				var diary = myDiarys[i];
				var layui_card = document.createElement("div");
				layui_card.className = "layui-card";
				var layui_card_header = document.createElement("div");
				layui_card_header.className = "layui-card-header";
				var layui_card_body = document.createElement("div");
				layui_card_body.className = "layui-card-body";

				var hr = document.createElement("hr");
				hr.className = "layui-bg-blue";
				layui_card_header.innerText = diary.title;
				layui_card_body.innerHTML = diary.content;
				// 添加进layui_card
				layui_card.appendChild(layui_card_header);
				layui_card.appendChild(layui_card_body);
				all.appendChild(layui_card);
				all.appendChild(hr);
			}
		}
		function clearDiv() {
			var all = document.getElementById("all");
			all.innerHTML = "";
		}
	</script>
</body>

</html>