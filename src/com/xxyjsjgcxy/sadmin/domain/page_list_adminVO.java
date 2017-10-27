package com.xxyjsjgcxy.sadmin.domain;

import java.util.List;

public class page_list_adminVO {

	private int pageIndex = 1;

	private int totalRecords = 0;

	private int pageSize = 20;

	private int totalPages = 1;

	private boolean HavePrePage = false;
	private boolean HaveNextPage = false;
	private searchAdminListDTO search;

	private List<AdminDTO> adminDTOList;

	private List<jsj_sadmin_admin> adminList;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isHavePrePage() {
		return HavePrePage;
	}

	public void setHavePrePage(boolean havePrePage) {
		HavePrePage = havePrePage;
	}

	public boolean isHaveNextPage() {
		return HaveNextPage;
	}

	public void setHaveNextPage(boolean haveNextPage) {
		HaveNextPage = haveNextPage;
	}

	public searchAdminListDTO getSearch() {
		return search;
	}

	public void setSearch(searchAdminListDTO search) {
		this.search = search;
	}

	public List<jsj_sadmin_admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<jsj_sadmin_admin> adminList) {
		this.adminList = adminList;
	}

	public List<AdminDTO> getAdminDTOList() {
		return adminDTOList;
	}

	public void setAdminDTOList(List<AdminDTO> adminDTOList) {
		this.adminDTOList = adminDTOList;
	}

}
