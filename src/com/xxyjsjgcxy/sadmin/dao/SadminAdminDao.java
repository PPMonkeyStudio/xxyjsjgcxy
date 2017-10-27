package com.xxyjsjgcxy.sadmin.dao;

import java.util.List;

import com.xxyjsjgcxy.sadmin.domain.jsj_sadmin_admin;
import com.xxyjsjgcxy.sadmin.domain.page_list_adminVO;

public interface SadminAdminDao {

	public jsj_sadmin_admin get_Admin_ByID(jsj_sadmin_admin admin);

	public void updateAdmin(jsj_sadmin_admin oldAdminvo);

	public void removeLinkByID(jsj_sadmin_admin admin);

	public boolean saveAdmin(jsj_sadmin_admin admin);

	public List<jsj_sadmin_admin> list_Admin_ByPage(page_list_adminVO page_list_admin);

	public int get_Admin_TotalRecords();

	public List<jsj_sadmin_admin> list_Admin_All();

	public jsj_sadmin_admin getAdminByAccount(String admin_account);

	public boolean getAdminByAccount(boolean b);

	public void modifiedPassword(jsj_sadmin_admin admin);

	public void modifiedpersonalPassword(jsj_sadmin_admin admin);

}
