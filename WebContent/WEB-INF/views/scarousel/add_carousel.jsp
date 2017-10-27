<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>增加轮播图</title>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-select.min.css">
<script type="text/javascript"
	src="<%=basePath%>js/scarousel/add_to_carousel.js"></script>
</head>
<body>
	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<div
		style="margin: 50px 0 0 260px; width: calc(100% - 260px); padding: 0 20px;">
		<%-- 	<a href="<%=basePath %>scarousel/skip_Query"><button class="btn btn-success" style="position: relative; left: 100px;">查询轮播</button></a> --%>
		<%-- 	<a href="<%=basePath %>scarousel/skip_Delete"><button class="btn btn-success" style="position: relative; left: 150px;">删除轮播</button></a> --%>
		<%-- 	<a href="<%=basePath %>scarousel/skip_Add"><button class="btn btn-success" style="position: relative; left: 200px;">增加轮播</button></a> --%>
		<!-- 		<table style="width: 95%; margin: 40px auto 0;" -->
		<!-- 			class="table-condensed table-bordered table-hover"> -->
		<!-- 			<tr> -->
		<!-- 				tr为行标签一个tr中可以定义多个单元格  -->
		<!-- 				th td 为单元格 -->
		<!-- 				<th style="width: 200px;">轮播图所属组：</th> -->
		<%-- 				<td><select id="number"> --%>
		<!-- 						<option value="大图">大图</option> -->
		<!-- 						<option value="小图">小图</option> -->
		<%-- 				</select></td> --%>
		<!-- 			</tr> -->
		<!-- 		</table> -->

		<div style="width: 100%; float: right; margin: 0 15% 20px 0;">
			<div style="float: right; width: 220px;">
				<select class="selectpicker" id="number">
					<option value="大图">大图组</option>
					<option value="小图">小图组</option>
				</select>
			</div>
			<div style="float: right; margin-right: 130px;"> 
				<input id="query" type="button" value="搜索" class="btn btn-primary">
			</div>
			<div style="float: right; margin-right: 30px;">
				<input type="text" id="queryTitle" class="form-control" style="width: 300px;"  placeholder="请输入新闻标题">
			</div>
		</div>

		<table id="tableC"
			style="width: 70%; margin: 0 auto; text-align: center;"
			class="table-condensed table-bordered table-hover">
		</table>
		<div style="margin: 20px auto; width: 400px; text-align: center;">
			<button class="btn btn-primary" style="" id="lastPage">上一页</button>
			<button class="btn btn-primary" style="" id="nextPage">下一页</button>
		</div>
		<div id="currentPage" style="text-align: center;">
			第 1 页	
		</div>
		<div id="pageCount" style="text-align: center;">
			共 n 页
		</div>
		

	</div>
</body>
<style type="text/css">
#tableC tr th {
	padding: 10px !important;
}
</style>
</html>