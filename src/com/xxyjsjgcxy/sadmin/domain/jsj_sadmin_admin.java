package com.xxyjsjgcxy.sadmin.domain;

public class jsj_sadmin_admin {
	// 管理员Id
	private String jsj_sadmin_admin_id;
	// 管理员账号
	private String admin_account;
	// 管理员密码
	private String admin_password;
	// 管理员管理权限
	private String admin_premission_admin;
	// 轮播图管理权限
	private String admin_premission_scarousel;
	// 新闻管理权限
	private String admin_premission_snews;
	// 链接管理权限
	private String admin_premission_slink;

	// 创建时间
	private String admin_gmt_create;
	// 修改时间
	private String admin_gmt_modified;

	public jsj_sadmin_admin() {

	}

	public jsj_sadmin_admin(String jsj_sadmin_admin_id, String admin_account, String admin_password,
			String admin_premission_admin, String admin_premission_scarousel, String admin_premission_snews,
			String admin_premission_slink, String admin_gmt_create, String admin_gmt_modified) {
		super();
		this.jsj_sadmin_admin_id = jsj_sadmin_admin_id;
		this.admin_account = admin_account;
		this.admin_password = admin_password;
		this.admin_premission_admin = admin_premission_admin;
		this.admin_premission_scarousel = admin_premission_scarousel;
		this.admin_premission_snews = admin_premission_snews;
		this.admin_premission_slink = admin_premission_slink;
		this.admin_gmt_create = admin_gmt_create;
		this.admin_gmt_modified = admin_gmt_modified;
	}

	@Override
	public String toString() {
		return "jsj_sadmin_admin [jsj_sadmin_admin_id=" + jsj_sadmin_admin_id + ", admin_account=" + admin_account
				+ ", admin_password=" + admin_password + ", admin_premission_admin=" + admin_premission_admin
				+ ", admin_premission_scarousel=" + admin_premission_scarousel + ", admin_premission_snews="
				+ admin_premission_snews + ", admin_premission_slink=" + admin_premission_slink + ", admin_gmt_create="
				+ admin_gmt_create + ", admin_gmt_modified=" + admin_gmt_modified + "]";
	}

	public String getJsj_sadmin_admin_id() {
		return jsj_sadmin_admin_id;
	}

	public void setJsj_sadmin_admin_id(String jsj_sadmin_admin_id) {
		this.jsj_sadmin_admin_id = jsj_sadmin_admin_id;
	}

	public String getAdmin_account() {
		return admin_account;
	}

	public void setAdmin_account(String admin_account) {
		this.admin_account = admin_account;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public String getAdmin_premission_admin() {
		return admin_premission_admin;
	}

	public void setAdmin_premission_admin(String admin_premission_admin) {
		this.admin_premission_admin = admin_premission_admin;
	}

	public String getAdmin_premission_scarousel() {
		return admin_premission_scarousel;
	}

	public void setAdmin_premission_scarousel(String admin_premission_scarousel) {
		this.admin_premission_scarousel = admin_premission_scarousel;
	}

	public String getAdmin_premission_snews() {
		return admin_premission_snews;
	}

	public void setAdmin_premission_snews(String admin_premission_snews) {
		this.admin_premission_snews = admin_premission_snews;
	}

	public String getAdmin_premission_slink() {
		return admin_premission_slink;
	}

	public void setAdmin_premission_slink(String admin_premission_slink) {
		this.admin_premission_slink = admin_premission_slink;
	}

	public String getAdmin_gmt_create() {
		return admin_gmt_create;
	}

	public void setAdmin_gmt_create(String admin_gmt_create) {
		this.admin_gmt_create = admin_gmt_create;
	}

	public String getAdmin_gmt_modified() {
		return admin_gmt_modified;
	}

	public void setAdmin_gmt_modified(String admin_gmt_modified) {
		this.admin_gmt_modified = admin_gmt_modified;
	}

}
