package com.xxyjsjgcxy.suser.domain;

import java.util.List;

import com.xxyjsjgcxy.snews.domain.NewsAndCategoryAndContentDTO;

public class DetailsVO {

	// ��������
	private NewsAndCategoryAndContentDTO newsCategoryContent;

	// �������
	private List<NewsAndCategoryAndContentDTO> relateNews;
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public NewsAndCategoryAndContentDTO getNewsCategoryContent() {
		return newsCategoryContent;
	}

	public List<NewsAndCategoryAndContentDTO> getRelateNews() {
		return relateNews;
	}

	public void setRelateNews(List<NewsAndCategoryAndContentDTO> relateNews) {
		this.relateNews = relateNews;
	}

	public void setNewsCategoryContent(NewsAndCategoryAndContentDTO newsCategoryContent) {
		this.newsCategoryContent = newsCategoryContent;
	}

}
