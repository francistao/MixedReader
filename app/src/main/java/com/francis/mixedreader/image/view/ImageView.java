package com.francis.mixedreader.image.view;

import android.widget.ImageButton;
import com.francis.mixedreader.model.ImageBean;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-22-2016
 *
 * ImageFragment 提取的抽象方法
 */
public interface ImageView {

	void addImages(List<ImageBean> list);
	void showProgress();
	void hideProgress();
	void showLoadFailMsg();

}
