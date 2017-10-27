package com.xxyjsjgcxy.snews.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xxyjsjgcxy.snews.dao.SnewsNewsDao;
import com.xxyjsjgcxy.snews.domain.jsj_snews_category;
import com.xxyjsjgcxy.snews.domain.jsj_snews_content;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;
import com.xxyjsjgcxy.snews.domain.page_list_newsVO;
import com.xxyjsjgcxy.suser.domain.ListVO;

import util.TimeUtil;

public class SnewsNewsDaoImpl implements SnewsNewsDao {

	@Override
	public void updateContent(jsj_snews_content content) {

		Session session = getSession();

		String hql = "update jsj_snews_content content set content.content_text='" + content.getContent_text()
				+ "',content.content_gmt_modified='" + content.getContent_gmt_modified()
				+ "' where content.jsj_snews_content_id='" + content.getJsj_snews_content_id() + "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();

	}

	@Override
	public void updateNews(jsj_snews_news news) {

		Session session = getSession();

		String hql = "update jsj_snews_news news set news.news_title='" + news.getNews_title() + "',news.news_bimg='"
				+ news.getNews_bimg() + "',news.news_simg='" + news.getNews_simg() + "',news.news_annex='"
				+ news.getNews_annex() + "',news.news_num_annex='" + news.getNews_num_annex() + "',news.news_keywords='"
				+ news.getNews_keywords() + "',news.news_category='" + news.getNews_category()
				+ "',news.news_recommend='" + news.getNews_recommend() + "',news.news_browse='" + news.getNews_browse()
				+ "',news.news_source='" + news.getNews_source() + "',news.news_publish='" + news.getNews_publish()
				+ "',news.news_gmt_show='" + news.getNews_gmt_show() + "',news.news_gmt_modified='"
				+ news.getNews_gmt_modified() + "' where news.jsj_snews_news_id='" + news.getJsj_snews_news_id() + "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();

	}

	@Override
	public jsj_snews_news getNewsByTitle(String news_title) {
		Session session = getSession();

		String hql = "from jsj_snews_news news where news.news_title='" + news_title + "'";

		Query query = session.createQuery(hql);

		jsj_snews_news news = null;

		news = (jsj_snews_news) query.uniqueResult();

		return news;
	}

	@Override
	public jsj_snews_news get_News_ByID(String newsID) {

		Session session = getSession();

		String hql = "from jsj_snews_news news where news.jsj_snews_news_id='" + newsID + "'";

		Query query = session.createQuery(hql);

		jsj_snews_news news = (jsj_snews_news) query.uniqueResult();

		return news;
	}

	@Override
	public void removeContentByNewsID(jsj_snews_news news) {

		Session session = getSession();

		String hql = "delete from jsj_snews_content content where content.content_news='" + news.getJsj_snews_news_id()
				+ "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();

	}

	@Override
	public void removeNewsByID(jsj_snews_news news) {

		Session session = getSession();

		String hql = "delete from jsj_snews_news news where  news.jsj_snews_news_id='" + news.getJsj_snews_news_id()
				+ "'";

		Query query = session.createQuery(hql);

		query.executeUpdate();
	}

	@Override
	public int get_News_TotalRecords(page_list_newsVO page_list_news) {

		Session session = getSession();
		String news_publish = "0,1";
		String news_recommend = "0,1";
		String category = "%%";

		String sqrt = "news_gmt_create";
		String sqrt_sc = "desc";

		String news_title = "%%";

		String news_keywords = "%%";

		String start_time = "0000-00-00";
		String stop_time = "9999-99-99";

		if (page_list_news.getSearch() != null) {
			if (page_list_news.getSearch().getPublish() != -1) {
				news_publish = "" + page_list_news.getSearch().getPublish();
			}

			if (page_list_news.getSearch().getRecommend() != -1) {
				news_recommend = "" + page_list_news.getSearch().getRecommend();
			}
			if (!page_list_news.getSearch().getCategory().equals("-1")) {
				category = page_list_news.getSearch().getCategory();
			}

			sqrt = page_list_news.getSearch().getSqrt();
			sqrt_sc = page_list_news.getSearch().getSqrt_sc();

			news_title = "%" + page_list_news.getSearch().getKeywords() + "%";

			news_keywords = "%" + page_list_news.getSearch().getKeywords() + "%";

			start_time = page_list_news.getSearch().getStart_time();

			if (!page_list_news.getSearch().getStop_time().equals("9999-99-99")) {

				try {

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
					String dstr = page_list_news.getSearch().getStop_time();
					java.util.Date date = sdf.parse(dstr);

					Calendar calendar = new GregorianCalendar();
					calendar.setTime(date);
					calendar.add(calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
					date = calendar.getTime(); // 这个时间就是日期往后推一天的结果

					String str = sdf.format(date);

					stop_time = str;

				} catch (ParseException e) {

					e.printStackTrace();
				}
			}

		}

		String hql = "select count(*) from jsj_snews_news news where (news.news_title like '" + news_title
				+ "' or news.news_keywords like '" + news_keywords + "') and news.news_category like '" + category
				+ "' and news.news_publish in (" + news_publish + ") and  news.news_recommend in (" + news_recommend
				+ ") and news.news_gmt_show >= '" + start_time + "' and news.news_gmt_show <= '" + stop_time
				+ "'   order by news." + sqrt + " " + sqrt_sc;
		Query query = session.createQuery(hql);

		int count = ((Number) query.uniqueResult()).intValue();

		//
		return count;

	}

	@Override
	public int get_News_TotalRecords_BySearch(String search) {

		Session session = getSession();

		search = "%" + search + "%";

		String hql = "select count(*) from jsj_snews_news news where ( news.news_title like '" + search
				+ "' or news.news_keywords like '" + search + "' ) and news.news_publish='1'";

		Query query = session.createQuery(hql);

		int count = ((Number) query.uniqueResult()).intValue();

		return count;
	}

	@Override
	public List<jsj_snews_news> list_News_BySearchAndPage(ListVO listVO) {

		Session session = getSession();

		String search = "%" + listVO.getSearch() + "%";

		String hql = "from jsj_snews_news news where (news.news_title like '" + search
				+ "' or news.news_keywords like '" + search
				+ "')  and news.news_publish='1' order by news_gmt_show desc";
		Query query = session.createQuery(hql);
		query.setFirstResult((listVO.getPageIndex() - 1) * listVO.getPageSize());
		query.setMaxResults(listVO.getPageSize());
		List<jsj_snews_news> newsList = query.list();

		session.clear();

		for (jsj_snews_news news : newsList) {

			news.setNews_title(news.getNews_title().replaceAll(listVO.getSearch(),
					"<span style='color: #ff5063;'>" + listVO.getSearch() + "</span>"));

			news.setNews_keywords(news.getNews_keywords().replaceAll(listVO.getSearch(),
					"<span style='color: #ff5063;'>" + listVO.getSearch() + "</span>"));

		}

		return newsList;
	}

	@Override
	public int get_News_TotalRecords_ByDate(String mydate) {

		Session session = getSession();

		String start_time = "0000-00-00";
		String stop_time = "9999-99-99";

		/*
		 * 本日新闻
		 */
		if (mydate.equals("1")) {
			/*
			 * 
			 */
			start_time = TimeUtil.getStringDay();
			/*
			 * 
			 */
			Calendar calendar = new GregorianCalendar();
			java.util.Date date = TimeUtil.getDateDay();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
			calendar.setTime(date);
			calendar.add(calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
			date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
			stop_time = sdf.format(date);
		} else
		/*
		 * 本周新闻
		 */
		if (mydate.equals("2")) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟

			String dstr = TimeUtil.getStringDay();

			java.util.Date date = null;
			try {
				date = sdf.parse(dstr);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Calendar calendar = new GregorianCalendar();

			calendar.setTime(date);

			String day = TimeUtil.getDay_Of_Week(TimeUtil.getDateDay());

			switch (day) {
			case "星期日":
				day = "1";
				break;
			case "星期一":
				day = "2";
				break;
			case "星期二":
				day = "3";
				break;
			case "星期三":
				day = "4";
				break;
			case "星期四":
				day = "5";
				break;
			case "星期五":
				day = "6";
				break;
			case "星期六":
				day = "7";
				break;
			}

			calendar.add(calendar.DATE, -1 * (Integer.parseInt(day) - 1));// 把日期往后增加一天.整数往后推,负数往前移动
			date = calendar.getTime(); // 这个时间就是日期往后推一天的结果

			start_time = sdf.format(date);
			/*
			 * 
			 */
			Calendar calendar2 = new GregorianCalendar();
			java.util.Date date2 = TimeUtil.getDateDay();
			calendar2.setTime(date2);
			calendar2.add(calendar2.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
			date2 = calendar2.getTime(); // 这个时间就是日期往后推一天的结果
			stop_time = sdf.format(date2);
		}
		/*
		 * 本月新闻
		 */
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟

			String dstr = TimeUtil.getStringDay();

			java.util.Date date = null;
			try {
				date = sdf.parse(dstr);
			} catch (ParseException e) {

				e.printStackTrace();
			}

			Calendar calendar = new GregorianCalendar();

			calendar.setTime(date);

			// 把日期往后增加一天.整数往后推,负数往前移动
			calendar.add(calendar.DATE, -1 * (Integer.parseInt(TimeUtil.getStringDay().substring(8)) - 1));

			date = calendar.getTime(); // 这个时间就是日期往后推一天的结果

			start_time = sdf.format(date);
			/*
			 * 
			 */
			Calendar calendar2 = new GregorianCalendar();
			java.util.Date date2 = TimeUtil.getDateDay();
			calendar2.setTime(date2);
			calendar2.add(calendar2.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
			date2 = calendar2.getTime(); // 这个时间就是日期往后推一天的结果
			stop_time = sdf.format(date2);

		}

		String hql = "select count(*) from jsj_snews_news news   where news.news_publish ='1' and news.news_gmt_show >= '"
				+ start_time + "' and news.news_gmt_show < '" + stop_time + "' order by news.news_gmt_show desc ";

		Query query = session.createQuery(hql);

		int count = ((Number) query.uniqueResult()).intValue();

		//
		return count;
	}

	@Override
	public List<jsj_snews_news> list_News_ByDateAndPage(ListVO listVO) throws ParseException {

		Session session = getSession();

		String start_time = "0000-00-00";
		String stop_time = "9999-99-99";

		if (listVO.getDate().equals("1")) {
			/*
			 * 
			 */
			start_time = TimeUtil.getStringDay();
			/*
			 * 
			 */
			Calendar calendar = new GregorianCalendar();
			java.util.Date date = TimeUtil.getDateDay();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
			calendar.setTime(date);
			calendar.add(calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
			date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
			stop_time = sdf.format(date);
		} else if (listVO.getDate().equals("2")) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟

			String dstr = TimeUtil.getStringDay();

			java.util.Date date = sdf.parse(dstr);

			Calendar calendar = new GregorianCalendar();

			calendar.setTime(date);

			String day = TimeUtil.getDay_Of_Week(TimeUtil.getDateDay());

			switch (day) {
			case "星期日":
				day = "1";
				break;
			case "星期一":
				day = "2";
				break;
			case "星期二":
				day = "3";
				break;
			case "星期三":
				day = "4";
				break;
			case "星期四":
				day = "5";
				break;
			case "星期五":
				day = "6";
				break;
			case "星期六":
				day = "7";
				break;
			}

			calendar.add(calendar.DATE, -1 * (Integer.parseInt(day) - 1));// 把日期往后增加一天.整数往后推,负数往前移动

			date = calendar.getTime(); // 这个时间就是日期往后推一天的结果

			start_time = sdf.format(date);
			/*
			 * 
			 */
			Calendar calendar2 = new GregorianCalendar();
			java.util.Date date2 = TimeUtil.getDateDay();
			calendar2.setTime(date2);
			calendar2.add(calendar2.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
			date2 = calendar2.getTime(); // 这个时间就是日期往后推一天的结果
			stop_time = sdf.format(date2);

		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟

			String dstr = TimeUtil.getStringDay();

			java.util.Date date = sdf.parse(dstr);

			Calendar calendar = new GregorianCalendar();

			calendar.setTime(date);

			// 把日期往后增加一天.整数往后推,负数往前移动
			calendar.add(calendar.DATE, -1 * (Integer.parseInt(TimeUtil.getStringDay().substring(8)) - 1));

			date = calendar.getTime(); // 这个时间就是日期往后推一天的结果

			start_time = sdf.format(date);
			/*
			 * 
			 */
			Calendar calendar2 = new GregorianCalendar();
			java.util.Date date2 = TimeUtil.getDateDay();
			calendar2.setTime(date2);
			calendar2.add(calendar2.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
			date2 = calendar2.getTime(); // 这个时间就是日期往后推一天的结果
			stop_time = sdf.format(date2);

		}

		String hql = "from jsj_snews_news news where news.news_publish ='1' and   news.news_gmt_show >= '" + start_time
				+ "' and news.news_gmt_show < '" + stop_time + "'  order by news.news_gmt_show desc";

		Query query = session.createQuery(hql);

		query.setFirstResult((listVO.getPageIndex() - 1) * listVO.getPageSize());

		query.setMaxResults(listVO.getPageSize());

		List<jsj_snews_news> newsList = query.list();

		session.clear();

		return newsList;
	}

	@Override
	public int get_News_TotalRecords_ByCategory(String categoryName) {

		Session session = getSession();
		String category = "%%";
		String recommend = "%%";
		String father = "%%";
		if (categoryName != null) {
			if (categoryName.equals("学院要闻")) {
				recommend = "1";
			} else {
				String hql = "from jsj_snews_category  where  category_name='" + categoryName + "' ";
				Query query = session.createQuery(hql);
				jsj_snews_category thisCategory = (jsj_snews_category) query.uniqueResult();
				if (thisCategory.getCategory_rank() == 1) {
					// 一级类别
					if (categoryName.equals("通知公告")) {
						category = "%" + categoryName + "%";
					} else {
						// 无指定
						father = "%" + thisCategory.getJsj_snews_category_id() + "%";
					}
				} else {
					// 二级类别
					category = "%" + categoryName + "%";
				}
			}
		}

		String hql = "select count(*) from jsj_snews_news news,jsj_snews_category category where news.news_category=category.jsj_snews_category_id and category.category_name like '"
				+ category + "' and news.news_recommend like '" + recommend + "' and category.category_father like '"
				+ father + "'  and news.news_publish='1' ";

		Query query = session.createQuery(hql);

		int count = ((Number) query.uniqueResult()).intValue();
		//
		return count;
	}

	@Override
	public List<jsj_snews_news> list_News_ByCategoryAndPage(ListVO listVO) {
		Session session = getSession();
		String category = "%%";
		String recommend = "%%";
		String father = "%%";
		if (listVO.getCategory() != null) {
			if (listVO.getCategory().equals("学院要闻")) {
				recommend = "1";
			} else {
				String hql = "from jsj_snews_category  where  category_name='" + listVO.getCategory() + "' ";
				Query query = session.createQuery(hql);
				jsj_snews_category thisCategory = (jsj_snews_category) query.uniqueResult();
				if (thisCategory.getCategory_rank() == 1) {
					// 一级类别
					if (listVO.getCategory().equals("通知公告")) {
						category = "%" + listVO.getCategory() + "%";
					} else {
						// 无指定
						father = "%" + thisCategory.getJsj_snews_category_id() + "%";
					}
				} else {
					// 二级类别
					category = "%" + listVO.getCategory() + "%";
				}
			}
		}
		String hql = "select news from jsj_snews_news news,jsj_snews_category category where news.news_category=category.jsj_snews_category_id and category.category_name like '"
				+ category + "' and news.news_recommend like '" + recommend + "' and category.category_father like '"
				+ father + "'  and news.news_publish='1' order by news_gmt_show desc";
		Query query = session.createQuery(hql);
		query.setFirstResult((listVO.getPageIndex() - 1) * listVO.getPageSize());
		query.setMaxResults(listVO.getPageSize());
		List<jsj_snews_news> newsList = query.list();
		session.clear();
		return newsList;
	}

	@Override
	public List<jsj_snews_news> list_News_ByPage(page_list_newsVO page_list_news) {

		Session session = getSession();

		String news_publish = "0,1";
		String news_recommend = "0,1";
		String category = "%%";

		String sqrt = "news_gmt_create";
		String sqrt_sc = "desc";

		String news_title = "%%";

		String news_keywords = "%%";

		String start_time = "0000-00-00";
		String stop_time = "9999-99-99";

		if (page_list_news.getSearch() != null) {
			if (page_list_news.getSearch().getPublish() != -1) {
				news_publish = "" + page_list_news.getSearch().getPublish();
			}

			if (page_list_news.getSearch().getRecommend() != -1) {
				news_recommend = "" + page_list_news.getSearch().getRecommend();
			}
			if (!page_list_news.getSearch().getCategory().equals("-1")) {
				category = page_list_news.getSearch().getCategory();
			}

			sqrt = page_list_news.getSearch().getSqrt();
			sqrt_sc = page_list_news.getSearch().getSqrt_sc();

			news_title = "%" + page_list_news.getSearch().getKeywords() + "%";

			news_keywords = "%" + page_list_news.getSearch().getKeywords() + "%";

			start_time = page_list_news.getSearch().getStart_time();

			if (!page_list_news.getSearch().getStop_time().equals("9999-99-99")) {

				try {

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
					String dstr = page_list_news.getSearch().getStop_time();
					java.util.Date date = sdf.parse(dstr);

					Calendar calendar = new GregorianCalendar();
					calendar.setTime(date);
					calendar.add(calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
					date = calendar.getTime(); // 这个时间就是日期往后推一天的结果

					String str = sdf.format(date);

					stop_time = str;

				} catch (ParseException e) {

					e.printStackTrace();
				}
			}

		}

		String hql = "from jsj_snews_news news where (news.news_title like '" + news_title
				+ "' or news.news_keywords like '" + news_keywords + "') and news.news_category like '" + category
				+ "' and news.news_publish in (" + news_publish + ") and  news.news_recommend in (" + news_recommend
				+ ") and news.news_gmt_show >= '" + start_time + "' and news.news_gmt_show <= '" + stop_time
				+ "'   order by news." + sqrt + " " + sqrt_sc;

		Query query = session.createQuery(hql);

		query.setFirstResult((page_list_news.getPageIndex() - 1) * page_list_news.getPageSize());

		query.setMaxResults(page_list_news.getPageSize());

		List<jsj_snews_news> newsList = query.list();

		session.clear();

		return newsList;
	}

	@Override
	public jsj_snews_content get_Content_ByNewsID(jsj_snews_news news) {

		Session session = getSession();

		String hql = "from jsj_snews_content content where content.content_news='" + news.getJsj_snews_news_id() + "'";

		Query query = session.createQuery(hql);

		jsj_snews_content content = (jsj_snews_content) query.uniqueResult();

		return content;

	}

	@Override
	public List<jsj_snews_news> list_News_ByRecommend_Num(int num) {

		Session session = getSession();

		String hql = "from jsj_snews_news news  where  news.news_publish='1' and news.news_recommend='1' order by news.news_gmt_show desc";
		Query query = session.createQuery(hql);

		query.setFirstResult(0);

		query.setMaxResults(num);

		List<jsj_snews_news> newsList = query.list();
		return newsList;
	}

	@Override
	public List<jsj_snews_news> list_News_ByCategory_Num(String categoryName, int num) {

		Session session = getSession();

		String hql = "select news from jsj_snews_news news,jsj_snews_category category where news.news_publish='1' and news.news_category=category.jsj_snews_category_id and category.category_name='"
				+ categoryName + "' order by news_gmt_show desc";
		Query query = session.createQuery(hql);

		query.setFirstResult(0);

		query.setMaxResults(num);

		List<jsj_snews_news> newsList = query.list();

		return newsList;

	}

	@Override
	public List<jsj_snews_news> list_News_ByKeywords(String keywords) {

		Session session = getSession();

		String[] splitKeywords = keywords.split(";");

		int KeywordsNum = splitKeywords.length;

		int i = 0;

		String hql = "from jsj_snews_news where news_keywords like '%" + splitKeywords[i] + "%' ";

		i++;

		while (i < KeywordsNum) {

			hql = hql + "or news_keywords like '%" + splitKeywords[i] + "%' ";

			i++;
		}

		hql = hql + "order by news_browse desc ";

		Query query = session.createQuery(hql);

		List<jsj_snews_news> newsList = query.list();

		return newsList;
	}

	@Override
	public List<jsj_snews_news> list_News_ByKeywords(String keywords, String newsID) {

		Session session = getSession();

		String[] splitKeywords = keywords.split(";");

		int KeywordsNum = splitKeywords.length;

		int i = 0;

		String hql = "from jsj_snews_news where (news_keywords like '%" + splitKeywords[i] + "%' ";

		i++;

		while (i < KeywordsNum) {

			hql = hql + "or news_keywords like '%" + splitKeywords[i] + "%' ";

			i++;
		}

		hql = hql + " )and news_recommend='1' and jsj_snews_news_id <> '" + newsID + "' order by news_browse desc ";

		Query query = session.createQuery(hql);

		query.setFirstResult(0);

		query.setMaxResults(4);

		List<jsj_snews_news> newsList = query.list();

		if (newsList.size() == 4) {
			return newsList;
		}

		// 如果未满四个就从最高浏览量里凑

		int num = 4 - newsList.size();

		hql = "from jsj_snews_news where news_recommend='1' and  jsj_snews_news_id <> '" + newsID
				+ "' order by news_browse desc";

		query = session.createQuery(hql);

		query.setFirstResult(0);

		query.setMaxResults(num);

		newsList.addAll(query.list());

		return newsList;
	}

	@Override
	public List<jsj_snews_news> list_News_All() {

		Session session = getSession();

		String hql = "from jsj_snews_news";

		Query query = session.createQuery(hql);

		List<jsj_snews_news> newsList = query.list();

		return newsList;
	}

	@Override
	public boolean saveContent(jsj_snews_content content) {

		Session session = getSession();

		session.save(content);

		return true;
	}

	@Override
	public boolean saveNews(jsj_snews_news news) {

		Session session = getSession();

		session.save(news);

		return true;
	}

	/*
	 * 
	 * 
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
