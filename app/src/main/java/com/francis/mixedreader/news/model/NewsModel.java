package com.francis.mixedreader.news.model;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-20-2016
 */
public interface NewsModel {

	/**
	 * 加载新闻
	 * @param url
	 * @param type
	 * @param listener
	 */
	void loadNews(String url, int type, NewsModelImpl.OnLoadNewsListener listener);

	/**
	 * 加载新闻细节
	 * @param docid
	 * @param listener
	 */
	void loadNewsDetail(String docid, NewsModelImpl.OnLoadNewsDetailListener listener);

}
