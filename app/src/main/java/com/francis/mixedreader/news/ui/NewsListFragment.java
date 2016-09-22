package com.francis.mixedreader.news.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.francis.mixedreader.model.NewsBean;
import com.francis.mixedreader.news.presenter.NewsPresenter;
import com.francis.mixedreader.news.presenter.NewsPresenterImpl;
import com.francis.mixedreader.news.ui.adapter.NewsAdapter;
import com.francis.mixedreader.news.view.NewsView;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-19-2016
 */
public class NewsListFragment extends Fragment implements NewsView{

	private static final String TAG = "NewsListFragment";

	private SwipeRefreshLayout swipeRefreshLayout;
	private RecyclerView recyclerView;
	private LinearLayoutManager layoutManager;
	private NewsAdapter adapter;
	private List<NewsBean> data;
	private NewsPresenter mNewsPresenter;

	private int mType = NewsFragment.NEWS_TYPE_TOP;
	private int pageIndex;

	public static NewsListFragment newInstance(int type){
		Bundle bundle = new Bundle();
		NewsListFragment fragment = new NewsListFragment();
		bundle.putInt("type", type);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mNewsPresenter = new NewsPresenterImpl(this);
		mType = getArguments().getInt("type");
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void showProgress() {

	}

	@Override
	public void addNews(List<NewsBean> newsList) {

	}

	@Override
	public void hideProgress() {

	}

	@Override
	public void showLoadFailMsg() {

	}
}
