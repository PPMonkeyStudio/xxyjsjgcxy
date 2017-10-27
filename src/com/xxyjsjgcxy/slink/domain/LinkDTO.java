package com.xxyjsjgcxy.slink.domain;

public class LinkDTO {

	private jsj_slink_link link;

	public LinkDTO(jsj_slink_link link) {

		this.link = link;
	}

	@Override
	public String toString() {
		return "LinkDTO [link=" + link + "]";
	}

	public jsj_slink_link getLink() {
		return link;
	}

	public void setLink(jsj_slink_link link) {
		this.link = link;
	}

}
