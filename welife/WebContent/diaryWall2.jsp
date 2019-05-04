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
<title>日记墙</title>
<link rel='stylesheet' href='css/lanrenzhijia.css' media='screen' />
</head>
<body>
	<section id="wrapper">
	<div id="container">
		<!-- <div class="grid">
			<div class="imgholder">
				<img src="images/img27.jpg" />
			</div>
			<strong>Sunset Lake</strong>
			<p>A peaceful sunset view...</p>
			<div class="meta">by j osborn</div>
		</div> -->
	</div>
	</section>

	<script src="js/diaryWall/diaryWall2.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/diaryWall/blocksit.min.js"></script>
	<script>
		window.onload = function() {
			getDiarys();
		}
		$(document).ready(function() {
			//vendor script
			$('#header').css({
				'top' : -50
			}).delay(1000).animate({
				'top' : 0
			}, 800);

			$('#footer').css({
				'bottom' : -15
			}).delay(1000).animate({
				'bottom' : 0
			}, 800);

			//blocksit define
			$(window).load(function() {

				$('#container').BlocksIt({
					numOfCol : 5,
					offsetX : 8,
					offsetY : 8
				});
			});

			//window resize
			var currentWidth = 1250;
			$(window).resize(function() {
				var winWidth = $(window).width();
				var conWidth;
				if (winWidth < 750) {
					conWidth = 500;
					col = 2
				} else if (winWidth < 1000) {
					conWidth = 750;
					col = 3
				} else if (winWidth < 1250) {
					conWidth = 1000;
					col = 4;
				} else {
					conWidth = 1250;
					col = 5;
				}

				if (conWidth != currentWidth) {
					currentWidth = conWidth;
					$('#container').width(conWidth);
					$('#container').BlocksIt({
						numOfCol : col,
						offsetX : 8,
						offsetY : 8
					});
				}
			});
		});
	</script>
</body>
</html>