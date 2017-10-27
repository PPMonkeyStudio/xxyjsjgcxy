function saveLink() {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				window.location = "/xxyjsjgcxy/slink/link_page_list_link?page=page_list_link&page_list_link.pageIndex=1";

			} else {
				toastr.error(xhr.status);
				stop_load();
			}
		}
	}
	var input_jsj_slink_link_id = document
			.getElementById("input_jsj_slink_link_id");
	var input_link_url = document.getElementById("input_link_url");
	var input_link_name = document.getElementById("input_link_name");
	
	
	
	//var input_link_gmt_show = document.getElementById("input_link_gmt_show");

	var formData = new FormData();

	/*
	 * ID、链接URL、链接名
	 */

	formData.append("link.jsj_slink_link_id", span_jsj_slink_link_id.innerHTML);
	
	formData.append("link.link_url", input_link_url.value);
	formData.append("link.link_name", input_link_name.value);

	
	
	
	
	

	/*
	 * 发送请求
	 */
	if (span_option.innerHTML == 'update') {
		xhr.open("POST", "/xxyjsjgcxy/slink/link_updateLink");
	} else {
		xhr.open("POST", "/xxyjsjgcxy/slink/link_saveLink");
	}
	xhr.send(formData);
	start_load();
}