var delete_link_id;

function delete_link() {

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				message = xhr.responseText;

				toastr.success("删除成功");

				window.location = "/xxyjsjgcxy/slink/link_page_list_link?page=page_list_link&page_list_link.pageIndex=1";

			} else {
				toastr.error(xhr.status);
				stop_load();
			}
		}
	}

	var formData = new FormData();

	formData.append("link.jsj_slink_link_id", delete_link_id);

	xhr.open("POST", "/xxyjsjgcxy/slink/link_deleteLink");

	xhr.send(formData);

	start_load();

	$('#model_delete_link').modal('hide');
}