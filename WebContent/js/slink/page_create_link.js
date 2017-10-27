window.onload = initialization;

function initialization() {

	if (span_option.innerHTML == 'update') {
		//create_editor();
		update_name();
		//update_annex();
	} else {
		getLinkUUID();
		System.out.println(getLinkUUID());
	}

	getLinkGmtCreate();

}

function create_editor() {

	/*
	 * getNewsUUID在这里给接口
	 */
	var span_jsj_slink_link_id = document
			.getElementById("span_jsj_slink_link_id");
	

	/*  
	 */
	
	
	editor.customConfig.uploadFileName = 'file';// 自定义 fileName

	editor.customConfig.uploadImgTimeout = 1000;// 自定义 timeout 时间

	editor.customConfig.customAlert = function(info) {
		// info 是需要提示的内容
		toastr.success(info);
	}
	editor.customConfig.uploadImgParams = {
	
	}
	/*  
	 */
	editor.customConfig.uploadImgHooks = {
		
		customInsert : function(insertImg, result, editor) {
			
			for (var url_num = 0; url_num < result.url.length; url_num++) {
				insertImg(result.url[url_num]);
			}
		
		}
	}
	editor.create();
	toastr.success('编辑器已初始化');
}

function getLinkUUID() {

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {

				var span_jsj_slink_link_id = document
						.getElementById("span_jsj_slink_link_id");
				span_jsj_slink_link_id.innerHTML = xhr.responseText;
				/*
				 * 要创建了UUID以后才能创建编辑器，不然图片获取不到UUID
				 */
				create_editor();
			} else {
				toastr.error(xhr.status);
			}
		}
	}

	xhr.open("POST", "/xxyjsjgcxy/slink/link_getLinkUUID");

	xhr.send(null);
}

function getLinkGmtCreate() {
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

	
}

var input_add_focus = false;
var mark_name = 0;
var num_name = 0;

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

			add_name();
		}
	}
};

function add_name() {

	if (num_name >= 1) {
		toastr.warning("最多添加1个关键字");
		return;
	}
	mark_name++;
	num_name++;

	var input_add = document.getElementById("input_add");
	var div_name_box = document.getElementById("div_name_box");

	var div_name = document.createElement("div");
	var div_delete = document.createElement("div");

	div_name_box.appendChild(div_name);
	div_name_box.appendChild(div_delete);

	div_name.innerHTML = input_add.value;
	div_name.style.backgroundColor = "#1abc9c";
	div_name.style.color = "white";
	div_name.style.width = "auto";
	div_name.style.float = "left";
	div_name.style.padding = "5px 10px";
	div_name.id = "div_name_" + mark_name;
	div_name.className = "div_name";

	div_delete.innerHTML = "x";
	div_delete.style.backgroundColor = "#1abc9c";
	div_delete.style.color = "white";
	div_delete.style.width = "auto";
	div_delete.style.float = "left";
	div_delete.style.margin = "0 10px 0 0";
	div_delete.style.padding = "5px 10px 5px 5px";
	div_delete.style.cursor = "pointer";
	div_delete.onclick = delete_name;
	div_delete.id = "div_delete_" + mark_name;
	// 清空
	input_add.value = "";
}

function delete_name() {

	num_name--;

	var div_name_box = document.getElementById("div_name_box");

	var div_delete = this;

	var div_name = document.getElementById("div_name_"
			+ this.id.substring(11));

	div_name_box.removeChild(div_delete);
	div_name_box.removeChild(div_name);

}






	