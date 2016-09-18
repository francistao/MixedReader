package com.francis.mixedreader.main.presenter;

import com.francis.mixedreader.R;
import com.francis.mixedreader.main.view.MainView;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-19-2016
 */
public class MainPresenterImpl implements MainPresenter{

	private MainView mainView;

	public MainPresenterImpl(MainView mainView) {
		this.mainView = mainView;
	}

	@Override
	public void switchNavigation(int id) {
		switch (id){
			case R.id.navigation_item_news:
				mainView.switch2News();
				break;
			case R.id.navigation_item_images:
				mainView.switch2Images();
				break;
			case R.id.navigation_item_weather:
				mainView.switch2Weather();
				break;
			case R.id.navigation_item_about:
				mainView.switch2About();
				break;
			default:
				mainView.switch2News();
				break;
		}
	}
}
