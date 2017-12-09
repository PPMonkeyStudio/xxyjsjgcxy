package com.xxyjsjgcxy.suser.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xxyjsjgcxy.scarousel.service.ScarouselService;
import com.xxyjsjgcxy.slink.domain.jsj_slink_link;
import com.xxyjsjgcxy.slink.service.SlinkLinkService;
import com.xxyjsjgcxy.snews.domain.NewsAndCategoryAndContentDTO;
import com.xxyjsjgcxy.snews.domain.jsj_snews_category;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;
import com.xxyjsjgcxy.snews.service.SnewsCategoryService;
import com.xxyjsjgcxy.snews.service.SnewsNewsService;
import com.xxyjsjgcxy.suser.domain.DetailsVO;
import com.xxyjsjgcxy.suser.domain.Index;
import com.xxyjsjgcxy.suser.domain.ListVO;
import com.xxyjsjgcxy.suser.service.SuserService;

@SuppressWarnings("serial")
public class SuserAction extends ActionSupport {

	private SuserService suserService;

	private SnewsCategoryService snewsCategoryService;

	private SnewsNewsService snewsNewsService;

	private SlinkLinkService slinkLinkService;

	private ScarouselService scarouselService;

	private jsj_snews_news news;

	private jsj_snews_category category;

	ListVO listVO;

	private String fileName;
	private InputStream inputStream;

	/*
	 * 
	 */
	public String logout() {

		ActionContext.getContext().getSession().remove("Admin");

		return "logout";
	}

	public String index() {
		/*
		 * 
		 */
		try {
			Properties props = new Properties();
			props.load(this.getClass().getClassLoader().getResourceAsStream("file.properties"));
			String lj = props.getProperty("lj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 
		 */
		Index index = new Index();

		List<jsj_snews_category> listCategory = snewsCategoryService.listCategoryByRankOne_ForHeader();
		ActionContext.getContext().getValueStack().set("listCategory", listCategory);

		List<jsj_snews_category> listAllCategory = snewsCategoryService.listCategoryAll();
		ActionContext.getContext().getValueStack().set("listAllCategory", listAllCategory);

		/*
		 * 
		 */
		List<NewsAndCategoryAndContentDTO> TZGG_Three = snewsNewsService
				.list_NewsAndCategoryAndContent_ByCategory_Num("通知公告", 3);
		// 删除图片
		for (NewsAndCategoryAndContentDTO TZGG : TZGG_Three) {
			TZGG.getContent().setContent_text(TZGG.getContent().getContent_text().replaceAll("<img.*\"[^>]*>", "【图片】"));
			TZGG.getContent()
					.setContent_text(TZGG.getContent().getContent_text().replaceAll("table.*</table>", "【表格】"));
		}

		List<NewsAndCategoryAndContentDTO> recommend_Nine = snewsNewsService
				.list_NewsAndCategoryAndContent_ByRecommend_Num(9);

		// 删除图片
		for (NewsAndCategoryAndContentDTO recommend : recommend_Nine) {
			recommend.getContent()
					.setContent_text(recommend.getContent().getContent_text().replaceAll("<img.*\"[^>]*>", "【图片】"));
			recommend.getContent()
					.setContent_text(recommend.getContent().getContent_text().replaceAll("<table.*</table>", "【表格】"));

		}

		List<NewsAndCategoryAndContentDTO> CGZS_Four = snewsNewsService
				.list_NewsAndCategoryAndContent_ByCategorySon_Num("成果展示", 9);

		List<jsj_slink_link> LJ = slinkLinkService.listLinkAll();

		List<jsj_snews_news> LB_B = scarouselService.getNewsBig();

		List<jsj_snews_news> LB_S = scarouselService.getNewsSmall();

		// System.out.println("LB_B:" + LB_B.toString());

		index.setTZGG_Three(TZGG_Three);
		index.setRecommend_Nine(recommend_Nine);
		index.setCGZS_Four(CGZS_Four);
		index.setLJ(LJ);
		index.setLB_B(LB_B);
		index.setLB_S(LB_S);
		/*
		 * 
		 */

		ActionContext.getContext().getValueStack().set("indexVO", index);

		return "index";
	}

	public String indexOld() {

		Index index = new Index();

		List<jsj_snews_category> listCategory = snewsCategoryService.listCategoryByRankOne_ForHeader();
		ActionContext.getContext().getValueStack().set("listCategory", listCategory);

		List<jsj_snews_category> listAllCategory = snewsCategoryService.listCategoryAll();
		ActionContext.getContext().getValueStack().set("listAllCategory", listAllCategory);

		/*
		 * 
		 */
		List<NewsAndCategoryAndContentDTO> TZGG_Three = snewsNewsService
				.list_NewsAndCategoryAndContent_ByCategory_Num("通知公告", 3);
		// 删除图片
		for (NewsAndCategoryAndContentDTO TZGG : TZGG_Three) {
			TZGG.getContent().setContent_text(TZGG.getContent().getContent_text().replaceAll("<img.*\"[^>]*>", "【图片】"));
			TZGG.getContent()
					.setContent_text(TZGG.getContent().getContent_text().replaceAll("table.*</table>", "【表格】"));
		}

		List<NewsAndCategoryAndContentDTO> recommend_Nine = snewsNewsService
				.list_NewsAndCategoryAndContent_ByRecommend_Num(9);

		// 删除图片
		for (NewsAndCategoryAndContentDTO recommend : recommend_Nine) {
			recommend.getContent()
					.setContent_text(recommend.getContent().getContent_text().replaceAll("<img.*\"[^>]*>", "【图片】"));
			recommend.getContent()
					.setContent_text(recommend.getContent().getContent_text().replaceAll("<table.*</table>", "【表格】"));

		}

		List<NewsAndCategoryAndContentDTO> CGZS_Four = snewsNewsService
				.list_NewsAndCategoryAndContent_ByCategorySon_Num("成果展示", 9);

		List<jsj_slink_link> LJ = slinkLinkService.listLinkAll();

		List<jsj_snews_news> LB_B = scarouselService.getNewsBig();

		List<jsj_snews_news> LB_S = scarouselService.getNewsSmall();

		// System.out.println("LB_B:" + LB_B.toString());

		index.setTZGG_Three(TZGG_Three);
		index.setRecommend_Nine(recommend_Nine);
		index.setCGZS_Four(CGZS_Four);
		index.setLJ(LJ);
		index.setLB_B(LB_B);
		index.setLB_S(LB_S);
		/*
		 * 
		 */

		ActionContext.getContext().getValueStack().set("indexVO", index);

		return "indexOld";
	}

	public String news_list() {

		List<jsj_snews_category> listCategory = snewsCategoryService.listCategoryByRankOne_ForHeader();
		ActionContext.getContext().getValueStack().set("listCategory", listCategory);

		List<jsj_snews_category> listAllCategory = snewsCategoryService.listCategoryAll();
		ActionContext.getContext().getValueStack().set("listAllCategory", listAllCategory);

		/*
		 * 
		 */

		if (listVO.getDate() != null) {
			try {
				listVO = snewsNewsService.list_NewsAndCategoryAndContent_ByDateAndPage(listVO);
			} catch (ParseException e) {

				e.printStackTrace();
			}
		} else if (listVO.getSearch() != null) {

			listVO = snewsNewsService.list_NewsAndCategoryAndContent_BySearchAndPage(listVO);
		} else {

			listVO = snewsNewsService.list_NewsAndCategoryAndContent_ByCategoryAndPage(listVO);
		}

		ActionContext.getContext().getValueStack().set("listVO", listVO);

		return "news_list";
	}

	public String news_details() {

		List<jsj_snews_category> listCategory = snewsCategoryService.listCategoryByRankOne_ForHeader();
		ActionContext.getContext().getValueStack().set("listCategory", listCategory);

		List<jsj_snews_category> listAllCategory = snewsCategoryService.listCategoryAll();
		ActionContext.getContext().getValueStack().set("listAllCategory", listAllCategory);

		/*
		 * 
		 */

		DetailsVO detailsVO = new DetailsVO();

		NewsAndCategoryAndContentDTO newsCategoryContent = null;
		if (category != null) {
			newsCategoryContent = snewsNewsService.get_NewsAndCategoryAndContent_ByNewsID(category.getCategory_news());

			String keywords = snewsNewsService.get_NewsAndCategoryAndContent_ByNewsID(category.getCategory_news())
					.getNews().getNews_keywords();
			String newsID = snewsNewsService.get_NewsAndCategoryAndContent_ByNewsID(category.getCategory_news())
					.getNews().getJsj_snews_news_id();

			List<NewsAndCategoryAndContentDTO> relateNews = snewsNewsService
					.list_NewsAndCategoryAndContent_ByKeywords_Num(keywords, 4, newsID);

			for (NewsAndCategoryAndContentDTO relate : relateNews) {

				relate.getContent()
						.setContent_text(relate.getContent().getContent_text().replaceAll("<img.*\"[^>]*>", "【图片】"));
				relate.getContent()
						.setContent_text(relate.getContent().getContent_text().replaceAll("<table.*</table>", "【表格】"));

			}

			detailsVO.setNewsCategoryContent(newsCategoryContent);

			detailsVO.setRelateNews(relateNews);

			ActionContext.getContext().getValueStack().set("detailsVO", detailsVO);

		} else {

			newsCategoryContent = snewsNewsService.get_NewsAndCategoryAndContent_ByNewsID(news.getJsj_snews_news_id());

			String keywords = snewsNewsService.get_NewsAndCategoryAndContent_ByNewsID(news.getJsj_snews_news_id())
					.getNews().getNews_keywords();
			String newsID = snewsNewsService.get_NewsAndCategoryAndContent_ByNewsID(news.getJsj_snews_news_id())
					.getNews().getJsj_snews_news_id();

			List<NewsAndCategoryAndContentDTO> relateNews = snewsNewsService
					.list_NewsAndCategoryAndContent_ByKeywords_Num(keywords, 4, newsID);

			for (NewsAndCategoryAndContentDTO relate : relateNews) {

				relate.getContent()
						.setContent_text(relate.getContent().getContent_text().replaceAll("<img.*\"[^>]*>", "【图片】"));
				relate.getContent()
						.setContent_text(relate.getContent().getContent_text().replaceAll("<table.*</table>", "【表格】"));
			}

			detailsVO.setNewsCategoryContent(newsCategoryContent);

			detailsVO.setRelateNews(relateNews);

			ActionContext.getContext().getValueStack().set("detailsVO", detailsVO);

		}

		// 图片浮动靠左
		// newsCategoryContent.getContent().setContent_text(
		// newsCategoryContent.getContent().getContent_text().replaceAll("<img
		// ", "<img style=\"float:left;\" "));

		// 浏览次数
		snewsNewsService.updateNewsBrowse(newsCategoryContent.getNews().getJsj_snews_news_id());

		return "news_details";
	}

	public String getAnnex() {
		File file = new File("C:/xxyjsjgcxy/xxyjsjgcxy_annex/snews_news/" + fileName);

		String[] split = fileName.split("_");

		fileName = split[1];
		// 解决中文名称丢失问题
		try {
			fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return "getAnnex";
	}

	/*
	 * 
	 */

	public SuserService getSuserService() {
		return suserService;
	}

	public ListVO getListVO() {
		return listVO;
	}

	public void setListVO(ListVO listVO) {
		this.listVO = listVO;
	}

	public void setSuserService(SuserService suserService) {
		this.suserService = suserService;
	}

	public SnewsCategoryService getSnewsCategoryService() {
		return snewsCategoryService;
	}

	public ScarouselService getScarouselService() {
		return scarouselService;
	}

	public void setScarouselService(ScarouselService scarouselService) {
		this.scarouselService = scarouselService;
	}

	public void setSnewsCategoryService(SnewsCategoryService snewsCategoryService) {
		this.snewsCategoryService = snewsCategoryService;
	}

	public SnewsNewsService getSnewsNewsService() {
		return snewsNewsService;
	}

	public jsj_snews_category getCategory() {
		return category;
	}

	public void setCategory(jsj_snews_category category) {
		this.category = category;
	}

	public void setSnewsNewsService(SnewsNewsService snewsNewsService) {
		this.snewsNewsService = snewsNewsService;
	}

	public SlinkLinkService getSlinkLinkService() {
		return slinkLinkService;
	}

	public void setSlinkLinkService(SlinkLinkService slinkLinkService) {
		this.slinkLinkService = slinkLinkService;
	}

	public jsj_snews_news getNews() {
		return news;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void setNews(jsj_snews_news news) {
		this.news = news;
	}

}
