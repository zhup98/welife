var E = window.wangEditor
var editor = new E('#editor')
var area = document.getElementById("area");
editor.customConfig.onchange = function(html) {
	// html 即变化之后的内容
	area.value = html;
}

editor.customConfig.emotions = [ {
	// tab 的标题
	title : '默认',
	// type -> 'emoji' / 'image'
	type : 'image',
	// content -> 数组
	content : [
			{
				alt : "[礼物]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c4/liwu_thumb.gif",
			},
			{
				alt : "[呵呵]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/ac/smilea_thumb.gif",
			},
			{
				alt : "[嘻嘻]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/0b/tootha_thumb.gif",
			},
			{
				alt : "[哈哈]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6a/laugh.gif",
			},
			{
				alt : "[可爱]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/14/tza_thumb.gif",
			},
			{
				alt : "[可怜]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/af/kl_thumb.gif",
			},
			{
				alt : "[挖鼻屎]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/a0/kbsa_thumb.gif",
			},
			{
				alt : "[吃惊]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f4/cj_thumb.gif",
			},
			{
				alt : "[害羞]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6e/shamea_thumb.gif",
			},
			{
				alt : "[挤眼]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c3/zy_thumb.gif",
			},
			{
				alt : "[闭嘴]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/29/bz_thumb.gif",
			},
			{
				alt : "[鄙视]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/71/bs2_thumb.gif",
			},
			{
				alt : "[爱你]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6d/lovea_thumb.gif",
			},
			{
				alt : "[泪]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/9d/sada_thumb.gif",
			},
			{
				alt : "[偷笑]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/19/heia_thumb.gif",
			},
			{
				alt : "[亲亲]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/8f/qq_thumb.gif",
			},
			{
				alt : "[生病]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/b6/sb_thumb.gif",
			},
			{
				alt : "[太开心]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/58/mb_thumb.gif",
			},
			{
				alt : "[懒得理你]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/17/ldln_thumb.gif",
			},
			{
				alt : "[右哼哼]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/98/yhh_thumb.gif",
			},
			{
				alt : "[左哼哼]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6d/zhh_thumb.gif",
			},
			{
				alt : "[嘘]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/a6/x_thumb.gif",
			},
			{
				alt : "[衰]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/af/cry.gif",
			},
			{
				alt : "[委屈]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/73/wq_thumb.gif",
			},
			{
				alt : "[怒]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/7c/angrya_thumb.gif",
			},
			{
				alt : "[疑问]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/5c/yw_thumb.gif",
			},
			{
				alt : "[馋嘴]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/a5/cza_thumb.gif",
			},
			{
				alt : "[拜拜]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/70/88_thumb.gif",
			},
			{
				alt : "[思考]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/e9/sk_thumb.gif",
			},
			{
				alt : "[钱]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/90/money_thumb.gif",
			},
			{
				alt : "[失望]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/0c/sw_thumb.gif",
			},
			{
				alt : "[酷]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/40/cool_thumb.gif",
			},
			{
				alt : "[花心]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/8c/hsa_thumb.gif",
			},
			{
				alt : "[哼]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/49/hatea_thumb.gif",
			},
			{
				alt : "[鼓掌]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/36/gza_thumb.gif",
			},
			{
				alt : "[悲伤]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/1a/bs_thumb.gif",
			},
			{
				alt : "[抓狂]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/62/crazya_thumb.gif",
			},
			{
				alt : "[黑线]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/91/h_thumb.gif",
			},
			{
				alt : "[心]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/40/hearta_thumb.gif",
			},
			{
				alt : "[猪头]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/58/pig.gif",
			},
			{
				alt : "[OK]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d6/ok_thumb.gif",
			},
			{
				alt : "[耶]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d9/ye_thumb.gif",
			},
			{
				alt : "[good]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d8/good_thumb.gif",
			},
			{
				alt : "[不要]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c7/no_thumb.gif",
			},
			{
				alt : "[赞]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d0/z2_thumb.gif",
			},
			{
				alt : "[来]",
				src : "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/40/come_thumb.gif",
			}

	]
} ]

// 自定义菜单配置
editor.customConfig.menus = [ 'head', // 标题
'bold', // 粗体
'fontSize', // 字号
'italic', // 斜体
'underline', // 下划线
'foreColor', // 文字颜色
'link', // 插入链接
'emoticon', // 表情
'image', // 插入图片
]

editor.customConfig.uploadImgServer = "/load"; // 上传URL
editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
editor.customConfig.uploadImgMaxLength = 5;
editor.customConfig.uploadFileName = 'myFileName';
editor.customConfig.uploadImgHooks = {
	customInsert : function(insertImg, result, editor) {
		// 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
		// insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

		// 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
		var url = result.data;
		insertImg(url);

		// result 必须是一个 JSON 格式字符串！！！否则报错
	}
}
editor.create()