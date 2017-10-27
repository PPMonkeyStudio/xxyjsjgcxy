package com.xxyjsjgcxy.suser.domain;

import java.util.List;

import com.xxyjsjgcxy.snews.domain.NewsAndCategoryAndContentDTO;

public class ListVO {

	// ��Ҫ��ʾ��ҳ��
	private int pageIndex = 1;

	// �ܼ�¼��
	private int totalRecords = 0;

	// ÿҳ��¼��
	private int pageSize = 10;

	// ��ҳ��
	private int totalPages = 1;

	private boolean HavePrePage = false; // �Ƿ�����һҳ
	private boolean HaveNextPage = false; // �Ƿ�����һҳ

	// 1Ϊ�Ƽ���ѧԺҪ��
	private String category = null;// ���

	private String search = null;// ����

	private String date = null;// ����

	// ʮ������
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
