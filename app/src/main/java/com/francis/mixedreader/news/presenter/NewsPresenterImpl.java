package com.francis.mixedreader.news.presenter;

import com.francis.mixedreader.commons.Urls;
import com.francis.mixedreader.model.NewsBean;
import com.francis.mixedreader.news.model.NewsModel;
import com.francis.mixedreader.news.model.NewsModelImpl;
import com.francis.mixedreader.news.ui.fragment.NewsFragment;
import com.francis.mixedreader.news.view.NewsView;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-20-2016
 */
public class NewsPresenterImpl implements NewsPresenter, NewsModelImpl.OnLoadNewsListener{

	private static final String TAG = "NewsPresenterImpl";

	private NewsView mNewsView;
	private NewsModel mNewsModel;

	public NewsPresenterImpl(NewsView newsView) {
		mNewsView = newsView;
		mNewsModel = new NewsModelImpl();
	}

	@Override
	public void loadNews(int type, int page) {
		String url = getUrl(type, page);
		//只有第一页或者刷新的时候才刷新进度条
		if(page == 0){
			mNewsView.showProgress();
		}
		mNewsModel.loadNews(url, type, this);
	}

	private String getUrl(int type, int pageIndex){
		StringBuffer sb = new StringBuffer();
		switch (type){
			case NewsFragment.NEWS_TYPE_TOP:
				sb.append(Urls.TOP_URL).append(Urls.TOP_ID);
				break;
			case NewsFragment.NEWS_TYPE_NBA:
				sb.append(Urls.COMMON_URL).append(Urls.NBA_ID);
				break;
			case NewsFragment.NEWS_TYPE_CARS:
				sb.append(Urls.COMMON_URL).append(Urls.CAR_ID);
				break;
			case NewsFragment.NEWS_TYPE_JOKES:
				sb.append(Urls.COMMON_URL).append(Urls.JOKE_ID);
				break;
			default:
				sb.append(Urls.TOP_URL).append(Urls.TOP_ID);
				break;
		}
		sb.append("/").append(pageIndex).append(Urls.END_URL);
		return sb.toString();
	}

	@Override
	public void onSuccess(List<NewsBean> list) {
		mNewsView.hideProgress();
		mNewsView.addNews(list);
	}

	@Override
	public void onFailure(String msg, Exception e) {
		mNewsView.hideProgress();
		mNewsView.showLoadFailMsg();
	}
}
