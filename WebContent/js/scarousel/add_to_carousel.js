window.onload = function() {
	// 残留问题，当第二页的数据已经被删除时，再按下一页由于页面总数未及时更新会造成数据流失
	// 但是第二次按下一页，页面总数已经更新，不会造成错误
	var page = 1;// 当前页面
	var totalPage = 0;// 总页面数
	var xmlHttp;
	var xmlHttpCount;
	var xmlHttpQuery;
	var newsNumber = 0;
	var next = document.getElementById("nextPage");
	var last = document.getElementById("lastPage");
	var uploadButton = document.getElementById("upload");
	var query = document.getElementById("query");
	var ajaxQuery = document.getElementById("queryTitle");
	// 获得新闻分页
	onload_news("/xxyjsjgcxy/scarousel/scarousel_getNews?page=" + page);
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
			totalPage = result.pageCount;
			var length = result.pageBean.length;
			var currentPage= document.getElementById("currentPage");
			var pageCount  =document.getElementById("pageCount");
			currentPage.innerHTML="第 "+page+" 页";
			pageCount.innerHTML="共 "+totalPage+" 页";
			var tablec = document.getElementById("tableC");
			tablec.innerHTML = "<tr><th>编号</th><th>标题</th><th>大图</th><th>创建时间</th><th>是否选中</th></tr>";
			
			for (var i = 0; i < length; i++) {
				var tr = document.createElement("tr");
				var tdId = document.createElement("th");
				var tdTitle = document.createElement("th");
				var tdBimg = document.createElement("th");
				var tdTime = document.createElement("th");
				var tdChoose = document.createElement("th");
				tr.setAttribute("class", "table-bordered");
				tdTitle.setAttribute("class", "table-bordered");
				tdBimg.setAttribute("class", "table-bordered");		
				tdId.setAttribute("class", "table-bordered");
				tdTime.setAttribute("class", "table-bordered");
				tdChoose.setAttribute("class", "table-bordered");
				tdId.innerHTML = ++newsNumber;
				tdTitle.innerHTML = result.pageBean[i].news_title;

				if (result.pageBean[i].news_bimg != "default.jpg") {
					tdBimg.innerHTML = "✔";
				} else {
					tdBimg.innerHTML = "<span style='color: #ff5063;'>✘</span>";
				}	
				//
				tdTime.innerHTML = result.pageBean[i].news_gmt_create;
				tdChoose.innerHTML = "<button class='btn btn-primary' onclick='uploadNews(this)' value="+result.pageBean[i].jsj_snews_news_id+">上传</button>";
				tr.appendChild(tdId);
				tr.appendChild(tdTitle);
				tr.appendChild(tdBimg)				
				tr.appendChild(tdTime);
				tr.appendChild(tdChoose);
				tablec.appendChild(tr);
				// 路径中有/则从根目录下寻找没有则从当前目录寻找
			}

		}

		// 上传ajax
	
	//查询
		
	ajaxQuery.oninput=function()
	{
		
		page=0;
		if(document.getElementById("queryTitle").value.replace(/(^\s*)|(\s*$)/g, "") ==""||document.getElementById("queryTitle").value.replace(/(^\s*)|(\s*$)/g, "")==null)
			{
			newsNumber=0;
			onload_news("/xxyjsjgcxy/scarousel/scarousel_getNews?page=" + page);
		}
		else
		{
			queryNews("/xxyjsjgcxy/scarousel/scarousel_queryTitle");
		}
	}
		
		
	query.onclick=function(){
				queryNews("/xxyjsjgcxy/scarousel/scarousel_queryTitle");
				page=0;
		}
	function queryNews(url) {
		if (window.XMLHttpRequest) {
			// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlHttpQuery = new XMLHttpRequest();
		} else {
			// IE6, IE5 浏览器执行代码
			xmlHttpQuery = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlHttpQuery.open("POST", url, true);
		xmlHttpQuery.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		var queryTitle = document.getElementById("queryTitle");
		var title  = queryTitle.value;
		var data = "title="+title;
		xmlHttpQuery.send(data);
		xmlHttpQuery.onreadystatechange = httpBackQuery;
	}
	
	function httpBackQuery()
	{
		newsNumber=0;
		if (xmlHttpQuery.readyState == 4 && xmlHttpQuery.status == 200) {
			var result  = xmlHttpQuery.responseText;
			result = JSON.parse(result);
			var length = result.length;
			var tablec = document.getElementById("tableC");
			tablec.innerHTML = "<tr><th>编号</th><th>标题</th><th>大图</th><th>创建时间</th><th>是否选中</th></tr>";	
			for (var i = 0; i < length; i++) {
				var tr = document.createElement("tr");
				var tdId = document.createElement("th");
				var tdTitle = document.createElement("th");
				var tdBimg = document.createElement("th");
				var tdTime = document.createElement("th");
				var tdChoose = document.createElement("th");
				tr.setAttribute("class", "table-bordered");
				tdTitle.setAttribute("class", "table-bordered");
				tdBimg.setAttribute("class", "table-bordered");		
				tdId.setAttribute("class", "table-bordered");
				tdTime.setAttribute("class", "table-bordered");
				tdChoose.setAttribute("class", "table-bordered");
				tdId.innerHTML = ++newsNumber;
				tdTitle.innerHTML = result[i].news_title;
				if (result[i].news_bimg != "default.jpg") {
					tdBimg.innerHTML = "✔";
				} else {
					tdBimg.innerHTML = "<span style='color: #ff5063;'>✘</span>";
				}	
				tdTime.innerHTML = result[i].news_gmt_create;
				tdChoose.innerHTML = "<button class='btn btn-primary' onclick='uploadNews(this)' value="+result[i].jsj_snews_news_id+">上传</button>";
				tr.appendChild(tdId);
				tr.appendChild(tdTitle);
				tr.appendChild(tdBimg)				
				tr.appendChild(tdTime);
				tr.appendChild(tdChoose);
				tablec.appendChild(tr);
			}
		
				// 路径中有/则从根目录下寻找没有则从当前目录寻找		
		}
	}
	
	
	// 下一页js
	next.onclick = function() {

		if (page >= totalPage) {
			page = totalPage;
			toastr.warning("已经是最后一页");
		} else {
			page++;
			newsNumber = 0;
			onload_news("/xxyjsjgcxy/scarousel/scarousel_getNews?page=" + page);
		}
	}
	// 上一页js
	last.onclick = function() {

		if (page <= 1) {
			page = 1;
			toastr.warning("已经是第一页");
		} else {
			page--;
			newsNumber = 0;
			onload_news("/xxyjsjgcxy/scarousel/scarousel_getNews?page=" + page);
		}
	}
}
}
var httpUpload;
var chooseOne;
function uploadNews(even) {
	chooseOne = even.value;
	addToCarousel("/xxyjsjgcxy/scarousel/scarousel_addToCarousel");
}
function addToCarousel(url) {
	var checkbox = document.getElementsByName("choose");

	var judgeNumber = 0;
	
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		httpUpload = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		httpUpload = new ActiveXObject("Microsoft.XMLHTTP");
	}
	httpUpload.open("POST", url, true);
	httpUpload.setRequestHeader('Content-Type',
			'application/x-www-form-urlencoded');
	var data = "img_group=" + document.getElementById("number").value
			+ "&img_news=" + chooseOne;
	httpUpload.send(data);
	httpUpload.onreadystatechange = httpAddBack;
}
function httpAddBack() {
	if (httpUpload.readyState == 4 && httpUpload.status == 200) {
		var result = httpUpload.responseText;
		toastr.warning(result);
	}
}
window.onunload=function()
{
	alert("dsa");
}

