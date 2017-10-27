package com.xxyjsjgcxy.snews.domain;

public class jsj_snews_news {

	// 新闻ID
	private String jsj_snews_news_id;

	// 新闻标题
	private String news_title;

	// 新闻大图
	private String news_bimg;

	// 新闻小图
	private String news_simg;

	// 新闻附件
	private String news_annex = "";

	// 新闻附件
	private int news_num_annex;

	// 新闻关键词
	private String news_keywords;

	// 新闻类别
	private String news_category;

	// 新闻推荐
	private int news_recommend;

	// 新闻浏览次数
	private int news_browse;

	// 新闻来源
	private String news_source;

	// 新闻是否发布
	private int news_publish;

	// 新闻显示时间
	private String news_gmt_show;

	// 新闻创建时间
	private String news_gmt_create;

	// 新闻修改时间
	private String news_gmt_modified;

	public jsj_snews_news() {

	}

	public jsj_snews_news(String jsj_snews_news_id, String news_title, String news_bimg, String news_simg,
			String news_annex, int news_num_annex, String news_keywords, String news_category, int news_recommend,
			int news_browse, String news_source, int news_publish, String news_gmt_show, String news_gmt_create,
			String news_gmt_modified) {

		this.jsj_snews_news_id = jsj_snews_news_id;
		this.news_title = news_title;

		this.news_bimg = news_bimg;
		this.news_simg = news_simg;
		this.news_annex = news_annex;
		this.news_num_annex = news_num_annex;
		this.news_keywords = news_keywords;
		this.news_category = news_category;
		this.news_recommend = news_recommend;
		this.news_browse = news_browse;
		this.news_source = news_source;
		this.news_publish = news_publish;
		this.news_gmt_show = news_gmt_show;
		this.news_gmt_create = news_gmt_create;
		this.news_gmt_modified = news_gmt_modified;
	}

	@Override
	public String toString() {
		return "jsj_snews_news [jsj_snews_news_id=" + jsj_snews_news_id + ", news_title=" + news_title + ", news_bimg="
				+ news_bimg + ", news_simg=" + news_simg + ", news_annex=" + news_annex + ", news_num_annex="
				+ news_num_annex + ", news_keywords=" + news_keywords + ", news_category=" + news_category
				+ ", news_recommend=" + news_recommend + ", news_browse=" + news_browse + ", news_source=" + news_source
				+ ", news_publish=" + news_publish + ", news_gmt_show=" + news_gmt_show + ", news_gmt_create="
				+ news_gmt_create + ", news_gmt_modified=" + news_gmt_modified + "]";
	}

	public int getNews_num_annex() {
		return news_num_annex;
	}

	public void setNews_num_annex(int news_num_annex) {
		this.news_num_annex = news_num_annex;
	}

	public int getNews_recommend() {
		return news_recommend;
	}

	public void setNews_recommend(int news_recommend) {
		this.news_recommend = news_recommend;
	}

	public int getNews_publish() {
		return news_publish;
	}

	public void setNews_publish(int news_publish) {
		this.news_publish = news_publish;
	}

	public String getJsj_snews_news_id() {
		return jsj_snews_news_id;
	}

	public void setJsj_snews_news_id(String jsj_snews_news_id) {
		this.jsj_snews_news_id = jsj_snews_news_id;
	}

	public String getNews_title() {
		return news_title;
	}

	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}

	public String getNews_bimg() {
		return news_bimg;
	}

	public void setNews_bimg(String news_bimg) {
		this.news_bimg = news_bimg;
	}

	public String getNews_simg() {
		return news_simg;
	}

	public void setNews_simg(String news_simg) {
		this.news_simg = news_simg;
	}

	public String getNews_annex() {
		return news_annex;
	}

	public void setNews_annex(String news_annex) {
		this.news_annex = news_annex;
	}

	public String getNews_keywords() {
		return news_keywords;
	}

	public void setNews_keywords(String news_keywords) {
		this.news_keywords = news_keywords;
	}

	public String getNews_category() {
		return news_category;
	}

	public void setNews_category(String news_category) {
		this.news_category = news_category;
	}

	public int getNews_browse() {
		return news_browse;
	}

	public void setNews_browse(int news_browse) {
		this.news_browse = news_browse;
	}

	public String getNews_source() {
		return news_source;
	}

	public void setNews_source(String news_source) {
		this.news_source = news_source;
	}

	public String getNews_gmt_create() {
		return news_gmt_create;
	}

	public void setNews_gmt_create(String news_gmt_create) {
		this.news_gmt_create = news_gmt_create;
	}

	public String getNews_gmt_modified() {
		return news_gmt_modified;
	}

	public void setNews_gmt_modified(String news_gmt_modified) {
		this.news_gmt_modified = news_gmt_modified;
	}

	public String getNews_gmt_show() {
		return news_gmt_show;
	}

	public void setNews_gmt_show(String news_gmt_show) {
		this.news_gmt_show = news_gmt_show;
	}

}
