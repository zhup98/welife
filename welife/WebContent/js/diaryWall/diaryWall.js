//window.onload = function() {
//	getDiarys();
//}
function appendDiv(list) {
	var grid = document.getElementById("main");
	for (var i = 0; i < list.length; i++) {
		var gridItems = document.createElement("div");
		gridItems.className = "pin";
		var box = document.createElement("div");
		box.className = "box";
		var diary = list[i];
		var title = document.createElement("strong");
		var dateAndName = document.createElement("div");
		dateAndName.className = "dateAndName";
		var content = document.createElement("div");
		content.className = "content";
		// 赋值
		title.innerHTML = diary.title;
		dateAndName.innerHTML = "<p class='date'>" + diary.date
				+ "</p><p class='name'>" + diary.username + "</p>";
		content.innerHTML = diary.content;

		box.appendChild(title);
		box.appendChild(dateAndName);
		box.appendChild(content);
		gridItems.appendChild(box);
		grid.appendChild(gridItems);
	}
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