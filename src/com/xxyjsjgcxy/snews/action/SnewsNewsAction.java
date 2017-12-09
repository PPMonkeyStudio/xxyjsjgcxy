package com.xxyjsjgcxy.snews.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xxyjsjgcxy.snews.domain.NewsAndCategoryAndContentDTO;
import com.xxyjsjgcxy.snews.domain.SearchNewsListDTO;
import com.xxyjsjgcxy.snews.domain.jsj_snews_content;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;
import com.xxyjsjgcxy.snews.domain.page_list_newsVO;
import com.xxyjsjgcxy.snews.service.SnewsNewsService;

import util.TimeUtil;

@SuppressWarnings("serial")
public class SnewsNewsAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {

	private SnewsNewsService snewsNewsService;

	private page_list_newsVO page_list_news;

	private jsj_snews_news news;

	private jsj_snews_content content;

	private String page;
	//
	private String option;

	private SearchNewsListDTO searchNewsList;

	// 修改后剩余的原附件
	private String remain_oldAnnex;

	private HttpServletResponse http_response;

	private HttpServletRequest http_request;

	/*
	 * 
	 */
	private File news_bimg;
	private String news_bimgFileName;
	private String news_bimgContentType;
	private File news_simg;
	private String news_simgFileName;
	private String news_simgContentType;

	private File[] file;
	private String[] fileFileName;
	private String[] fileContentType;

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public String updateNewsPage() {

		NewsAndCategoryAndContentDTO newsAndCategoryAndContentDTO = snewsNewsService
				.get_NewsAndCategoryAndContent_ByNewsID(news.getJsj_snews_news_id());

		ActionContext.getContext().getValueStack().set("newsAndCategoryAndContentDTO", newsAndCategoryAndContentDTO);

		ActionContext.getContext().getValueStack().set("option", "update");

		ActionContext.getContext().getValueStack().set("page", "page_create_news");

		return "updateNewsPage";
	}

	public void ifRepeatNewsTitle() {

		if ("save".equals(option)) {
			if (snewsNewsService.ifRepeatNewsTitleBySave(news.getNews_title())) {
				try {

					http_response.setContentType("text/html;charset=utf-8");

					http_response.getWriter().write("yes");

				} catch (IOException e) {

					e.printStackTrace();
				}
			} else {
				try {

					http_response.setContentType("text/html;charset=utf-8");

					http_response.getWriter().write("no");

				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		} else {
			if (snewsNewsService.ifRepeatNewsTitleByUpdate(news.getJsj_snews_news_id(), news.getNews_title())) {
				try {

					http_response.setContentType("text/html;charset=utf-8");

					http_response.getWriter().write("yes");

				} catch (IOException e) {

					e.printStackTrace();
				}
			} else {
				try {

					http_response.setContentType("text/html;charset=utf-8");

					http_response.getWriter().write("no");

				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

	}

	public void deleteNews() {
		snewsNewsService.removeNewsByID(news);

		try {

			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write("success");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void getNewsUUID() {
		String newsUUID = UUID.randomUUID().toString();
		try {
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write(newsUUID);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void saveNewsContentImg() {
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
		if (file != null) {
			int i = 0;
			String[] imgUrl = new String[file.length];
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();// 格式化
			gsonBuilder.disableHtmlEscaping();// 避免'='转译成'\'
			Gson gson = gsonBuilder.create();

			while (i < file.length) {

				String filePath;
				String fileName = UUID.randomUUID().toString()
						+ fileFileName[i].substring(fileFileName[i].lastIndexOf("."));
				filePath = lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/content_temporary/" + news.getJsj_snews_news_id()
						+ "_" + fileName;

				File newFile = new File(filePath);
				try {
					FileUtils.copyFile(file[i], newFile);
				} catch (IOException e) {
					e.printStackTrace();
				}

				imgUrl[i] = "/xxyjsjgcxy/snews/img_getNewsTemporaryContentImg?imgName=" + news.getJsj_snews_news_id()
						+ "_" + fileName;

				i++;
			}
			/*
			 * 返回
			 */

			Map<String, Object> map = new HashMap<>();
			map.put("error", 0);
			map.put("url", imgUrl);
			/*
			 * 
			 */
			try {
				http_response.setContentType("text/html;charset=utf-8");
				http_response.getWriter().write(gson.toJson(map));
				System.out.println(gson.toJson(map));
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	public void updateNews() {
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
		System.out.println("-----------------------------updateNews-------------------------------");

		NewsAndCategoryAndContentDTO oldNewsAndCategoryAndContentDTO = snewsNewsService
				.get_NewsAndCategoryAndContent_ByNewsID(news.getJsj_snews_news_id());

		/*
		 * 大小图
		 */
		if (news_bimg != null) {
			if (news_bimg.length() <= 50 * 1024 * 1024) {
				if (!oldNewsAndCategoryAndContentDTO.getNews().getNews_bimg().equals("default.jpg")) {
					File oldBimg = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/bimg/"
							+ oldNewsAndCategoryAndContentDTO.getNews().getNews_bimg());
					oldBimg.delete();
				}
				String filePath;
				String fileName = UUID.randomUUID().toString()
						+ news_bimgFileName.substring(news_bimgFileName.lastIndexOf("."));
				filePath = lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/bimg/" + fileName;
				oldNewsAndCategoryAndContentDTO.getNews().setNews_bimg(fileName);
				File newFile = new File(filePath);
				try {
					FileUtils.copyFile(news_bimg, newFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (news_simg != null) {
			if (news_simg.length() <= 50 * 1024 * 1024) {
				if (!oldNewsAndCategoryAndContentDTO.getNews().getNews_simg().equals("default.jpg")) {
					File oldSimg = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/simg/"
							+ oldNewsAndCategoryAndContentDTO.getNews().getNews_simg());
					oldSimg.delete();
				}
				String filePath;
				String fileName = UUID.randomUUID().toString()
						+ news_simgFileName.substring(news_simgFileName.lastIndexOf("."));
				filePath = lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/simg/" + fileName;
				oldNewsAndCategoryAndContentDTO.getNews().setNews_simg(fileName);
				File newFile = new File(filePath);
				try {
					FileUtils.copyFile(news_simg, newFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		/*
		 * 标题、关键词、来源、时间
		 */
		oldNewsAndCategoryAndContentDTO.getNews().setNews_title(news.getNews_title());
		oldNewsAndCategoryAndContentDTO.getNews().setNews_keywords(news.getNews_keywords());

		oldNewsAndCategoryAndContentDTO.getNews().setNews_source(news.getNews_source());
		oldNewsAndCategoryAndContentDTO.getNews().setNews_gmt_show(news.getNews_gmt_show());
		oldNewsAndCategoryAndContentDTO.getNews().setNews_gmt_modified(TimeUtil.getStringSecond());

		/*
		 * 内容
		 */

		content.setContent_text(content.getContent_text().replaceAll("border=\"0\"",
				"border=\"0\" class=\"table table-striped table-bordered table-hover\""));

		oldNewsAndCategoryAndContentDTO.getContent().setContent_text(content.getContent_text());

		snewsNewsService.removeContentTemporaryImg_saveContentImg(oldNewsAndCategoryAndContentDTO.getNews(),
				oldNewsAndCategoryAndContentDTO.getContent());
		snewsNewsService.removeOldContentImg(oldNewsAndCategoryAndContentDTO.getNews(),
				oldNewsAndCategoryAndContentDTO.getContent());
		/*
		 * 附件
		 */
		// 修改后剩余的原附件

		if (remain_oldAnnex != null) {
			System.out.println("remain_oldAnnex:" + remain_oldAnnex);
			System.out.println("旧附件已修改改");
			snewsNewsService.removeOldAnnex(oldNewsAndCategoryAndContentDTO.getNews(), remain_oldAnnex);
		} else {
			System.out.println("remain_oldAnnex:" + remain_oldAnnex);
			System.out.println("旧附件未修改");
		}

		if (file != null) {
			System.out.println("附件数：" + file.length);
			int i = 0;
			while (i < file.length) {
				String filePath;
				String fileName = fileFileName[i];
				filePath = lj + "xxyjsjgcxy/xxyjsjgcxy_annex/snews_news/" + news.getJsj_snews_news_id() + "_"
						+ fileName;
				System.out.println(fileName);
				if (i == 0) {
					news.setNews_annex(fileName);
				} else {
					news.setNews_annex((news.getNews_annex() + ";" + fileName));
				}

				File newFile = new File(filePath);
				try {
					FileUtils.copyFile(file[i], newFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				i++;
			}
			news.setNews_num_annex(file.length);
			System.out.println("新附件：" + news.getNews_annex());
		} else {
			System.out.println("未上传新附件");

		}

		System.out.println("news:" + news.getNews_annex());
		System.out.println("olC:" + oldNewsAndCategoryAndContentDTO.getNews().getNews_annex());
		System.out.println("remain:" + remain_oldAnnex);

		// 旧附件未变动
		if (remain_oldAnnex == null) {
			System.out.println("旧附件未变动");
			// 旧附件为空
			if (oldNewsAndCategoryAndContentDTO.getNews().getNews_annex() == null
					|| oldNewsAndCategoryAndContentDTO.getNews().getNews_annex().equals("")
					|| oldNewsAndCategoryAndContentDTO.getNews().getNews_annex().equals("null")) {
				System.out.println("旧附件为空");
				// 新附件为空
				if (news.getNews_annex().equals("") || news.getNews_annex() == null) {
					System.out.println("新附件为空");
					news.setNews_annex("");
				}
				// 新附件不为空
				else {
					System.out.println("新附件不为空");
					// 不变动
				}
			}
			// 旧附件不为空
			else {
				System.out.println("旧附件不为空");
				// 新附件为空
				if (news.getNews_annex().equals("") || news.getNews_annex() == null) {
					System.out.println("新附件为空");
					news.setNews_annex(oldNewsAndCategoryAndContentDTO.getNews().getNews_annex());
				}
				// 新附件不为空
				else {
					System.out.println("新附件不为空");
					news.setNews_annex(
							oldNewsAndCategoryAndContentDTO.getNews().getNews_annex() + ";" + news.getNews_annex());
				}
			}
		}
		// 旧附件全部删除了
		else if (remain_oldAnnex.equals("")) {
			System.out.println("旧附件全部删除了");
			// 新附件为空
			if (news.getNews_annex().equals("") || news.getNews_annex() == null) {
				System.out.println("新附件为空");
				news.setNews_annex("");
			}
			// 新附件不为空
			else {
				System.out.println("新附件不为空");
				// 不变动
			}
		}
		// 旧附件删除了一部分
		else {
			System.out.println("旧附件删除了一部分");
			// 新附件为空
			if (news.getNews_annex().equals("") || news.getNews_annex() == null) {
				System.out.println("新附件为空");
				news.setNews_annex(remain_oldAnnex);
			}
			// 新附件不为空
			else {
				System.out.println("新附件不为空");
				news.setNews_annex(remain_oldAnnex + ";" + news.getNews_annex());
			}
		}

		if (news.getNews_annex() == null || news.getNews_annex().length() == 0) {
			news.setNews_num_annex(0);
		} else {
			news.setNews_num_annex((news.getNews_annex().split(";")).length);
		}

		System.out.println("1最终:" + news.getNews_annex());
		System.out.println("最终:" + news.getNews_num_annex());
		oldNewsAndCategoryAndContentDTO.getNews().setNews_annex(news.getNews_annex());
		oldNewsAndCategoryAndContentDTO.getNews().setNews_num_annex(news.getNews_num_annex());
		/*
		 * 类别
		 */
		oldNewsAndCategoryAndContentDTO.getNews().setNews_category(news.getNews_category());
		/*
		 * 推荐、发布
		 */
		oldNewsAndCategoryAndContentDTO.getNews().setNews_recommend(news.getNews_recommend());
		oldNewsAndCategoryAndContentDTO.getNews().setNews_publish(news.getNews_publish());
		/*
		 * 更新
		 */
		snewsNewsService.updateNews(oldNewsAndCategoryAndContentDTO.getNews());
		snewsNewsService.updateContent(oldNewsAndCategoryAndContentDTO.getContent());
	}

	public void saveNews() {
		String lj = "";
		try {
			Properties props = new Properties();
			props.load(this.getClass().getClassLoader().getResourceAsStream("file.properties"));
			lj = props.getProperty("lj");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 大图
		 */
		if (news_bimg != null) {
			if (news_bimg.length() <= 50 * 1024 * 1024) {
				String filePath;
				String fileName = UUID.randomUUID().toString()
						+ news_bimgFileName.substring(news_bimgFileName.lastIndexOf("."));
				filePath = lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/bimg/" + fileName;
				news.setNews_bimg(fileName);
				File newFile = new File(filePath);
				try {
					FileUtils.copyFile(news_bimg, newFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			news.setNews_bimg("default.jpg");
		}
		/*
		 * 小图
		 */
		if (news_simg != null) {
			if (news_simg.length() <= 50 * 1024 * 1024) {
				String filePath;
				String fileName = UUID.randomUUID().toString()
						+ news_simgFileName.substring(news_simgFileName.lastIndexOf("."));
				filePath = lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/simg/" + fileName;
				news.setNews_simg(fileName);
				File newFile = new File(filePath);
				try {
					FileUtils.copyFile(news_simg, newFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			news.setNews_simg("default.jpg");
		}

		/*
		 * 附件
		 */
		if (file != null) {

			int i = 0;
			while (i < file.length) {
				String filePath;
				String fileName = fileFileName[i];
				filePath = lj + "xxyjsjgcxy/xxyjsjgcxy_annex/snews_news/" + news.getJsj_snews_news_id() + "_"
						+ fileName;
				System.out.println(fileName);

				news.setNews_annex(news.getNews_annex() + ";" + fileFileName[i]);

				File newFile = new File(filePath);
				try {
					FileUtils.copyFile(file[i], newFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				i++;
			}
			news.setNews_annex(news.getNews_annex().substring(1));
			System.out.println(news.getNews_annex());
			news.setNews_num_annex(file.length);
		} else {
			System.out.println("未上传附件");
			news.setNews_num_annex(0);
		}

		/*
		 * 其他
		 */
		snewsNewsService.save_News(news);

		/*
		 * 内容的图片处理
		 */
		System.out.println("content:" + content);
		content = snewsNewsService.removeContentTemporaryImg_saveContentImg(news, content);
		/*
		 * 内容表
		 */

		content.setContent_news(news.getJsj_snews_news_id());
		content.setContent_text(content.getContent_text().replaceAll("border=\"0\"",
				"border=\"0\" class=\"table table-striped table-bordered table-hover\""));
		snewsNewsService.save_Content(content);

		/*
		 * end
		 */
	}

	public String page_create_news() {

		ActionContext.getContext().getValueStack().set("page", page);

		return "page_create_news";
	}

	public void listNewsAll() {

		List<jsj_snews_news> newsList = snewsNewsService.listNewsAll();

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();

		try {

			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write(gson.toJson(newsList));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String page_list_news() {
		if (searchNewsList != null) {
			page_list_news.setSearch(searchNewsList);

		}
		page_list_news = snewsNewsService.list_NewsAndCategoryAndContent_ByPage(page_list_news);

		ActionContext.getContext().getValueStack().set("page_list_news", page_list_news);

		ActionContext.getContext().getValueStack().set("page", "page_list_news");

		return "page_list_news";
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	public void setServletRequest(HttpServletRequest http_request) {

		this.http_request = http_request;

	}

	public HttpServletResponse getHttp_response() {
		return http_response;
	}

	public void setHttp_response(HttpServletResponse http_response) {
		this.http_response = http_response;
	}

	public HttpServletRequest getHttp_request() {
		return http_request;
	}

	public void setHttp_request(HttpServletRequest http_request) {
		this.http_request = http_request;
	}

	public SnewsNewsService getSnewsNewsService() {
		return snewsNewsService;
	}

	public void setSnewsNewsService(SnewsNewsService snewsNewsService) {
		this.snewsNewsService = snewsNewsService;
	}

	public jsj_snews_news getNews() {
		return news;
	}

	public jsj_snews_content getContent() {
		return content;
	}

	public void setContent(jsj_snews_content content) {
		this.content = content;
	}

	public void setNews(jsj_snews_news news) {
		this.news = news;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public File getNews_bimg() {
		return news_bimg;
	}

	public void setNews_bimg(File news_bimg) {
		this.news_bimg = news_bimg;
	}

	public String getNews_bimgFileName() {
		return news_bimgFileName;
	}

	public void setNews_bimgFileName(String news_bimgFileName) {
		this.news_bimgFileName = news_bimgFileName;
	}

	public String getNews_bimgContentType() {
		return news_bimgContentType;
	}

	public page_list_newsVO getPage_list_news() {
		return page_list_news;
	}

	public void setPage_list_news(page_list_newsVO page_list_news) {
		this.page_list_news = page_list_news;
	}

	public void setNews_bimgContentType(String news_bimgContentType) {
		this.news_bimgContentType = news_bimgContentType;
	}

	public File getNews_simg() {
		return news_simg;
	}

	public void setNews_simg(File news_simg) {
		this.news_simg = news_simg;
	}

	public String getNews_simgFileName() {
		return news_simgFileName;
	}

	public SearchNewsListDTO getSearchNewsList() {
		return searchNewsList;
	}

	public void setSearchNewsList(SearchNewsListDTO searchNewsList) {
		this.searchNewsList = searchNewsList;
	}

	public void setNews_simgFileName(String news_simgFileName) {
		this.news_simgFileName = news_simgFileName;
	}

	public String getNews_simgContentType() {
		return news_simgContentType;
	}

	public void setNews_simgContentType(String news_simgContentType) {
		this.news_simgContentType = news_simgContentType;
	}

	public String getRemain_oldAnnex() {
		return remain_oldAnnex;
	}

	public void setRemain_oldAnnex(String remain_oldAnnex) {
		this.remain_oldAnnex = remain_oldAnnex;
	}

	@Override
	public void setServletResponse(HttpServletResponse http_response) {

		this.http_response = http_response;

	}

}
