function download_annex() {

	var div_news_annex = document.getElementById("div_news_annex");
	var div_annex_box = document.getElementById("div_annex_box");

	var news_annexs = $.trim(div_news_annex.innerHTML).split(";");

	if ($.trim(div_news_annex.innerHTML) != "null"
			&& $.trim(div_news_annex.innerHTML).length != 0) {

		for (var i = 0; i < news_annexs.length; i++) {
			// 总父容器
			var div_annex_box = document.getElementById("div_annex_box");

			// 单个父容器
			var div_annex_father = document.createElement("div");
			div_annex_box.appendChild(div_annex_father);
			div_annex_father.style.height = "50px";
			div_annex_father.style.lineHeight = "50px";

			// 图标
			var div_annex_img = document.createElement("img");
			var input_annex_type = news_annexs[i].substring(news_annexs[i]
					.lastIndexOf(".") + 1);
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
			div_annex_img.style.margin = "9px 10px";

			// 链接
			var a_annex = document.createElement("a");
			a_annex.appendChild(document.createTextNode(news_annexs[i]));
			a_annex.style.lineHeight = "50px";
			a_annex.style.display = "inline-block";
			a_annex.style.verticalAlign = "top";

			var div_news_id = document.getElementById("div_news_id");

			a_annex.href = "/xxyjsjgcxy/suser/getAnnex?fileName="
					+ div_news_id.innerHTML + "_" + news_annexs[i];

			//
			div_annex_father.appendChild(div_annex_img);
			div_annex_father.appendChild(a_annex);
		}

	}
}