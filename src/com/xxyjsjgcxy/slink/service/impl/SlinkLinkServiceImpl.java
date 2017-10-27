package com.xxyjsjgcxy.slink.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.xxyjsjgcxy.slink.dao.SlinkLinkDao;
import com.xxyjsjgcxy.slink.domain.LinkDTO;
import com.xxyjsjgcxy.slink.domain.jsj_slink_link;
import com.xxyjsjgcxy.slink.domain.page_list_linkVO;
import com.xxyjsjgcxy.slink.service.SlinkLinkService;

import util.TimeUtil;

public class SlinkLinkServiceImpl implements SlinkLinkService {
	@Override
	public void updateLink(jsj_slink_link link) {
		// TODO Auto-generated method stub
		link.setLink_gmt_modified(TimeUtil.getStringSecond());

		slinkLinkDao.updateLink(link);
	}

	@Override
	public boolean save_Link(jsj_slink_link link) {
		// TODO Auto-generated method stub
		link.setJsj_slink_link_id(UUID.randomUUID().toString());

		link.setLink_gmt_create(TimeUtil.getStringSecond());

		link.setLink_gmt_modified(link.getLink_gmt_create());

		slinkLinkDao.saveLink(link);

		return true;
	}

	@Override
	public List<jsj_slink_link> listLinkAll() {

		return slinkLinkDao.list_Link_All();
	}

	@Override
	public List<LinkDTO> list_Link_All() {

		List<LinkDTO> linkDTOList = new ArrayList<LinkDTO>();

		LinkDTO linkDTO;

		List<jsj_slink_link> linkList = slinkLinkDao.list_Link_All();

		for (jsj_slink_link link : linkList) {

			linkDTO = new LinkDTO(link);

			linkDTOList.add(linkDTO);
		}

		return linkDTOList;

	}

	@Override
	public page_list_linkVO list_Link_ByPage(page_list_linkVO page_list_link) {
		// TODO Auto-generated method stub
		List<LinkDTO> linkDTOList = new ArrayList<LinkDTO>();

		LinkDTO linkDTO;

		List<jsj_slink_link> linkList = slinkLinkDao.list_Link_ByPage(page_list_link);

		if (page_list_link.getSearch() != null && !page_list_link.getSearch().getName().equals("")) {

			int i = 0;
			while (i < linkList.size()) {

				linkList.get(i)
						.setLink_name(linkList.get(i).getLink_name().replaceAll(page_list_link.getSearch().getName(),
								"<span style='color: #ff5063;'>" + page_list_link.getSearch().getName() + "</span>"));

				i++;
			}
		}

		// 灏佽鎬昏褰曟暟
		page_list_link.setTotalRecords(slinkLinkDao.get_Link_TotalRecords());
		// 灏佽鎬婚〉鏁�
		page_list_link.setTotalPages(((page_list_link.getTotalRecords() - 1) / page_list_link.getPageSize()) + 1);

		if (page_list_link.getPageIndex() <= 1) {
			page_list_link.setHavePrePage(false);
		} else {
			page_list_link.setHavePrePage(true);
		}
		if (page_list_link.getPageIndex() >= page_list_link.getTotalPages()) {
			page_list_link.setHaveNextPage(false);
		} else {
			page_list_link.setHaveNextPage(true);
		}

		for (jsj_slink_link link : linkList) {

			linkDTO = new LinkDTO(link);

			linkDTOList.add(linkDTO);
		}

		page_list_link.setLinkDTOList(linkDTOList);

		return page_list_link;

	}

	@Override
	public LinkDTO get_Link_ByLinkID(jsj_slink_link link) {
		// TODO Auto-generated method stub

		link = slinkLinkDao.get_Link_ByID(link);

		LinkDTO linkDTO = new LinkDTO(link);

		return linkDTO;

	}

	@Override
	public void removeLinkByID(jsj_slink_link link) {
		// TODO Auto-generated method stub
		link = slinkLinkDao.get_Link_ByID(link);
		// 閾炬帴

		slinkLinkDao.removeLinkByID(link);

	}

	private SlinkLinkDao slinkLinkDao;

	public SlinkLinkDao getSlinkLinkDao() {
		return slinkLinkDao;
	}

	public void setSlinkLinkDao(SlinkLinkDao slinkLinkDao) {
		this.slinkLinkDao = slinkLinkDao;
	}

}
