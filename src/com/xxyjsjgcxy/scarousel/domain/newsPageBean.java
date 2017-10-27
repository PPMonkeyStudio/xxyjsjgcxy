package com.xxyjsjgcxy.scarousel.domain;

import java.util.List;

public class newsPageBean {

	private int pageCount;
	private List pageBean;

	public newsPageBean() {
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List getPageBean() {
		return pageBean;
	}

	public void setPageBean(List pageBean) {
		this.pageBean = pageBean;
	}
}
