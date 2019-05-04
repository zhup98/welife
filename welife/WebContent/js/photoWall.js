function getImgs(imgList) {
	// var imgList = [ "img/b02.jpg", "img/b06.jpg", "img/build.jpg",
	// "img/car1.jpg", "img/t01.jpg", "img/car2.jpg", "img/car3.jpg",
	// "img/t02.jpg", "img/v1.jpg", "img/car4.jpg" ];
	var grid = document.getElementById("main");
	for (var i = 0; i < imgList.length; i++) {
		var gridItems = document.createElement("div");
		gridItems.className = "pin";
		var box = document.createElement("div");
		box.className = "box";
		var imgSrc = imgList[i];
		var img = document.createElement("img");
		img.src = imgSrc;

		box.appendChild(img);
		gridItems.appendChild(box);
		grid.appendChild(gridItems);
	}
}
function ajaxFunction() {
	var xmlHttp;
	var imgList = [];
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			var dataObj = eval("(" + xmlHttp.responseText + ")");
			// console.info(typeof dataObj.images);
			console.info(dataObj.images.length);
			for (var i = 0; i < dataObj.images.length; i++) {
				imgList.push("img/waterFall/" + dataObj.images[i]);
			}
			getImgs(imgList);
		}
	}

	xmlHttp.open("GET", "PhotoWallServlet", true);
	xmlHttp.send();

}