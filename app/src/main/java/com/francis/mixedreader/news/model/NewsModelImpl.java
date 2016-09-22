package com.francis.mixedreader.news.model;

import com.francis.mixedreader.model.NewsBean;
import com.francis.mixedreader.model.NewsDetailBean;
import com.francis.mixedreader.utils.OkHttpUtils;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-20-2016
 *
 * 新闻业务处理类
 */
public class NewsModelImpl implements NewsModel{

	/**
	 * 加载新闻列表
	 * @param url
	 * @param type
	 * @param listener
	 */
	@Override
	public void loadNews(String url, int type, OnLoadNewsDetailListener listener) {
		OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {

			@Override
			public void onSuccess(String response) {

			}

			@Override
			public void onFailure(Exception e) {

			}
		};
	}

	@Override
	public void loadNewsDetail(String docid, OnLoadNewsDetailListener listener) {

	}

	public interface OnLoadNewsListener{
		void onSuccess(List<NewsBean> list);
		void onFailure(String msg, Exception e);
	}

	public interface OnLoadNewsDetailListener{
		void onSuccess(NewsDetailBean newsDetailBean);
		void onFailure(String msg, Exception e);
	}



}
