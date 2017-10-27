<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();//当前项目目录
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>删除轮播图</title>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-select.min.css">
<link rel="stylesheet" href="<%=basePath%>css/scarousel/normalize.css">
<link rel="stylesheet" href="<%=basePath%>css/scarousel/style.css">
<script type="text/javascript"
	src="<%=basePath%>js/scarousel/delete_carousel.js"></script>
</head>
<body>
	<!-- /前代表网站的根地址即域名 -->
	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<div
		style="margin: 50px 0 0 260px; width: calc(100% - 260px); padding: 0 20px;">
		<!-- 内容写在此处 -->
		<%-- 		<a href="<%=basePath%>scarousel/skip_Query"><button --%>
		<!-- 				class="btn btn-success" style="position: relative; left: 100px;">查询轮播</button></a> -->
		<%-- 		<a href="<%=basePath%>scarousel/skip_Delete"><button --%>
		<!-- 				class="btn btn-success" style="position: relative; left: 150px;">删除轮播</button></a> -->
		<%-- 		<a href="<%=basePath%>scarousel/skip_Add"><button --%>
		<!-- 				class="btn btn-success" style="position: relative; left: 200px;">增加轮播</button></a> -->



		<div style="width: 100%; float: right; margin: 0 15% 20px 0;">

			<div style="float: right; width: 220px;">
				<select class="selectpicker" id="queryByGroup">
					<option value="all">所有组</option>
					<option value="大图">大图组</option>
					<option value="小图">小图组</option>
				</select>
			</div>
		</div>





		<!--  -->
		<table id="tableC"
			style="width: 70%; margin: 0 auto; text-align: center;"
			class="table-condensed table-bordered table-hover">
			<tr>
				<th>编号</th>
				<th>标题</th>
				<th>作者</th>
				<th>是否选中</th>
			</tr>
		</table>
		<!--  -->
		<button class="btn btn-danger"
			style="float: right; margin: 20px 15% 0 0;" id="delete"
			onclick="deleteCarousel()">删除轮播</button>
		<!--  -->
		<div style="margin: 20px auto; width: 400px; text-align: center;">
			<button class="btn btn-primary" style="" id="lastPage">上一页</button>
			<button class="btn btn-primary" style="" id="indexPage">首页</button>
			<button class="btn btn-primary" style="" id="nextPage">下一页</button>
		</div>


	</div>
</body>
<script>
	// 	$('select').selectpicker('refresh');
</script>
<style type="text/css">
#tableC tr th {
	padding: 10px !important;
}
</style>
</html>