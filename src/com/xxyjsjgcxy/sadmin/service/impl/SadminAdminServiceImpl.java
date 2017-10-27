package com.xxyjsjgcxy.sadmin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.xxyjsjgcxy.sadmin.dao.SadminAdminDao;
import com.xxyjsjgcxy.sadmin.domain.AdminDTO;
import com.xxyjsjgcxy.sadmin.domain.jsj_sadmin_admin;
import com.xxyjsjgcxy.sadmin.domain.page_list_adminVO;
import com.xxyjsjgcxy.sadmin.service.SadminAdminService;

import util.TimeUtil;
import util.md5;

public class SadminAdminServiceImpl implements SadminAdminService {
	private SadminAdminDao sadminAdminDao;

	@Override
	public AdminDTO get_Admin_ByAdminID(jsj_sadmin_admin admin) {

		admin = sadminAdminDao.get_Admin_ByID(admin);

		AdminDTO adminDTO = new AdminDTO(admin);

		return adminDTO;
	}

	@Override
	public void updateAdmin(jsj_sadmin_admin admin) {
		// TODO Auto-generated method stub
		admin.setAdmin_gmt_modified(TimeUtil.getStringSecond());

		sadminAdminDao.updateAdmin(admin);
	}

	@Override
	public void removeAdminByID(jsj_sadmin_admin admin) {
		// TODO Auto-generated method stub
		admin = sadminAdminDao.get_Admin_ByID(admin);
		sadminAdminDao.removeLinkByID(admin);
	}

	@Override
	public boolean save_Admin(jsj_sadmin_admin admin) {
		// TODO Auto-generated method stub

		admin.setJsj_sadmin_admin_id(UUID.randomUUID().toString());

		admin.setAdmin_gmt_create(TimeUtil.getStringSecond());

		admin.setAdmin_gmt_modified(admin.getAdmin_gmt_create());

		admin.setAdmin_password(md5.GetMD5Code(admin.getAdmin_password()));

		sadminAdminDao.saveAdmin(admin);
		return true;

	}

	@Override
	public page_list_adminVO list_Admin_ByPage(page_list_adminVO page_list_admin) {
		// TODO Auto-generated method stub
		// List<jsj_sadmin_admin> adminList = new ArrayList<jsj_sadmin_admin>();

		// jsj_sadmin_admin adminvo;
		List<AdminDTO> adminDTOList = new ArrayList<AdminDTO>();

		AdminDTO adminDTO;
		List<jsj_sadmin_admin> adminList = sadminAdminDao.list_Admin_ByPage(page_list_admin);

		if (page_list_admin.getSearch() != null && !page_list_admin.getSearch().getName().equals("")) {

			int i = 0;
			while (i < adminList.size()) {

				adminList.get(i)
						.setAdmin_account(adminList.get(i).getAdmin_account().replaceAll(
								page_list_admin.getSearch().getName(), "<span style='color: #ff5063;'>"
										+ page_list_admin.getSearch().getName() + "</span>"));

				i++;
			}
		}

		// 灏佽鎬昏褰曟暟
		page_list_admin.setTotalRecords(sadminAdminDao.get_Admin_TotalRecords());
		// 灏佽鎬婚〉鏁�
		page_list_admin.setTotalPages(((page_list_admin.getTotalRecords() - 1) / page_list_admin.getPageSize()) + 1);

		if (page_list_admin.getPageIndex() <= 1) {
			page_list_admin.setHavePrePage(false);
		} else {
			page_list_admin.setHavePrePage(true);
		}
		if (page_list_admin.getPageIndex() >= page_list_admin.getTotalPages()) {
			page_list_admin.setHaveNextPage(false);
		} else {
			page_list_admin.setHaveNextPage(true);
		}

		for (jsj_sadmin_admin admin : adminList) {

			adminDTO = new AdminDTO(admin);

			adminDTOList.add(adminDTO);
		}

		page_list_admin.setAdminDTOList(adminDTOList);

		return page_list_admin;

	}

	public SadminAdminDao getSadminAdminDao() {
		return sadminAdminDao;
	}

	public void setSadminAdminDao(SadminAdminDao sadminAdminDao) {
		this.sadminAdminDao = sadminAdminDao;
	}

	@Override
	public List<AdminDTO> list_Admin_All() {
		// TODO Auto-generated method stub

		List<AdminDTO> adminDTOList = new ArrayList<AdminDTO>();

		AdminDTO adminDTO;

		List<jsj_sadmin_admin> adminList = sadminAdminDao.list_Admin_All();

		return adminDTOList;
	}

	@Override
	public String Adminlogin(String admin_account, String admin_password) {
		// TODO Auto-generated method stub
		jsj_sadmin_admin admin = sadminAdminDao.getAdminByAccount(admin_account);
		if (admin == null) {
			return "error";
		}
		if (!md5.GetMD5Code(admin_password).equals(admin.getAdmin_password())) {
			return "passerror";
		}
		return "success";
	}

	@Override
	public jsj_sadmin_admin getAdminByAccount(String admin_account) {
		// TODO Auto-generated method stub
		return sadminAdminDao.getAdminByAccount(admin_account);
	}

	@Override
	public void modifiedPassword(jsj_sadmin_admin admin) {
		// TODO Auto-generated method stub
		admin.setAdmin_gmt_modified(TimeUtil.getStringSecond());

		sadminAdminDao.modifiedPassword(admin);
	}

	@Override
	public void modifiedpersonalPassword(jsj_sadmin_admin admin) {
		// TODO Auto-generated method stub
		sadminAdminDao.modifiedpersonalPassword(admin);
	}

}
