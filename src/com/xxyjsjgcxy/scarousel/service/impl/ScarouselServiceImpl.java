package com.xxyjsjgcxy.scarousel.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.xxyjsjgcxy.scarousel.dao.scarouselDao;
import com.xxyjsjgcxy.scarousel.domain.imgPageBean;
import com.xxyjsjgcxy.scarousel.domain.jsj_scarousel_img;
import com.xxyjsjgcxy.scarousel.domain.newsPageBean;
import com.xxyjsjgcxy.scarousel.service.ScarouselService;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;

// Referenced classes of package com.xxyjsjgcxy.scarousel.service.impl:
//			ScarouselService

public class ScarouselServiceImpl implements ScarouselService {

	private scarouselDao scarouselDao;

	public ScarouselServiceImpl() {
	}

	public scarouselDao getScarouselDao() {
		return scarouselDao;
	}

	public void setScarouselDao(scarouselDao scarouselDao) {
		this.scarouselDao = scarouselDao;
	}

	@Override
	public newsPageBean getNews(int page) {
		int result = scarouselDao.getNewsCount();
		double c = result;
		result = (int) Math.ceil(c / 5D);
		List list = scarouselDao.getNews(page);
		newsPageBean pageBean = new newsPageBean();
		pageBean.setPageBean(list);
		pageBean.setPageCount(result);
		return pageBean;
	}

	@Override
	public String addToCarousel(String img_group, String img_news) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		jsj_scarousel_img scarousel = new jsj_scarousel_img();
		List<jsj_snews_news> listNews = scarouselDao.getNewsById(img_news);
		if (img_group.equals("大图")) {
			scarousel.setJsj_scarousel_img_id(listNews.get(0).getJsj_snews_news_id());
		} else {
			scarousel.setJsj_scarousel_img_id(listNews.get(0).getJsj_snews_news_id() + "s");
		}
		if (listNews.size() > 0) {
			img_news = (new StringBuilder(String.valueOf(listNews.get(0).getNews_title()))).toString();
			scarousel.setImg_news(img_news);
			scarousel.setImg_group(img_group);
			scarousel.setImg_gmt_create(sdf.format(date));
			scarousel.setImg_gmt_modified(sdf.format(date));
			List list = scarouselDao.judgeIsExists(img_news, img_group);
			if (list.size() == 0) {
				scarouselDao.addToCarousel(scarousel);
				return "添加成功！";
			} else {
				return "已存在！";
			}
		} else {
			return "添加失败！";
		}
	}

	@Override
	public imgPageBean getCarouselImg(int page, String queryType) {
		int result = scarouselDao.getCarouselImgCount(queryType);
		double c = result;
		result = (int) Math.ceil(c / 5D);
		List list = scarouselDao.getCarouselImg(page, queryType);
		imgPageBean pageBean = new imgPageBean();
		pageBean.setPageCount(result);
		pageBean.setPageBean(list);
		return pageBean;
	}

	// 删除大图用新闻的id删除，删除小图用新闻的id并在尾部加上s
	@Override
	public String deleteCarousel(String jsj_scarousel_img_id) {
		List list = scarouselDao.getCarouselImgById(jsj_scarousel_img_id);

		if (list.size() > 0) {
			System.out.println("从更高");
			scarouselDao.deleteCarousel(jsj_scarousel_img_id);
			return "删除成功";
		} else {
			return "删除失败";
		}
	}

	@Override
	public List<jsj_snews_news> getNewsBig() {

		List<jsj_snews_news> list = scarouselDao.getNewsBig();

		return list;
	}

	@Override
	public List<jsj_snews_news> getNewsSmall() {

		List<jsj_snews_news> list = scarouselDao.getNewsSmall();

		return list;
	}

	@Override
	public List<jsj_snews_news> queryByTitle(String title) {
		// TODO Auto-generated method stub
		List<jsj_snews_news> list = scarouselDao.queryByTitle(title);

		return list;
	}
}
