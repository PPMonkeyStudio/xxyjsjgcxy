package com.xxyjsjgcxy.snews.domain;

import java.util.List;

public class page_list_newsVO {
	/*
	 * 
	 */
	// 需要显示的页码
	private int pageIndex = 1;
	// 总记录数
	private int totalRecords = 0;
	// 每页记录数
	private int pageSize = 20;
	// 总页数
	private int totalPages = 1;

	private boolean HavePrePage = false; // 是否有上一页
	private boolean HaveNextPage = false; // 是否有下一页

	private SearchNewsListDTO search;

	private List<NewsAndCategoryAndContentDTO> newsAndCategoryAndContentDTOList;

	/*
	 * 
	 */

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

	public SearchNewsListDTO getSearch() {
		return search;
	}

	public void setSearch(SearchNewsListDTO search) {
		this.search = search;
	}

	public List<NewsAndCategoryAndContentDTO> getNewsAndCategoryAndContentDTOList() {
		return newsAndCategoryAndContentDTOList;
	}

	public void setNewsAndCategoryAndContentDTOList(
			List<NewsAndCategoryAndContentDTO> newsAndCategoryAndContentDTOList) {
		this.newsAndCategoryAndContentDTOList = newsAndCategoryAndContentDTOList;
	}

	/*
	 * 
	 */

}
