package com.xxyjsjgcxy.scarousel.service;

import java.util.List;

import com.xxyjsjgcxy.scarousel.domain.imgPageBean;
import com.xxyjsjgcxy.scarousel.domain.newsPageBean;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;

public interface ScarouselService {

	public abstract newsPageBean getNews(int i);

	public abstract String addToCarousel(String s, String s1);

	public abstract imgPageBean getCarouselImg(int i, String s);

	public abstract String deleteCarousel(String s);

	public List<jsj_snews_news> getNewsBig();

	public List<jsj_snews_news> getNewsSmall();

	public List<jsj_snews_news> queryByTitle(String title);
}
