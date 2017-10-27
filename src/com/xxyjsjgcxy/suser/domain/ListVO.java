package com.xxyjsjgcxy.suser.domain;

import java.util.List;

import com.xxyjsjgcxy.snews.domain.NewsAndCategoryAndContentDTO;

public class ListVO {

	// 需要显示的页码
	private int pageIndex = 1;

	// 总记录数
	private int totalRecords = 0;

	// 每页记录数
	private int pageSize = 10;

	// 总页数
	private int totalPages = 1;

	private boolean HavePrePage = false; // 是否有上一页
	private boolean HaveNextPage = false; // 是否有下一页

	// 1为推荐的学院要闻
	private String category = null;// 类别

	private String search = null;// 搜索

	private String date = null;// 日期

	// 十个新闻
	private List<NewsAndCategoryAndContentDTO> listNews;

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public int getPageIndex() {
		return pageIndex;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public List<NewsAndCategoryAndContentDTO> getListNews() {
		return listNews;
	}

	public void setListNews(List<NewsAndCategoryAndContentDTO> listNews) {
		this.listNews = listNews;
	}

}
