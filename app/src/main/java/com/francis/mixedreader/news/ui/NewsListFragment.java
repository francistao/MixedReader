package com.francis.mixedreader.news.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.francis.mixedreader.R;
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
public class NewsListFragment extends Fragment implements NewsView, SwipeRefreshLayout.OnRefreshListener {

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
		View view = inflater.inflate(R.layout.fragment_newslist, null);
		swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
		swipeRefreshLayout.setColorSchemeResources(R.color.primary,
				R.color.primary_dark, R.color.primary_light,
				R.color.accent);
		swipeRefreshLayout.setOnRefreshListener(this);

		recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
		recyclerView.setHasFixedSize(true);

		layoutManager = new LinearLayoutManager(getActivity());
		recyclerView.setLayoutManager(layoutManager);

		recyclerView.setItemAnimator(new DefaultItemAnimator());
		adapter = new NewsAdapter(getActivity().getApplicationContext());
		adapter.setOnItemClickListener(mOnItemClickListener);
		recyclerView.setAdapter(adapter);
		recyclerView.addOnScrollListener(mOnScrollListener);
		onRefresh();
		return view;
	}

	private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

		@Override
		public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
			super.onScrollStateChanged(recyclerView, newState);
		}

		@Override
		public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
			super.onScrolled(recyclerView, dx, dy);
		}
	};


	private NewsAdapter.OnItemClickListener mOnItemClickListener = new NewsAdapter.OnItemClickListener() {

		@Override
		public void OnItemClick(View view, int position) {

		}
	};

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

	@Override
	public void onRefresh() {

	}
}
