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
<link rel="stylesheet" href="<%=basePath%>css/news_list/news_list.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/news_list/manhuaDate.1.0.css">

<title>新闻列表</title>
</head>
<body>
	<jsp:include page="/header.jsp" flush="true"></jsp:include>
	<!------------------------------------------------------------------------------------->
	<!------------------------------------------------------------------------------------->
	<!------------------------------------------------------------------------------------->
	<!-- 存储附件-->
	<div id="div_search" style="display: none;">
		<s:property value="listVO.search" />
	</div>
	<div id="content_all"
		style="width: 100%; min-width: 970px; margin: 30px 0 0 0;">

		<div id="news_head">
			<div id="head" style="width: 970px; margin: 0 auto;">
				<p>
					<s:if test="listVO.search!=''&listVO.search!=null">
					检索：<s:property value="listVO.search" />
					</s:if>
					<s:elseif test="listVO.category!=''&listVO.category!=null">
						<s:property value="listVO.category" />
					</s:elseif>
					<s:else>新闻列表</s:else>
				</p>
			</div>
		</div>

		<div id="main"
			style="width: 970px; min-height: 580px; margin: 0 auto;">

			<div id="main_left" style="width: 500px; float: left;">
				<div id="news_list" style="min-height: 500px;">
					<s:iterator value="listVO.listNews" var="LN">
						<div id="news_list_content_head">
							<a
								href="<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
							value="#LN.news.jsj_snews_news_id" />">
								<s:property value="#LN.news.news_title" escapeHtml="false" />
							</a>
						</div>

						<div id="news_list_content_datekeyword">
							<s:property value="#LN.category.category_name" />
							|
							<s:property value="#LN.news.news_gmt_show.substring(0,10)" />
							|
							<s:property value="#LN.news.news_keywords" escapeHtml="false" />
						</div>

					</s:iterator>
				</div>

				<s:if test="listVO.search!=''&listVO.search!=null">
					<div id="news_page">
						<span
							onclick="window.location='<%=basePath%>suser/news_list?listVO.search=<s:property value="listVO.search" />&listVO.pageIndex=1'">首
							页 |</span>
						<s:if test="listVO.HavePrePage">
							<span
								onclick="window.location='<%=basePath%>suser/news_list?listVO.search=<s:property value="listVO.search" />&listVO.pageIndex=<s:property value="listVO.pageIndex-	1" />'">上
								一 页 |</span>
						</s:if>
						<s:else>
							<span onclick="javascript:toastr.warning('已经是第一页了');">上一 页
								|</span>
						</s:else>
						<s:if test="listVO.HaveNextPage">
							<span
								onclick="window.location='<%=basePath%>suser/news_list?listVO.search=<s:property value="listVO.search" />&listVO.pageIndex=<s:property value="listVO.pageIndex+1" />'">下
								一 页 |</span>
						</s:if>
						<s:else>
							<span onclick="javascript:toastr.warning('已经是最后一页了');">下 一
								页 |</span>
						</s:else>
						<span
							onclick="window.location='<%=basePath%>suser/news_list?listVO.search=<s:property value="listVO.search" />&listVO.pageIndex=<s:property value="listVO.totalPages" />'">尾
							页 </span>
					</div>
				</s:if>
				<s:elseif test="listVO.category!=''&listVO.category!=null">
					<div id="news_page">
						<span
							onclick="window.location='<%=basePath%>suser/news_list?listVO.category=<s:property value="listVO.category" />&listVO.pageIndex=1'">首
							页 |</span>
						<s:if test="listVO.HavePrePage">
							<span
								onclick="window.location='<%=basePath%>suser/news_list?listVO.category=<s:property value="listVO.category" />&listVO.pageIndex=<s:property value="listVO.pageIndex-	1" />'">上
								一 页 |</span>
						</s:if>
						<s:else>
							<span onclick="javascript:toastr.warning('已经是第一页了');">上一 页
								|</span>
						</s:else>
						<s:if test="listVO.HaveNextPage">
							<span
								onclick="window.location='<%=basePath%>suser/news_list?listVO.category=<s:property value="listVO.category" />&listVO.pageIndex=<s:property value="listVO.pageIndex+1" />'">下
								一 页 |</span>
						</s:if>
						<s:else>
							<span onclick="javascript:toastr.warning('已经是最后一页了');">下 一
								页 |</span>
						</s:else>
						<span
							onclick="window.location='<%=basePath%>suser/news_list?listVO.category=<s:property value="listVO.category" />&listVO.pageIndex=<s:property value="listVO.totalPages" />'">尾
							页 </span>
					</div>
				</s:elseif>
				<s:else>
					<div id="news_page">
						<span
							onclick="window.location='<%=basePath%>suser/news_list?listVO.date=<s:property value="listVO.date" />&listVO.pageIndex=1'">首
							页 |</span>
						<s:if test="listVO.HavePrePage">
							<span
								onclick="window.location='<%=basePath%>suser/news_list?listVO.date=<s:property value="listVO.date" />&listVO.pageIndex=<s:property value="listVO.pageIndex-	1" />'">上
								一 页 |</span>
						</s:if>
						<s:else>
							<span onclick="javascript:toastr.warning('已经是第一页了');">上一 页
								|</span>
						</s:else>
						<s:if test="listVO.HaveNextPage">
							<span
								onclick="window.location='<%=basePath%>suser/news_list?listVO.date=<s:property value="listVO.date" />&listVO.pageIndex=<s:property value="listVO.pageIndex+1" />'">下
								一 页 |</span>
						</s:if>
						<s:else>
							<span onclick="javascript:toastr.warning('已经是最后一页了');">下 一
								页 |</span>
						</s:else>
						<span
							onclick="window.location='<%=basePath%>suser/news_list?listVO.date=<s:property value="listVO.date" />&listVO.pageIndex=<s:property value="listVO.totalPages" />'">尾
							页 </span>
					</div>
				</s:else>
				<div id="news_record">
					<span>第<s:property value="listVO.pageIndex" />页 |
					</span> <span>共<s:property value="listVO.totalPages" />页 |
					</span> <span>共<s:property value="listVO.totalRecords" />条 记 录
					</span>
				</div>
			</div>

			<div id="main_right" style="float: right;">
				<div id="main_right_up"
					style="width: 340px; height: 340px; margin-top: 50px"></div>
				<div id="main_right_down" style="margin-left: 20px;">
					<p
						onclick="window.location='<%=basePath%>suser/news_list?listVO.date=1&listVO.pageIndex=1'">本日新闻
						&gt;</p>
					<br /> <br />
					<p
						onclick="window.location='<%=basePath%>suser/news_list?listVO.date=2&listVO.pageIndex=1'">本周新闻
						&gt;</p>
					<br /> <br />
					<p
						onclick="window.location='<%=basePath%>suser/news_list?listVO.date=3&listVO.pageIndex=1'">本月新闻
						&gt;</p>
					<br /> <br />
				</div>
			</div>

		</div>
		<div class="clear"></div>
	</div>

	<!------------------------------------------------------------------------------------->
	<!------------------------------------------------------------------------------------->
	<!------------------------------------------------------------------------------------->
	<jsp:include page="/footer.jsp" flush="true"></jsp:include>

</body>
<script type="text/javascript"
	src="<%=basePath%>js/news_list/manhuaDate.1.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("input.mh_date").manhuaDate({
			fuhao : "-", //日期连接符默认为-
			isTime : false, //是否开启时间值默认为false
			beginY : 2017, //年份的开始默认为1949
			endY : 2017
		//年份的结束默认为2049
		});
	});
</script>

</html>