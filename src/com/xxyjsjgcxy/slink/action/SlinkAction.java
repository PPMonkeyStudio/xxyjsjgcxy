package com.xxyjsjgcxy.slink.action;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xxyjsjgcxy.slink.domain.LinkDTO;
import com.xxyjsjgcxy.slink.domain.jsj_slink_link;
import com.xxyjsjgcxy.slink.domain.page_list_linkVO;
import com.xxyjsjgcxy.slink.domain.searchLinkListDTO;
import com.xxyjsjgcxy.slink.service.SlinkLinkService;

import util.TimeUtil;

public class SlinkAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {

	private SlinkLinkService slinkLinkService;

	private page_list_linkVO page_list_link;

	private jsj_slink_link link;
	private jsj_slink_link content;

	private String page;

	private String option;

	private searchLinkListDTO searchLinkList;

	private HttpServletResponse http_response;

	private HttpServletRequest http_request;

	public String page_create_link() {

		ActionContext.getContext().getValueStack().set("page", page);

		return "page_create_link";
	}

	/*
	 * 閺囧瓨鏌�
	 */
	public String updateLinkPage() {

		LinkDTO linkDTO = slinkLinkService.get_Link_ByLinkID(link);

		ActionContext.getContext().getValueStack().set("linkDTO", linkDTO);

		ActionContext.getContext().getValueStack().set("option", "update");

		ActionContext.getContext().getValueStack().set("page", "page_create_link");

		return "updateLinkPage";
	}

	public void deleteLink() {

		slinkLinkService.removeLinkByID(link);

		try {

			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write("success");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void getLinkUUID() {
		String linkUUID = UUID.randomUUID().toString();
		try {
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write(linkUUID);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void updateLink() {

		System.out.println("-----------------------------updateLink-------------------------------");

		LinkDTO oldLinkDTO = slinkLinkService.get_Link_ByLinkID(link);

		oldLinkDTO.getLink().setLink_name(link.getLink_name());
		// oldLinkDTO.getLink().setLink_name1(link.getLink_name1());
		oldLinkDTO.getLink().setLink_url(link.getLink_url());
		oldLinkDTO.getLink().setLink_gmt_modified(TimeUtil.getStringSecond());

		slinkLinkService.updateLink(oldLinkDTO.getLink());

	}

	public void saveLink() {

		slinkLinkService.save_Link(link);

	}

	public String page_list_link() {

		if (searchLinkList != null) {
			System.out.println(searchLinkList);
			page_list_link.setSearch(searchLinkList);

		}

		page_list_link = slinkLinkService.list_Link_ByPage(page_list_link);

		ActionContext.getContext().getValueStack().set("page_list_link", page_list_link);

		ActionContext.getContext().getValueStack().set("page", "page_list_link");

		return "page_list_link";
	}

	public SlinkLinkService getSlinkLinkService() {
		return slinkLinkService;
	}

	public void setSlinkLinkService(SlinkLinkService slinkLinkService) {
		this.slinkLinkService = slinkLinkService;
	}

	public page_list_linkVO getPage_list_link() {
		return page_list_link;
	}

	public void setPage_list_link(page_list_linkVO page_list_link) {
		this.page_list_link = page_list_link;
	}

	public jsj_slink_link getLink() {
		return link;
	}

	public void setLink(jsj_slink_link link) {
		this.link = link;
	}

	public jsj_slink_link getContent() {
		return content;
	}

	public void setContent(jsj_slink_link content) {
		this.content = content;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public searchLinkListDTO getSearchLinkList() {
		return searchLinkList;
	}

	public void setSearchLinkList(searchLinkListDTO searchLinkList) {
		this.searchLinkList = searchLinkList;
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

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub

	}
}
