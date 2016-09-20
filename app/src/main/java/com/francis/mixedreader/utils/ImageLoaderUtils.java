package com.francis.mixedreader.utils;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.francis.mixedreader.R;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-19-2016
 *
 *
 * 图片加载工具类
 */
public class ImageLoaderUtils {

	public static void display(Context context, ImageView imageView, String url){
		if(imageView == null){
			throw new IllegalArgumentException("argument error");
		}

		Glide.with(context).load(url).placeholder(R.drawable.ic_image_loading)
				.error(R.drawable.ic_image_loadfail).crossFade().into(imageView);
	}
}
