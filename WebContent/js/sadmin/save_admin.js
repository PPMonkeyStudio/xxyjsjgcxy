var formData = false;
function formDataj() {
	formData = new FormData();
	var input_jsj_sadmin_admin_id = document
			.getElementById("input_jsj_sadmin_admin_id");
	var input_admin_account = document.getElementById("input_admin_account");
	var input_admin_password = document.getElementById("input_admin_password");
	var select_admin_premission_admin = document
			.getElementById("select_admin_premission_admin");
	var select_admin_premission_scarousel = document
			.getElementById("select_admin_premission_scarousel");
	var select_admin_premission_snews = document
			.getElementById("select_admin_premission_snews");
	var select_admin_premission_slink = document
			.getElementById("select_admin_premission_slink");

	/*
	 * ID、管理员账号、管理员密码、权限
	 */

	formData.append("admin.jsj_sadmin_admin_id",
			span_jsj_sadmin_admin_id.innerHTML);
	formData.append("admin.admin_account", input_admin_account.value);
	formData.append("admin.admin_password", input_admin_password.value);
	formData.append("admin.admin_premission_admin",
			select_admin_premission_admin.value);
	formData.append("admin.admin_premission_scarousel",
			select_admin_premission_scarousel.value);
	formData.append("admin.admin_premission_snews",
			select_admin_premission_snews.value);
	formData.append("admin.admin_premission_slink",
			select_admin_premission_slink.value);

}
function formDataf() {
	formData = new FormData();
	var input_jsj_sadmin_admin_id = document
			.getElementById("input_jsj_sadmin_admin_id");
	var input_admin_account = document.getElementById("input_admin_account");

	var select_admin_premission_admin = document
			.getElementById("select_admin_premission_admin");
	var select_admin_premission_scarousel = document
			.getElementById("select_admin_premission_scarousel");
	var select_admin_premission_snews = document
			.getElementById("select_admin_premission_snews");
	var select_admin_premission_slink = document
			.getElementById("select_admin_premission_slink");

	/*
	 * ID、管理员账号、管理员密码、权限
	 */

	formData.append("admin.jsj_sadmin_admin_id",
			span_jsj_sadmin_admin_id.innerHTML);
	formData.append("admin.admin_account", input_admin_account.value);

	formData.append("admin.admin_premission_admin",
			select_admin_premission_admin.value);
	formData.append("admin.admin_premission_scarousel",
			select_admin_premission_scarousel.value);
	formData.append("admin.admin_premission_snews",
			select_admin_premission_snews.value);
	formData.append("admin.admin_premission_slink",
			select_admin_premission_slink.value);

}
function adminlength() {
	var input_admin_account = document.getElementById("input_admin_account");
	// 只简单的判断用户名的长度
	// var input_admin_password =
	// document.getElementById("input_admin_password");
	var username = input_admin_account.value;
	// var password=input_admin_password.value;
	if (username.length <= 0) {
		toastr.error("用户名不能为空");
		return false;
	}
	if (username.length > 10) {
		toastr.error("输入的用户名过长");
		// document.getElementById(input_admin_account.name).innerHTML =
		// "输入的用户名过长";
		return false;
	}
	// if(password.length<=0){
	// toastr.error("密码不能为空");
	// return false;
	// }
	// if(password.length > 50)
	// {
	// toastr.error("输入的密码过长");
	// // document.getElementById(input_admin_account.name).innerHTML =
	// "输入的用户名过长";
	// return false;
	// }

	addAdmin();
	return true;

}
function addAdmin() {

	var xhr = false;
	xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		var message = null;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				message = xhr.responseText;
				if (message == '1') {
					toastr.success("创建成功");
					saveAdmin();
				} else if (message == '0') {
					toastr.warning("账号不可重复");
				}
				// window.location =
				// "/pxxyca/sadmin/admin_page_list_admin?page=page_list_admin&page_list_admin.pageIndex=1";
			} else {
				toastr.error(xhr.status);
				stop_load();
			}
		}
	}

	if (span_option.innerHTML == 'update') {
		formDataf();
		xhr.open("POST", "/xxyjsjgcxy/sadmin/admin_updateAdmin");
	} else {
		formDataj();
		xhr.open("POST", "/xxyjsjgcxy/sadmin/admin_saveAdmin");
	}
	xhr.send(formData);
}

function saveAdmin() {

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

	/*
	 * 发送请求
	 */
	if (span_option.innerHTML == 'update') {
		formDataf();
		xhr.open("POST", "/xxyjsjgcxy/sadmin/admin_updateAdmin");
	} else {
		formDataj();
		xhr.open("POST", "/xxyjsjgcxy/sadmin/admin_saveAdmin");

	}
	xhr.send(formData);
	start_load();
}