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
	src="<%=basePath%>js/snews/getNewsCategory.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/snews/page_list_news.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/snews/search_and_sqrt_news.js"></script>
<!---------------------------------------------------------------------------------------------------->
<title>新闻列表</title>
</head>
<body>
	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div style="margin: 50px 0 0 260px; width: calc(100% - 260px);">
		<!-- 内容写在此处 -->
		<!--  -->
		<span id="span_sqrt" style="display: none;"><s:property
				value="page_list_news.search.sqrt" /></span>
		<!--  -->
		<span id="span_sqrt_sc" style="display: none;"><s:property
				value="page_list_news.search.sqrt_sc" /></span>
		<!--  -->
		<span id="span_news_category" style="display: none;"><s:property
				value="page_list_news.search.category" /></span>
		<!--  -->
		<span id="span_news_publish" style="display: none;"><s:property
				value="page_list_news.search.publish" /></span>
		<!--  -->
		<span id="span_news_recommend" style="display: none;"><s:property
				value="page_list_news.search.recommend" /></span>
		<!--  -->
		<table style="width: 95%; margin: 0 auto; text-align: center;">
			<tr>
				<td style="height: 50px;"><button class="btn btn-primary"
						onclick="search_news()" style="float: right; margin: 8px 0 0 0;">检索</button>
					<input type="text" class="form-control" id="input_keywords"
					value="<s:property
				value="page_list_news.search.keywords" />"
					style="width: 200px; float: right; margin: 8px 10px 8px 50px;" />
					<input type="text" placeholder="XXXX-XX-XX" id="input_data_end"
					class="form-control"
					value="<s:property
				value="page_list_news.search.stop_time" />"
					style="width: 120px; float: right; text-align: center; margin: 8px 0 0 10px;">
					<span style="float: right; line-height: 50px;">到</span> <input
					type="text" class="form-control" placeholder="XXXX-XX-XX"
					id="input_data_start"
					value="<s:property
				value="page_list_news.search.start_time" />"
					style="width: 120px; float: right; text-align: center; margin: 8px 10px 0 10px;">
					<span style="float: right; line-height: 50px;">从</span></td>
			</tr>
		</table>

		<table style="width: 95%; margin: 20px auto; text-align: center;"
			class="table-bordered  table-striped table-hover">
			<tr>
				<!--  -->
				<th><select
					style="width: auto; text-align: center; margin: 0 auto;"
					class="form-control" id="select_publish" onchange="search_news()">
						<s:if test="page_list_news.search.publish == 0">
							<option value="-1">发布</option>
							<option value="1">已发布</option>
							<option value="0" selected="selected">未发布</option>
						</s:if>
						<s:elseif test="page_list_news.search.publish == 1">
							<option value="-1">发布</option>
							<option value="1" selected="selected">已发布</option>
							<option value="0">未发布</option>
						</s:elseif>
						<s:else>
							<option value="-1" selected="selected">发布</option>
							<option value="1">已发布</option>
							<option value="0">未发布</option>
						</s:else>
				</select></th>
				<!--  -->
				<th><select
					style="width: auto; text-align: center; margin: 0 auto;"
					class="form-control" id="select_recommend" onchange="search_news()">
						<s:if test="page_list_news.search.recommend == 0">
							<option value="-1">推荐</option>
							<option value="1">已推荐</option>
							<option value="0" selected="selected">未推荐</option>
						</s:if>
						<s:elseif test="page_list_news.search.recommend == 1">
							<option value="-1">推荐</option>
							<option value="1" selected="selected">已推荐</option>
							<option value="0">未推荐</option>
						</s:elseif>
						<s:else>
							<option value="-1" selected="selected">推荐</option>
							<option value="1">已推荐</option>
							<option value="0">未推荐</option>
						</s:else>
				</select></th>
				<!--  -->
				<th><select
					style="width: auto; text-align: center; margin: 0 auto;"
					id="select_news_category" class="form-control"
					onchange="search_news()">
						<option value="-1">所有类别</option>
				</select></th>
				<!--  -->
				<th>新闻标题</th>

				<!--  -->
				<th>关键词</th>
				<th>大图</th>
				<th>小图</th>
				<th class="table_sqrt" id=news_num_annex onclick="click_sqrt(this)">附件数</th>
				<th class="table_sqrt" id="news_browse" onclick="click_sqrt(this)">浏览次数</th>
				<th class="table_sqrt" id="news_gmt_show" onclick="click_sqrt(this)">显示时间</th>
				<th class="table_sqrt" id="news_gmt_create"
					onclick="click_sqrt(this)">创建时间</th>
				<th class="table_sqrt" id="news_gmt_modified"
					onclick="click_sqrt(this)">修改时间</th>
				<th>操作</th>
			</tr>

			<s:iterator value="page_list_news.newsAndCategoryAndContentDTOList"
				id="NACACDTOL">
				<tr>
					<td><s:if
							test="#NACACDTOL.news.news_publish == '1'.toString()">✔</s:if> <s:else>
							<span style='color: #ff5063;'>✘</span>
						</s:else></td>
					<td><s:if
							test="#NACACDTOL.news.news_recommend == '1'.toString()">✔</s:if>
						<s:else>
							<span style='color: #ff5063;'>✘</span>
						</s:else></td>
					<td><s:property value="#NACACDTOL.category.category_name" /></td>
					<td><s:property value="#NACACDTOL.news.news_title"
							escape="false" /></td>
					<td><s:property value="#NACACDTOL.news.news_keywords"
							escape="false" /></td>
					<td><s:if test="#NACACDTOL.news.news_bimg != 'default.jpg'">✔</s:if>
						<s:else>
							<span style='color: #ff5063;'>✘</span>
						</s:else></td>
					<td><s:if test="#NACACDTOL.news.news_simg != 'default.jpg'">✔</s:if>
						<s:else>
							<span style='color: #ff5063;'>✘</span>
						</s:else></td>
					<td><s:property value="#NACACDTOL.news.news_num_annex" /></td>
					<td><s:property value="#NACACDTOL.news.news_browse" /></td>
					<td><s:property value="#NACACDTOL.news.news_gmt_show" /></td>
					<td><s:property value="#NACACDTOL.news.news_gmt_create" /></td>
					<td><s:property value="#NACACDTOL.news.news_gmt_modified" /></td>
					<td><button class="btn btn-primary" style="margin: 5px;"
							onclick="window.location='<%=basePath%>snews/news_updateNewsPage?news.jsj_snews_news_id=<s:property value="#NACACDTOL.news.jsj_snews_news_id" />'">修改</button>
						<button class="btn btn-danger" style="margin: 5px;"
							id="<s:property
							value="#NACACDTOL.news.jsj_snews_news_id" />"
							data-toggle="modal" data-target="#model_delete_news"
							onclick="javascript:delete_news_id=this.id;">删除</button></td>
				</tr>
			</s:iterator>

		</table>
		<!------------------------------------------------------------------------------------------------------------------->

		<div style="margin: 0 auto; width: 400px; text-align: center;">
			<button class="btn btn-primary" onclick="search_news(1)">首页</button>
			<s:if test="page_list_news.HavePrePage">
				<button class="btn btn-primary"
					onclick="search_news(<s:property value="page_list_news.pageIndex-1" />)">上一页</button>
			</s:if>
			<s:else>
				<button class="btn btn-primary"
					onclick="javascript:toastr.warning('已经是第一页了');">上一页</button>
			</s:else>
			<s:if test="page_list_news.HaveNextPage">
				<button class="btn btn-primary"
					onclick="search_news(<s:property value="page_list_news.pageIndex+1" />)">下一页</button>
			</s:if>
			<s:else>

				<button class="btn btn-primary"
					onclick="javascript:toastr.warning('已经是最后一页了');">下一页</button>
			</s:else>
			<button class="btn btn-primary"
				onclick="search_news(<s:property value="page_list_news.totalPages" />)">尾页</button>
		</div>
		<!------------------------------------------------------------------------------------------------------------------->
		<div style="margin: 20px auto 20px; width: 200px; text-align: center;">
			第
			<s:property value="page_list_news.pageIndex" />
			页<br>共
			<s:property value="page_list_news.totalPages" />
			页<br>共
			<s:property value="page_list_news.totalRecords" />
			条记录
		</div>


		<!------------------------------------------------------------------------------------------------------------------->
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->


	<div class="modal fade" id="model_delete_news">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">确认信息</h4>
				</div>
				<div class="modal-body">
					<h4 id="h4_delete">删除此新闻？</h4>
				</div>
				<div class="modal-footer">
					<button class="btn btn-danger" onclick="delete_news()">删除</button>
					<button class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
</body>
<style type="text/css">
.table_sqrt:hover {
	cursor: pointer !important;
	background-color: #b5c6d6 !important;
	color: white !important;
}
</style>
<script>
	$('select').selectpicker('refresh');
</script>
<script>
	$.datetimepicker.setLocale('ch');
	$('#input_data_start').datetimepicker({
		yearStart : 1990, //设置最小年份
		yearEnd : 2050, //设置最大年份
		yearOffset : 0, //年偏差
		timepicker : false, //关闭时间选项
		format : 'Y-m-d', //格式化日期年-月-日

		minDate : '1990/01/01', // 设置最小日期
		maxDate : '2030/01/01', // 设置最大日期
	});
	$('#input_data_end').datetimepicker({
		yearStart : 1990, //设置最小年份
		yearEnd : 2050, //设置最大年份
		yearOffset : 0, //年偏差
		timepicker : false, //关闭时间选项
		format : 'Y-m-d', //格式化日期年-月-日

		minDate : '1990/01/01', // 设置最小日期
		maxDate : '2030/01/01', // 设置最大日期
	});
</script>
<script>
	var select_news_category = document.getElementById("select_news_category");
	getNewsCategory(select_news_category);
</script>


</html>