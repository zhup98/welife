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
<link rel="stylesheet" href="css/home.css">
<title>首页</title>
</head>
<body>
	<jsp:include page="nav.jsp" flush="true" />
	<header>
	<div id="all">
		<div id="myCarousel" class="carousel slide">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="img/car1.jpg" alt="First slide">
				</div>
				<div class="item">
					<img src="img/car2.jpg" alt="Second slide">
				</div>
				<div class="item">
					<img src="img/car3.jpg" alt="Third slide">
				</div>
				<div class="item">
					<img src="img/car4.jpg" alt="Third slide">
				</div>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev" style="display: none"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next" style="display: none"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>

		<div class="pics">
			<ul>
				<li><a href="#"><img src="img/t01.jpg"></a><span>人生不过如此</span></li>
				<li><a href="#"><img src="img/t02.jpg"></a><span>愉快心情</span></li>
				<li><a href="#"><img src="img/t03.jpg"></a><span>这组图片中的静物等非常的日系</span></li>
			</ul>
		</div>

		<div id="tabSize">
			<ul id="myTab" class="nav nav-tabs">
				<li class="active"><a href="#build" data-toggle="tab">网站建设</a></li>
				<li><a href="#tool" data-toggle="tab">推荐工具</a></li>
				<li><a href="#study" data-toggle="tab">学习心得</a></li>
				<li><a href="#me" data-toggle="tab">关于站长</a></li>
				<li><a href="#liuyan" data-toggle="tab">留言信息</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="build">
					<div class="pics pics_float_left">
						<ul>
							<li><a href="build.html"><img class="imgSize"
									src="img/build/build.jpg"></a><span>如何快速搭建博客网站</span></li>
							<li><a href="#"><img class="imgSize"
									src="img/build/build2.jpg"></a><span>写一个属于自己的博客网站</span></li>
							<li><a href="https://www.aliyun.com/"><img
									class="imgSize" src="img/build/build3.png"></a><span>选择阿里云服务器</span></li>
						</ul>
					</div>
					<!-- 放置图片右边的文字链接 -->
					<div id="build_right">
						<ul class="list-group">
							<li class="list-group-item list-group-item-success"><a
								data-toggle="modal" data-target="#myModal1">welife，记录我们的点点滴滴</a></li>
							<li class="list-group-item list-group-item-warning"></li>
							<li class="list-group-item list-group-item-warning"></li>
							<li class="list-group-item list-group-item-success"><a
								data-toggle="modal" data-target="#myModal2">如何快速搭建属于自己的博客网站</a></li>
							<li class="list-group-item list-group-item-info"></li>
							<li class="list-group-item list-group-item-info"></li>
							<li class="list-group-item list-group-item-success"><a
								data-toggle="modal" data-target="#myModal3">想要遇见你</a></li>
						</ul>
					</div>
				</div>
				<div class="tab-pane fade" id="tool">
					<div id="tool_page">
						<iframe align="center" width="100%" src="modelHtml/tools.html"
							frameborder="no" border="0" marginwidth="0" marginheight="0"
							style="height: -webkit-fill-available;"></iframe>
					</div>
				</div>
				<div class="tab-pane fade" id="study">亲，还在建设中。。。</div>
				<div class="tab-pane fade" id="me">
					<div id="me_page">
						<iframe align="center" width="100%" src="modelHtml/me.html"
							frameborder="no" border="0" marginwidth="0" marginheight="0"
							style="height: -webkit-fill-available;"></iframe>
					</div>
				</div>
				<div class="tab-pane fade" id="liuyan">
					<div id="liuyan_page">
						<iframe align="center" width="100%" src="liuYanMessage.jsp"
							frameborder="no" border="0" marginwidth="0" marginheight="0"
							style="height: -webkit-fill-available;"></iframe>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>

	<!-- 模态框（Modal1） -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" style="height: 100%">
		<div class="modal-dialog" style="height: 100%">
			<div class="modal-content" style="height: 95%">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">welife，记录我们的点点滴滴</h4>
				</div>
				<div class="modal-body" style="height: 80%">
					<iframe align="center" width="100%" height="100%" src=""
						frameborder="no" border="0" marginwidth="0" marginheight="0"></iframe>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 模态框（Modal2） -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" style="height: 100%">
		<div class="modal-dialog" style="height: 100%">
			<div class="modal-content" style="height: 95%">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">如何快速搭建属于自己的博客网站</h4>
				</div>
				<div class="modal-body" style="height: 80%">
					<iframe align="center" width="100%" height="100%" src="build.html"
						frameborder="no" border="0" marginwidth="0" marginheight="0"></iframe>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 模态框（Modal3） -->
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" style="height: 100%">
		<div class="modal-dialog" style="height: 100%">
			<div class="modal-content" style="height: 95%">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">想要遇见你</h4>
				</div>
				<div class="modal-body" style="height: 80%">
					<iframe align="center" width="100%" height="100%"
						src="modelHtml/missyou.html" frameborder="no" border="0"
						marginwidth="0" marginheight="0"></iframe>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" flush="true" />
	<script src="js/jquery.js"></script>
	<script type="text/javascript" src="dist/js/bootstrap.js"></script>
	<script>
		$(function() {
			$('#myCarousel').carousel({
				interval : 3000
			});
			$('#myCarousel').mouseover(function() {
				$('.carousel-control').css("display", "block");
			});
			$('#myCarousel').mouseout(function() {
				$('.carousel-control').css("display", "none");
			});
		});
	</script>
</body>
</html>