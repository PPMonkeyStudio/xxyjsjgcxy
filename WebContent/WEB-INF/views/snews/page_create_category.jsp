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
	src="<%=basePath%>js/snews/save_category.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/snews/getNewsCategory.js"></script>
<!---------------------------------------------------------------------------------------------------->
<title>创建类别</title>

</head>
<body>
	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div style="margin: 0 0 0 260px; width: calc(100% - 260px);">
		<!-- 内容写在此处 -->
		<span id="span_category_news" style="display: none;"><s:property
				value="category.category_news" /></span>
		<!--  -->
		<table style="width: 95%; margin: 40px auto 0;"
			class=" table-condensed table-bordered table-hover">
			<input type="hidden" id="input_category_id"
				value="<s:property
							value="category.jsj_snews_category_id" />">
			<tr>
				<th>类别名称：</th>
				<td><input type="text" class="form-control"
					<s:if test="category.category_name != null">value="<s:property
							value="category.category_name" />"</s:if>
					id="input_category_name" style="width: 500px;"></td>
			</tr>
			<tr>
				<th>是否显示：</th>
				<td><s:if test="category.category_show == '0'.toString()">
						<input type="checkbox" id="checkbox_category_show">
					</s:if> <s:else>
						<input type="checkbox" id="checkbox_category_show"
							checked="checked">
					</s:else></td>
			</tr>
			<tr>
				<th>类别排序：</th>
				<td><input type="text" class="form-control"
					<s:if test="category.category_sqrt != null">value="<s:property
							value="category.category_sqrt" />"</s:if>
					id="input_category_sqrt" style="width: 100px;"></td>
			</tr>
			<tr>
				<th>类别等级：</th>
				<td><select class="selectpicker" data-live-search="false"
					id="select_category_rank" onchange="select_rank_onchange()">
						<option value="1"
							<s:if test="category.category_rank == '1'.toString()">
							selected="selected"
						</s:if>>一级类别</option>
						<option value="2"
							<s:if test="category.category_rank == '2'.toString()">
							selected="selected"
						</s:if>>二级类别</option>
				</select></td>
			</tr>

			<tr>
				<th>父类别：</th>
				<td><select id="select_category_father" class="form-control"
					style="width: auto; text-align: center;">

				</select>
					<div id="null_father">无</div></td>
				<!-- 隐藏域 -->


				<input type="hidden" id="hidden_category_father"
					value="<s:property value="category.category_father" />" />
			</tr>
			<tr>
				<th>指定图片：</th>
				<td><img id="img"
					src="<%=basePath%>snews/img_getNewsCategoryImg?imgName=<s:property value="category.category_img" />"
					onclick="img_click()" style="height: 200px; width: 200px;" /> <input
					id="input_category_img" type="file" onchange="img_change(this)"
					accept="image/*" style="display: none;" /></td>
			</tr>
			<tr>
				<th>类别简介：</th>
				<td><input type="text" class="form-control"
					<s:if test="category.category_Introduction != null">value="<s:property
							value="category.category_Introduction" />"</s:if>
					id="input_category_Introduction" style="width: 500px;"></td>
			</tr>
			<tr>
				<th>指定新闻：</th>
				<td><select class="selectpicker" data-live-search="true"
					id="select_category_news" title="选择指定新闻">
						<option value="">无</option>
				</select></td>
			</tr>
			<tr>
				<th></th>
				<td><s:if test="option == 'update'">
						<button class="btn btn-primary" onclick="update_category()">保存</button>
					</s:if> <s:else>
						<button class="btn btn-primary" onclick="save_category()">保存</button>
					</s:else></td>
			</tr>

		</table>

	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
</body>
<script type="text/javascript">
	/*上传图片的JS*/

	function img_click() {
		document.getElementById("input_category_img").click();
	}

	function img_change(file) {
		var img = document.getElementById("img");
		var reader = new FileReader();
		reader.onload = function(evt) {
			img.src = evt.target.result;
		}

		reader.readAsDataURL(file.files[0]);
	}
</script>
<script type="text/javascript">
	window.onload = getAllCategory;
</script>

<script type="text/javascript">
	/*相应类别等级的改变*/

	function start_select_rank() {

		var select_category_rank = document
				.getElementById("select_category_rank");
		var select_category_father = document
				.getElementById("select_category_father");
		var null_father = document.getElementById("null_father");

		if (select_category_rank.value == '1') {
			select_category_father.style.display = "none";
			null_father.style.display = "block";
		} else {
			select_category_father.style.display = "block";
			null_father.style.display = "none";
		}
	}

	function select_rank_onchange() {

		var select_category_rank = document
				.getElementById("select_category_rank");
		var select_category_father = document
				.getElementById("select_category_father");
		var null_father = document.getElementById("null_father");

		if (select_category_rank.value == '1') {
			select_category_father.style.display = "none";
			null_father.style.display = "block";
		} else {
			select_category_father.style.display = "block";
			null_father.style.display = "none";
		}

	}
</script>
<script type="text/javascript">
	var select_category_news = document.getElementById("select_category_news");

	getNews(select_category_news);
</script>
</html>