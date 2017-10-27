package com.xxyjsjgcxy.suser.domain;

import java.util.List;

import com.xxyjsjgcxy.snews.domain.NewsAndCategoryAndContentDTO;

public class DetailsVO {

	// 新闻详情
	private NewsAndCategoryAndContentDTO newsCategoryContent;

	// 相关新闻
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
