window.onload = function() {
	// 残留问题，当第二页的数据已经被删除时，再按下一页由于页面总数未及时更新会造成数据流失(此分页方案无法解决)
	// 但是第二次按下一页，页面总数已经更新，不会造成错误
	var page = 1;
	var totalPage = 0;
	var imgNumber = 0;
	var xmlHttpCount;
	var xmlHttp;
	var next = document.getElementById("nextPage");
	var last = document.getElementById("lastPage");
	var queryType = "all";
	// var query = document.getElementById("query");
	var index = document.getElementById("indexPage");
	// 获得新闻分页
	onload_news("/xxyjsjgcxy/scarousel/scarousel_getCarouselImg?page=" + page
			+ "&queryType=" + queryType);
	function onload_news(url) {
		if (window.XMLHttpRequest) {
			// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlHttp = new XMLHttpRequest();
		} else {
			// IE6, IE5 浏览器执行代码
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlHttp.open("GET", url, true);
		xmlHttp.send();
		xmlHttp.onreadystatechange = httpBackNews;
	}
	function httpBackNews() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			var result = xmlHttp.responseText;
			result = JSON.parse(result);
			var length = result.pageBean.length;
			totalPage = result.pageCount;
			var tablec = document.getElementById("tableC");
			tablec.innerHTML = "<tr><th>编号</th><th>新闻</th><th>所属图组</th><th>添加时间</th><th>是否选中</th></tr>";
			for (var i = 0; i < length; i++) {
				var tr = document.createElement("tr");
				var tdId = document.createElement("th");
				var tdTitle = document.createElement("th");
				var tdAuthor = document.createElement("th");
				var tdTime = document.createElement("th");
				var tdChoose = document.createElement("th");
				tr.setAttribute("class", "table-bordered");
				tdTitle.setAttribute("class", "table-bordered");
				tdId.setAttribute("class", "table-bordered");
				tdAuthor.setAttribute("class", "table-bordered");
				tdChoose.setAttribute("class", "table-bordered");

				tdId.innerHTML = ++imgNumber;
				tdTitle.innerHTML = result.pageBean[i].img_news;
				tdTime.innerHTML = result.pageBean[i].img_gmt_create;
				tdChoose.innerHTML = "<input  name='choose' type='checkbox' value='"
						+ result.pageBean[i].jsj_scarousel_img_id + "'>";
				tdAuthor.innerHTML = result.pageBean[i].img_group;
				tr.appendChild(tdId);
				tr.appendChild(tdTitle);
				tr.appendChild(tdAuthor);
				tr.appendChild(tdTime);
				tr.appendChild(tdChoose);
				tablec.appendChild(tr);
				// 路径中有/则从根目录下寻找没有则从当前目录寻找

				
			}
		}
	}
	// ---------------------------------------------------------下一页js-----------------------------------------------------------
	next.onclick = function() {
		// 取大于等于的原因：当页面总数因为数据被删除动态更新了，当前页面将大于页面总数的情况
		if (page >= totalPage) {
			page = totalPage;
			toastr.warning("已经是最后一页");
		} else {
			page++;
			imgNumber = 0;
			onload_news("/xxyjsjgcxy/scarousel/scarousel_getCarouselImg?page="
					+ page + "&queryType=" + queryType);
		}
	}
	// ------------------------------------------上一页js-----------------------------------------------------------
	last.onclick = function() {

		if (page <= 1) {
			page = 1;
			toastr.warning("已经是第一页");
		} else {
			page--;
			imgNumber = 0;
			onload_news("/xxyjsjgcxy/scarousel/scarousel_getCarouselImg?page="
					+ page + "&queryType=" + queryType);
		}

	}

	// -------------------------------------查找js-------------------------------------------------------------------0

	var query = document.getElementById("queryByGroup");

	query.onchange = function() {
		// page设为1
		imgNumber = 0;
		var selectType = document.getElementById("queryByGroup");
		queryType = selectType.value;
		page = 1;
		onload_news("/xxyjsjgcxy/scarousel/scarousel_getCarouselImg?page="
				+ page + "&queryType=" + queryType);
	}

	index.onclick = function() {
		if (page == 1) {
			toastr.warning("已经是首页");
		} else {
			imgNumber = 0;
			page = 1;
			onload_news("/xxyjsjgcxy/scarousel/scarousel_getCarouselImg?page="
					+ page + "&queryType=" + queryType);
		}
	}
}

// -------------------------------------删除js----------------------------------------------------------------------
var httpDelete;
function deleteCarousel() {
	deleteCarouselToAction("/xxyjsjgcxy/scarousel/scarousel_deleteCarousel");
}

function deleteCarouselToAction(url) {

	var formdata = new FormData();
	var chooseAll = document.getElementsByName("choose");
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		httpDelete = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		httpDelete = new ActiveXObject("Microsoft.XMLHTTP");
	}
	for (var i = 0; i < chooseAll.length; i++) {
		if (chooseAll[i].checked) {
			formdata.append("jsj_scarousel_img_id", chooseAll[i].value);
		}
	}
	httpDelete.open("POST", url, true);
	httpDelete.send(formdata);
	httpDelete.onreadystatechange = delelteCarouselBack;
}
function delelteCarouselBack() {
	// state状态 状况 status身份
	if (httpDelete.readyState == 4 && httpDelete.status == 200) {
		var result = httpDelete.responseText;
		window.location.href = "/xxyjsjgcxy/scarousel/skip_Delete";
	}
}