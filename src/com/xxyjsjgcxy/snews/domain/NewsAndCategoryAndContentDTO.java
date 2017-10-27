package com.xxyjsjgcxy.snews.domain;

public class NewsAndCategoryAndContentDTO {

	private jsj_snews_news news;

	private jsj_snews_category category;

	private jsj_snews_content content;

	public NewsAndCategoryAndContentDTO(jsj_snews_news news, jsj_snews_category category, jsj_snews_content content) {

		this.news = news;
		this.category = category;
		this.content = content;
	}

	@Override
	public String toString() {
		return "NewsAndCategoryAndContentDTO [news=" + news + ", category=" + category + ", content=" + content + "]";
	}

	public jsj_snews_news getNews() {
		return news;
	}

	public void setNews(jsj_snews_news news) {
		this.news = news;
	}

	public jsj_snews_content getContent() {
		return content;
	}

	public void setContent(jsj_snews_content content) {
		this.content = content;
	}

	public jsj_snews_category getCategory() {
		return category;
	}

	public void setCategory(jsj_snews_category category) {
		this.category = category;
	}

}
