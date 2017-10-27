var mark_annex = 0;
var num_annex = 0;

function add_annex() {
	if (num_annex >= 10) {
		toastr.warning("最多上传 10个附件");
		return;
	}

	// 总父容器
	var div_annex_box = document.getElementById("div_annex_box");

	// 创建input
	var input_annex = document.createElement("input");

	div_annex_box.appendChild(input_annex);

	input_annex.type = "file";
	input_annex.click();
	input_annex.id = "input_annex_" + (mark_annex + 1);
	input_annex.className = "input_news_annex";
	input_annex.onchange = input_annex_change;
	input_annex.style.display = "none";
}

function input_annex_change(annex) {
	mark_annex++;
	num_annex++;

	// 总父容器
	var div_annex_box = document.getElementById("div_annex_box");
	var div_annex_father = document.createElement("div");
	var div_annex_img = document.createElement("img");
	var div_annex_name = document.createElement("div");
	var div_annex_del = document.createElement("div");

	div_annex_box.appendChild(div_annex_father);
	div_annex_father.appendChild(div_annex_img);
	div_annex_father.appendChild(div_annex_name);
	div_annex_father.appendChild(div_annex_del);

	div_annex_father.style.float = "left";
	div_annex_father.style.width = "100%";
	div_annex_father.id = "div_annex_father_" + mark_annex;

	// 求出后缀
	if (annex == "[object Event]") {
		var input_annex_type = annex.target.files[0].name
				.substring(annex.target.files[0].name.lastIndexOf(".") + 1);
	} else {
		var input_annex_type = annex.substring(annex.lastIndexOf(".") + 1);
	}

	switch (input_annex_type) {
	case "jpg":
	case "JPG":
	case "jpeg":
	case "JPEG":
	case "png":
	case "PNG":
	case "gif":
	case "GIF":
	case "svg":
	case "SVG": {
		div_annex_img.src = "../img/img.png";
		break;
	}
	case "txt":
	case "TXT": {
		div_annex_img.src = "../img/txt.png";
		break;
	}
	case "xls":
	case "XLS":
	case "xlsx":
	case "XLSX": {
		div_annex_img.src = "../img/excel.png";
		break;
	}
	case "doc":
	case "DOC":
	case "docx":
	case "DOCX": {

		div_annex_img.src = "../img/word.png";
		break;
	}
	case "ppt":
	case "PPT":
	case "pptx":
	case "PPTX": {
		div_annex_img.src = "../img/ppt.png";
		break;
	}
	case "pdf":
	case "PDF": {
		div_annex_img.src = "../img/pdf.png";
		break;
	}
	case "rar":
	case "RAR":
	case "zip":
	case "ZIP":
	case "arj":
	case "ARJ":
	case "z":
	case "Z": {
		div_annex_img.src = "../img/archive.png";
		break;
	}
	case "wmv":
	case "WMV":
	case "asf":
	case "ASF":
	case "asx":
	case "ASX":
	case "rm":
	case "RM":
	case "rmvb":
	case "RMVB":
	case "mpg":
	case "MPG":
	case "mpeg":
	case "MPEG":
	case "mpe":
	case "MPE":
	case "3gp":
	case "3GP":
	case "mov":
	case "MOV":
	case "mp4":
	case "MP4":
	case "m4v":
	case "M4V":
	case "avi":
	case "AVI":
	case "mkv":
	case "MKV":
	case "flv":
	case "FLY":
	case "vob":
	case "VOB":
	case "dat":
	case "DAT": {
		div_annex_img.src = "../img/video.png";
		break;
	}
	default: {
		div_annex_img.src = "../img/unknown.png";
		break;
	}
	}
	
	div_annex_img.style.float = "left";
	div_annex_img.style.margin = "10px 10px 0 10px";

	if (annex == "[object Event]") {
		div_annex_name.innerHTML = annex.target.files[0].name;
	} else {
		div_annex_name.innerHTML = annex;
	}
	div_annex_name.style.width = "auto";
	div_annex_name.style.float = "left";
	div_annex_name.style.lineHeight = "32px";
	div_annex_name.style.margin = "10px 0 0 0";
	if (annex == "[object Event]") {
	} else {
		div_annex_name.className = "div_old_annex";
	}
	div_annex_del.innerHTML = "X";
	div_annex_del.style.width = "auto";
	div_annex_del.style.float = "left";
	div_annex_del.style.backgroundColor = "#d9534f";
	div_annex_del.style.color = "white";
	div_annex_del.style.margin = "10px 0 0 10px";
	div_annex_del.style.padding = "5px 10px";
	div_annex_del.style.borderRadius = "50%";
	div_annex_del.style.cursor = "pointer";
	div_annex_del.onclick = del_annex;
	div_annex_del.id = "div_annex_del_" + mark_annex;
}

function del_annex() {
	num_annex--;
	var div_annex_box = document.getElementById("div_annex_box");
	var div_annex_del = this;
	var div_annex_father = document.getElementById("div_annex_father_"
			+ div_annex_del.id.substring(14));
	var input_annex = document.getElementById("input_annex_"
			+ div_annex_del.id.substring(14));

	div_annex_box.removeChild(div_annex_father);
	div_annex_box.removeChild(input_annex);

}

