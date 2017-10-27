function saveNews() {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				stop_load();
				if (xhr.responseText == "premission_none") {
					toastr.warning("无权限");

				} else {
					window.location = "/xxyjsjgcxy/snews/news_page_list_news?page=page_list_news&page_list_news.pageIndex=1";
				}

			} else {
				toastr.error(xhr.status);
				stop_load();
			}
		}
	}
	var input_jsj_snews_news_id = document
			.getElementById("input_jsj_snews_news_id");
	var input_news_title = document.getElementById("input_news_title");
	var select_news_category = document.getElementById("select_news_category");
	var checkbox_news_recommend = document
			.getElementById("checkbox_news_recommend");
	var checkbox_news_publish = document
			.getElementById("checkbox_news_publish");
	var input_bimg = document.getElementById("input_bimg");
	var input_simg = document.getElementById("input_simg");
	var input_news_source = document.getElementById("input_news_source");
	var input_news_gmt_show = document.getElementById("input_news_gmt_show");
	var span_option = document.getElementById("span_option");

	var formData = new FormData();

	/*
	 * ID、标题、分类、来源
	 */

	formData.append("news.jsj_snews_news_id", span_jsj_snews_news_id.innerHTML);
	formData.append("news.news_source", input_news_source.value);
	formData.append("news.news_title", input_news_title.value);
	formData.append("news.news_category", select_news_category.value);

	/*
	 * 推荐、发布
	 */
	if (checkbox_news_recommend.checked) {
		formData.append("news.news_recommend", 1);
	} else {
		formData.append("news.news_recommend", 0);
	}
	if (checkbox_news_publish.checked) {
		formData.append("news.news_publish", 1);
	} else {
		formData.append("news.news_publish", 0);
	}
	/*
	 * 大小图
	 */
	if (input_bimg.files[0] != null) {
		formData.append("news_bimg", input_bimg.files[0]);
	}
	if (input_simg.files[0] != null) {
		formData.append("news_simg", input_simg.files[0]);
	}
	/*
	 * 时间
	 */
	formData.append("news.news_gmt_show", input_news_gmt_show.value);
	/*
	 * 关键词
	 */
	var div_keywords = document.getElementsByClassName("div_keywords");
	var news_keywords = "";
	var i;
	for (i = 0; i < div_keywords.length; i++) {
		news_keywords = news_keywords + ";" + div_keywords[i].innerHTML;
	}
	news_keywords = news_keywords.substring(1);
	formData.append("news.news_keywords", news_keywords);
	/*
	 * 内容
	 */

	var content_text = editor.txt.html();// 获得编辑器的内容
	formData.append("content.content_text", content_text);

	/*
	 * 附件
	 */
	var input_news_annex = document.getElementsByClassName("input_news_annex");
	for (i = 0; i < input_news_annex.length; i++) {
		if (input_news_annex[i].files[0] != null) {
			formData.append("file", input_news_annex[i].files[0]);
		}
	}
	var div_old_annex = document.getElementsByClassName("div_old_annex");
	var span_news_num_annex = document.getElementById("span_news_num_annex");
	if (div_old_annex.length != span_news_num_annex.innerHTML) {
		for (i = 0; i < div_old_annex.length; i++) {
			var oldAnnex;
			if (oldAnnex == null) {
				oldAnnex = div_old_annex[i].innerHTML;
			} else {
				oldAnnex = oldAnnex + ";" + div_old_annex[i].innerHTML;
			}
		}
		if (div_old_annex.length > 0) {
			formData.append("remain_oldAnnex", oldAnnex);
		} else {
			formData.append("remain_oldAnnex", "");
		}
	}
	/*
	 * 发送请求
	 */
	if (span_option.innerHTML == 'update') {
		xhr.open("POST", "/xxyjsjgcxy/snews/news_updateNews");
	} else {
		xhr.open("POST", "/xxyjsjgcxy/snews/news_saveNews");
	}
	xhr.send(formData);
	start_load();
}
/*
 * 判断新闻标题不可重复
 */
function ifRepeatNewsTitle() {

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				if (xhr.responseText == "no") {
					saveNews();
				} else {
					toastr.warning("新闻标题已存在");
				}
			} else {
				toastr.error(xhr.status);
			}
		}
	}
	xhr.open("POST", "/xxyjsjgcxy/snews/news_ifRepeatNewsTitle");
	var formData = new FormData();

	var span_jsj_snews_news_id = document
			.getElementById("span_jsj_snews_news_id");
	var input_news_title = document.getElementById("input_news_title");
	var span_option = document.getElementById("span_option");

	formData.append("news.jsj_snews_news_id", span_jsj_snews_news_id.innerHTML);
	formData.append("news.news_title", input_news_title.value);
	if (span_option.innerHTML == 'update') {
		formData.append("option", "update");
	} else {
		formData.append("option", "save");
	}

	xhr.send(formData);

}