package com.xxyjsjgcxy.snews.dao;

import java.text.ParseException;
import java.util.List;

import com.xxyjsjgcxy.snews.domain.jsj_snews_content;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;
import com.xxyjsjgcxy.snews.domain.page_list_newsVO;
import com.xxyjsjgcxy.suser.domain.ListVO;

public interface SnewsNewsDao {
	/*
	 * 
	 */
	public boolean saveNews(jsj_snews_news news);

	public boolean saveContent(jsj_snews_content content);

	/*
	 * 
	 */
	public List<jsj_snews_news> list_News_All();

	public List<jsj_snews_news> list_News_ByKeywords(String keywords);

	public List<jsj_snews_news> list_News_ByKeywords(String keywords, String newsID);

	public List<jsj_snews_news> list_News_ByCategory_Num(String categoryName, int num);

	public List<jsj_snews_news> list_News_ByRecommend_Num(int num);

	public List<jsj_snews_news> list_News_ByPage(page_list_newsVO page_list_news);

	public List<jsj_snews_news> list_News_ByCategoryAndPage(ListVO listVO);

	public List<jsj_snews_news> list_News_BySearchAndPage(ListVO listVO);

	public List<jsj_snews_news> list_News_ByDateAndPage(ListVO listVO) throws ParseException;

	/*
	 * 
	 */

	public jsj_snews_content get_Content_ByNewsID(jsj_snews_news news);

	public int get_News_TotalRecords(page_list_newsVO page_list_news);

	public int get_News_TotalRecords_ByCategory(String categoryID);

	public int get_News_TotalRecords_BySearch(String userSearch);

	public int get_News_TotalRecords_ByDate(String date);

	/*
	 * 
	 */
	public jsj_snews_news get_News_ByID(String newsID);

	/*
	 * 
	 */
	public void removeNewsByID(jsj_snews_news news);

	public void removeContentByNewsID(jsj_snews_news news);

	/*
	 * 
	 */
	public void updateNews(jsj_snews_news news);

	public void updateContent(jsj_snews_content content);

	public jsj_snews_news getNewsByTitle(String news_title);

}
