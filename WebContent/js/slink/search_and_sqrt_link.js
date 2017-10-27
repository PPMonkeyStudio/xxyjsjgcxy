window.onload = start_sqrt;
var sqrt;
var sqrt_sc;

function start_sqrt() {
	var span_sqrt = document.getElementById("span_sqrt");
	var span_sqrt_sc = document.getElementById("span_sqrt_sc");

	if (span_sqrt.innerHTML == "") {
		sqrt = "link_gmt_create";
		sqrt_sc = "asc";
	} else {

		sqrt = span_sqrt.innerHTML;
		sqrt_sc = span_sqrt_sc.innerHTML;
	}

}

function click_sqrt(click_div) {
	if (sqrt_sc == "desc") {
		sqrt_sc = "asc";
	} else {
		sqrt_sc = "desc";
	}
	sqrt = click_div.id;
	search_link();
}

function search_link() {
	//var select_publish = document.getElementById("select_publish");
	//var select_recommend = document.getElementById("select_recommend");
	//var select_news_category = document.getElementById("select_news_category");
	var input_name = document.getElementById("input_name");

	//var input_data_start = document.getElementById("input_data_start");
	//var input_data_end = document.getElementById("input_data_end");


//	if (input_data_start.value == "") {
//		input_data_start.value = "0000-00-00";
//	}
//	if (input_data_end.value == "") {
//		input_data_end.value = "9999-99-99";
//	}
//
//	if (input_data_start.value > input_data_end.value) {
//
//		toastr.warning("起始日期不可大于终止日期");
//
//		return;
//	}



	/*
	 * 
	 */
	/*
	 * 
	 */
	var url = "/xxyjsjgcxy/slink/link_page_list_link?page_list_link.pageIndex=1&searchLinkList.sqrt="
	+ sqrt
	+ "&searchLinkList.sqrt_sc="
	+ sqrt_sc
	
	
	
	
	+ "&searchLinkList.name="
	+ input_name.value;
	//+ "&searchLinkList.start_time="
	//+ input_data_start.value
	//+ "&searchLinkList.stop_time="
	//+ input_data_end.value;

	window.location = url;

}