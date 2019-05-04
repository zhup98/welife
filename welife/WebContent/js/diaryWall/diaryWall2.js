//window.onload = function() {
//	getDiarys();
//}
function appendDiv(list) {
	// var grid = document.getElementsByClassName("columns")[0];
	var grid = document.getElementById("container");
	var htmls = "";
	for (var i = 0; i < list.length; i++) {
		var diary = list[i];
		var html = "<div class='grid'><strong>"
				+ diary.title
				+ "</strong><div class='dateAndUser'><i class='ileft'>"+diary.username+"</i><i class='iright'>"+diary.date+"</i></div><p>"
				+ diary.content
				+ "</p></div>";
		htmls = htmls + html;
	}
	grid.innerHTML = htmls;
}
function getDiarys() {
	var xmlHttp;
	var diaryList = [];
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			var dataObj = eval("(" + xmlHttp.responseText + ")");
			for (var i = 0; i < dataObj.diary.length; i++) {
				var diary = dataObj.diary[i]; // 拿到单个json数据
				diaryList.push(diary);
			}
			appendDiv(diaryList);
		}
	}
	xmlHttp.open("GET", "DiaryWallServelt", true);
	xmlHttp.send();
}