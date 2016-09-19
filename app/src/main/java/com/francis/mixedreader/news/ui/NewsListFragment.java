package com.francis.mixedreader.news.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-19-2016
 */
public class NewsListFragment extends Fragment{

	public static NewsListFragment newInstance(int type){
		Bundle bundle = new Bundle();
		NewsListFragment fragment = new NewsListFragment();
		bundle.putInt("type", type);
		fragment.setArguments(bundle);
		return fragment;
	}
}
