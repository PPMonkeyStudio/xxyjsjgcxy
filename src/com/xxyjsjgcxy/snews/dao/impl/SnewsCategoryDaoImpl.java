package com.xxyjsjgcxy.snews.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xxyjsjgcxy.snews.dao.SnewsCategoryDao;
import com.xxyjsjgcxy.snews.domain.jsj_snews_category;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;

@SuppressWarnings("unchecked")
public class SnewsCategoryDaoImpl implements SnewsCategoryDao {

	@Override
	public jsj_snews_category get_Category_ByNewsCategory(jsj_snews_news news) {

		Session session = getSession();

		String hql = "from jsj_snews_category category where category.jsj_snews_category_id='" + news.getNews_category()
				+ "'";

		System.out.println(hql);

		Query query = session.createQuery(hql);

		jsj_snews_category category = (jsj_snews_category) query.uniqueResult();

		return category;
	}

	@Override
	public boolean removeCategoryByFather(jsj_snews_category category) {

		Session session = getSession();

		String hql = "delete from jsj_snews_category category where category.category_father='"
				+ category.getJsj_snews_category_id() + "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();

		return true;
	}

	@Override
	public boolean removeCategoryByID(jsj_snews_category category) {

		Session session = getSession();

		String hql = "delete from jsj_snews_category category where category.jsj_snews_category_id='"
				+ category.getJsj_snews_category_id() + "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();

		return true;
	}

	@Override
	public jsj_snews_category get_Category_ByName(jsj_snews_category category) {

		Session session = getSession();

		String hql = "from jsj_snews_category  where category_name='" + category.getCategory_name() + "'";

		Query query = session.createQuery(hql);

		category = (jsj_snews_category) query.uniqueResult();

		if (category != null) {

			return category;

		} else {
			return null;
		}

	}

	@Override
	public boolean save_Category(jsj_snews_category category) {

		Session session = getSession();

		session.save(category);

		return true;
	}

	@Override
	public List<jsj_snews_category> listCategoryByRank(String category_rank) {

		Session session = getSession();

		String hql = "from jsj_snews_category category where category.category_rank='" + category_rank
				+ "' order by category_sqrt desc";

		Query query = session.createQuery(hql);

		List<jsj_snews_category> categoryList = query.list();

		if (categoryList != null) {

			return categoryList;

		} else {
			return null;
		}
	}

	@Override
	public List<jsj_snews_category> listCategoryByName(String category_name) {

		Session session = getSession();

		String hql = "from jsj_snews_category category where category.category_name='" + category_name + "'";

		Query query = session.createQuery(hql);

		List<jsj_snews_category> categoryList = query.list();

		if (categoryList != null) {

			return categoryList;

		} else {
			return null;
		}
	}

	@Override
	public List<jsj_snews_category> listCategoryByRankOne_ForHeader() {

		Session session = getSession();

		String hql = "from jsj_snews_category category where category.category_show='1' and category.category_rank='1' order by category_sqrt desc";

		Query query = session.createQuery(hql);

		List<jsj_snews_category> categoryList = query.list();

		if (categoryList != null) {

			return categoryList;

		} else {
			return null;
		}

	}

	@Override
	public List<jsj_snews_category> listCategoryAll() {

		Session session = getSession();

		String hql = "from jsj_snews_category order by category_gmt_create desc";

		Query query = session.createQuery(hql);

		List<jsj_snews_category> categoryList = query.list();

		return categoryList;
	}

	@Override
	public List<jsj_snews_category> listCategoryByFatherName(String category_fatherName) {

		Session session = getSession();

		String hql = "from jsj_snews_category category where category.category_name='" + category_fatherName + "'";

		Query query = session.createQuery(hql);

		jsj_snews_category father = (jsj_snews_category) query.uniqueResult();

		hql = "from jsj_snews_category category where category.category_father='" + father.getJsj_snews_category_id()
				+ "'";

		query = session.createQuery(hql);

		List<jsj_snews_category> categoryList = query.list();

		return categoryList;
	}

	@Override
	public List<jsj_snews_category> listCategoryByFather(String category_father) {

		Session session = getSession();

		String hql = "from jsj_snews_category category where category.category_father='" + category_father + "'";

		Query query = session.createQuery(hql);

		List<jsj_snews_category> categoryList = query.list();

		return categoryList;
	}

	@Override
	public jsj_snews_category get_Category_ByID(jsj_snews_category category) {

		Session session = getSession();

		String hql = "from jsj_snews_category category where category.jsj_snews_category_id='"
				+ category.getJsj_snews_category_id() + "'";

		Query query = session.createQuery(hql);

		category = (jsj_snews_category) query.uniqueResult();

		return category;

	}

	@Override
	public boolean updateCategoryShowByID(jsj_snews_category category) {

		Session session = getSession();

		String hql = "update jsj_snews_category category set category.category_show='" + category.getCategory_show()
				+ "' where category.jsj_snews_category_id='" + category.getJsj_snews_category_id() + "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();

		return true;
	}

	@Override
	public boolean update_RemoveCategoryNewsByNewsID(String newsID) {

		Session session = getSession();

		String hql = "update jsj_snews_category category set category.category_news='' where category.category_news='"
				+ newsID + "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();

		return true;
	}

	@Override
	public boolean updateCategoryAllByID(jsj_snews_category category) {

		Session session = getSession();

		String hql = "update jsj_snews_category category set category.category_name='" + category.getCategory_name()
				+ "',category.category_rank='" + category.getCategory_rank() + "',category.category_sqrt='"
				+ category.getCategory_sqrt() + "',category.category_show='" + category.getCategory_show()
				+ "',category.category_Introduction='" + category.getCategory_Introduction()
				+ "' ,category.category_img='" + category.getCategory_img() + "',category.category_news='"
				+ category.getCategory_news() + "',category.category_father='" + category.getCategory_father()
				+ "' where category.jsj_snews_category_id='" + category.getJsj_snews_category_id() + "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();

		return true;
	}

	/*
	 * 
	 */

	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
