var delete_category_id;

function delete_category() {

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				message = xhr.responseText;

				toastr.success("删除成功");

				window.location = "/xxyjsjgcxy/snews/category_page_list_category?page=page_list_category";
			} else {
				toastr.error(xhr.status);
			}
		}
	}

	var formData = new FormData();

	formData.append("category.jsj_snews_category_id", delete_category_id);

	xhr.open("POST", "/xxyjsjgcxy/snews/category_delete_category");

	xhr.send(formData);

}