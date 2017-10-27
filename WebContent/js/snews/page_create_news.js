window.onload = initialization;

function initialization() {

	if (span_option.innerHTML == 'update') {
		create_editor();
		update_keywords();
		update_annex();
	} else {
		getNewsUUID();
		getNewsGmtCreate();
	}

	var select_news_category = document.getElementById("select_news_category");

	getNewsCategory(select_news_category);

}
function deleteImg() {
	toastr.success();
	document.getElementById("simg").value = "";
	document.getElementById("input_simg").value = "";
	input_simg.files[0] = null;
	toastr.success();
}
function create_editor() {

	/*
	 * getNewsUUID在这里给接口
	 */
	var span_jsj_snews_news_id = document
			.getElementById("span_jsj_snews_news_id");
	editor.customConfig.uploadImgServer = '/xxyjsjgcxy/snews/news_saveNewsContentImg?news.jsj_snews_news_id='
			+ span_jsj_snews_news_id.innerHTML;// 上传图片到服务器

	/*  
	 */
	editor.customConfig.uploadImgMaxSize = 50 * 1024 * 1024;// 将图片大小限制为 3M
	editor.customConfig.zIndex = 3;
	editor.customConfig.uploadFileName = 'file';// 自定义 fileName

	editor.customConfig.uploadImgTimeout = 1000;// 自定义 timeout 时间

	editor.customConfig.customAlert = function(info) {
		// info 是需要提示的内容
		toastr.success(info);
	}
	editor.customConfig.uploadImgParams = {
	// token: 'abcdef12345' // 属性值会自动进行 encode ，此处无需 encode，必须要有这个，不然默认会有这个参数
	}
	/*  
	 */
	editor.customConfig.uploadImgHooks = {
		// 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
		// （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
		customInsert : function(insertImg, result, editor) {
			// 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
			// insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果
			// 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
			for (var url_num = 0; url_num < result.url.length; url_num++) {
				insertImg(result.url[url_num]);
			}
			// result 必须是一个 JSON 格式字符串！！！否则报错
		}
	}
	editor.create();
	toastr.success('编辑器已初始化');
}

function getNewsUUID() {

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {

				var span_jsj_snews_news_id = document
						.getElementById("span_jsj_snews_news_id");
				span_jsj_snews_news_id.innerHTML = xhr.responseText;
				/*
				 * 要创建了UUID以后才能创建编辑器，不然图片获取不到UUID
				 */
				create_editor();
			} else {
				toastr.error(xhr.status);
			}
		}
	}

	xhr.open("POST", "/xxyjsjgcxy/snews/news_getNewsUUID");

	xhr.send(null);
}

function getNewsGmtCreate() {
	var dtCur = new Date();
	var yearCur = dtCur.getFullYear();
	var monCur = dtCur.getMonth() + 1;
	var dayCur = dtCur.getDate();
	var hCur = dtCur.getHours();
	var mCur = dtCur.getMinutes();
	var sCur = dtCur.getSeconds();
	var timeCur = yearCur + "-" + (monCur < 10 ? "0" + monCur : monCur) + "-"
			+ (dayCur < 10 ? "0" + dayCur : dayCur) + " "
			+ (hCur < 10 ? "0" + hCur : hCur) + ":"
			+ (mCur < 10 ? "0" + mCur : mCur) + ":"
			+ (sCur < 10 ? "0" + sCur : sCur);

	var input_news_gmt_show = document.getElementById("input_news_gmt_show");
	input_news_gmt_show.value = timeCur;
}

var input_add_focus = false;
var mark_keywords = 0;
var num_keywords = 0;

function input_add_onfocus() {

	input_add_focus = true;
}

function input_add_onblur() {
	var input_add = document.getElementById("input_add");
	input_add_focus = false;
}

document.onkeydown = function(event) {
	var e = event || window.event || arguments.callee.caller.arguments[0];
	if (e && e.keyCode == 13) {
		if (input_add_focus) {

			add_keywords();
		}
	}
};

function add_keywords() {

	if (num_keywords >= 5) {
		toastr.warning("最多添加五个关键词");
		return;
	}
	mark_keywords++;
	num_keywords++;

	var input_add = document.getElementById("input_add");
	var div_keywords_box = document.getElementById("div_keywords_box");

	var div_keywords = document.createElement("div");
	var div_delete = document.createElement("div");

	div_keywords_box.appendChild(div_keywords);
	div_keywords_box.appendChild(div_delete);

	div_keywords.innerHTML = input_add.value;
	div_keywords.style.backgroundColor = "#1abc9c";
	div_keywords.style.color = "white";
	div_keywords.style.width = "auto";
	div_keywords.style.float = "left";
	div_keywords.style.padding = "5px 10px";
	div_keywords.id = "div_keywords_" + mark_keywords;
	div_keywords.className = "div_keywords";

	div_delete.innerHTML = "x";
	div_delete.style.backgroundColor = "#1abc9c";
	div_delete.style.color = "white";
	div_delete.style.width = "auto";
	div_delete.style.float = "left";
	div_delete.style.margin = "0 10px 0 0";
	div_delete.style.padding = "5px 10px 5px 5px";
	div_delete.style.cursor = "pointer";
	div_delete.onclick = delete_keywords;
	div_delete.id = "div_delete_" + mark_keywords;
	// 清空
	input_add.value = "";
}

function delete_keywords() {

	num_keywords--;

	var div_keywords_box = document.getElementById("div_keywords_box");

	var div_delete = this;

	var div_keywords = document.getElementById("div_keywords_"
			+ this.id.substring(11));

	div_keywords_box.removeChild(div_delete);
	div_keywords_box.removeChild(div_keywords);

}

/* 上传图片的JS */
function bimg_click() {
	document.getElementById("input_bimg").click();
}
function simg_click() {
	document.getElementById("input_simg").click();
}
function bimg_change(file) {
	var img = document.getElementById("bimg");
	var reader = new FileReader();
	reader.onload = function(evt) {
		img.src = evt.target.result;
	}

	reader.readAsDataURL(file.files[0]);
}
function simg_change(file) {
	var img = document.getElementById("simg");
	var reader = new FileReader();
	reader.onload = function(evt) {
		img.src = evt.target.result;
	}

	reader.readAsDataURL(file.files[0]);
}
