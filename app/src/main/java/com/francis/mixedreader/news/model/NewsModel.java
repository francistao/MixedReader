package com.francis.mixedreader.news.model;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-20-2016
 */
public interface NewsModel {

	void loadNews(String url, int type, NewsModelImpl.OnLoadNewsDetailListener listener);

	void loadNewsDetail(String docid, NewsModelImpl.OnLoadNewsDetailListener listener);

}
