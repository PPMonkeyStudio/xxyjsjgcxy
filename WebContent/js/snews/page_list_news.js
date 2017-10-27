var delete_news_id;

function delete_news() {

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				message = xhr.responseText;

				toastr.success("删除成功");

				window.location = "/xxyjsjgcxy/snews/news_page_list_news?page=page_list_news&page_list_news.pageIndex=1";

			} else {
				toastr.error(xhr.status);
				stop_load();
			}
		}
	}

	var formData = new FormData();

	formData.append("news.jsj_snews_news_id", delete_news_id);

	xhr.open("POST", "/xxyjsjgcxy/snews/news_deleteNews");

	xhr.send(formData);

	start_load();

	$('#model_delete_news').modal('hide');
}