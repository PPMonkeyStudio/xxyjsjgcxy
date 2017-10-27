package com.xxyjsjgcxy.slink.domain;

public class jsj_slink_link {

	// 链接ID
	private String jsj_slink_link_id;
	// 链接名
	private String link_name;
	// 链接URL
	private String link_url;

	// 创建时间
	private String link_gmt_create;
	// 修改时间
	private String link_gmt_modified;

	public jsj_slink_link() {

	}

	public jsj_slink_link(String jsj_slink_link_id, String link_name,
			String link_url, String link_gmt_create, String link_gmt_modified) {

		this.jsj_slink_link_id = jsj_slink_link_id;
		this.link_name = link_name;
		this.link_url = link_url;
		this.link_gmt_create = link_gmt_create;
		this.link_gmt_modified = link_gmt_modified;
	}

	@Override
	public String toString() {
		return "jsj_slink_link [jsj_slink_link_id=" + jsj_slink_link_id
				+ ", link_name=" + link_name + ", link_url=" + link_url
				+ ", link_gmt_create=" + link_gmt_create
				+ ", link_gmt_modified=" + link_gmt_modified + "]";
	}

	public String getJsj_slink_link_id() {
		return jsj_slink_link_id;
	}

	public void setJsj_slink_link_id(String jsj_slink_link_id) {
		this.jsj_slink_link_id = jsj_slink_link_id;
	}

	public String getLink_name() {
		return link_name;
	}

	public void setLink_name(String link_name) {
		this.link_name = link_name;
	}

	public String getLink_url() {
		return link_url;
	}

	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}

	public String getLink_gmt_create() {
		return link_gmt_create;
	}

	public void setLink_gmt_create(String link_gmt_create) {
		this.link_gmt_create = link_gmt_create;
	}

	public String getLink_gmt_modified() {
		return link_gmt_modified;
	}

	public void setLink_gmt_modified(String link_gmt_modified) {
		this.link_gmt_modified = link_gmt_modified;
	}

}