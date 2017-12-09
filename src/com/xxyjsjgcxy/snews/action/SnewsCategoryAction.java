package com.xxyjsjgcxy.snews.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
import com.xxyjsjgcxy.snews.domain.CategoryListDTO;
import com.xxyjsjgcxy.snews.domain.jsj_snews_category;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;
import com.xxyjsjgcxy.snews.service.SnewsCategoryService;

@SuppressWarnings("serial")
public class SnewsCategoryAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {

	private SnewsCategoryService snewsCategoryService;

	private jsj_snews_news news;

	private jsj_snews_category category;

	//
	private String page;
	//
	private String option;

	private File file;

	private String fileFileName;

	private HttpServletResponse http_response;

	private HttpServletRequest http_request;

	/*
	 * 必须要有，会自动寻找这两个
	 */
	private File category_img;
	private String category_imgFileName;
	private String category_imgContentType;
	/*
	 * 
	 */
	private File news_bimg;
	private String news_bimgFileName;
	private String news_bimgContentType;
	private File news_simg;
	private String news_simgFileName;
	private String news_simgContentType;

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public String page_create_category() {

		if (option.equals("update")) {
			category = snewsCategoryService.getCategoryByID(category);
		} else if (option.equals("create")) {

		}

		// 为了设置父类别
		ActionContext.getContext().getValueStack().set("category", category);

		ActionContext.getContext().getValueStack().set("option", option);

		ActionContext.getContext().getValueStack().set("page", page);

		return "page_create_category";
	}

	public String page_list_category() {

		/*
		 * 
		 */
		List<CategoryListDTO> categoryListDTO = snewsCategoryService.listCategoryOneAndSon();

		/*
		 * 
		 */
		ActionContext.getContext().getValueStack().set("categoryListDTO", categoryListDTO);

		ActionContext.getContext().getValueStack().set("page", page);

		return "page_list_category";
	}

	/*
	 * 修改类别
	 */
	public void update_category() {
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
		ActionContext.getContext().getValueStack().set("page", page);

		jsj_snews_category oldCategory = snewsCategoryService.getCategoryByID(category);

		if (category_img != null) {
			if (category_img.length() <= 5242800) {

				String filePath;

				String fileName = UUID.randomUUID().toString()
						+ category_imgFileName.substring(category_imgFileName.lastIndexOf("."));

				filePath = lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_category/" + fileName;

				System.out.println("改名后fileName:" + fileName);

				category.setCategory_img(fileName);

				// 存储文件变量storageFile
				File newFile = new File(filePath);

				try {

					FileUtils.copyFile(category_img, newFile);

				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		} else {
			category.setCategory_img(oldCategory.getCategory_img());
		}

		snewsCategoryService.updateCategoryAllByID(category);

		try {

			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write("success");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/*
	 * 创建类别
	 */
	public void save_category() {
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
		 * 验证类别名称，图片类型
		 */

		if (snewsCategoryService.getCategoryByName(category) != null) {

			/*
			 * 找到名称相同的category了
			 */

			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();// 格式化
			Gson gson = gsonBuilder.create();

			try {

				http_response.setContentType("text/html;charset=utf-8");

				http_response.getWriter().write(gson.toJson("类名重复，不可使用此类名"));

			} catch (IOException e) {

				e.printStackTrace();
			}

			return;
		}

		/*
		 * 存储图片
		 */
		if (category_img != null) {
			if (category_img.length() <= 5242800) {

				String filePath;

				String fileName = UUID.randomUUID().toString()
						+ category_imgFileName.substring(category_imgFileName.lastIndexOf("."));

				filePath = lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_category/" + fileName;

				System.out.println("改名后fileName:" + fileName);

				category.setCategory_img(fileName);

				// 存储文件变量storageFile
				File newFile = new File(filePath);

				try {

					FileUtils.copyFile(category_img, newFile);

				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		} else {
			category.setCategory_img("default.jpg");
		}

		/*
		 * 存储数据
		 */
		snewsCategoryService.saveCategory(category);

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		try {

			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write(gson.toJson("success"));

			ActionContext.getContext().getValueStack().set("page", page);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/*
	 * 获得所有一级类别
	 */
	public void list_category_rankOne() {

		List<jsj_snews_category> categoryList = snewsCategoryService.listCategoryByRankOne();

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();

		try {

			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write(gson.toJson(categoryList));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void listCategoryAll() {

		List<jsj_snews_category> categoryList = snewsCategoryService.listCategoryAll();

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();

		try {

			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write(gson.toJson(categoryList));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void listCategoryRankTwo() {

		List<jsj_snews_category> categoryList = snewsCategoryService.listCategoryRankTwo();

		categoryList.addAll(snewsCategoryService.listCategoryByName("通知公告"));

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();

		try {

			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write(gson.toJson(categoryList));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/*
	 * 修改category_show
	 */
	public void update_category_show() {

		snewsCategoryService.updateCategoryShowByID(category);

		try {

			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write("success");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void delete_category() {

		snewsCategoryService.removeCategoryByID(category);

		try {

			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write("success");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public File getFile() {
		return file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public void setFile(File file) {
		this.file = file;
	}

	/*
	 * 
	 */

	public File getNews_bimg() {
		return news_bimg;
	}

	public SnewsCategoryService getSnewsCategoryService() {
		return snewsCategoryService;
	}

	public void setSnewsCategoryService(SnewsCategoryService snewsCategoryService) {
		this.snewsCategoryService = snewsCategoryService;
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

	public void setNews_simgFileName(String news_simgFileName) {
		this.news_simgFileName = news_simgFileName;
	}

	public String getNews_simgContentType() {
		return news_simgContentType;
	}

	public void setNews_simgContentType(String news_simgContentType) {
		this.news_simgContentType = news_simgContentType;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public File getCategory_img() {
		return category_img;
	}

	public void setCategory_img(File category_img) {
		this.category_img = category_img;
	}

	public String getCategory_imgFileName() {
		return category_imgFileName;
	}

	public void setCategory_imgFileName(String category_imgFileName) {
		this.category_imgFileName = category_imgFileName;
	}

	public String getCategory_imgContentType() {
		return category_imgContentType;
	}

	public void setCategory_imgContentType(String category_imgContentType) {
		this.category_imgContentType = category_imgContentType;
	}

	public jsj_snews_category getCategory() {
		return category;
	}

	public void setCategory(jsj_snews_category category) {
		this.category = category;
	}

	public jsj_snews_news getNews() {
		return news;
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

	@Override
	public void setServletRequest(HttpServletRequest http_request) {

		this.http_request = http_request;

	}

	@Override
	public void setServletResponse(HttpServletResponse http_response) {

		this.http_response = http_response;

	}

}
