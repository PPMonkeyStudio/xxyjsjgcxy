package com.xxyjsjgcxy.snews.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.xxyjsjgcxy.snews.dao.SnewsCategoryDao;
import com.xxyjsjgcxy.snews.domain.CategoryListDTO;
import com.xxyjsjgcxy.snews.domain.jsj_snews_category;
import com.xxyjsjgcxy.snews.service.SnewsCategoryService;

import util.TimeUtil;

public class SnewsCategoryServiceImpl implements SnewsCategoryService {

	@Override
	public List<jsj_snews_category> listCategoryAll() {

		return snewsCategoryDao.listCategoryAll();
	}

	@Override
	public boolean removeCategoryByID(jsj_snews_category category) {

		// 删除此类
		snewsCategoryDao.removeCategoryByID(category);

		// 删除子类
		snewsCategoryDao.removeCategoryByFather(category);

		// 此类新闻，类别置空

		// 子类新闻，类别置空

		return true;
	};

	@Override
	public jsj_snews_category getCategoryByName(jsj_snews_category category) {

		category = snewsCategoryDao.get_Category_ByName(category);

		if (category == null) {
			return null;
		} else {
			return category;
		}

	}

	@Override
	public boolean saveCategory(jsj_snews_category category) {

		category.setJsj_snews_category_id(UUID.randomUUID().toString());

		category.setCategory_gmt_create(TimeUtil.getStringSecond());

		category.setCategory_gmt_modified(category.getCategory_gmt_create());

		snewsCategoryDao.save_Category(category);

		return true;
	}

	@Override
	public List<jsj_snews_category> listCategoryByRankOne() {

		return snewsCategoryDao.listCategoryByRank("1");
	}

	@Override
	public List<jsj_snews_category> listCategoryRankTwo() {

		return snewsCategoryDao.listCategoryByRank("2");
	}

	@Override
	public List<jsj_snews_category> listCategoryByName(String category_name) {

		return snewsCategoryDao.listCategoryByName(category_name);
	}

	@Override
	public List<jsj_snews_category> listCategoryByRankOne_ForHeader() {

		return snewsCategoryDao.listCategoryByRankOne_ForHeader();
	}

	@Override
	public List<CategoryListDTO> listCategoryOneAndSon() {

		List<jsj_snews_category> categoryList = snewsCategoryDao.listCategoryByRank("1");

		List<CategoryListDTO> categoryListDTOList = new ArrayList<CategoryListDTO>();

		List<jsj_snews_category> sonCategoryList = new ArrayList<jsj_snews_category>();

		for (jsj_snews_category tmpCategory : categoryList) {

			sonCategoryList = snewsCategoryDao.listCategoryByFather(tmpCategory.getJsj_snews_category_id());

			categoryListDTOList.add(new CategoryListDTO(tmpCategory, sonCategoryList));

		}

		return categoryListDTOList;
	}

	@Override
	public boolean updateCategoryShowByID(jsj_snews_category category) {

		// 通过ID查找到原纪录
		jsj_snews_category oldCategory = snewsCategoryDao.get_Category_ByID(category);

		// 改变category_show字段
		oldCategory.setCategory_show(category.getCategory_show());
		// 重新存入数据库
		snewsCategoryDao.updateCategoryShowByID(category);

		return true;
	}

	@Override
	public jsj_snews_category getCategoryByID(jsj_snews_category category) {

		return snewsCategoryDao.get_Category_ByID(category);
	}

	@Override
	public boolean update_RemoveCategoryNewsByNewsID(String newsID) {

		return snewsCategoryDao.update_RemoveCategoryNewsByNewsID(newsID);
	}

	@Override
	public boolean updateCategoryAllByID(jsj_snews_category category) {
		snewsCategoryDao.updateCategoryAllByID(category);
		return true;
	}

	/*
	 * 
	 * 
	 */
	private SnewsCategoryDao snewsCategoryDao;

	public SnewsCategoryDao getSnewsCategoryDao() {
		return snewsCategoryDao;
	}

	public void setSnewsCategoryDao(SnewsCategoryDao snewsCategoryDao) {
		this.snewsCategoryDao = snewsCategoryDao;
	}

}
