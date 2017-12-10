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
<link rel="stylesheet"
	href="<%=basePath%>css/news_details/news_details.css" />
<script type="text/javascript"
	src="<%=basePath%>js/news_details/news_details.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/news_details/details_download_annex.js"></script>
<title><s:property
		value="detailsVO.newsCategoryContent.news.news_title" /></title>
</head>
<body>
	<jsp:include page="/header.jsp" flush="true"></jsp:include>
	<!------------------------------------------------------------------------------------->
	<!------------------------------------------------------------------------------------->
	<!------------------------------------------------------------------------------------->
	<!-- 存储附件-->
	<div id="div_news_id" style="display: none;">
		<s:property
			value="detailsVO.newsCategoryContent.news.jsj_snews_news_id" />
	</div>
	<div id="news_details_main"
		style="width: 100%; min-width: 970px; margin: 30px 0 0 0;">
		<div id="news_head" style="width: 100%;">
			<div id="head" style="width: 970px; margin: 0 auto;">
				<p>
					<s:property
						value="detailsVO.newsCategoryContent.category.category_name" />
				</p>
			</div>
		</div>
		<div id="news" style="width: 970px; margin: 0 auto;">
			<div id="news_details_head" style="width: 1000px; margin-top: 40px;">
				<p>
					<s:property value="detailsVO.newsCategoryContent.news.news_title" />
				</p>
				<br /> <span style="font-size: 18px; color: #555555;"><s:property
						value="detailsVO.newsCategoryContent.news.news_gmt_show.substring(0,10)" />
					| <s:property
						value="detailsVO.newsCategoryContent.news.news_source" /></span>
				<hr class="hr_style" />
			</div>
			<div id="news_details_content"
				style="width: 970px; margin-top: 30px;">
				<div>
					<s:property
						value="detailsVO.newsCategoryContent.content.content_text"
						escapeHtml="false" />
				</div>
				<!-- 存储附件-->
				<div id="div_news_annex" style="display: none;">
					<s:property value="detailsVO.newsCategoryContent.news.news_annex" />
				</div>
				<!-- 附件 -->
				<div id="div_annex_box" style="margin: 30px 0;"></div>

				<!-- 分割线 -->
				<hr class="hr_style" />

			</div>
			<div id="key_share">
				<span style="float: left; font-size: 14px; color: #003262;">关键词：<s:property
						value="detailsVO.newsCategoryContent.news.news_keywords" /></span>

			</div>
		</div>
		<%-- <div id="news_bottom" style="">
			<div id="about_news" style="width: 970px; margin: 0 auto;">

				<div id="about_news_head">
					<p
						style="font-size: 18px; font-weight: bold; color: #003262; letter-spacing: 5px;">相关新闻</p>
				</div>
				<br />
				<div id="show_news">

					<ul class="out_ul">
						<s:iterator value="detailsVO.relateNews" id="RN">
							<s:if test="#RN.news.news_simg !='default.jpg'">
								<li class="out_li">
									<ul class="news_ul">
										<li><img style="cursor: pointer;"
											onclick="window.location='<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
											value="#RN.news.jsj_snews_news_id" />'"
											src="<%=basePath%>snews/img_getNewsSImg?imgName=<s:property value="#RN.news.news_simg" />" />
											<div style="height: 45px; overflow: hidden;">
												<span
													onclick="window.location='<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
											value="#RN.news.jsj_snews_news_id" />'"><s:property
														value="#RN.news.news_title" /></span>
											</div></li>
									</ul>
								</li>
							</s:if>
							<s:else>
							<li class="out_li">
								<ul class="news_ul">
									<div class="news_head"
										onclick="window.location='<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
											value="#RN.news.jsj_snews_news_id" />'">
										<s:property value="#RN.news.news_title" />
									</div>
									<div class="news_content"
										onclick="window.location='<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
											value="#RN.news.jsj_snews_news_id" />'">
										<s:property value="#RN.content.content_text" escapeHtml="false" />
									</div>
								</ul>
							</li>
							</s:else>
						</s:iterator>
					</ul>

				</div>
			</div>

		</div> --%>
	</div>
	<!------------------------------------------------------------------------------------->
	<!------------------------------------------------------------------------------------->
	<!------------------------------------------------------------------------------------->
	<jsp:include page="/footer.jsp" flush="true"></jsp:include>

</body>
<script>
	download_annex();
	function qc(){
		var newsContent=document.getElementById("news_content").getElementsByTagName("p");
		for(var i=0;i<newsContent.length;i++){

			div1[i].innerHTML='';

			} 
	}
	qc();
</script>
</html>