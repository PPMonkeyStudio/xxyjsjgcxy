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
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<script src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!------------------------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/index/navANDfooter.css">
<!------------------------------------------------------------------------------------------------->
<!------------------------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/toastr.css" />

<script type="text/javascript" src="<%=basePath%>js/toastr.js"></script>

<!------------------------------------------------------------------------------------------------->
<title>信息与计算机工程学院</title>
</head>
<body>
	<!---------------------------------------------------------------------------------------------------->
	<div class="header">
		<!--顶条start-->
		<div class="topImfo">
			<div class="imfo">
				<a
					href="<%=basePath%>suser/news_list?listVO.category=通知公告&listVO.pageIndex=1">通知公告</a>
				<a
					href="<%=basePath%>suser/news_list?listVO.category=学院要闻&listVO.pageIndex=1">&nbsp;&nbsp;&nbsp;&nbsp;学校要闻</a>
				<div class="imfoLeft">
					<a>联系我们</a>
					<!--搜索条start-->
					<div class="search">
						<input type="text" id="input_searchNews" maxlength="15"
							value="<s:property value="listVO.search" />"
							style="padding: 0 0 0 5px;" /> <img style="cursor: pointer;"
							onclick="searchNews()" src="<%=basePath%>img/index/search.png" />
					</div>
				</div>
			</div>
		</div>
		<!--顶条end-->
		<!--nav start-->
		<div class="nav">
			<div class="header_nav">
				<div class="logo">
					<img src="<%=basePath%>img/index/logo.png" style="cursor: pointer;"
						onclick="window.location='<%=basePath%>suser/index'">
				</div>
			</div>
			<div class="top-nav">
				<div id="navList" class="navlist-wrap">
					<div class="navlist clearfix">
						<a  href="<%=basePath%>suser/index" class="nav-btn">首页</a>

						<!-- 超过八个不显示 -->
						<s:iterator value="listCategory" var="LC">
							<s:if test="#LC.category_news!=''">
								<a
									href="<%=basePath%>suser/news_details?category.category_news=<s:property value="#LC.category_news" />&listVO.pageIndex=1"
									class="nav-btn"><s:property value="#LC.category_name" /></a>
							</s:if>
							<s:else>
								<a
									href="<%=basePath%>suser/news_list?listVO.category=<s:property value="#LC.category_name" />&listVO.pageIndex=1"
									class="nav-btn"><s:property value="#LC.category_name" /></a>
							</s:else>
						</s:iterator>

					</div>
				</div>
				<div id="expandZone" class="expand">
					<div class="detailNav">

						<s:iterator value="listCategory" var="LC">
							<div class="item">
								<div class="detailNav-list">
									<div class="detailNav_left">
										<div class="introImg">
											<span><s:property value="#LC.category_Introduction" /></span>
										</div>
										<img
											src="<%=basePath%>snews/img_getNewsCategoryImg?imgName=<s:property value="#LC.category_img" />" />
									</div>
									<div class="detailNav_right">
										<s:iterator value="listAllCategory" var="LAC">
											<s:if test="#LAC.category_father==#LC.jsj_snews_category_id">
												<s:if test="#LAC.category_news!=''">
													<a
														href="<%=basePath%>suser/news_details?category.category_news=<s:property value="#LAC.category_news" />&listVO.pageIndex=1"><s:property
															value="#LAC.category_name" /></a>
												</s:if>
												<s:else>
													<a
														href="<%=basePath%>suser/news_list?listVO.category=<s:property value="#LAC.category_name" />&listVO.pageIndex=1"><s:property
															value="#LAC.category_name" /></a>
												</s:else>
											</s:if>
										</s:iterator>
									</div>
								</div>
							</div>
						</s:iterator>
					</div>
				</div>
			</div>
		</div>
		<!--nav end-->
	</div>
</body>
<script src="<%=basePath%>js/index/home.js"></script>

<script>
	function searchNews() {

		var input_searchNews = document.getElementById("input_searchNews");

		window.location = "/xxyjsjgcxy/suser/news_list?listVO.search="
				+ input_searchNews.value + "&listVO.pageIndex=1";
	}
</script>

</html>