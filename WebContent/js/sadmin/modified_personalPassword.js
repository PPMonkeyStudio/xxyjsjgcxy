function modified(){
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message = null;
		if (xhr.readyState == 4) {
			
			if (xhr.status == 200) {
				message = xhr.responseText;
				if (message == '1') {
					toastr.success("修改成功");
					modifiedpersonalPassword();
				} else if (message == '0') {
					toastr.error("原密码输入错误");
				}
				//window.location = "/pxxyca/sadmin/admin_page_list_admin?page=page_list_admin&page_list_admin.pageIndex=1";
				//window.location.href="/pxxyca/navbar.jsp";
			} else {
				toastr.error(xhr.status);
				stop_load();
			}
		}
	}
	formData = new FormData();
	var input_jsj_sadmin_admin_id = document
	.getElementById("input_jsj_sadmin_admin_id");
	var input_admin_account = document.getElementById("input_admin_account");
	var input_admin_oldpassword = document.getElementById("input_admin_oldpassword");
	//var input_admin_password = document.getElementById("input_admin_password");
	formData.append("admin.jsj_sadmin_admin_id",
			span_jsj_sadmin_admin_id.innerHTML);
	formData.append("admin.admin_password", input_admin_oldpassword.value);
	formData.append("admin.admin_account", input_admin_account.value);
	//formData.append("admin.admin_password", input_admin_password.value);
	/*
	 * 请求
	 */
		
		xhr.open("POST", "/xxyjsjgcxy/sadmin/admin_modifiedpersonalPassword");
	
	xhr.send(formData);
	//start_load();
}

function modifiedpersonalPassword(){
	
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message = null;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				message = xhr.responseText;
				//window.location = "/pxxyca/sadmin/admin_page_list_admin?page=page_list_admin&page_list_admin.pageIndex=1";
				window.location.href="/xxyjsjgcxy/navbar.jsp";
			} else {
				toastr.error(xhr.status);
				stop_load();
			}
		}
	}
	formData = new FormData();
	var input_jsj_sadmin_admin_id = document
	.getElementById("input_jsj_sadmin_admin_id");
	var input_admin_account = document.getElementById("input_admin_account");
	//var input_admin_oldpassword = document.getElementById("input_admin_oldpassword");
	var input_admin_password = document.getElementById("input_admin_password");
	formData.append("admin.jsj_sadmin_admin_id",
			span_jsj_sadmin_admin_id.innerHTML);
	//formData.append("admin.admin_password", input_admin_oldpassword.value);
	formData.append("admin.admin_account", input_admin_account.value);
	formData.append("admin.admin_password", input_admin_password.value);
	/*
	 * 请求
	 */
		
		xhr.open("POST", "/xxyjsjgcxy/sadmin/admin_modified");

	xhr.send(formData);
	start_load();
}