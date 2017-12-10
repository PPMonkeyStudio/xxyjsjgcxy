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
<!------------------------------------------------------------------------------------------------->

<!------------------------------------------------------------------------------------------------->
<title>信息与计算机工程学院</title>
</head>
<body>




	<!---------------------------------------------------------------------------------------------------->

	<div class="footer">

		<div id="detailNav_copyright">
			<div class="navi_body">
				<div class="navi_head">
					<div style="width: 1040px; margin-left: auto; margin-right: auto;">
						<s:iterator value="listCategory" var="LC">
							<span> <s:if test="#LC.category_news!=''">
									<p class="navi_title" style="cursor: pointer;"
										onclick="window.location='<%=basePath%>suser/news_details?category.category_news=<s:property value="#LC.category_news" />&listVO.pageIndex=1'">
								</s:if> <s:else>
									<p class="navi_title" style="cursor: pointer;"
										onclick="window.location='<%=basePath%>suser/news_list?listVO.category=<s:property value="#LC.category_name" />&listVO.pageIndex=1'">
								</s:else> <s:property value="#LC.category_name" />
								</p> <s:iterator value="listAllCategory" var="LAC">
									<s:if test="#LAC.category_father==#LC.jsj_snews_category_id">
										<p>
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
										</p>
									</s:if>
								</s:iterator>
							</span>
						</s:iterator>
					</div>
				</div>
			</div>
			<div class="foot">
				<div>
					Copyright <span style="color:white;cursor: pointer;" onclick="window.location='<%=basePath%>login.jsp'">©</span>2012-2018
					College of information and Computer Engineering. All rights
					reserved.
				</div>
				<div>信息与计算机工程学院 版权所有</div>
			</div>
		</div>
	</div>



</body>

</html>