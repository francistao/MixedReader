package com.francis.mixedreader.image.model;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-23-2016
 */
public interface ImageModel {

	void loadImageList(ImageModelImpl.OnLoadImageListListener listener);
}
