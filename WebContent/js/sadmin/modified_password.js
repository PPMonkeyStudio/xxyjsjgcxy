function modifiedPassword(){

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				
				window.location = "/xxyjsjgcxy/sadmin/admin_page_list_admin?page=page_list_admin&page_list_admin.pageIndex=1";

			} else {
				toastr.error(xhr.status);
				stop_load();
			}
		}
	}
	formData = new FormData();
	var input_jsj_sadmin_admin_id = document
	.getElementById("input_jsj_sadmin_admin_id");
	var input_admin_password = document.getElementById("input_admin_password");
	formData.append("admin.jsj_sadmin_admin_id",
			span_jsj_sadmin_admin_id.innerHTML);
	formData.append("admin.admin_password", input_admin_password.value);
	/*
	 * 请求
	 */
	
		
		xhr.open("POST", "/xxyjsjgcxy/sadmin/admin_modifiedPassword");
	


	
	xhr.send(formData);
	start_load();
}