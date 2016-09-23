package com.francis.mixedreader.image.model;

import com.francis.mixedreader.model.ImageBean;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-23-2016
 */
public class ImageModelImpl {


	public interface OnLoadImageListListener{
		void onSuccess(List<ImageBean> list);
		void onFailure(String msg, Exception e);
	}
}
