package com.xxyjsjgcxy.slink.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xxyjsjgcxy.slink.dao.SlinkLinkDao;
import com.xxyjsjgcxy.slink.domain.jsj_slink_link;
import com.xxyjsjgcxy.slink.domain.page_list_linkVO;

public class SlinkLinkDaoImpl implements SlinkLinkDao {

	@Override
	public boolean saveLink(jsj_slink_link link) {
		// TODO Auto-generated method stub
		Session session = getSession();

		session.save(link);

		return true;
	}

	@Override
	public List<jsj_slink_link> list_Link_All() {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from jsj_slink_link";

		Query query = session.createQuery(hql);

		List<jsj_slink_link> linkList = query.list();

		return linkList;
	}

	@Override
	public List<jsj_slink_link> list_Link_ByPage(page_list_linkVO page_list_link) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String sqrt = "link_gmt_create";
		String sqrt_sc = "desc";

		String link_name = "%%";
		// String link_name1 = "%%";

		if (page_list_link.getSearch() != null) {

			sqrt = page_list_link.getSearch().getSqrt();
			sqrt_sc = page_list_link.getSearch().getSqrt_sc();

			// link_name1 = "%" + page_list_link.getSearch().getName() + "%";

			link_name = "%" + page_list_link.getSearch().getName() + "%";

		}

		String hql = "from jsj_slink_link link where (link.link_name like '" + link_name + "')     order by link."
				+ sqrt + " " + sqrt_sc;

		System.out.println("hql:" + hql);

		Query query = session.createQuery(hql);

		query.setFirstResult((page_list_link.getPageIndex() - 1) * page_list_link.getPageSize());

		query.setMaxResults(page_list_link.getPageSize());

		List<jsj_slink_link> linkList = query.list();

		session.clear();

		return linkList;
	}

	@Override
	public int get_Link_TotalRecords() {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "select count(*) from jsj_slink_link";

		Query query = session.createQuery(hql);

		int count = ((Number) query.uniqueResult()).intValue();

		//
		return count;
	}

	@Override
	public jsj_slink_link get_Link_ByID(jsj_slink_link link) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from jsj_slink_link link where link.jsj_slink_link_id='" + link.getJsj_slink_link_id() + "'";

		Query query = session.createQuery(hql);

		link = (jsj_slink_link) query.uniqueResult();

		return link;
	}

	@Override
	public void removeLinkByID(jsj_slink_link link) {
		// TODO Auto-generated method stub

		Session session = getSession();

		String hql = "delete from jsj_slink_link link where link.jsj_slink_link_id='" + link.getJsj_slink_link_id()
				+ "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();
	}

	@Override
	public void updateLink(jsj_slink_link link) {
		// TODO Auto-generated method stub

		Session session = getSession();

		String hql = "update jsj_slink_link link set link.link_name='" + link.getLink_name() + "',link.link_url='"
				+ link.getLink_url() + "',link.link_gmt_modified='" + link.getLink_gmt_modified()

				+ "' where link.jsj_slink_link_id='" + link.getJsj_slink_link_id() + "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();
	}

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

	@Override
	public boolean saveContent(jsj_slink_link content) {

		Session session = getSession();

		session.save(content);
		return true;
	}
}
