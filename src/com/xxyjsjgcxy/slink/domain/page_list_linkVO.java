package com.xxyjsjgcxy.slink.domain;

import java.util.List;

import com.xxyjsjgcxy.snews.domain.NewsAndCategoryAndContentDTO;
import com.xxyjsjgcxy.snews.domain.SearchNewsListDTO;

public class page_list_linkVO {
	
	private int pageIndex = 1;
	
	private int totalRecords = 0;

	private int pageSize = 20;
	
	private int totalPages = 1;

	private boolean HavePrePage = false; 
	private boolean HaveNextPage = false; 
	private searchLinkListDTO search;

	private List<LinkDTO> linkDTOList;

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

	public searchLinkListDTO getSearch() {
		return search;
	}

	public void setSearch(searchLinkListDTO search) {
		this.search = search;
	}

	public List<LinkDTO> getLinkDTOList() {
		return linkDTOList;
	}

	public void setLinkDTOList(List<LinkDTO> linkDTOList) {
		this.linkDTOList = linkDTOList;
	}
}
