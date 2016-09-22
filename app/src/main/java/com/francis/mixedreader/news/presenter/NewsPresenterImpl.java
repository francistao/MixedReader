package com.francis.mixedreader.news.presenter;

import com.francis.mixedreader.news.model.NewsModel;
import com.francis.mixedreader.news.model.NewsModelImpl;
import com.francis.mixedreader.news.view.NewsView;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-20-2016
 */
public class NewsPresenterImpl implements NewsPresenter{

	private static final String TAG = "NewsPresenterImpl";

	private NewsView mNewsView;
	private NewsModel mNewsModel;

	public NewsPresenterImpl(NewsView newsView) {
		mNewsView = newsView;
		mNewsModel = new NewsModelImpl();
	}

	@Override
	public void loadNews(int type, int page) {

	}
}
