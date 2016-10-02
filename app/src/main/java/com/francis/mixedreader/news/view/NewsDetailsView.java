package com.francis.mixedreader.news.view;

/**
 * @author taoc @ Zhihu Inc.
 * @since 10-02-2016
 */

public interface NewsDetailsView {

	void showNewsDetailContent(String newsDetailContent);

	void showProgress();

	void hideProgress();
}
