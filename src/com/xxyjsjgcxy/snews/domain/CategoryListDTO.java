package com.xxyjsjgcxy.snews.domain;

import java.util.List;

public class CategoryListDTO {

	private jsj_snews_category category;

	private List<jsj_snews_category> sonCategoryList;

	public CategoryListDTO(jsj_snews_category category, List<jsj_snews_category> sonCategoryList) {

		this.category = category;
		this.sonCategoryList = sonCategoryList;
	}

	public jsj_snews_category getCategory() {
		return category;
	}

	public void setCategory(jsj_snews_category category) {
		this.category = category;
	}

	public List<jsj_snews_category> getSonCategoryList() {
		return sonCategoryList;
	}

	public void setSonCategoryList(List<jsj_snews_category> sonCategoryList) {
		this.sonCategoryList = sonCategoryList;
	}

}
