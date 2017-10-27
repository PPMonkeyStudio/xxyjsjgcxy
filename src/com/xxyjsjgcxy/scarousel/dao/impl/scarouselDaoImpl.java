package com.xxyjsjgcxy.scarousel.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.xxyjsjgcxy.scarousel.dao.scarouselDao;
import com.xxyjsjgcxy.scarousel.domain.jsj_scarousel_img;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;

public class scarouselDaoImpl implements scarouselDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional
	public List getNews(int page) {
		String hql = "from jsj_snews_news where news_bimg != 'default.jpg' or news_simg != 'default.jpg'";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((page - 1) * 5);
		query.setMaxResults(5);
		List list = query.list();
		return list;
	}

	@Override
	@Transactional
	public int getNewsCount() {
		System.out.println("获得了新闻总数");
		if (getSession() == null) {
			System.out.println("未获得session");
		} else {
			System.out.println("已经获得session");
		}
		String hql = "from jsj_snews_news where news_bimg != 'default.jpg' or news_simg!= 'default.jpg'";
		Query query = getSession().createQuery(hql);
		List list = query.list();
		System.out.println(list);
		// System.out.println(list.size());
		return list.size();
	}

	@Override
	@Transactional
	public void addToCarousel(jsj_scarousel_img scarousel) {
		getSession().save(scarousel);
	}

	@Override
	@Transactional
	public List judgeIsExists(String img_news, String img_group) {
		String hql = (new StringBuilder("from jsj_scarousel_img where  img_news = '")).append(img_news).append("'")
				.append("and img_group ='").append(img_group).append("'").toString();
		Query query = getSession().createQuery(hql);
		List list = query.list();
		return list;
	}

	@Override
	@Transactional
	public int getCarouselImgCount(String queryType) {
		Query query;
		if (queryType.equals("all")) {
			String hql = "from jsj_scarousel_img";
			query = getSession().createQuery(hql);
		} else {
			System.out.println("来到了条件" + queryType);
			String hql = "from jsj_scarousel_img where img_group = :queryType";
			query = getSession().createQuery(hql).setParameter("queryType", queryType);
		}
		List list = query.list();
		System.out.println(list);
		return list.size();
	}

	@Override
	@Transactional
	public List getCarouselImg(int page, String queryType) {
		Query query;
		if (queryType.equals("all")) {
			String hql = "from jsj_scarousel_img";
			query = getSession().createQuery(hql);
		} else {
			String hql = "from jsj_scarousel_img where img_group = :queryType";
			query = getSession().createQuery(hql).setParameter("queryType", queryType);
		}
		query.setFirstResult((page - 1) * 5);
		query.setMaxResults(5);
		List list = query.list();
		return list;
	}

	@Override
	@Transactional
	public List getNewsById(String img_news) {
		System.out.println("come on add dao");
		String hql = "from jsj_snews_news where jsj_snews_news_id = :newsId";
		Query query = getSession().createQuery(hql).setParameter("newsId", img_news);
		List<jsj_snews_news> list = query.list();
		System.out.println();
		return list;
	}

	@Override
	@Transactional
	public void deleteCarousel(String jsj_scarousel_img_id) {
		jsj_scarousel_img img = (jsj_scarousel_img) getSession()
				.load("com.xxyjsjgcxy.scarousel.domain.jsj_scarousel_img", jsj_scarousel_img_id);
		getSession().delete(img);
	}

	@Override
	@Transactional
	public List getCarouselImgById(String jsj_scarousel_img_id) {

		String hql = "from jsj_scarousel_img  where jsj_scarousel_img_id=:name";
		Query query = getSession().createQuery(hql).setParameter("name", jsj_scarousel_img_id);
		List list = query.list();
		return list;
	}

	@Override
	@Transactional
	public List<jsj_snews_news> getNewsBig() {
		// TODO Auto-generated method stub
		String hql = "from jsj_scarousel_img where img_group = '大图' order by img_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<jsj_scarousel_img> img = query.list(); // 获得所有类型的轮播
		System.out.println("come on querybig");
		System.out.println(img);
		List<jsj_snews_news> list = new ArrayList<jsj_snews_news>();
		for (jsj_scarousel_img jsj_scarousel_img : img) {
			// 通过轮播查找到的数据中的id查到新闻表中所有的数据
			System.out.println(jsj_scarousel_img.getJsj_scarousel_img_id() + "sunhyi");
			jsj_snews_news news = (jsj_snews_news) getSession().load("com.xxyjsjgcxy.snews.domain.jsj_snews_news",
					jsj_scarousel_img.getJsj_scarousel_img_id());
			list.add(news);
			System.out.println(list.toString());
			System.out.println(news.getNews_bimg());
		}
		// System.out.println(list.get(0).getNews_bimg());
		System.out.println("來了");
		return list;
	}

	@Override
	@Transactional
	public List<jsj_snews_news> getNewsSmall() {
		System.out.println("come on query small");
		String queryType = "小图";
		String hql = "from jsj_scarousel_img where img_group = :queryType";
		Query query = getSession().createQuery(hql).setParameter("queryType", queryType);
		List<jsj_scarousel_img> img = query.list();
		System.out.println(img);
		List<jsj_snews_news> list = new ArrayList<jsj_snews_news>();
		for (jsj_scarousel_img jsj_scarousel_img : img) {
			jsj_snews_news news = (jsj_snews_news) getSession().load("com.xxyjsjgcxy.snews.domain.jsj_snews_news",
					jsj_scarousel_img.getJsj_scarousel_img_id().substring(0,
							(jsj_scarousel_img.getJsj_scarousel_img_id().length() - 1)));
			list.add(news);
		}
		System.out.println(list.toString());
		return list;
	}

	@Override
	@Transactional
	public List<jsj_snews_news> queryByTitle(String title) {
		// TODO Auto-generated method stub
		title = "%" + title + "%";
		String hql = "from jsj_snews_news where news_title like :title and news_bimg != 'default.jpg'";
		Query query = getSession().createQuery(hql).setParameter("title", title);
		List<jsj_snews_news> list = query.list();
		System.out.println("没有出dao");
		return list;
	}
}
