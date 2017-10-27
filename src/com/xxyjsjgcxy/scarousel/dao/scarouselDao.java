package com.xxyjsjgcxy.scarousel.dao;

import java.util.List;

import com.xxyjsjgcxy.scarousel.domain.jsj_scarousel_img;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;

public interface scarouselDao {

	public abstract List getNews(int i);

	public abstract int getNewsCount();

	public abstract List judgeIsExists(String s, String img_group);

	public abstract List getNewsById(String s);

	public abstract void addToCarousel(jsj_scarousel_img jsj_scarousel_img);

	public abstract int getCarouselImgCount(String s);

	public abstract List getCarouselImg(int i, String s);

	public abstract void deleteCarousel(String s);

	public abstract List getCarouselImgById(String s);

	public List<jsj_snews_news> getNewsBig();

	public List<jsj_snews_news> getNewsSmall();

	public List<jsj_snews_news> queryByTitle(String title);
}
