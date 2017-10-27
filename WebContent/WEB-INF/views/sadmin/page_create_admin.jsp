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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!---------------------------------------------------------------------------------------------------->
<script type="text/javascript"
	src="<%=basePath%>js/sadmin/page_create_admin.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/sadmin/page_update_admin.js"></script>
<script type="text/javascript" src="<%=basePath%>js/sadmin/save_admin.js"></script>
  <title>添加管理员</title>
</head>
  <body>
  <jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div id="main" style="margin: 0 0 0 260px; width: calc(100% - 260px);">
		<!-- 内容写在此处 -->
		<!-- 存储ID -->
		<span id="span_jsj_sadmin_admin_id" style="display: none;"><s:property
				value="adminDTO.admin.jsj_sadmin_admin_id" /></span>
		<!-- 存储操作，create、option -->
		<span id="span_option" style="display: none;"><s:property value="option" /></span>
				
		
		
		<!----------------------------------------------------------------------->
		<table style="width: 95%; margin: 40px auto 200px;" id="admin_table"
			class=" table-condensed table-bordered table-hover">
			<tr>
				<th>管理员账号：</th>
				<td><input type="text" class="form-control"
					value="<s:property value="adminDTO.admin.admin_account" />"
					id="input_admin_account" style="width: 800px;"></td>
			</tr>
			<s:if test="option==update">
			<tr>
				<th>管理员密码：</th>
				<td><input type="text" class="form-control"
					value="<s:property value="adminDTO.admin.admin_password" />"
					id="input_admin_password" style="width: 800px;"></td>
			</tr>
		</s:if>
			<tr>
				<th>管理员管理权限：</th>
				<td><select class="form-control" id="select_admin_premission_admin"
				value="<s:property value="adminDTO.admin.admin_premission_admin" />"
					style="width: auto; text-align: center;">
					<option>无权限</option>
					<option>管理权限</option>
				</select></td>
			</tr>
			<tr>
				<th>轮播图管理权限：</th>
				<td><select class="form-control" id="select_admin_premission_scarousel"
				value="adminDTO.admin.admin_premission_scarousel"
					style="width: auto; text-align: center;">
					
					<option>无权限</option>
					<option>管理权限</option>
				</select></td>
			</tr>
			<tr>
				<th>新闻管理权限：</th>
				<td><select class="form-control" id="select_admin_premission_snews"
				value="adminDTO.admin.admin_premission_snews"
					style="width: auto; text-align: center;">
					<option>无权限</option>
					<option>管理权限</option>
				</select></td>
			</tr>
			<tr>
				<th>链接管理权限：</th>
				<td><select class="form-control" id="select_admin_premission_slink"
				value="adminDTO.admin.admin_premission_slink"
					style="width: auto; text-align: center;">
					<option>无权限</option>
					<option>管理权限</option>
				</select></td>
			</tr>

			<tr>
				<th></th>
				<td>
					<button class="btn btn-primary" style="" onclick="adminlength()">保存</button>
<!-- 					<button class="btn btn-primary" style="background-color: #1abc9c;" -->
<!-- 						onclick="">还原更改</button> -->
				</td>
			</tr>

		</table>

	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->


	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
</body>
 <script>
	$.datetimepicker.setLocale('ch');
	$('#input_link_gmt_show').datetimepicker({
		yearStart : 2010, //设置最小年份
		yearEnd : 2050, //设置最大年份
		yearOffset : -20, //年偏差
		timepicker : true, //关闭时间选项
		format : 'Y-m-d H:i:s', //格式化日期年-月-日

		minDate : '1990/01/01', // 设置最小日期
		maxDate : '2030/01/01', // 设置最大日期
	});
</script>
<script type="text/javascript">
	var div_load = document.getElementById("div_load");
	var main = document.getElementById("main");
</script>
<script type="text/javascript">
	var E = window.wangEditor;
	var editor = new E('#content_toolbar', '#content_text');
</script>
<style type="text/css">
#link_table tr td {
	padding: 20px !important;
}

#link_table th {
	width: 120px !important;
}
</style>
</html>
