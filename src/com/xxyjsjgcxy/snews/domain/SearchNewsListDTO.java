package com.xxyjsjgcxy.snews.domain;

public class SearchNewsListDTO {
	//
	private int publish;
	private int recommend;
	private String category = "%%";
	//
	private String start_time = "0000-00-00";
	private String stop_time = "9999-99-99";
	private String keywords;
	//
	private String sqrt = "news_gmt_create";
	private String sqrt_sc = "desc";

	/*
	 * 
	 */

	@Override
	public String toString() {
		return "searchNewsListDTO [publish=" + publish + ", recommend=" + recommend + ", category=" + category
				+ ", start_time=" + start_time + ", stop_time=" + stop_time + ", keywords=" + keywords + ", sqrt="
				+ sqrt + ", sqrt_sc=" + sqrt_sc + "]";
	}

	public int getRecommend() {
		return recommend;
	}

	public int getPublish() {
		return publish;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPublish(int publish) {
		this.publish = publish;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getStop_time() {
		return stop_time;
	}

	public void setStop_time(String stop_time) {
		this.stop_time = stop_time;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getSqrt() {
		return sqrt;
	}

	public void setSqrt(String sqrt) {
		this.sqrt = sqrt;
	}

	public String getSqrt_sc() {
		return sqrt_sc;
	}

	public void setSqrt_sc(String sqrt_sc) {
		this.sqrt_sc = sqrt_sc;
	}

}
