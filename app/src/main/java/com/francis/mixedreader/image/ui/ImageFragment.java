package com.francis.mixedreader.image.ui;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.francis.mixedreader.image.ui.adapter.ImageAdapter;
import com.francis.mixedreader.model.ImageBean;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-19-2016
 *
 * 图片的 Fragment
 */
public class ImageFragment extends Fragment {

	private static final String TAG = "ImageFragment";

	private SwipeRefreshLayout mSwipeRefreshLayout;
	private RecyclerView mRecyclerView;
	private LinearLayoutManager mLayoutManager;
	private ImageAdapter adapter;
	private List<ImageBean> data;



}
