package com.francis.mixedreader.news.view;

import com.francis.mixedreader.model.NewsBean;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-20-2016
 *
 * NewsFragment 抽取出来的公共属性
 */
public interface NewsView {

	void showProgress();

	void addNews(List<NewsBean>newsList);

	void hideProgress();

	void showLoadFailMsg();

}
