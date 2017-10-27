package com.xxyjsjgcxy.snews.service;

import java.util.List;

import com.xxyjsjgcxy.snews.domain.CategoryListDTO;
import com.xxyjsjgcxy.snews.domain.jsj_snews_category;

public interface SnewsCategoryService {

	public jsj_snews_category getCategoryByName(jsj_snews_category category);

	/*
	 * 
	 */
	public boolean saveCategory(jsj_snews_category category);

	/*
	 * 
	 */
	public List<jsj_snews_category> listCategoryByRankOne();

	public List<jsj_snews_category> listCategoryByName(String category_name);

	public List<jsj_snews_category> listCategoryByRankOne_ForHeader();

	public List<CategoryListDTO> listCategoryOneAndSon();

	public List<jsj_snews_category> listCategoryAll();

	public List<jsj_snews_category> listCategoryRankTwo();

	/*
	 * 
	 */
	public boolean updateCategoryShowByID(jsj_snews_category category);

	public boolean updateCategoryAllByID(jsj_snews_category category);

	public boolean update_RemoveCategoryNewsByNewsID(String newsID);

	/*
	 * 
	 */
	public jsj_snews_category getCategoryByID(jsj_snews_category category);

	public boolean removeCategoryByID(jsj_snews_category category);

}
