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
<script type="text/javascript"  src="<%=basePath%>js/sadmin/modified_password.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/sadmin/page_update_admin.js"></script>
<script type="text/javascript" src="<%=basePath%>js/sadmin/save_admin.js"></script>
<script type="text/javascript" src="<%=basePath%>js/sadmin/modified_personalPassword.js"></script>
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
				value="#session.Admin.jsj_sadmin_admin_id" /></span>
		<!-- 存储操作，create、option -->
		<span id="span_option" style="display: none;"><s:property value="option" /></span>
				
		
		
		<!----------------------------------------------------------------------->
		<table style="width: 95%; margin: 40px auto 200px;" id="admin_table"
			class=" table-condensed table-bordered table-hover">
             
             <tr>
				<th>管理员账号：</th>
				<td><input disabled="disabled" type="text" class="form-control"
					value="<s:property value="#session.Admin.admin_account" />"
					id="input_admin_account" style="width: 800px;"></td>
			</tr>
			<tr>
				<th>管理员原密码：</th>
				<td><input type="text" class="form-control"
                 	    id="input_admin_oldpassword" style="width: 800px;"></td>
			</tr>
			<tr>
				<th>管理员新密码：</th>
				<td><input type="text" class="form-control"
                 	    id="input_admin_password" style="width: 800px;"></td>
			</tr>
			<tr>
				<th></th>
				<td>
					<button class="btn btn-primary" style="" onclick="modified()">保存</button>
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
