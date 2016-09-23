package com.francis.mixedreader.image.presenter;

import com.francis.mixedreader.image.model.ImageModel;
import com.francis.mixedreader.image.model.ImageModelImpl;
import com.francis.mixedreader.image.ui.ImageFragment;
import com.francis.mixedreader.image.view.ImageView;
import com.francis.mixedreader.model.ImageBean;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-23-2016
 */
public class ImagePresenterImpl implements ImagePresenter, ImageModelImpl.OnLoadImageListListener {

	private ImageModel mImageModel;
	private ImageView mImageView;

	public ImagePresenterImpl(ImageView imageView) {
		mImageModel = new ImageModelImpl();
		mImageView = imageView;
	}



	@Override
	public void loadImageList() {
		mImageView.showProgress();
		mImageModel.loadImageList(this);

	}

	@Override
	public void onSuccess(List<ImageBean> list) {
		mImageView.addImages(list);
		mImageView.hideProgress();
	}

	@Override
	public void onFailure(String msg, Exception e) {
		mImageView.hideProgress();
		mImageView.showLoadFailMsg();
	}
}
