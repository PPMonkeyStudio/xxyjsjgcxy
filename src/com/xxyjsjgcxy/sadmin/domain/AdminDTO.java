package com.xxyjsjgcxy.sadmin.domain;

public class AdminDTO {
	private jsj_sadmin_admin admin;

	public AdminDTO(jsj_sadmin_admin admin) {

		this.admin = admin;
	}

	@Override
	public String toString() {
		return "AdminDTO [admin=" + admin + "]";
	}

	public jsj_sadmin_admin getAdmin() {
		return admin;
	}

	public void setAdmin(jsj_sadmin_admin admin) {
		this.admin = admin;
	}

}
