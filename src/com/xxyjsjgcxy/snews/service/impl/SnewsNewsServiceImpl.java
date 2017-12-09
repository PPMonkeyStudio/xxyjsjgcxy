package com.xxyjsjgcxy.snews.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.xxyjsjgcxy.scarousel.service.ScarouselService;
import com.xxyjsjgcxy.snews.dao.SnewsCategoryDao;
import com.xxyjsjgcxy.snews.dao.SnewsNewsDao;
import com.xxyjsjgcxy.snews.domain.NewsAndCategoryAndContentDTO;
import com.xxyjsjgcxy.snews.domain.jsj_snews_category;
import com.xxyjsjgcxy.snews.domain.jsj_snews_content;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;
import com.xxyjsjgcxy.snews.domain.page_list_newsVO;
import com.xxyjsjgcxy.snews.service.SnewsNewsService;
import com.xxyjsjgcxy.suser.domain.ListVO;

import util.TimeUtil;

public class SnewsNewsServiceImpl implements SnewsNewsService {
	@Override
	public boolean ifRepeatNewsTitleByUpdate(String jsj_snews_news_id, String news_title) {
		jsj_snews_news news = snewsNewsDao.getNewsByTitle(news_title);
		if (news != null) {
			if (news.getJsj_snews_news_id().equals(jsj_snews_news_id)) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean ifRepeatNewsTitleBySave(String news_title) {

		if (snewsNewsDao.getNewsByTitle(news_title) != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void updateContent(jsj_snews_content content) {

		content.setContent_gmt_modified(TimeUtil.getStringSecond());

		snewsNewsDao.updateContent(content);
	}

	@Override
	public void updateNewsBrowse(String newsID) {

		jsj_snews_news news = snewsNewsDao.get_News_ByID(newsID);

		news.setNews_browse(news.getNews_browse() + 1);

		snewsNewsDao.updateNews(news);

	}

	@Override
	public void updateNews(jsj_snews_news news) {

		news.setNews_gmt_modified(TimeUtil.getStringSecond());
		snewsNewsDao.updateNews(news);
	}

	@Override
	public NewsAndCategoryAndContentDTO get_NewsAndCategoryAndContent_ByNewsID(String newsID) {

		jsj_snews_news news = snewsNewsDao.get_News_ByID(newsID);

		jsj_snews_category category = snewsCategoryDao.get_Category_ByNewsCategory(news);

		jsj_snews_content content = snewsNewsDao.get_Content_ByNewsID(news);

		NewsAndCategoryAndContentDTO newsAndCategoryAndContentDTO = new NewsAndCategoryAndContentDTO(news, category,
				content);

		return newsAndCategoryAndContentDTO;
	}

	@Override
	public void removeNewsByID(jsj_snews_news news) {

		news = snewsNewsDao.get_News_ByID(news.getJsj_snews_news_id());

		// 新闻
		snewsNewsDao.removeNewsByID(news);

		// 内容

		snewsNewsDao.removeContentByNewsID(news);

		// 内容图片

		removeContentImgByNewsID(news);

		// 附件

		removeNewsAnnexByNewsID(news);

		// 大小图

		removeNewsBImgByNewsID(news);

		removeNewsSImgByNewsID(news);
		/*
		 * 
		 * 
		 * 
		 */
		System.out.println("12");
		// 删除轮播
		System.out.println(scarouselService.deleteCarousel(news.getJsj_snews_news_id()));
		;
		System.out.println(scarouselService.deleteCarousel(news.getJsj_snews_news_id() + "s"));
		;
		System.out.println("32");
		// 删除类别指定新闻
		snewsCategoryDao.update_RemoveCategoryNewsByNewsID(news.getJsj_snews_news_id());
	}

	@Override
	public void removeNewsBImgByNewsID(jsj_snews_news news) {
		/*
		 * 获取路径
		 */
		String lj = "";
		try {
			Properties props = new Properties();
			props.load(this.getClass().getClassLoader().getResourceAsStream("file.properties"));
			lj = props.getProperty("lj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 
		 */
		if (news.getNews_bimg().equals("default.jpg")) {

		} else {
			System.out.println("删除大图：" + news.getNews_bimg());
			File bImg = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/bimg/" + news.getNews_bimg());
			bImg.delete();
		}
	}

	@Override
	public void removeNewsSImgByNewsID(jsj_snews_news news) {
		/*
		 * 获取路径
		 */
		String lj = "";
		try {
			Properties props = new Properties();
			props.load(this.getClass().getClassLoader().getResourceAsStream("file.properties"));
			lj = props.getProperty("lj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 
		 */
		if (news.getNews_simg().equals("default.jpg")) {

		} else {
			System.out.println("删除小图：" + news.getNews_simg());
			File sImg = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/simg/" + news.getNews_simg());
			sImg.delete();
		}
	}

	@Override
	public void removeNewsAnnexByNewsID(jsj_snews_news news) {
		/*
		 * 获取路径
		 */
		String lj = "";
		try {
			Properties props = new Properties();
			props.load(this.getClass().getClassLoader().getResourceAsStream("file.properties"));
			lj = props.getProperty("lj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 
		 */
		File root = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_annex/snews_news");
		File[] allFiles = root.listFiles();

		for (File file : allFiles) {
			String[] splitFileName = file.getName().split("_");
			if (splitFileName[0].equals(news.getJsj_snews_news_id())) {
				file.delete();
			}
		}

	}

	@Override
	public void removeContentImgByNewsID(jsj_snews_news news) {
		/*
		 * 获取路径
		 */
		String lj = "";
		try {
			Properties props = new Properties();
			props.load(this.getClass().getClassLoader().getResourceAsStream("file.properties"));
			lj = props.getProperty("lj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 
		 */
		File root = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/content");
		File[] allFiles = root.listFiles();

		for (File file : allFiles) {
			String[] splitFileName = file.getName().split("_");
			if (splitFileName[0].equals(news.getJsj_snews_news_id())) {
				file.delete();
			}
		}

	}

	@Override
	public ListVO list_NewsAndCategoryAndContent_ByDateAndPage(ListVO listVO) throws ParseException {
		List<NewsAndCategoryAndContentDTO> newsAndCategoryAndContentDTOList = new ArrayList<NewsAndCategoryAndContentDTO>();

		NewsAndCategoryAndContentDTO newsAndCategoryAndContentDTO;

		jsj_snews_category category;

		jsj_snews_content content;

		List<jsj_snews_news> newsList = snewsNewsDao.list_News_ByDateAndPage(listVO);

		// 匹配变色

		// 封装总记录数
		listVO.setTotalRecords(snewsNewsDao.get_News_TotalRecords_ByDate(listVO.getDate()));

		System.out.println("总记录数:" + listVO.getTotalRecords());

		// 封装总页数
		listVO.setTotalPages(((listVO.getTotalRecords() - 1) / listVO.getPageSize()) + 1);

		if (listVO.getPageIndex() <= 1) {
			listVO.setHavePrePage(false);
		} else {
			listVO.setHavePrePage(true);
		}
		if (listVO.getPageIndex() >= listVO.getTotalPages()) {
			listVO.setHaveNextPage(false);
		} else {
			listVO.setHaveNextPage(true);
		}

		for (jsj_snews_news news : newsList) {

			content = snewsNewsDao.get_Content_ByNewsID(news);

			category = snewsCategoryDao.get_Category_ByNewsCategory(news);

			newsAndCategoryAndContentDTO = new NewsAndCategoryAndContentDTO(news, category, content);

			newsAndCategoryAndContentDTOList.add(newsAndCategoryAndContentDTO);
		}

		listVO.setListNews(newsAndCategoryAndContentDTOList);

		return listVO;
	}

	@Override
	public ListVO list_NewsAndCategoryAndContent_BySearchAndPage(ListVO listVO) {

		List<NewsAndCategoryAndContentDTO> newsAndCategoryAndContentDTOList = new ArrayList<NewsAndCategoryAndContentDTO>();

		NewsAndCategoryAndContentDTO newsAndCategoryAndContentDTO;

		jsj_snews_category category;

		jsj_snews_content content;

		List<jsj_snews_news> newsList = snewsNewsDao.list_News_BySearchAndPage(listVO);

		// 匹配变色

		// 封装总记录数
		listVO.setTotalRecords(snewsNewsDao.get_News_TotalRecords_BySearch(listVO.getSearch()));

		System.out.println("总记录数:" + listVO.getTotalRecords());

		// 封装总页数
		listVO.setTotalPages(((listVO.getTotalRecords() - 1) / listVO.getPageSize()) + 1);

		if (listVO.getPageIndex() <= 1) {
			listVO.setHavePrePage(false);
		} else {
			listVO.setHavePrePage(true);
		}
		if (listVO.getPageIndex() >= listVO.getTotalPages()) {
			listVO.setHaveNextPage(false);
		} else {
			listVO.setHaveNextPage(true);
		}

		for (jsj_snews_news news : newsList) {

			content = snewsNewsDao.get_Content_ByNewsID(news);

			category = snewsCategoryDao.get_Category_ByNewsCategory(news);

			newsAndCategoryAndContentDTO = new NewsAndCategoryAndContentDTO(news, category, content);

			newsAndCategoryAndContentDTOList.add(newsAndCategoryAndContentDTO);
		}

		listVO.setListNews(newsAndCategoryAndContentDTOList);

		return listVO;
	}

	@Override
	public ListVO list_NewsAndCategoryAndContent_ByCategoryAndPage(ListVO listVO) {

		List<NewsAndCategoryAndContentDTO> newsAndCategoryAndContentDTOList = new ArrayList<NewsAndCategoryAndContentDTO>();

		NewsAndCategoryAndContentDTO newsAndCategoryAndContentDTO;

		jsj_snews_category category;

		jsj_snews_content content;

		List<jsj_snews_news> newsList = snewsNewsDao.list_News_ByCategoryAndPage(listVO);

		// 匹配变色

		// 封装总记录数
		listVO.setTotalRecords(snewsNewsDao.get_News_TotalRecords_ByCategory(listVO.getCategory()));

		System.out.println("总记录数:" + listVO.getTotalRecords());

		// 封装总页数
		listVO.setTotalPages(((listVO.getTotalRecords() - 1) / listVO.getPageSize()) + 1);

		if (listVO.getPageIndex() <= 1) {
			listVO.setHavePrePage(false);
		} else {
			listVO.setHavePrePage(true);
		}
		if (listVO.getPageIndex() >= listVO.getTotalPages()) {
			listVO.setHaveNextPage(false);
		} else {
			listVO.setHaveNextPage(true);
		}

		for (jsj_snews_news news : newsList) {

			content = snewsNewsDao.get_Content_ByNewsID(news);

			category = snewsCategoryDao.get_Category_ByNewsCategory(news);

			newsAndCategoryAndContentDTO = new NewsAndCategoryAndContentDTO(news, category, content);

			newsAndCategoryAndContentDTOList.add(newsAndCategoryAndContentDTO);
		}

		listVO.setListNews(newsAndCategoryAndContentDTOList);

		return listVO;
	};

	@Override
	public page_list_newsVO list_NewsAndCategoryAndContent_ByPage(page_list_newsVO page_list_news) {

		List<NewsAndCategoryAndContentDTO> newsAndCategoryAndContentDTOList = new ArrayList<NewsAndCategoryAndContentDTO>();

		NewsAndCategoryAndContentDTO newsAndCategoryAndContentDTO;

		jsj_snews_category category;

		jsj_snews_content content;

		List<jsj_snews_news> newsList = snewsNewsDao.list_News_ByPage(page_list_news);

		// 匹配变色
		if (page_list_news.getSearch() != null && !page_list_news.getSearch().getKeywords().equals("")) {
			System.out.println("高亮显示：" + page_list_news.getSearch().getKeywords());
			int i = 0;
			while (i < newsList.size()) {

				newsList.get(i).setNews_title(newsList.get(i).getNews_title().replaceAll(
						page_list_news.getSearch().getKeywords(),
						"<span style='color: #ff5063;'>" + page_list_news.getSearch().getKeywords() + "</span>"));

				newsList.get(i).setNews_keywords(newsList.get(i).getNews_keywords().replaceAll(
						page_list_news.getSearch().getKeywords(),
						"<span style='color: #ff5063;'>" + page_list_news.getSearch().getKeywords() + "</span>"));

				i++;
			}
		}

		// 封装总记录数
		page_list_news.setTotalRecords(snewsNewsDao.get_News_TotalRecords(page_list_news));

		// 封装总页数
		page_list_news.setTotalPages(((page_list_news.getTotalRecords() - 1) / page_list_news.getPageSize()) + 1);

		if (page_list_news.getPageIndex() <= 1) {
			page_list_news.setHavePrePage(false);
		} else {
			page_list_news.setHavePrePage(true);
		}
		if (page_list_news.getPageIndex() >= page_list_news.getTotalPages()) {
			page_list_news.setHaveNextPage(false);
		} else {
			page_list_news.setHaveNextPage(true);
		}

		for (jsj_snews_news news : newsList) {

			content = snewsNewsDao.get_Content_ByNewsID(news);

			category = snewsCategoryDao.get_Category_ByNewsCategory(news);

			newsAndCategoryAndContentDTO = new NewsAndCategoryAndContentDTO(news, category, content);

			newsAndCategoryAndContentDTOList.add(newsAndCategoryAndContentDTO);
		}

		page_list_news.setNewsAndCategoryAndContentDTOList(newsAndCategoryAndContentDTOList);

		return page_list_news;
	}

	@Override
	public void removeOldAnnex(jsj_snews_news oldNews, String remain_oldAnnex) {
		/*
		 * 获取路径
		 */
		String lj = "";
		try {
			Properties props = new Properties();
			props.load(this.getClass().getClassLoader().getResourceAsStream("file.properties"));
			lj = props.getProperty("lj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 
		 */
		String[] oldAnnexs = oldNews.getNews_annex().split(";");
		String[] remain_oldAnnexs = remain_oldAnnex.split(";");
		List<String> remove_oldAnnexList = new ArrayList<String>();
		for (int i = 0; i < oldAnnexs.length; i++) {
			for (int j = 0; j < remain_oldAnnexs.length; j++) {
				if ((remain_oldAnnexs[j]).equals(oldAnnexs[i])) {
					oldAnnexs[i] = null;
					break;
				}
			}
		}
		/*
		 * 删除
		 */
		for (int i = 0; i < oldAnnexs.length; i++) {
			if (oldAnnexs[i] != null) {
				remove_oldAnnexList.add(oldAnnexs[i]);
				String path = lj + "xxyjsjgcxy/xxyjsjgcxy_annex/snews_news/" + oldNews.getJsj_snews_news_id() + "_"
						+ oldAnnexs[i];
				File file = new File(path);
				file.delete();
			}
		}
	}

	@Override
	public void removeOldContentImg(jsj_snews_news news, jsj_snews_content content) {
		/*
		 * 获取路径
		 */
		String lj = "";
		try {
			Properties props = new Properties();
			props.load(this.getClass().getClassLoader().getResourceAsStream("file.properties"));
			lj = props.getProperty("lj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 
		 */

		/*
		 * 创建内容图片的列表
		 */
		List<String> imgNameList = new ArrayList<String>();
		String[] splitContent1 = content.getContent_text().split(news.getJsj_snews_news_id() + "_");
		if (splitContent1.length > 1) {
			System.out.println("-----------------------------有图片------------------------");
			System.out.println("splitContent1.length:" + splitContent1.length);
			for (int i = 1; i < splitContent1.length; i++) {
				String[] splitContent2 = splitContent1[i].split("\"");
				imgNameList.add(splitContent2[0]);
				System.out.println("splitContent2[0]:" + splitContent2[0]);
			}
		} else {
			System.out.println("-----------------------------无图片------------------------");
		}
		/*
		 * 删除已经删除的图片
		 */

		File root = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/content");

		File[] allFiles = root.listFiles();

		/*
		 * 将文件夹里所有图片挑出此新闻的
		 */
		for (File file : allFiles) {
			/*
			 * 图片文件
			 */
			String[] splitFileName = file.getName().split("_");
			if (splitFileName[0].equals(news.getJsj_snews_news_id())) {
				int j = 0;
				for (String imgName : imgNameList) {
					if (splitFileName[1].equals(imgName)) {
						j = 1;
						break;
					}
				}
				if (j == 0) {
					file.delete();
				}
			}
		}

	}

	@Override
	public jsj_snews_content removeContentTemporaryImg_saveContentImg(jsj_snews_news news, jsj_snews_content content) {
		/*
		 * 获取路径
		 */
		String lj = "";
		try {
			Properties props = new Properties();
			props.load(this.getClass().getClassLoader().getResourceAsStream("file.properties"));
			lj = props.getProperty("lj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 
		 */
		System.out.println(
				"deleteContentTemporaryImg_saveContentImg:-----newsID：----------" + news.getJsj_snews_news_id());
		/*
		 * 创建内容图片的列表
		 */
		List<String> imgNameList = new ArrayList<String>();
		String[] splitContent1 = content.getContent_text().split(news.getJsj_snews_news_id() + "_");
		if (splitContent1.length > 1) {
			System.out.println("-----------------------------有图片------------------------");
			System.out.println("splitContent1.length:" + splitContent1.length);
			for (int i = 1; i < splitContent1.length; i++) {
				String[] splitContent2 = splitContent1[i].split("\"");
				imgNameList.add(splitContent2[0]);
				System.out.println("splitContent2[0]:" + splitContent2[0]);
			}
		} else {
			System.out.println("-----------------------------无图片------------------------");
		}
		/*
		 * 转移临时图片
		 */

		File root = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/content_temporary");

		File[] allFiles = root.listFiles();

		/*
		 * 将文件夹里所有图片挑出此新闻的
		 */
		for (File file : allFiles) {
			String[] splitFileName = file.getName().split("_");

			if (splitFileName[0].equals(news.getJsj_snews_news_id())) {
				/*
				 * 此新闻的图片,如果图片在内容中有匹配，就转移，否则就删除
				 */
				System.out.println("splitFileName[1]:" + splitFileName[1]);
				System.out.println(imgNameList.toString());
				for (String imgName : imgNameList) {

					if (splitFileName[1].equals(imgName)) {
						/*
						 * 转移
						 */
						File newFile = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/content/" + file.getName());
						try {
							FileUtils.copyFile(file, newFile);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					}
				}
				/*
				 * 不管有无匹配到都要删除临时文件，存在的文件已经转移了
				 */
				file.delete();
			}

		}
		/*
		 * 替换内容的图片名
		 */
		content.setContent_text(content.getContent_text().replaceAll("getNewsTemporaryContentImg\\?imgName=",
				"getNewsContentImg?imgName="));
		return content;
	}

	@Override
	public List<NewsAndCategoryAndContentDTO> list_NewsAndCategoryAndContent_ByCategorySon_Num(String categoryName,
			int num) {

		List<NewsAndCategoryAndContentDTO> newsAndCategoryAndContentDTOList = new ArrayList<NewsAndCategoryAndContentDTO>();

		NewsAndCategoryAndContentDTO newsAndCategoryAndContentDTO;

		jsj_snews_category category;

		jsj_snews_content content;

		List<jsj_snews_category> categorySonList = snewsCategoryDao.listCategoryByFatherName(categoryName);

		List<jsj_snews_news> newsList = new ArrayList<jsj_snews_news>();

		// 已取几条
		int have_num = 0;

		for (jsj_snews_category categorySon : categorySonList) {

			have_num = have_num + newsList.size();
			System.out.println(have_num);
			if ((num - have_num) <= 0) {

			} else {
				System.out.println(num - have_num);
				System.out.println("sss");
				newsList.addAll(snewsNewsDao.list_News_ByCategory_Num(categorySon.getCategory_name(), num - have_num));
			}

		}

		System.out.println(newsList.toString());

		for (jsj_snews_news news : newsList) {

			content = snewsNewsDao.get_Content_ByNewsID(news);

			category = snewsCategoryDao.get_Category_ByNewsCategory(news);

			newsAndCategoryAndContentDTO = new NewsAndCategoryAndContentDTO(news, category, content);

			newsAndCategoryAndContentDTOList.add(newsAndCategoryAndContentDTO);
		}

		return newsAndCategoryAndContentDTOList;
	}

	@Override
	public List<NewsAndCategoryAndContentDTO> list_NewsAndCategoryAndContent_ByCategory_Num(String categoryName,
			int num) {

		List<NewsAndCategoryAndContentDTO> newsAndCategoryAndContentDTOList = new ArrayList<NewsAndCategoryAndContentDTO>();

		NewsAndCategoryAndContentDTO newsAndCategoryAndContentDTO;

		jsj_snews_category category;

		jsj_snews_content content;

		List<jsj_snews_news> newsList = snewsNewsDao.list_News_ByCategory_Num(categoryName, num);

		for (jsj_snews_news news : newsList) {

			content = snewsNewsDao.get_Content_ByNewsID(news);

			category = snewsCategoryDao.get_Category_ByNewsCategory(news);

			newsAndCategoryAndContentDTO = new NewsAndCategoryAndContentDTO(news, category, content);

			newsAndCategoryAndContentDTOList.add(newsAndCategoryAndContentDTO);
		}

		return newsAndCategoryAndContentDTOList;
	}

	@Override
	public List<NewsAndCategoryAndContentDTO> list_NewsAndCategoryAndContent_ByRecommend_Num(int num) {

		List<NewsAndCategoryAndContentDTO> newsAndCategoryAndContentDTOList = new ArrayList<NewsAndCategoryAndContentDTO>();

		NewsAndCategoryAndContentDTO newsAndCategoryAndContentDTO;

		jsj_snews_category category;

		jsj_snews_content content;

		List<jsj_snews_news> newsList = snewsNewsDao.list_News_ByRecommend_Num(num);

		for (jsj_snews_news news : newsList) {

			content = snewsNewsDao.get_Content_ByNewsID(news);

			category = snewsCategoryDao.get_Category_ByNewsCategory(news);

			newsAndCategoryAndContentDTO = new NewsAndCategoryAndContentDTO(news, category, content);

			newsAndCategoryAndContentDTOList.add(newsAndCategoryAndContentDTO);
		}

		return newsAndCategoryAndContentDTOList;
	}

	@Override
	public List<NewsAndCategoryAndContentDTO> list_NewsAndCategoryAndContent_ByKeywords_Num(String keywords, int num,
			String newsID) {

		List<NewsAndCategoryAndContentDTO> newsAndCategoryAndContentDTOList = new ArrayList<NewsAndCategoryAndContentDTO>();

		NewsAndCategoryAndContentDTO newsAndCategoryAndContentDTO;

		jsj_snews_category category;

		jsj_snews_content content;

		List<jsj_snews_news> newsList = snewsNewsDao.list_News_ByKeywords(keywords, newsID);

		for (jsj_snews_news news : newsList) {

			content = snewsNewsDao.get_Content_ByNewsID(news);

			category = snewsCategoryDao.get_Category_ByNewsCategory(news);

			newsAndCategoryAndContentDTO = new NewsAndCategoryAndContentDTO(news, category, content);

			newsAndCategoryAndContentDTOList.add(newsAndCategoryAndContentDTO);
		}

		return newsAndCategoryAndContentDTOList;
	}

	@Override
	public List<jsj_snews_news> listNewsAll() {

		return snewsNewsDao.list_News_All();
	}

	@Override
	public List<NewsAndCategoryAndContentDTO> list_NewsAndCategoryAndContent_All() {

		List<NewsAndCategoryAndContentDTO> newsAndCategoryAndContentDTOList = new ArrayList<NewsAndCategoryAndContentDTO>();

		NewsAndCategoryAndContentDTO newsAndCategoryAndContentDTO;

		jsj_snews_category category;

		jsj_snews_content content;

		List<jsj_snews_news> newsList = snewsNewsDao.list_News_All();

		for (jsj_snews_news news : newsList) {

			content = snewsNewsDao.get_Content_ByNewsID(news);

			category = snewsCategoryDao.get_Category_ByNewsCategory(news);

			newsAndCategoryAndContentDTO = new NewsAndCategoryAndContentDTO(news, category, content);

			newsAndCategoryAndContentDTOList.add(newsAndCategoryAndContentDTO);
		}

		return newsAndCategoryAndContentDTOList;
	}

	@Override
	public boolean save_Content(jsj_snews_content content) {

		content.setJsj_snews_content_id(UUID.randomUUID().toString());

		content.setContent_gmt_create(TimeUtil.getStringSecond());

		content.setContent_gmt_modified(content.getContent_gmt_create());

		System.out.println(content.toString());

		snewsNewsDao.saveContent(content);

		return true;
	}

	@Override
	public boolean save_News(jsj_snews_news news) {

		news.setNews_browse(0);

		news.setNews_gmt_create(TimeUtil.getStringSecond());

		news.setNews_gmt_modified(news.getNews_gmt_create());

		snewsNewsDao.saveNews(news);

		return true;
	}

	/*
	 * 
	 */
	private ScarouselService scarouselService;

	private SnewsNewsDao snewsNewsDao;

	private SnewsCategoryDao snewsCategoryDao;

	public SnewsCategoryDao getSnewsCategoryDao() {
		return snewsCategoryDao;
	}

	public ScarouselService getScarouselService() {
		return scarouselService;
	}

	public void setScarouselService(ScarouselService scarouselService) {
		this.scarouselService = scarouselService;
	}

	public void setSnewsCategoryDao(SnewsCategoryDao snewsCategoryDao) {
		this.snewsCategoryDao = snewsCategoryDao;
	}

	public SnewsNewsDao getSnewsNewsDao() {
		return snewsNewsDao;
	}

	public void setSnewsNewsDao(SnewsNewsDao snewsNewsDao) {
		this.snewsNewsDao = snewsNewsDao;
	}

}
