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
<!--------------------------------------------------------------------------------->
<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-select.min.css">
<script type="text/javascript" src="<%=basePath%>js/bootstrap-select.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet"
	href="<%=basePath%><%=basePath%>css/navbar/chartist-custom.css">
<link rel="stylesheet" href="<%=basePath%>css/navbar/main.css">
<link rel="stylesheet"
	href="<%=basePath%>css/navbar/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>css/navbar/style.css">
<link rel="stylesheet" href="<%=basePath%>css/table.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/jquery.datetimepicker.css" />
<script type="text/javascript"
	src="<%=basePath%>js/jquery.datetimepicker.full.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/flat/green.css" />
<script type="text/javascript" src="<%=basePath%>js/icheck.js"></script>
<!--------------------------------------------------------------------------------->
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/toastr.css" />
<script type="text/javascript" src="<%=basePath%>js/toastr.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/snews/load.css" />
<script type="text/javascript" src="<%=basePath%>js/snews/load.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/slink/load.css" />
<script type="text/javascript" src="<%=basePath%>js/slink/load.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/sadmin/load.css" />
<script type="text/javascript" src="<%=basePath%>js/sadmin/load.js"></script>
<!--------------------------------------------------------------------------------->
<title>Insert title here</title>
</head>
<body>
	<!--顶部-->
	<%-- <div
		style="background-color: white; height: 125px; width: 100%; z-index: 10; position: fixed; top: 0; left: 0;">
		<img src="<%=basePath%>img/logo.jpg" class="img-responsive logo">
	</div> --%>

	<div id="wrapper" style="position: fixed; top: 0; left: 0;">
		<!--左侧-->
		<div id="sidebar-nav" class="sidebar"
			style="margin: 0 0 0 0; position: fixed; top: 0; left: 0;">
			<div
				style="color: white; font-size: 25px; margin: 0 0 20px 0; text-align: center; padding: 0 50px 0 0;">
				管理员
				<s:property value="#session.Admin.admin_account" />
			</div>
			<div class="sidebar-scroll">

				<ul class="nav">
         <s:if test="#session.Admin.admin_premission_scarousel=='管理权限'">
					<li><s:if test="page=='skipToAdd'||page=='skipToDelete'">
							<a href="#scarousel" data-toggle="collapse"
								class="active">
						</s:if> <s:else>
							<a href="#scarousel" data-toggle="collapse" class="collapsed">
						</s:else> <i class="lnr lnr-rocket"></i><span>轮播图管理</span><i
						class="icon-submenu lnr lnr-chevron-left"></i></a> <s:if
							test="page=='skipToAdd'||page=='skipToDelete'">
							<div id="scarousel" class="collapse in">
						</s:if> <s:else>
							<div id="scarousel" class="collapse ">
						</s:else>


						<ul class="nav">
							<li><s:if test="page=='skipToAdd'">
									<a href="<%=basePath%>scarousel/skip_Add" class="active">添加轮播图</a>
								</s:if> <s:else>
									<a href="<%=basePath%>scarousel/skip_Add">添加轮播图</a>
								</s:else></li>
							<li><s:if test="page=='skipToDelete'">
									<a href="<%=basePath%>scarousel/skip_Delete" class="active">轮播图列表</a>
								</s:if> <s:else>
									<a href="<%=basePath%>scarousel/skip_Delete">轮播图列表</a>
								</s:else></li>
						</ul>
			</div>
			</li>
			</s:if>

			<!---------------------------------------------------------------------------------------------------------------------------------->
			<s:if test="#session.Admin.admin_premission_snews=='管理权限'">
			<li><s:if
					test="page=='page_create_news'||page=='page_list_category'||page=='page_create_category'||page=='page_list_news' ">
					<a href="#snews" data-toggle="collapse" class="active">
				</s:if> <s:else>
					<a href="#snews" data-toggle="collapse" class="collapsed">
				</s:else> <i class="lnr lnr-pencil"></i> <span>新闻管理</span> <i
				class="icon-submenu lnr lnr-chevron-left"></i></a> <s:if
					test="page=='page_create_news'||page=='page_list_category'||page=='page_create_category'||page=='page_list_news'">
					<div id="snews" class="collapse in">
				</s:if> <s:else>
					<div id="snews" class="collapse">
				</s:else>


				<ul class="nav">
					<!--  -->
					<li><s:if test="page=='page_create_news'">
							<a
								href="<%=basePath%>snews/news_page_create_news?page=page_create_news"
								class="active"> 创建新闻</a>
						</s:if> <s:else>
							<a
								href="<%=basePath%>snews/news_page_create_news?page=page_create_news">
								创建新闻</a>
						</s:else></li>
					<!--  -->
					<li><s:if test="page=='page_list_news'">
							<a
								href="<%=basePath%>snews/news_page_list_news?page=page_list_news&page_list_news.pageIndex=1"
								class="active">新闻列表</a>
						</s:if> <s:else>
							<a
								href="<%=basePath%>snews/news_page_list_news?page=page_list_news&page_list_news.pageIndex=1">
								新闻列表</a>
						</s:else></li>
					<!--  -->
					<li><s:if test="page=='page_list_category'">
							<a
								href="<%=basePath%>snews/category_page_list_category?page=page_list_category"
								class="active">新闻类别列表</a>
						</s:if> <s:else>
							<a
								href="<%=basePath%>snews/category_page_list_category?page=page_list_category">新闻类别列表</a>
						</s:else></li>
					<!--  -->
					<li><s:if test="page=='page_create_category'">
							<a
								href="<%=basePath%>snews/category_page_create_category?page=page_create_category&option=create"
								class="active"> 创建类别</a>
						</s:if> <s:else>
							<a
								href="<%=basePath%>snews/category_page_create_category?page=page_create_category&option=create">
								创建类别</a>
						</s:else></li>
					<!--  -->
				</ul></li>
				</s:if>

			<!---------------------------------------------------------------------------------------------------------------------------------->
			<s:if test="#session.Admin.admin_premission_slink=='管理权限'">
			<li><s:if
					test="page=='page_create_link'||page=='page_list_link' ">
					<a href="#slink" data-toggle="collapse" class="active">
				</s:if> <s:else>
					<a href="#slink" data-toggle="collapse" class="collapsed">
				</s:else> <i class="lnr lnr-flag"></i> <span>链接管理</span> <i
				class="icon-submenu lnr lnr-chevron-left"></i></a> <s:if
					test="page=='page_create_link'||page=='page_list_link'">
					<div id="slink" class="collapse in">
				</s:if> <s:else>
					<div id="slink" class="collapse">
				</s:else>
				<ul class="nav">
					<!--  -->
					<li><s:if test="page=='page_create_link'">
							<a
								href="<%=basePath%>slink/link_page_create_link?page=page_create_link"
								class="active"> 添加链接</a>
						</s:if> <s:else>
							<a
								href="<%=basePath%>slink/link_page_create_link?page=page_create_link">
								添加链接</a>
						</s:else></li>
					<!--  -->
					<li><s:if test="page=='page_list_link'">
							<a
								href="<%=basePath%>slink/link_page_list_link?page=page_list_link&page_list_link.pageIndex=1"
								class="active">链接列表</a>
						</s:if> <s:else>
							<a
								href="<%=basePath%>slink/link_page_list_link?page=page_list_link&page_list_link.pageIndex=1">
								链接列表</a>
						</s:else></li>
					<!--  -->
				</ul>
		</div>
		</li>
		</s:if>


		<!---------------------------------------------------------------------------------------------------------------------------------->
		<%-- 			<li><a href="#"><i class="lnr lnr lnr-bubble"></i><span>留言管理</span></a> --%>
		<!-- 			</li> -->


		<!---------------------------------------------------------------------------------------------------------------------------------->
          <s:if test="#session.Admin.admin_premission_admin=='管理权限'">
               <li><s:if
							test="page=='page_create_admin'||page=='page_list_admin' ">
							<a href="#sadmin" data-toggle="collapse" class="active">
						</s:if> <s:else>
							<a href="#sadmin" data-toggle="collapse" class="collapsed">
						</s:else> <i class="lnr lnr lnr-user"></i><span>管理员管理</span> <i
						class="icon-submenu lnr lnr-chevron-left"></i></a> <s:if
							test="page=='page_create_admin'||page=='page_list_admin'">
							<div id="sadmin" class="collapse in">
						</s:if> <s:else>
							<div id="sadmin" class="collapse">
						</s:else>
						<ul class="nav">
							<!--  -->
							<li><s:if test="page=='page_create_admin'">
									<a
										href="<%=basePath%>sadmin/admin_page_create_admin?page=page_create_admin"
										class="active"> 添加管理员</a>
								</s:if> <s:else>
									<a
										href="<%=basePath%>sadmin/admin_page_create_admin?page=page_create_admin">
										添加管理员</a>
								</s:else></li>
							<!--  -->
							<li><s:if test="page=='page_list_admin'">
									<a
										href="<%=basePath%>sadmin/admin_page_list_admin?page=page_list_admin&page_list_admin.pageIndex=1"
										class="active">管理员列表</a>
								</s:if> <s:else>
									<a
										href="<%=basePath%>sadmin/admin_page_list_admin?page=page_list_admin&page_list_admin.pageIndex=1">
										管理员列表</a>
								</s:else></li>
							<!--  -->
						</ul>
			</div>
			</li>
			</s:if>
	<!---------------------------------------------------------------------------------------------------------------------------------->
	<%-- <li><s:if
			test="page=='page_restore_database'||page=='page_backup_database'">
			<a href="#database" data-toggle="collapse" class="active"><i
				class="lnr lnr lnr-database"></i><span>数据库管理</span><i
				class="icon-submenu lnr lnr-chevron-left"></i></a>
		</s:if> <s:else>
			<a href="#database" data-toggle="collapse" class="collapsed"><i
				class="lnr lnr lnr-database"></i><span>数据库管理</span><i
				class="icon-submenu lnr lnr-chevron-left"></i></a>
		</s:else> <s:if
			test="page=='page_restore_database'||page=='page_backup_database'">
			<div id="sadmin" class="collapse in">
		</s:if> <s:else>
			<div id="database" class="collapse ">
		</s:else>



		<ul class="nav">
			<li><s:if test="page=='page_backup_database'">
					<a
						href="${pageContext.request.contextPath }/sdatabase/sdatabase_page_backup_database"
						class="active">备份数据库</a>
				</s:if> <s:else>
					<a
						href="${pageContext.request.contextPath }/sdatabase/sdatabase_page_backup_database"
						class="">备份数据库</a>
				</s:else></li>
			<li><s:if test="page=='page_restore_database'">

					<a
						href="${pageContext.request.contextPath }/sdatabase/sdatabase_page_restore_database"
						class="active">数据库列表</a>

				</s:if> <s:else>
					<a
						href="${pageContext.request.contextPath }/sdatabase/sdatabase_page_restore_database">数据库列表</a>
				</s:else></li>

		</ul>
	</div>
	</li> --%>
<s:if test="#session.Admin.admin_account!=null">
	<li><a href="<%=basePath%>sadmin/admin_page_modified_personalPassword?page=page_modified_personalPassword"><i class="lnr lnr lnr-user"></i><span>修改个人密码</span></a>
	                </li>
	                </s:if>
			
	<!---------------------------------------------------------------------------------------------------------------------------------->
	<li><a href="<%=basePath%>suser/logout"><i class="lnr lnr-exit"></i><span>退出系统</span></a>
	</li>
	</ul>
	</div>
	</div>
	</div>
	<!--------------------------------------------------------------------------------------------->
	<!--------------------------------------------------------------------------------------------->
	<!--------------------------------------------------------------------------------------------->
	<div id="div_load"></div>
	<div id="cloth"></div>
	<!--------------------------------------------------------------------------------------------->
	<!--------------------------------------------------------------------------------------------->
	<!--------------------------------------------------------------------------------------------->
</body>
<script>
	$(document).ready(function() {
		$('input').iCheck({
			checkboxClass : 'icheckbox_flat-green',
			radioClass : 'iradio_flat-green'
		});
	});
</script>
</html>