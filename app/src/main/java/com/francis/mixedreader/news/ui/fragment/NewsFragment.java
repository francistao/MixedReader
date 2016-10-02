package com.francis.mixedreader.news.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.francis.mixedreader.R;
import java.util.ArrayList;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-19-2016
 *
 * 新闻界面
 */
public class NewsFragment extends Fragment{

	public static final int NEWS_TYPE_TOP = 0;
	public static final int NEWS_TYPE_NBA = 1;
	public static final int NEWS_TYPE_CARS = 2;
	public static final int NEWS_TYPE_JOKES = 3;

	private TabLayout tabLayout;
	private ViewPager viewPager;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_news, null);
		tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
		viewPager = (ViewPager) view.findViewById(R.id.viewpager);
		viewPager.setOffscreenPageLimit(3);
		setupViewPager(viewPager);
		tabLayout.addTab(tabLayout.newTab().setText(R.string.top));
		tabLayout.addTab(tabLayout.newTab().setText(R.string.nba));
		tabLayout.addTab(tabLayout.newTab().setText(R.string.cars));
		tabLayout.addTab(tabLayout.newTab().setText(R.string.jokes));
		tabLayout.setupWithViewPager(viewPager);
		return view;
	}

	private void setupViewPager(ViewPager viewPager) {

		//Fragment 中潜逃使用 Fragment 一定要使用 getChildFragmentManager()， 否则会有问题
		MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
		adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_TOP), getString(R.string.top));
		adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_NBA), getString(R.string.nba));
		adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_CARS), getString(R.string.cars));
		adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_JOKES), getString(R.string.jokes));
		viewPager.setAdapter(adapter);
	}

	public static class MyPagerAdapter extends FragmentPagerAdapter{

		private List<Fragment> fragmentList = new ArrayList<>();
		private List<String> fragmentTitle = new ArrayList<>();

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		public void addFragment(Fragment fragment, String title){
			fragmentList.add(fragment);
			fragmentTitle.add(title);
		}
		@Override
		public Fragment getItem(int position) {
			return fragmentList.get(position);
		}

		@Override
		public int getCount() {
			return fragmentList.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return fragmentTitle.get(position);
		}
	}
}
