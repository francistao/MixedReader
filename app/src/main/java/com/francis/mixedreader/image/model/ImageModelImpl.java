package com.francis.mixedreader.image.model;

import android.util.Log;
import com.francis.mixedreader.commons.Urls;
import com.francis.mixedreader.model.ImageBean;
import com.francis.mixedreader.utils.ImageJsonUtils;
import com.francis.mixedreader.utils.OkHttpUtils;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-23-2016
 */
public class ImageModelImpl implements ImageModel{

	/**
	 * 获取图片列表
	 * @param listener
	 */
	@Override
	public void loadImageList(final OnLoadImageListListener listener) {
		String url = Urls.IMAGES_URL;
		OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {

			@Override
			public void onSuccess(String response) {
				List<ImageBean> imageBeanList = ImageJsonUtils.readJsonImageBeans(response);
				listener.onSuccess(imageBeanList);
				Log.d("---------->", imageBeanList.toString());
			}

			@Override
			public void onFailure(Exception e) {
				listener.onFailure("load image list failure.", e);
				Log.d("---------->", "!!!!!!!!!!!!!");
			}
		};
		OkHttpUtils.get(url, loadNewsCallback);
	}

	public interface OnLoadImageListListener{
		void onSuccess(List<ImageBean> list);
		void onFailure(String msg, Exception e);
	}
}
