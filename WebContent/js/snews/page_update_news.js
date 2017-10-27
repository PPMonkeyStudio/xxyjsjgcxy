function update_keywords() {
	var input_add = document.getElementById("input_add");
	if (input_add.value != "") {
		toastr.success(input_add.value);
		var keywords = input_add.value.split(";");
		for (var i = 0; i < keywords.length; i++) {
			input_add.value = keywords[i];
			add_keywords();
		}
	}
}
function update_annex() {
	var div_news_annex = document.getElementById("div_news_annex");
	var news_annexs = $.trim(div_news_annex.innerHTML).split(";");
	if ($.trim(div_news_annex.innerHTML) != "null"
			&& $.trim(div_news_annex.innerHTML).length != 0) {
		for (var i = 0; i < news_annexs.length; i++) {
			// 总父容器
			var div_annex_box = document.getElementById("div_annex_box");
			// 创建input
			var input_annex = document.createElement("input");
			div_annex_box.appendChild(input_annex);
			input_annex.type = "file";
			input_annex.id = "input_annex_" + mark_annex;
			input_annex.style.display = "none";
			input_annex_change(news_annexs[i]);
		}
	}

}
