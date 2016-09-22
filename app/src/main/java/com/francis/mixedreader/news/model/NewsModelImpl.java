package com.francis.mixedreader.news.model;

import com.francis.mixedreader.model.NewsBean;
import com.francis.mixedreader.model.NewsDetailBean;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-20-2016
 */
public class NewsModelImpl implements NewsModel{



	public interface OnLoadNewsListener{
		void onSuccess(List<NewsBean> list);
		void onFailure(String msg, Exception e);
	}

	public interface OnLoadNewsDetailListener{
		void onSuccess(NewsDetailBean newsDetailBean);
		void onFailure(String msg, Exception e);
	}



}
