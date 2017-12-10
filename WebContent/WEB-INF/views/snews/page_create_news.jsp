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
	src="<%=basePath%>js/snews/page_create_news.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/snews/page_update_news.js"></script>
<script type="text/javascript" src="<%=basePath%>js/snews/save_news.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/snews/pageCreateNews_annex.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/snews/getNewsCategory.js"></script>
<!---------------------------------------------------------------------------------------------------->
<script type="text/javascript" src="<%=basePath%>js/wangEditor.js"></script>
<!---------------------------------------------------------------------------------------------------->
<title>创建新闻</title>
</head>
<body>
	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div id="main" style="margin: 0 0 0 260px; width: calc(100% - 260px);">
		<!-- 内容写在此处 -->
		<!-- 存储ID -->
		<span id="span_jsj_snews_news_id" style="display: none;"><s:property
				value="newsAndCategoryAndContentDTO.news.jsj_snews_news_id" /></span>
		<!-- 存储操作，create、option -->
		<span id="span_option" style="display: none;"><s:property
				value="option" /></span>
		<!-- 存储新闻类别 -->
		<span id="span_news_category" style="display: none;"><s:property
				value="newsAndCategoryAndContentDTO.news.news_category" /></span>
		<!-- 存储附件-->
		<div id="div_news_annex" style="display: none;">
			<s:property value="newsAndCategoryAndContentDTO.news.news_annex" />
		</div>
		<!-- 存储已有附件数量-->
		<span id="span_news_num_annex" style="display: none;"><s:property
				value="newsAndCategoryAndContentDTO.news.news_num_annex" /></span>
		<!----------------------------------------------------------------------->
		<table style="width: 95%; margin: 40px auto 200px;" id="news_table"
			class=" table-condensed table-bordered table-hover">
			<tr>
				<th>新闻标题：</th>
				<td><input type="text" class="form-control"
					value="<s:property value="newsAndCategoryAndContentDTO.news.news_title" />"
					id="input_news_title" style="width: 800px;"></td>
			</tr>
			<tr>
				<th>所属类别：</th>
				<td><select class="selectpicker" data-live-search="true"
					title="选择类别" id="select_news_category"
					style="width: auto; text-align: center;">
				</select></td>
			</tr>
			<tr>
				<th>要闻推荐：</th>
				<td><s:if
						test="newsAndCategoryAndContentDTO.news.news_recommend == '0'.toString()">
						<input type="checkbox" id="checkbox_news_recommend">
					</s:if> <s:else>
						<input type="checkbox" id="checkbox_news_recommend"
							checked="checked">
					</s:else></td>
			</tr>
			<tr>
				<th>发布：</th>
				<td><s:if
						test="newsAndCategoryAndContentDTO.news.news_publish  == '0'.toString()">
						<input type="checkbox" id="checkbox_news_publish">
					</s:if> <s:else>
						<input type="checkbox" checked="checked"
							id="checkbox_news_publish">
					</s:else></td>
			</tr>

			<tr style="height: 50px;">
				<th>关键词：</th>
				<td><input type="text"
					style="float: left; margin: 0 10px 0 0; width: 250px;"
					maxlength="15" placeholder="输入后按回车键，添加关键词" class="form-control"
					id="input_add" onfocus="input_add_onfocus()"
					value="<s:property value="newsAndCategoryAndContentDTO.news.news_keywords" />"
					onblur="input_add_onblur()" />
					<div id="div_keywords_box"></div></td>
			</tr>
			<tr>
				<th>大图：</th>
				<td><img id="bimg"
					src="<%=basePath%>snews/img_getNewsBImg?imgName=<s:property value="newsAndCategoryAndContentDTO.news.news_bimg" />"
					onclick="bimg_click()"
					style="height: 200px; width: 200px; float: left;" /> <input
					accept="image/*" id="input_bimg" type="file"
					onchange="bimg_change(this)" style="display: none;" /></td>
			</tr>
			<tr style="display: none;">
				<th>小图：</th>
				<td><img id="simg"
					src="<%=basePath%>snews/img_getNewsSImg?imgName=<s:property value="newsAndCategoryAndContentDTO.news.news_simg" />"
					onclick="simg_click()" style="height: 200px; width: 200px;" /> <input
					id="input_simg" accept="image/*" type="file"
					onchange="simg_change(this)" style="display: none;" /></td>
			</tr>
			<tr>
				<th>新闻内容：</th>
				<td><div id="content_toolbar"></div>
					<div id="content_text"
						style="width: 100%; height: 800px; word-wrap: break-word; word-break: break-all; background-color: white; margin: 20px 10px;">
						<s:property
							value="newsAndCategoryAndContentDTO.content.content_text"
							escapeHtml="false" />
					</div></td>
			</tr>
			<tr>
				<th>附件：</th>
				<td><div>
						<button class="btn btn-primary" style="background-color: #1abc9c;"
							onclick="add_annex()">上传</button>
					</div>
					<div id="div_annex_box" style="float: left;"></div></td>
			</tr>
			<tr>
				<th>新闻来源：</th>
				<td><input type="text" class="form-control"
					value="<s:property
							value="newsAndCategoryAndContentDTO.news.news_source"
							/>"
					id="input_news_source" style="width: 800px;"></td>
			</tr>
			<tr>
				<th>显示时间：</th>
				<td><input type="text" class="form-control"
					value="<s:property
							value="newsAndCategoryAndContentDTO.news.news_gmt_show"
							/>"
					id="input_news_gmt_show" style="width: 800px;"></td>
			</tr>
			<tr>
				<th></th>
				<td>
					<button class="btn btn-primary" style=""
						onclick="ifRepeatNewsTitle()">保存</button>
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
	$('#input_news_gmt_show').datetimepicker({
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
#news_table tr td {
	padding: 20px !important;
}

#news_table th {
	width: 120px !important;
}
</style>
</html>