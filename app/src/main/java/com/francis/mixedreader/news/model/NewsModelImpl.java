package com.francis.mixedreader.news.model;

import com.francis.mixedreader.commons.Urls;
import com.francis.mixedreader.model.NewsBean;
import com.francis.mixedreader.model.NewsDetailBean;
import com.francis.mixedreader.news.ui.fragment.NewsFragment;
import com.francis.mixedreader.utils.NewsjsonUtils;
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
	public void loadNews(String url, final int type, final OnLoadNewsListener listener) {
		OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {

			@Override
			public void onSuccess(String response) {
				List<NewsBean> newsBeenList = NewsjsonUtils.readJsonNewsBeans(response, getID(type));
				listener.onSuccess(newsBeenList);
			}

			@Override
			public void onFailure(Exception e) {
				listener.onFailure("load news list failure.", e);
			}
		};
		OkHttpUtils.get(url, loadNewsCallback);
	}

	/**
	 * 加载新闻详情
	 * @param docid
	 * @param listener
	 */
	@Override
	public void loadNewsDetail(final String docid, final OnLoadNewsDetailListener listener) {
		String url = getDetailUrl(docid);
		OkHttpUtils.ResultCallback<String> loadNewsDetailsCallback = new OkHttpUtils.ResultCallback<String>() {

			@Override
			public void onSuccess(String response) {
				NewsDetailBean newsDetailBean = (NewsDetailBean) NewsjsonUtils.readJsonNewsBeans(response, docid);
				listener.onSuccess(newsDetailBean);
			}

			@Override
			public void onFailure(Exception e) {
				listener.onFailure("load news detail info failure.", e);
			}
		};
		OkHttpUtils.get(url, loadNewsDetailsCallback);

	}

	/**
	 * 获取 ID
	 * @param type
	 * @return
	 */
	private String getID(int type){
		String id;
		switch (type){
			case NewsFragment.NEWS_TYPE_TOP:
				id = Urls.TOP_ID;
				break;
			case NewsFragment.NEWS_TYPE_NBA:
				id = Urls.NBA_ID;
				break;
			case NewsFragment.NEWS_TYPE_CARS:
				id = Urls.CAR_ID;
				break;
			case NewsFragment.NEWS_TYPE_JOKES:
				id = Urls.JOKE_ID;
				break;
			default:
				id = Urls.TOP_ID;
				break;
		}
		return id;
	}

	private String getDetailUrl(String docId){
		StringBuffer sb = new StringBuffer(Urls.NEW_DETAIL);
		sb.append(docId).append(Urls.END_DETAIL_URL);
		return sb.toString();
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
