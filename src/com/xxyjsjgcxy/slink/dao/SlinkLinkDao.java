package com.xxyjsjgcxy.slink.dao;

import java.util.List;


import com.xxyjsjgcxy.slink.domain.jsj_slink_link;
import com.xxyjsjgcxy.slink.domain.page_list_linkVO;
import com.xxyjsjgcxy.snews.domain.jsj_snews_content;



public interface SlinkLinkDao {

	public boolean saveLink(jsj_slink_link link);
	public boolean saveContent(jsj_slink_link content);
	

	public List<jsj_slink_link> list_Link_All();

	public List<jsj_slink_link> list_Link_ByPage(page_list_linkVO page_list_link);


	public int get_Link_TotalRecords();

	public jsj_slink_link get_Link_ByID(jsj_slink_link link);

	public void removeLinkByID(jsj_slink_link link);


	public void updateLink(jsj_slink_link link);

}
