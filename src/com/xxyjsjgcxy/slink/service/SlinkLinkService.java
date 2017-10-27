package com.xxyjsjgcxy.slink.service;

import java.util.List;

import com.xxyjsjgcxy.slink.domain.LinkDTO;
import com.xxyjsjgcxy.slink.domain.jsj_slink_link;
import com.xxyjsjgcxy.slink.domain.page_list_linkVO;

public interface SlinkLinkService {
	public boolean save_Link(jsj_slink_link link);

	public List<LinkDTO> list_Link_All();

	public List<jsj_slink_link> listLinkAll();

	public page_list_linkVO list_Link_ByPage(page_list_linkVO page_list_link);

	public LinkDTO get_Link_ByLinkID(jsj_slink_link link);

	public void removeLinkByID(jsj_slink_link link);

	public void updateLink(jsj_slink_link link);

}
