package com.xxyjsjgcxy.snews.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import com.opensymphony.xwork2.ActionSupport;

public class ImgAction extends ActionSupport {

	private String imgName;
	private InputStream inputStream;

	/*
	 * 
	 */
	public String getNewsContentImg() throws FileNotFoundException {
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
		if (imgName.equals("") || imgName == null) {
			imgName = "default.jpg";
		}
		File file = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/content/" + imgName);
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			file = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/NotFound.jpg");
			inputStream = new FileInputStream(file);
		}
		return "getImg";
	}

	public String getNewsBImg() throws FileNotFoundException {
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
		if (imgName.equals("") || imgName == null) {
			imgName = "default.jpg";
		}
		File file = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/bimg/" + imgName);
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			file = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/NotFound.jpg");
			inputStream = new FileInputStream(file);
		}
		return "getImg";
	}

	public String getNewsSImg() throws FileNotFoundException {
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
		if (imgName.equals("") || imgName == null) {
			imgName = "default.jpg";
		}
		File file = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/simg/" + imgName);
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			file = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/NotFound.jpg");
			inputStream = new FileInputStream(file);
		}
		return "getImg";
	}

	public String getNewsCategoryImg() throws FileNotFoundException {
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
		if (imgName.equals("") || imgName == null) {
			imgName = "default.jpg";
		}
		File file = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_category/" + imgName);
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			file = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/NotFound.jpg");
			inputStream = new FileInputStream(file);
		}
		return "getImg";
	}

	public String getNewsTemporaryContentImg() throws FileNotFoundException {
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
		if (imgName.equals("") || imgName == null) {
			imgName = "default.jpg";
		}
		File file = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/snews_news/content_temporary/" + imgName);
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			file = new File(lj + "xxyjsjgcxy/xxyjsjgcxy_img/NotFound.jpg");
			inputStream = new FileInputStream(file);
		}
		return "getImg";
	}

	/*
	 * 
	 */
	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
