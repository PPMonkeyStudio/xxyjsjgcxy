package com.xxyjsjgcxy.snews.service;

import java.text.ParseException;
import java.util.List;

import com.xxyjsjgcxy.snews.domain.NewsAndCategoryAndContentDTO;
import com.xxyjsjgcxy.snews.domain.jsj_snews_content;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;
import com.xxyjsjgcxy.snews.domain.page_list_newsVO;
import com.xxyjsjgcxy.suser.domain.ListVO;

public interface SnewsNewsService {

	public boolean save_News(jsj_snews_news news);

	public boolean save_Content(jsj_snews_content content);

	public List<NewsAndCategoryAndContentDTO> list_NewsAndCategoryAndContent_All();

	public List<jsj_snews_news> listNewsAll();

	public List<NewsAndCategoryAndContentDTO> list_NewsAndCategoryAndContent_ByKeywords_Num(String keywords, int num,
			String newsID);

	public List<NewsAndCategoryAndContentDTO> list_NewsAndCategoryAndContent_ByCategory_Num(String categoryName,
			int num);

	public List<NewsAndCategoryAndContentDTO> list_NewsAndCategoryAndContent_ByCategorySon_Num(String categoryName,
			int num);

	public List<NewsAndCategoryAndContentDTO> list_NewsAndCategoryAndContent_ByRecommend_Num(int num);

	public page_list_newsVO list_NewsAndCategoryAndContent_ByPage(page_list_newsVO page_list_news);

	public ListVO list_NewsAndCategoryAndContent_ByCategoryAndPage(ListVO listVO);

	public ListVO list_NewsAndCategoryAndContent_BySearchAndPage(ListVO listVO);

	public ListVO list_NewsAndCategoryAndContent_ByDateAndPage(ListVO listVO) throws ParseException;

	public NewsAndCategoryAndContentDTO get_NewsAndCategoryAndContent_ByNewsID(String newsID);

	public jsj_snews_content removeContentTemporaryImg_saveContentImg(jsj_snews_news news, jsj_snews_content content);

	public void removeOldContentImg(jsj_snews_news news, jsj_snews_content content);

	public void removeNewsByID(jsj_snews_news news);

	public void removeOldAnnex(jsj_snews_news news, String remain_oldAnnex);

	public void removeContentImgByNewsID(jsj_snews_news news);

	public void removeNewsAnnexByNewsID(jsj_snews_news news);

	public void removeNewsBImgByNewsID(jsj_snews_news news);

	public void removeNewsSImgByNewsID(jsj_snews_news news);

	public void updateNews(jsj_snews_news news);

	public void updateNewsBrowse(String newsID);

	public void updateContent(jsj_snews_content content);

	public boolean ifRepeatNewsTitleBySave(String news_title);

	public boolean ifRepeatNewsTitleByUpdate(String jsj_snews_news_id, String news_title);

}
