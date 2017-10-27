package com.xxyjsjgcxy.scarousel.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xxyjsjgcxy.scarousel.domain.imgPageBean;
import com.xxyjsjgcxy.scarousel.domain.newsPageBean;
import com.xxyjsjgcxy.scarousel.service.ScarouselService;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;

public class ScarouselAction extends ActionSupport {

	private ScarouselService scarouselService;
	private int page;
	private String img_group;
	private String img_news;
	private String queryType;
	private String title;
	private String jsj_scarousel_img_id[];

	public ScarouselAction() {
	}

	public ScarouselService getScarouselService() {
		return scarouselService;
	}

	public void setScarouselService(ScarouselService scarouselService) {
		this.scarouselService = scarouselService;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void getNews() throws IOException {

		newsPageBean pageBean = scarouselService.getNews(page);
		Gson gson = new Gson();
		String result = gson.toJson(pageBean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	public String getImg_group() {
		return img_group;
	}

	public void setImg_group(String img_group) {
		this.img_group = img_group;
	}

	public String getImg_news() {
		return img_news;
	}

	public void setImg_news(String img_news) {
		this.img_news = img_news;
	}

	public void addToCarousel() throws IOException {

		String result = scarouselService.addToCarousel(img_group, img_news);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public void getCarouselImg() throws IOException {

		// String d = new String(queryType.getBytes("iso-8859-1"), "UTF-8");
		imgPageBean pageBean = scarouselService.getCarouselImg(page, queryType);
		Gson gson = new Gson();
		String result = gson.toJson(pageBean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	public String[] getJsj_scarousel_img_id() {
		return jsj_scarousel_img_id;
	}

	public void setJsj_scarousel_img_id(String jsj_scarousel_img_id[]) {
		this.jsj_scarousel_img_id = jsj_scarousel_img_id;
	}

	public void deleteCarousel() {

		for (int i = 0; i < jsj_scarousel_img_id.length; i++) {
			String s = scarouselService.deleteCarousel(jsj_scarousel_img_id[i]);
		}

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void queryTitle() throws IOException {
		title = title.trim();
		List<jsj_snews_news> list = scarouselService.queryByTitle(title);
		System.out.println(list);
		Gson gson = new Gson();
		String result = gson.toJson(list);
		System.out.println(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();

	}

}
