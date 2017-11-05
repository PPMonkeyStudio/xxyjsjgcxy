package com.xxyjsjgcxy.sadmin.action;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xxyjsjgcxy.sadmin.domain.AdminDTO;
import com.xxyjsjgcxy.sadmin.domain.jsj_sadmin_admin;
import com.xxyjsjgcxy.sadmin.domain.page_list_adminVO;
import com.xxyjsjgcxy.sadmin.domain.searchAdminListDTO;
import com.xxyjsjgcxy.sadmin.service.SadminAdminService;

import util.TimeUtil;
import util.md5;

public class SadminAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {

	private SadminAdminService sadminAdminService;

	private page_list_adminVO page_list_admin;

	private jsj_sadmin_admin admin;

	private String page;

	private String option;

	private searchAdminListDTO searchAdminList;

	private HttpServletResponse http_response;

	private HttpServletRequest http_request;

	private String admin_password;

	private String admin_account;

	HttpServletRequest request = ServletActionContext.getRequest();

	HttpServletResponse response = ServletActionContext.getResponse();

	public String page_create_admin() {

		ActionContext.getContext().getValueStack().set("page", page);

		return "page_create_admin";
	}

	public String page_modified_personalPassword() {

		ActionContext.getContext().getValueStack().set("page", page);

		return "page_modified_personalPassword";
	}

	/*
	 * 閺囧瓨鏌婃い鐢告桨
	 */
	public String updateAdminPage() {

		AdminDTO adminDTO = sadminAdminService.get_Admin_ByAdminID(admin);

		ActionContext.getContext().getValueStack().set("adminDTO", adminDTO);

		ActionContext.getContext().getValueStack().set("option", "update");

		ActionContext.getContext().getValueStack().set("page", "page_create_admin");

		return "updateAdminPage";

	}

	public String updateAdminPasswordPage() {

		AdminDTO adminDTO = sadminAdminService.get_Admin_ByAdminID(admin);

		ActionContext.getContext().getValueStack().set("adminDTO", adminDTO);

		ActionContext.getContext().getValueStack().set("option", "updatepw");

		ActionContext.getContext().getValueStack().set("page", "page_modified_password");

		return "updateAdminPasswordPage";

	}

	public void deleteAdmin() {
		sadminAdminService.removeAdminByID(admin);
		System.out.println(admin.getAdmin_account());
		System.out.println(admin.getJsj_sadmin_admin_id());
		try {

			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write("success");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void getAdminUUID() {
		String adminUUID = UUID.randomUUID().toString();
		try {
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write(adminUUID);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void updateAdmin() {
		System.out.println("a");
		System.out.println("-----------------------------updateAdmin-------------------------------");

		AdminDTO oldAdminDTO = sadminAdminService.get_Admin_ByAdminID(admin);
		System.out.println(oldAdminDTO.toString());
		if (sadminAdminService.getAdminByAccount(admin.getAdmin_account()) == null
				|| oldAdminDTO.getAdmin().getAdmin_account().equals(admin.getAdmin_account())) {
			oldAdminDTO.getAdmin().setAdmin_account(admin.getAdmin_account());
			// oldAdminDTO.getAdmin().setAdmin_password(
			// md5.GetMD5Code(admin.getAdmin_password()));
			oldAdminDTO.getAdmin().setAdmin_premission_admin(admin.getAdmin_premission_admin());
			oldAdminDTO.getAdmin().setAdmin_premission_scarousel(admin.getAdmin_premission_scarousel());
			oldAdminDTO.getAdmin().setAdmin_premission_snews(admin.getAdmin_premission_snews());
			oldAdminDTO.getAdmin().setAdmin_premission_slink(admin.getAdmin_premission_slink());

			oldAdminDTO.getAdmin().setAdmin_gmt_modified(TimeUtil.getStringSecond());
			sadminAdminService.updateAdmin(oldAdminDTO.getAdmin());

			try {
				request.getSession();
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("1");
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
			System.out.println("a" + admin.getAdmin_account());
			try {
				request.getSession();
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("0");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	/*
	 * 闁插秶鐤嗙�靛棛鐖�
	 */
	public void modifiedPassword() {
		AdminDTO oldAdminDTO = sadminAdminService.get_Admin_ByAdminID(admin);
		oldAdminDTO.getAdmin().setAdmin_password(md5.GetMD5Code(admin.getAdmin_password()));
		System.out.println(admin.getAdmin_password());
		oldAdminDTO.getAdmin().setAdmin_gmt_modified(TimeUtil.getStringSecond());
		sadminAdminService.modifiedPassword(oldAdminDTO.getAdmin());

	}

	/*
	 * 娣囶喗鏁兼稉顏冩眽鐎靛棛鐖�
	 */
	public void modifiedpersonalPassword() {

		String pw = (String) ActionContext.getContext().getSession().get("Adminpw");
		if (admin.getAdmin_password().equals(pw)) {

			try {
				request.getSession();
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("1");
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {

			try {
				request.getSession();
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("0");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void modified() {
		AdminDTO oldAdminDTO = sadminAdminService.get_Admin_ByAdminID(admin);

		oldAdminDTO.getAdmin().setAdmin_password(md5.GetMD5Code(admin.getAdmin_password()));

		sadminAdminService.modifiedpersonalPassword(oldAdminDTO.getAdmin());
		try {
			request.getSession();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("1");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void saveAdmin() {

		if ((sadminAdminService.getAdminByAccount(admin.getAdmin_account())) == null) {

			sadminAdminService.save_Admin(admin);
			try {
				request.getSession();
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("1");
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {

			try {
				request.getSession();
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("0");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public String page_list_admin() {

		if (searchAdminList != null) {

			page_list_admin.setSearch(searchAdminList);

		}

		page_list_admin = sadminAdminService.list_Admin_ByPage(page_list_admin);

		ActionContext.getContext().getValueStack().set("page_list_admin", page_list_admin);

		ActionContext.getContext().getValueStack().set("page", "page_list_admin");

		return "page_list_admin";
	}

	public void Adminlogin() {
		String result = sadminAdminService.Adminlogin(admin_account, admin_password);

		if (!"error".equals(result) || !"passerror".equals(result)) {
			// 鐎涙ɑ鏂佺粻锛勬倞閸涙Ξession 缁狅紕鎮婇崨妯垮閸欐灚锟戒胶顓搁悶鍡楁喅鐎靛棛鐖�
			ActionContext.getContext().getSession().put("Admin", sadminAdminService.getAdminByAccount(admin_account));
			ActionContext.getContext().getSession().put("Adminpw", admin_password);
		}
		// 鏉╂柨娲栫紒娆忣吂閹撮顏�
		try {
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write("{\"result\":\"" + result + "\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getMd5Pass() {
		System.out.println("getMd5Pass");
		// 鏉╂柨娲栫紒娆忣吂閹撮顏�
		try {
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter()
					.write("{\"pass\":\"" + md5.GetMD5Code(admin_password) + "\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SadminAdminService getSadminAdminService() {
		return sadminAdminService;
	}

	public void setSadminAdminService(SadminAdminService sadminAdminService) {
		this.sadminAdminService = sadminAdminService;
	}

	public page_list_adminVO getPage_list_admin() {
		return page_list_admin;
	}

	public void setPage_list_admin(page_list_adminVO page_list_admin) {
		this.page_list_admin = page_list_admin;
	}

	public jsj_sadmin_admin getAdmin() {
		return admin;
	}

	public void setAdmin(jsj_sadmin_admin admin) {
		this.admin = admin;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public String getAdmin_account() {
		return admin_account;
	}

	public void setAdmin_account(String admin_account) {
		this.admin_account = admin_account;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public searchAdminListDTO getSearchAdminList() {
		return searchAdminList;
	}

	public void setSearchAdminList(searchAdminListDTO searchAdminList) {
		this.searchAdminList = searchAdminList;
	}

	public HttpServletResponse getHttp_response() {
		return http_response;
	}

	public void setHttp_response(HttpServletResponse http_response) {
		this.http_response = http_response;
	}

	public HttpServletRequest getHttp_request() {
		return http_request;
	}

	public void setHttp_request(HttpServletRequest http_request) {
		this.http_request = http_request;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub

	}

}
