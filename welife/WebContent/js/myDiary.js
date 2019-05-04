window.onload = function() {
	var start = 1; // 所查询的页数
	var num = 5; // 每页显示的数目
	var pageParams = {
		start : 1,
		num : 5
	};
	var length;
	$.ajax({
		type : "post",
		url : "MyDiaryServlet",
		data : pageParams,
		async : true,
		dataType : "json",
		success : function(dataObj) {
			// length = getDiaryNum(dataObj.myDiary);
			console.info(dataObj.myDiary);
			creatDiv(dataObj.myDiary);

			layui.use('laypage', function() {
				var laypage = layui.laypage;
				//总页数大于页码总数
				laypage.render({
					elem : 'demo1',
					count : 1555, //数据总数
					curr: pageParams.start,
					limit : 5,
					jump : function(obj, first) {
						console.log(obj)
						console.log(obj.curr);
						pageParams.start = obj.curr;
					}
				});
			});
		}
	});
}
function getDiaryNum(myDiarys) {
	return myDiarys.length
}
function creatDiv(myDiarys) {
	var all = document.getElementById("all");
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