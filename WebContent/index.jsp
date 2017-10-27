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
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>css/index/swiper.min.css">
<!------------------------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/index/index.css" />

<!------------------------------------------------------------------------------------------------->
<title>信息与计算机工程学院</title>
</head>
<body>


	<jsp:include page="/header.jsp" flush="true"></jsp:include>

	<!---------------------------------------------------------------------------------------------------->

	<div id="wrapper">
		<div class="head">
			<!--顶条和nav will include-->
			<div class="lunbo">
				<div class="swiper_big">
					<div class="swiper-container part1">
						<div class="swiper-wrapper">
							<s:iterator value="indexVO.LB_B" id="LB_B">
								<div class="swiper-slide part1_1">
									<img style="cursor: pointer;"
										onclick="window.location='<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
									value="#LB_B.jsj_snews_news_id" />'"
										src="<%=basePath%>snews/img_getNewsBImg?imgName=<s:property value="#LB_B.news_bimg" />">
									<div class="img_title" style="cursor: pointer;"
										onclick="window.location='<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
									value="#LB_B.jsj_snews_news_id" />'">
										<span><s:property value="#LB_B.news_title" /></span>
									</div>
								</div>
							</s:iterator>
						</div>
						<!--<div class="swiper-button-prev"></div>
						<div class="swiper-button-next"></div>-->
					</div>
					<div class="swiper-pagination part_1"></div>
				</div>
			</div>
		</div>
		<!--header end-->
		<!--main start-->
		<div class="clear"></div>
		<div class="main">
			<div class="newBox info-content">
				<div class="newTop">
					<span>通知公告</span> <a
						href="<%=basePath%>suser/news_list?listVO.category=通知公告&listVO.pageIndex=1">更多>></a>
				</div>

				<div class="info-show">
					<!--  -->
					<s:iterator value="indexVO.TZGG_Three" id="TZGG">

						<div class="media info2">
							<div class="media-left media-left-change">
								<a href="#">
									<div class="time">
										<span><s:property
												value="#TZGG.news.news_gmt_show.substring(8,10)" /></span><span><s:property
												value="#TZGG.news.news_gmt_show.substring(0,7)" /></span>
									</div> <img src="<%=basePath%>img/index/time.png" />
								</a>
							</div>
							<div class="media-body">
								<a class="media-heading heading"
									href="<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
												value="#TZGG.news.jsj_snews_news_id" />"><s:property
										value="#TZGG.news.news_title" /></a> <a
									href="<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
												value="#TZGG.news.jsj_snews_news_id" />"><s:property
										value="#TZGG.content.content_text" escape="false" /></a>
							</div>
						</div>

					</s:iterator>
					<!--  -->
				</div>

			</div>
			<div class="newBox info_wrapper">
				<div class="newTop new_title">
					<span>学院要闻</span> <a
						href="<%=basePath%>suser/news_list?listVO.category=学院要闻&listVO.pageIndex=1">更多>></a>
				</div>
				<div class="newContent info_content">
					<!--  -->
					<s:iterator value="indexVO.recommend_Nine" id="RN">

						<%-- <s:if test="#RN.news.news_simg=='default.jpg'"> --%>
						<div class="info1 cot_content_center">
							<div class="newCot">
								<h3 class="heading"
									onclick="window.location='<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
											value="#RN.news.jsj_snews_news_id" />'">
									<s:property value="#RN.news.news_title" />
								</h3>
								<a
									href="<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
												value="#RN.news.jsj_snews_news_id" />"><s:property
										value="#RN.content.content_text" escape="false" /></a>
							</div>
						</div>
						<%-- </s:if> --%>
						<%-- <s:else>
							<div class="info1 cot_content">
								<div class="newCot img_color">
									<img class="info_img" style="cursor: pointer;"
										onclick="window.location='<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
											value="#RN.news.jsj_snews_news_id" />'"
										src="<%=basePath%>snews/img_getNewsSImg?imgName=<s:property value="#RN.news.news_simg" />" />
									<h3 class="heading"
										onclick="window.location='<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
											value="#RN.news.jsj_snews_news_id" />'">
										<s:property value="#RN.news.news_title" />
									</h3>
									<a class="word_a"
										href="<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
												value="#RN.news.jsj_snews_news_id" />"><s:property
											value="#RN.content.content_text" escape="false" /> </a>
								</div>
							</div>
						</s:else> --%>

					</s:iterator>
				</div>
			</div>
			<div class="newBox"
				style="margin-bottom: 40px; border-top: 1px solid #d0dce6; border-bottom: 0px; padding-top: 30px;">
				<div class="newTop" style="margin-bottom: 10px;">
					<span>成果展示</span> <a
						href="<%=basePath%>suser/news_list?listVO.category=成果展示&listVO.pageIndex=1">更多>></a>
				</div>
				<div class="swiper_small">
					<div class="swiper-container part2">
						<div class="swiper-wrapper">

							<s:iterator value="indexVO.LB_S" id="LB_S">
								<div class="swiper-slide part2_1">
									<img style="cursor: pointer;"
										onclick="window.location='<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
									value="#LB_S.jsj_snews_news_id" />'"
										src="<%=basePath%>snews/img_getNewsBImg?imgName=<s:property value="#LB_S.news_bimg" />">
									<div class="title" style="cursor: pointer;"
										onclick="window.location='<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
									value="#LB_S.jsj_snews_news_id" />'">
										<s:property value="#LB_S.news_title" />
									</div>
								</div>
							</s:iterator>
						</div>
					</div>
					<div class="swiper-pagination part_2"></div>
				</div>
				<div class="showList">
					<s:iterator value="indexVO.CGZS_Four" id="CGZS">
						<div class="showCot">
							<img class="showList_img" src="<%=basePath%>img/index/dig.png" />
							<a class="showList_text"
								href="<%=basePath%>suser/news_details?news.jsj_snews_news_id=<s:property
									value="#CGZS.news.jsj_snews_news_id" />"><s:property
									value="#CGZS.news.news_title" /></a><span class="showList_time"><s:property
									value="#CGZS.news.news_gmt_show.substring(0,7)" /></span>
						</div>
					</s:iterator>

				</div>
				<div class="clear"></div>
			</div>

		</div>

	</div>
	<div class="link">
		<div class="linkCot">
			<span>常用链接</span>
			<div style="background-color: #babfc4; width: 300px; height: 2px;"></div>
			<s:iterator value="indexVO.LJ" id="LJ">
				<a href="http://<s:property value="#LJ.link_url" />" target="_Blank"><s:property
						value="#LJ.link_name" /></a>
			</s:iterator>


		</div>
	</div>
	<!--main end-->
	<!--footer will include-->
	</div>

	<script src="<%=basePath%>js/bootstrap.min.js"></script>
	<script src="<%=basePath%>js/index/idangerous.swiper.min.js"></script>
	<script src="<%=basePath%>js/index/idangerous.swiper.progress.js"></script>
	<script src="<%=basePath%>js/index/swiper-3.4.2.jquery.min.js"></script>

	<script>
		var mySwiper = new Swiper('.part1', {
			direction : 'horizontal',
			loop : true,
			// 如果需要分页器
			pagination : '.part_1',
			paginationClickable : true,
			autoplay : 3000,
			speed : 1000, //动画时长
			// 如果需要前进后退按钮
			nextButton : '.swiper-button-next',
			prevButton : '.swiper-button-prev',
		})
		var mySwiper = new Swiper('.part2', {
			direction : 'horizontal',
			loop : true,
			// 如果需要分页器
			pagination : '.part_2',
			paginationClickable : true,
			autoplay : 3000,
			speed : 1000, //动画时长
			// 如果需要前进后退按钮
			nextButton : '.swiper-button-next',
			prevButton : '.swiper-button-prev',
			onProgressChange : function(swiper) {
				for (var i = 0; i < swiper.slides.length; i++) {
					var slide = swiper.slides[i];
					var progress = slide.progress;
					var translate = progress * swiper.width;
					var opacity = 1 - Math.min(Math.abs(progress), 1);
					slide.style.opacity = opacity;
					swiper.setTransform(slide, 'translate3d(' + translate
							+ 'px,0,0)');
				}
			},
			onTouchStart : function(swiper) {
				for (var i = 0; i < swiper.slides.length; i++) {
					swiper.setTransition(swiper.slides[i], 0);
				}
			},
			onSetWrapperTransition : function(swiper, speed) {
				for (var i = 0; i < swiper.slides.length; i++) {
					swiper.setTransition(swiper.slides[i], speed);
				}
			},
			onSlideChangeStart : function(swiper) {
				$('.caption li').removeClass('active');
				$('.caption li').eq(swiper.activeLoopIndex).addClass('active')
			}
		})
	</script>
	<jsp:include page="/footer.jsp" flush="true"></jsp:include>
</body>

</html>