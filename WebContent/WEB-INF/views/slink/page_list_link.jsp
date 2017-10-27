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
<script type="text/javascript"
	src="<%=basePath%>js/slink/page_list_link.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/slink/search_and_sqrt_link.js"></script>
<title>链接列表</title>
</head>
<body>
	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div style="margin: 50px 0 0 260px; width: calc(100% - 260px);">
		<!-- 内容写在此处 -->
		<span id="span_sqrt" style="display: none;"><s:property
				value="page_list_link.search.sqrt" /></span>
		<!--  -->
		<span id="span_sqrt_sc" style="display: none;"><s:property
				value="page_list_link.search.sqrt_sc" /></span>
		<!--  -->
		<table style="width: 95%; margin: 0 auto; text-align: center;">
			<tr>
				<td style="height: 50px;"><button class="btn btn-primary"
						onclick="search_link()" style="float: right; margin: 8px 0 0 0;">检索</button>
					<input type="text" class="form-control" id="input_name"
					value="<s:property
				value="page_list_link.search.name" />"
					style="width: 200px; float: right; margin: 8px 10px 8px 50px;" />

				</td>
			</tr>
		</table>
		<table id="table" style="width: 95%; margin: 20px auto; text-align: center;"
			class="table-bordered">
			<tr>
				<!--  -->

				<th>链接名</th>
				<th>链接URL</th>




				<th id="link_gmt_create" onclick="click_sqrt(this)">创建时间</th>
				<th id="link_gmt_modified" onclick="click_sqrt(this)">修改时间</th>
				<th>操作</th>
			</tr>

			<s:iterator value="page_list_link.linkDTOList" id="NACACDTOL">
				<tr>
					<td><s:property value="#NACACDTOL.link.link_name"
							escape="false" /></td>
					<td><s:property value="#NACACDTOL.link.link_url"
							escape="false" /></td>

					<td><s:property value="#NACACDTOL.link.link_gmt_create" /></td>
					<td><s:property value="#NACACDTOL.link.link_gmt_modified" /></td>
					<td><button class="btn btn-primary" style="margin: 5px;"
							onclick="window.location='<%=basePath%>slink/link_updateLinkPage?link.jsj_slink_link_id=<s:property value="#NACACDTOL.link.jsj_slink_link_id" />'">修改</button>
						<button class="btn btn-danger" style="margin: 5px;"
							id="<s:property
							value="#NACACDTOL.link.jsj_slink_link_id" />"
							data-toggle="modal" data-target="#model_delete_link"
							onclick="javascript:delete_link_id=this.id;">删除</button></td>
				</tr>
			</s:iterator>

		</table>
		<!------------------------------------------------------------------------------------------------------------------->
		<div style="margin: 0 auto; width: 400px; text-align: center;">
			<button class="btn btn-primary"
				onclick="window.location='<%=basePath%>slink/link_page_list_link?page=page_list_link&page_list_link.pageIndex=1'">首页</button>
			<s:if test="page_list_link.HavePrePage">
				<button class="btn btn-primary"
					onclick="window.location='<%=basePath%>slink/link_page_list_link?page=page_list_link&page_list_link.pageIndex=<s:property value="page_list_link.pageIndex-1" />'">上一页</button>
			</s:if>
			<s:else>
				<button class="btn btn-primary"
					onclick="javascript:toastr.warning('已经是第一页了');">上一页</button>
			</s:else>
			<s:if test="page_list_link.HaveNextPage">
				<button class="btn btn-primary"
					onclick="window.location='<%=basePath%>slink/link_page_list_link?page=page_list_link&page_list_link.pageIndex=<s:property value="page_list_link.pageIndex+1" />'">下一页</button>
			</s:if>
			<s:else>

				<button class="btn btn-primary"
					onclick="javascript:toastr.warning('已经是最后一页了');">下一页</button>
			</s:else>
			<button class="btn btn-primary"
				onclick="window.location='<%=basePath%>slink/link_page_list_link?page=page_list_link&page_list_link.pageIndex=<s:property value="page_list_link.totalPages" />'">尾页</button>
		</div>
		<!------------------------------------------------------------------------------------------------------------------->
		<div style="margin: 20px auto 20px; width: 200px; text-align: center;">
			第
			<s:property value="page_list_link.pageIndex" />
			页<br>共
			<s:property value="page_list_link.totalPages" />
			页<br>共
			<s:property value="page_list_link.totalRecords" />
			条记录
		</div>
		<!------------------------------------------------------------------------------------------------------------------->
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div class="modal fade" id="model_delete_link">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">确认信息</h4>
				</div>
				<div class="modal-body">
					<h4 id="h4_delete">删除此链接？</h4>
				</div>
				<div class="modal-footer">
					<button class="btn btn-danger" onclick="delete_link()">删除</button>
					<button class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
</body>
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
<style type="text/css">
#table tr th {
	padding: 10px !important;
}

</style>
</html>