package com.xxyjsjgcxy.snews.domain;

import java.util.List;

public class page_list_newsVO {
	/*
	 * 
	 */
	// ��Ҫ��ʾ��ҳ��
	private int pageIndex = 1;
	// �ܼ�¼��
	private int totalRecords = 0;
	// ÿҳ��¼��
	private int pageSize = 20;
	// ��ҳ��
	private int totalPages = 1;

	private boolean HavePrePage = false; // �Ƿ�����һҳ
	private boolean HaveNextPage = false; // �Ƿ�����һҳ

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
