package com.francis.mixedreader.image.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.francis.mixedreader.R;
import com.francis.mixedreader.image.presenter.ImagePresenter;
import com.francis.mixedreader.image.presenter.ImagePresenterImpl;
import com.francis.mixedreader.image.ui.adapter.ImageAdapter;
import com.francis.mixedreader.image.view.ImageView;
import com.francis.mixedreader.model.ImageBean;
import java.util.ArrayList;
import java.util.List;



/**
 * @author taoc @ Zhihu Inc.
 * @since 09-19-2016
 *
 * 图片的 Fragment
 */
public class ImageFragment extends Fragment implements ImageView, SwipeRefreshLayout.OnRefreshListener {

	private static final String TAG = "ImageFragment";

	private SwipeRefreshLayout mSwipeRefreshLayout;
	private RecyclerView mRecyclerView;
	private LinearLayoutManager mLayoutManager;
	private ImageAdapter adapter;
	private List<ImageBean> data;
	private ImagePresenter mImagePresenter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mImagePresenter = new ImagePresenterImpl(this);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_image, null);
		mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
		mSwipeRefreshLayout.setColorSchemeResources(R.color.primary,
				R.color.primary_dark, R.color.primary_light, R.color.accent);
		mSwipeRefreshLayout.setOnRefreshListener(this);

		mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
		mRecyclerView.setHasFixedSize(true);

		mLayoutManager = new LinearLayoutManager(getActivity());
		mRecyclerView.setLayoutManager(mLayoutManager);

		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		adapter = new ImageAdapter(getActivity().getApplicationContext());
		mRecyclerView.setAdapter(adapter);
		mRecyclerView.addOnScrollListener(mOnScrollListener);
		onRefresh();
		mImagePresenter.loadImageList();
		return view;
	}

	private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

		private int lastVisibleItem;

		@Override
		public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
			super.onScrollStateChanged(recyclerView, newState);
			if(newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()){
				//加载更多
				Snackbar.make(getActivity().findViewById(R.id.drawer_layout), getString(R.string.image_hit), Snackbar.LENGTH_SHORT).show();
			}
		}

		@Override
		public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
			super.onScrolled(recyclerView, dx, dy);
			lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
		}
	};

	@Override
	public void addImages(List<ImageBean> list) {
		Log.d("======》》", list.toString());
		if(data == null){
			data = new ArrayList<>();
		}
		data.addAll(list);
		adapter.setData(data);
	}

	@Override
	public void showProgress() {
		mSwipeRefreshLayout.setRefreshing(true);
	}

	@Override
	public void hideProgress() {
		mSwipeRefreshLayout.setRefreshing(false);
	}

	@Override
	public void showLoadFailMsg() {
		View view = getActivity() == null ? mRecyclerView.getRootView() : getActivity().findViewById(R.id.drawer_layout);
		Snackbar.make(view, getString(R.string.load_fail), Snackbar.LENGTH_SHORT).show();
	}

	@Override
	public void onRefresh() {
		if(data != null){
			data.clear();
		}
		mImagePresenter.loadImageList();
	}

}
