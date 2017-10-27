package com.xxyjsjgcxy.sadmin.service;

import java.util.List;

import com.xxyjsjgcxy.sadmin.domain.AdminDTO;
import com.xxyjsjgcxy.sadmin.domain.jsj_sadmin_admin;
import com.xxyjsjgcxy.sadmin.domain.page_list_adminVO;

public interface SadminAdminService {

	public AdminDTO get_Admin_ByAdminID(jsj_sadmin_admin admin);

	public void updateAdmin(jsj_sadmin_admin oldAdminvo);

	public void removeAdminByID(jsj_sadmin_admin admin);

	public boolean save_Admin(jsj_sadmin_admin admin);

	public page_list_adminVO list_Admin_ByPage(page_list_adminVO page_list_admin);

	public List<AdminDTO> list_Admin_All();

	public String Adminlogin(String admin_account, String admin_password);

	public void modifiedPassword(jsj_sadmin_admin admin);

	jsj_sadmin_admin getAdminByAccount(String admin_account);

	public void modifiedpersonalPassword(jsj_sadmin_admin admin);

}
