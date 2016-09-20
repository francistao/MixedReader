package com.francis.mixedreader.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-20-2016
 *
 * 新闻详情的实体类
 */
public class NewsDetailBean implements Serializable{

	/**
	 * docid
	 */
	private String docid;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 来源
	 */
	private String source;

	/**
	 * 主体
	 */
	private String body;

	/**
	 * 时间
	 */
	private String ptime;

	/**
	 * cover
	 */
	private String cover;

	/**
	 * 图片列表
	 */
	private List<String> imgList;

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPtime() {
		return ptime;
	}

	public void setPtime(String ptime) {
		this.ptime = ptime;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public List<String> getImgList() {
		return imgList;
	}

	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}
}
