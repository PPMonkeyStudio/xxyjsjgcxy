package com.xxyjsjgcxy.snews.domain;

public class jsj_snews_category {

	// �������ID
	private String jsj_snews_category_id;

	// �����������
	private String category_name;

	// �������ȼ�
	private int category_rank;

	// ��������
	private Integer category_sqrt;

	// ��������Ƿ���ʾ,1��0��
	private int category_show;

	// �������ļ��
	private String category_Introduction;

	// ��������ͼƬ
	private String category_img;

	// ��������ָ������
	private String category_news;

	// �������ĸ����
	private String category_father;

	// ������𴴽�ʱ��
	private String category_gmt_create;

	// ��������޸�ʱ��
	private String category_gmt_modified;

	public Integer getCategory_sqrt() {
		return category_sqrt;
	}

	public void setCategory_sqrt(Integer category_sqrt) {
		this.category_sqrt = category_sqrt;
	}

	public String getJsj_snews_category_id() {
		return jsj_snews_category_id;
	}

	public String getCategory_Introduction() {
		return category_Introduction;
	}

	public void setCategory_Introduction(String category_Introduction) {
		this.category_Introduction = category_Introduction;
	}

	public void setJsj_snews_category_id(String jsj_snews_category_id) {
		this.jsj_snews_category_id = jsj_snews_category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getCategory_rank() {
		return category_rank;
	}

	public void setCategory_rank(int category_rank) {
		this.category_rank = category_rank;
	}

	public int getCategory_show() {
		return category_show;
	}

	public void setCategory_show(int category_show) {
		this.category_show = category_show;
	}

	public String getCategory_img() {
		return category_img;
	}

	public void setCategory_img(String category_img) {
		this.category_img = category_img;
	}

	public String getCategory_news() {
		return category_news;
	}

	public void setCategory_news(String category_news) {
		this.category_news = category_news;
	}

	public String getCategory_father() {
		return category_father;
	}

	public void setCategory_father(String category_father) {
		this.category_father = category_father;
	}

	public String getCategory_gmt_create() {
		return category_gmt_create;
	}

	public void setCategory_gmt_create(String category_gmt_create) {
		this.category_gmt_create = category_gmt_create;
	}

	public String getCategory_gmt_modified() {
		return category_gmt_modified;
	}

	public void setCategory_gmt_modified(String category_gmt_modified) {
		this.category_gmt_modified = category_gmt_modified;
	}

}
