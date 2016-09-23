package com.francis.mixedreader.image.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.francis.mixedreader.image.presenter.ImagePresenter;
import com.francis.mixedreader.image.presenter.ImagePresenterImpl;
import com.francis.mixedreader.image.ui.adapter.ImageAdapter;
import com.francis.mixedreader.image.view.ImageView;
import com.francis.mixedreader.model.ImageBean;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-19-2016
 *
 * 图片的 Fragment
 */
public class ImageFragment extends Fragment implements ImageView {

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

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void addImages(List<ImageBean> list) {

	}

	@Override
	public void showProgress() {

	}

	@Override
	public void hideProgress() {

	}

	@Override
	public void showLoadFailMsg() {

	}
}
