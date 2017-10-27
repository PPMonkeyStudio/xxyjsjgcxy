var delete_link_id;

function delete_admin() {

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				message = xhr.responseText;

				toastr.success("删除成功");

				window.location = "/xxyjsjgcxy/sadmin/admin_page_list_admin?page=page_list_admin&page_list_admin.pageIndex=1";

			} else {
				toastr.error(xhr.status);
				stop_load();
			}
		}
	}

	var formData = new FormData();

	formData.append("admin.jsj_sadmin_admin_id", delete_admin_id);

	xhr.open("POST", "/xxyjsjgcxy/sadmin/admin_deleteAdmin");

	xhr.send(formData);

	start_load();

	$('#model_delete_admin').modal('hide');
}