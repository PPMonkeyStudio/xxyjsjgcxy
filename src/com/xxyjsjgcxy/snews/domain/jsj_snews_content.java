package com.xxyjsjgcxy.snews.domain;

public class jsj_snews_content {
	// �������ݱ��
	private String jsj_snews_content_id;
	// ������������
	private String content_news;
	// ��������
	private String content_text;
	// �������ļ�¼����ʱ��
	private String content_gmt_create;
	// ���ݼ�¼�޸�ʱ��
	private String content_gmt_modified;

	@Override
	public String toString() {
		return "jsj_snews_content [jsj_snews_content_id=" + jsj_snews_content_id + ", content_news=" + content_news
				+ ", content_text=" + content_text + ", content_gmt_create=" + content_gmt_create
				+ ", content_gmt_modified=" + content_gmt_modified + "]";
	}

	public String getJsj_snews_content_id() {
		return jsj_snews_content_id;
	}

	public void setJsj_snews_content_id(String jsj_snews_content_id) {
		this.jsj_snews_content_id = jsj_snews_content_id;
	}

	public String getContent_news() {
		return content_news;
	}

	public void setContent_news(String content_news) {
		this.content_news = content_news;
	}

	public String getContent_text() {
		return content_text;
	}

	public void setContent_text(String content_text) {
		this.content_text = content_text;
	}

	public String getContent_gmt_create() {
		return content_gmt_create;
	}

	public void setContent_gmt_create(String content_gmt_create) {
		this.content_gmt_create = content_gmt_create;
	}

	public String getContent_gmt_modified() {
		return content_gmt_modified;
	}

	public void setContent_gmt_modified(String content_gmt_modified) {
		this.content_gmt_modified = content_gmt_modified;
	}

}
