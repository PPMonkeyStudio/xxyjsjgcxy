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
	src="<%=basePath%>js/snews/page_list_category.js"></script>
<!---------------------------------------------------------------------------------------------------->
<title>新闻类别</title>
</head>
<body>
	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div style="margin: 0 0 0 260px; width: calc(100% - 260px);">
		<!-- 内容写在此处 -->
		<div style="width: 100%; height: 50px; margin: 100px 0 0 0;">
			<button class="btn btn-primary"
				style="margin: 0 10% 0 0; float: right;"
				onclick="window.location='<%=basePath%>snews/category_page_create_category?page=page_create_category&option=new&category.category_rank=1&category.category_father=0'">创建一级类别</button>
		</div>

		<!---------------------------------------------------------------------------->
		<div style="width: 80%; margin: 0 0 100px 10%;">
			<hr
				style="width: 100%; height: 0px; border: 2px solid #eeeeee; margin: 0;">
			<!---------------------------------------------------------------------------->

			<s:iterator value="categoryListDTO" var="CL">
				<div style="height: 50px;">
					<i class="lnr lnr-bookmark"
						style="color: #1abc9c; font-weight: bold; margin: 0 5px 0 0; font-size: 20px;"></i>
					<%--  --%>
					<span style="line-height: 50px;"><s:property
							value="#CL.category.category_name" /></span>
					<!--  -->

					<div style="width: auto; float: right; margin: 0 0 0 20px;">
						<s:if test="#CL.category.category_show == '1'.toString()">
							<input type="checkbox" checked="checked"
								id="checkbox_<s:property
							value="#CL.category.jsj_snews_category_id" />">
						</s:if>
						<s:else>
							<input type="checkbox"
								id="checkbox_<s:property
							value="#CL.category.jsj_snews_category_id" />">
						</s:else>
						<label style="margin: 15px 0 0 0; cursor: pointer;"
							for="checkbox_<s:property
							value="#CL.category.jsj_snews_category_id" />">显示</label>
						<!--  -->
					</div>
					<!--  -->
					<button class="btn btn-danger"
						id="<s:property
							value="#CL.category.jsj_snews_category_id" />"
						style="margin: 8px 5px; float: right;" data-toggle="modal"
						data-target="#model_delete_category"
						onclick="javascript:delete_category_id=this.id;">删除</button>
					<!--  -->
					<button class="btn btn-warning"
						style="margin: 8px 5px; float: right;"
						onclick="window.location='<%=basePath%>snews/category_page_create_category?page=page_create_category&option=update&category.jsj_snews_category_id=<s:property
							value="#CL.category.jsj_snews_category_id" />'">修改</button>
					<!--  -->

					<!--  -->
					<button class="btn btn-success"
						style="margin: 8px 5px; float: right;"
						onclick="window.location='<%=basePath%>snews/category_page_create_category?page=page_create_category&option=new&category.category_rank=2&category.category_father=<s:property
							value="#CL.category.jsj_snews_category_id" />'">创建子类别</button>
					<div class="form-control"
						style="width: 100px; float: right; margin: 8px 5px; text-align: center;">
						排序：
						<s:property value="#CL.category.category_sqrt" />
					</div>
				</div>
				<!---------------------------->
				<s:iterator value="#CL.sonCategoryList" var="SCL">
					<div style="height: 50px; margin: 0 0 0 80px;">
						<span style="line-height: 50px;"><s:property
								value="#SCL.category_name" /></span>
						<div style="width: 75px; float: right; height: 100%;"></div>
						<!--  -->
						<!-- 						<div style="width: auto; float: right; margin: 0 0 0 20px;"> -->
						<%-- 							<s:if test="#SCL.category_show == '1'.toString()"> --%>
						<!-- 								<input type="checkbox" checked="checked" -->
						<%-- 									id="checkbox_<s:property --%>
						<%-- 							value="#SCL.jsj_snews_category_id" />"> --%>
						<%-- 							</s:if> --%>
						<%-- 							<s:else> --%>
						<!-- 								<input type="checkbox" -->
						<%-- 									id="checkbox_<s:property --%>
						<%-- 							value="#SCL.jsj_snews_category_id" />"> --%>
						<%-- 							</s:else> --%>
						<!-- 							<label style="margin: 15px 0 0 0px; cursor: pointer;" -->
						<%-- 								for="checkbox_<s:property --%>
						<%-- 														value="#SCL.jsj_snews_category_id" />">显示</label> --%>
						<!-- 						</div> -->
						<!--  -->
						<button class="btn btn-danger" data-toggle="modal"
							data-target="#model_delete_category"
							id="<s:property
							value="#SCL.jsj_snews_category_id" />"
							style="margin: 8px 5px; float: right;"
							onclick="javascript:delete_category_id=this.id;">删除</button>
						<!--  -->
						<button class="btn btn-warning"
							style="margin: 8px 5px; float: right;"
							onclick="window.location='<%=basePath%>snews/category_page_create_category?page=page_create_category&option=update&category.jsj_snews_category_id=<s:property
							value="#SCL.jsj_snews_category_id" />'">修改</button>
						<!--  -->
					</div>
				</s:iterator>
				<hr
					style="width: 100%; height: 0px; border: 2px solid #eeeeee; margin: 0;">
				<!---------------------------->
			</s:iterator>
		</div>
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->


	<div class="modal fade" id="model_delete_category">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">确认信息</h4>
				</div>
				<div class="modal-body">
					<h4 id="h4_delete">删除此类别，将删除此类别的所有子类别，并将此类别和子类别所属新闻的类别置为空。</h4>
				</div>
				<div class="modal-footer">
					<button class="btn btn-danger" onclick="delete_category()">删除</button>
					<button class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
</body>
<script type="text/javascript">
	
$('input').on('ifChanged', function(event){
	update_category_show(event.target);
	});

function update_category_show(checkbox){
	
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				
				if(xhr.responseText=='success'){
					toastr.success("修改成功");
				}else{
					toastr.error("修改失败");
				}
				
			} else {
				toastr.error(xhr.status);
			}
		}
	}
	
	xhr.open("POST", "/xxyjsjgcxy/snews/category_update_category_show");
	
	if(checkbox.checked){
		var category_show=1;
	}else{
		var category_show=0;
	}
	var formData = new FormData();
	
	formData.append("category.jsj_snews_category_id",checkbox.id.substring(9));
	formData.append("category.category_show",category_show);
	
	xhr.send(formData);
}

</script>
</html>