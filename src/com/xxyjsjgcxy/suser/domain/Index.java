package com.xxyjsjgcxy.suser.domain;

import java.util.List;

import com.xxyjsjgcxy.slink.domain.jsj_slink_link;
import com.xxyjsjgcxy.snews.domain.NewsAndCategoryAndContentDTO;
import com.xxyjsjgcxy.snews.domain.jsj_snews_news;

public class Index {

	// �ֲ�1
	private List<jsj_snews_news> LB_B;
	// ����֪ͨ����
	private List<NewsAndCategoryAndContentDTO> TZGG_Three;

	// �Ÿ�ѧԺҪ��
	private List<NewsAndCategoryAndContentDTO> recommend_Nine;

	// �ֲ�2
	private List<jsj_snews_news> LB_S;

	// �ĸ��ɹ�չʾ
	private List<NewsAndCategoryAndContentDTO> CGZS_Four;

	// ����
	private List<jsj_slink_link> LJ;

	/*
	 * 
	 */

	public List<NewsAndCategoryAndContentDTO> getCGZS_Four() {
		return CGZS_Four;
	}

	public List<jsj_snews_news> getLB_B() {
		return LB_B;
	}

	public void setLB_B(List<jsj_snews_news> lB_B) {
		LB_B = lB_B;
	}

	public List<jsj_snews_news> getLB_S() {
		return LB_S;
	}

	public void setLB_S(List<jsj_snews_news> lB_S) {
		LB_S = lB_S;
	}

	public List<jsj_slink_link> getLJ() {
		return LJ;
	}

	public void setLJ(List<jsj_slink_link> lJ) {
		LJ = lJ;
	}

	public void setCGZS_Four(List<NewsAndCategoryAndContentDTO> cGZS_Four) {
		CGZS_Four = cGZS_Four;
	}

	public List<NewsAndCategoryAndContentDTO> getTZGG_Three() {
		return TZGG_Three;
	}

	public void setTZGG_Three(List<NewsAndCategoryAndContentDTO> tZGG_Three) {
		TZGG_Three = tZGG_Three;
	}

	public List<NewsAndCategoryAndContentDTO> getRecommend_Nine() {
		return recommend_Nine;
	}

	public void setRecommend_Nine(List<NewsAndCategoryAndContentDTO> recommend_Nine) {
		this.recommend_Nine = recommend_Nine;
	}

}
