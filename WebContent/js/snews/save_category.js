function checkImg() {

	var input_category_img = document.getElementById("img").value;

	if (input_category_img == null || input_category_img == "") {
		return true;

	} else if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG|)$/.test(input_category_img)) {

		toastr.success("图片类型必须是.gif,jpeg,jpg,png中的一种");

		return false;
	}

}

function save_category() {

	if (checkImg()) {
	} else {
		return;
	}

	var input_category_name = document.getElementById("input_category_name");

	var select_category_rank = document.getElementById("select_category_rank");
	var input_category_sqrt = document.getElementById("input_category_sqrt");
	var checkbox_category_show = document
			.getElementById("checkbox_category_show");

	var select_category_father = document
			.getElementById("select_category_father");

	var input_category_Introduction = document
			.getElementById("input_category_Introduction");

	var input_category_img = document.getElementById("input_category_img");

	var select_category_news = document.getElementById("select_category_news");

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {

				if (xhr.responseText == "premission_none") {
					toastr.warning("无权限");
				} else if (JSON.parse(xhr.responseText) == 'success') {
					toastr.success(JSON.parse(xhr.responseText));
					window.location = "/xxyjsjgcxy/snews/category_page_list_category?page=page_list_category";
				} else {
					toastr.error(message);
				}

			} else {
				toastr.error(xhr.status);
			}
		}
	}

	xhr.open("POST", "/xxyjsjgcxy/snews/category_save_category");

	var formData = new FormData();

	formData.append("category.category_name", input_category_name.value);

	formData.append("category.category_Introduction",
			input_category_Introduction.value);

	formData.append("category.category_rank", select_category_rank.value);

	if (!isNaN(input_category_sqrt.value)) {
		formData.append("category.category_sqrt", input_category_sqrt.value);
	} else {
		toastr.warning("排序只能为数字");
		return;
	}

	if (checkbox_category_show.checked) {
		formData.append("category.category_show", 1);
	} else {
		formData.append("category.category_show", 0);
	}

	if (select_category_rank.value == '1') {
		formData.append("category.category_father", 0);
	} else {
		formData.append("category.category_father",
				select_category_father.value);
	}
	// input_category_img.files[0]
	// str="code="+input_category_img.files[0];

	formData.append("category.category_news", select_category_news.value);

	if (input_category_img.files[0] != null) {
		// 这里不是直接赋值给对象，这里给了文件类型的category_img
		formData.append("category_img", input_category_img.files[0]);
	}

	xhr.send(formData);

}

function getAllCategory() {

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {

				var json = JSON.parse(xhr.responseText);

				for ( var num in json) {

					var input_category_id = document
							.getElementById("input_category_id");

					if (json[num].jsj_snews_category_id != input_category_id.value) {
						var option = document.createElement("option");

						var select_category_father = document
								.getElementById("select_category_father");

						option.appendChild(document
								.createTextNode(json[num].category_name));

						select_category_father.appendChild(option);

						option.value = json[num].jsj_snews_category_id;

						var hidden_category_father = document
								.getElementById("hidden_category_father");

						if (hidden_category_father.value == json[num].jsj_snews_category_id) {
							option.selected = true;
						}
					}

				}

			} else {
				toastr.error(xhr.status);
			}
		}
	}

	xhr.open("POST", "/xxyjsjgcxy/snews/category_list_category_rankOne");

	xhr.send(null);

	// 初始化类别等级影响的父类别选项
	start_select_rank();

}

function update_category() {

	if (checkImg()) {

	} else {

		return;
	}

	var input_category_id = document.getElementById("input_category_id");

	var input_category_name = document.getElementById("input_category_name");

	var input_category_Introduction = document
			.getElementById("input_category_Introduction");

	var select_category_rank = document.getElementById("select_category_rank");
	var input_category_sqrt = document.getElementById("input_category_sqrt");
	var checkbox_category_show = document
			.getElementById("checkbox_category_show");

	var select_category_father = document
			.getElementById("select_category_father");

	var input_category_img = document.getElementById("input_category_img");

	var select_category_news = document.getElementById("select_category_news");

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {

				message = xhr.responseText;

				if (message == 'success') {
					toastr.success(message);

					window.location = "/xxyjsjgcxy/snews/category_page_list_category?page=page_list_category";
				} else if (xhr.responseText == "premission_none") {
					toastr.warning("无权限");
				} else {
					toastr.error(message);
				}

			} else {
				toastr.error(xhr.status);
			}
		}
	}

	xhr.open("POST", "/xxyjsjgcxy/snews/category_update_category");

	var formData = new FormData();
	formData.append("category.jsj_snews_category_id", input_category_id.value);
	formData.append("category.category_name", input_category_name.value);
	formData.append("category.category_Introduction",
			input_category_Introduction.value);
	formData.append("category.category_rank", select_category_rank.value);

	if (!isNaN(input_category_sqrt.value)) {
		formData.append("category.category_sqrt", input_category_sqrt.value);

	} else {
		toastr.warning("排序只能为数字");
		return;
	}

	if (checkbox_category_show.checked) {
		formData.append("category.category_show", 1);
	} else {
		formData.append("category.category_show", 0);
	}

	if (select_category_rank.value == '1') {
		formData.append("category.category_father", 0);
	} else {
		formData.append("category.category_father",
				select_category_father.value);
	}
	// input_category_img.files[0]
	// str="code="+input_category_img.files[0];

	formData.append("category.category_news", select_category_news.value);

	if (input_category_img.files[0] != null) {
		// 这里不是直接赋值给对象，这里给了文件类型的category_img
		formData.append("category_img", input_category_img.files[0]);
	}

	xhr.send(formData);

}
