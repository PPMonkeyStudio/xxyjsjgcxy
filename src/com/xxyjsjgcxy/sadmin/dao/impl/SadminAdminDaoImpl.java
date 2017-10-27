package com.xxyjsjgcxy.sadmin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xxyjsjgcxy.sadmin.dao.SadminAdminDao;
import com.xxyjsjgcxy.sadmin.domain.jsj_sadmin_admin;
import com.xxyjsjgcxy.sadmin.domain.page_list_adminVO;

public class SadminAdminDaoImpl implements SadminAdminDao {

	@Override
	public jsj_sadmin_admin get_Admin_ByID(jsj_sadmin_admin admin) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from jsj_sadmin_admin admin where admin.jsj_sadmin_admin_id='" + admin.getJsj_sadmin_admin_id()
				+ "'";

		Query query = session.createQuery(hql);

		admin = (jsj_sadmin_admin) query.uniqueResult();

		return admin;
	}

	@Override
	public void updateAdmin(jsj_sadmin_admin admin) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "update jsj_sadmin_admin admin set admin.admin_account='" + admin.getAdmin_account()
				+ "',admin.admin_premission_admin='" + admin.getAdmin_premission_admin()
				+ "',admin.admin_premission_scarousel='" + admin.getAdmin_premission_scarousel()
				+ "',admin.admin_premission_slink='" + admin.getAdmin_premission_slink()

				+ "',admin.admin_premission_snews='" + admin.getAdmin_premission_snews()
				+ "',admin.admin_gmt_modified='" + admin.getAdmin_gmt_modified()

				+ "' where admin.jsj_sadmin_admin_id='" + admin.getJsj_sadmin_admin_id() + "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();
	}

	@Override
	public void removeLinkByID(jsj_sadmin_admin admin) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "delete from jsj_sadmin_admin admin where admin.jsj_sadmin_admin_id='"
				+ admin.getJsj_sadmin_admin_id() + "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();
	}

	@Override
	public List<jsj_sadmin_admin> list_Admin_ByPage(page_list_adminVO page_list_admin) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String sqrt = "admin_gmt_create";
		String sqrt_sc = "desc";
		String admin_account = "%%";

		if (page_list_admin.getSearch() != null) {

			sqrt = page_list_admin.getSearch().getSqrt();
			sqrt_sc = page_list_admin.getSearch().getSqrt_sc();

			admin_account = "%" + page_list_admin.getSearch().getName() + "%";

		}

		String hql = "from jsj_sadmin_admin admin where (admin.admin_account like '" + admin_account
				+ "')     order by admin." + sqrt + " " + sqrt_sc;

		System.out.println("hql:" + hql);

		Query query = session.createQuery(hql);

		query.setFirstResult((page_list_admin.getPageIndex() - 1) * page_list_admin.getPageSize());

		query.setMaxResults(page_list_admin.getPageSize());

		List<jsj_sadmin_admin> adminList = query.list();

		session.clear();

		return adminList;
	}

	@Override
	public int get_Admin_TotalRecords() {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "select count(*) from jsj_sadmin_admin";

		Query query = session.createQuery(hql);

		int count = ((Number) query.uniqueResult()).intValue();

		return count;
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
	public boolean saveAdmin(jsj_sadmin_admin admin) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.save(admin);

		return true;
	}

	@Override
	public List<jsj_sadmin_admin> list_Admin_All() {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from jsj_sadmin_admin";

		Query query = session.createQuery(hql);

		List<jsj_sadmin_admin> adminList = query.list();

		return adminList;
	}

	@Override
	public jsj_sadmin_admin getAdminByAccount(String admin_account) {
		// TODO Auto-generated method stub
		String hql = "from jsj_sadmin_admin  where admin_account = '" + admin_account + "'";
		jsj_sadmin_admin addAdmin = (jsj_sadmin_admin) getSession().createQuery(hql).uniqueResult();
		return (jsj_sadmin_admin) getSession().createQuery(hql).uniqueResult();
	}

	@Override
	public boolean getAdminByAccount(boolean b) {
		// TODO Auto-generated method stub
		String hql = "from jsj_sadmin_admin  where admin_account = '" + b + "'";
		return (Boolean) getSession().createQuery(hql).uniqueResult();
	}

	@Override
	public void modifiedPassword(jsj_sadmin_admin admin) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "update jsj_sadmin_admin admin set admin.admin_password='" + admin.getAdmin_password()

				+ "',admin.admin_gmt_modified='" + admin.getAdmin_gmt_modified()

				+ "' where admin.jsj_sadmin_admin_id='" + admin.getJsj_sadmin_admin_id() + "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();
	}

	@Override
	public void modifiedpersonalPassword(jsj_sadmin_admin admin) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "update jsj_sadmin_admin admin set admin.admin_password='" + admin.getAdmin_password()

				+ "' where admin.jsj_sadmin_admin_id='" + admin.getJsj_sadmin_admin_id() + "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();
	}

}
