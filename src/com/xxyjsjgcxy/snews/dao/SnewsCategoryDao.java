package com.xxyjsjgcxy.snews.dao;

import java.util.List;

import com.xxyjsjgcxy.snews.domain.jsj_snews_category;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;

public interface SnewsCategoryDao {
	/*
	 * 
	 */
	public jsj_snews_category get_Category_ByName(jsj_snews_category category);

	public jsj_snews_category get_Category_ByID(jsj_snews_category category);

	public jsj_snews_category get_Category_ByNewsCategory(jsj_snews_news news);

	/*
	 * 
	 */
	public boolean save_Category(jsj_snews_category category);

	/*
	 * 
	 */
	public List<jsj_snews_category> listCategoryByRank(String category_rank);

	public List<jsj_snews_category> listCategoryByName(String category_name);

	public List<jsj_snews_category> listCategoryByRankOne_ForHeader();

	public List<jsj_snews_category> listCategoryAll();

	public List<jsj_snews_category> listCategoryByFather(String category_father);

	public List<jsj_snews_category> listCategoryByFatherName(String category_fatherName);

	/*
	 * 
	 */
	public boolean updateCategoryShowByID(jsj_snews_category category);

	public boolean updateCategoryAllByID(jsj_snews_category category);

	public boolean update_RemoveCategoryNewsByNewsID(String newsID);

	/*
	 * 
	 */
	public boolean removeCategoryByID(jsj_snews_category category);

	public boolean removeCategoryByFather(jsj_snews_category category);
	/*
	 * 
	 */

}
