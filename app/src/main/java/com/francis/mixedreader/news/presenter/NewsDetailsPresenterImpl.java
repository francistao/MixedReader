package com.francis.mixedreader.news.presenter;

import android.content.Context;
import com.francis.mixedreader.model.NewsDetailBean;
import com.francis.mixedreader.news.model.NewsModel;
import com.francis.mixedreader.news.model.NewsModelImpl;
import com.francis.mixedreader.news.view.NewsDetailsView;

/**
 * @author taoc @ Zhihu Inc.
 * @since 10-02-2016
 */

public class NewsDetailsPresenterImpl implements NewsDetailsPresenter, NewsModelImpl.OnLoadNewsDetailListener {


	private Context mContext;
	private NewsDetailsView mNewsDetailsView;
	private NewsModel mNewsModel;

	public NewsDetailsPresenterImpl(Context context, NewsDetailsView newsDetailsView) {
		mContext = context;
		mNewsDetailsView = newsDetailsView;
		mNewsModel = new NewsModelImpl();
	}

	@Override
	public void loadNewsDetails(String docId) {
		mNewsDetailsView.showProgress();
		mNewsModel.loadNewsDetail(docId, this);
	}

	@Override
	public void onSuccess(NewsDetailBean newsDetailBean) {
		mNewsDetailsView.hideProgress();
		if(newsDetailBean != null){
			mNewsDetailsView.showNewsDetailContent(newsDetailBean.getBody());
		}
	}

	@Override
	public void onFailure(String msg, Exception e) {
		mNewsDetailsView.hideProgress();

	}
}
