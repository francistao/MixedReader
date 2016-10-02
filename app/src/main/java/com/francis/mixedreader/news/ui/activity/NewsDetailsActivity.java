package com.francis.mixedreader.news.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import com.francis.mixedreader.model.NewsBean;
import com.francis.mixedreader.news.presenter.NewsDetailsPresenter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

/**
 * @author taoc @ Zhihu Inc.
 * @since 10-02-2016
 *
 *
 * 新闻详情页
 */

public class NewsDetailsActivity extends AppCompatActivity{

	private NewsBean mNewsBean;
	private HtmlTextView mHtmlTextView;
	private NewsDetailsPresenter mNewsDetailsPresenter;
	private ProgressBar mProgressBar;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


	}
}
