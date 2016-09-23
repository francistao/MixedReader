package com.francis.mixedreader.utils;

import com.francis.mixedreader.model.ImageBean;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-23-2016
 *
 */
public class ImageJsonUtils {

	private static final String TAG = "ImageJsonUtils";

	/**
	 * 将获取到的 json 转换为图片列表对象
	 * @param res
	 * @return
	 */
	public static List<ImageBean> readJsonImageBeans(String res){
		List<ImageBean> beens = new ArrayList<>();
		try {
			JsonParser parser = new JsonParser();
			JsonArray jsonArray = parser.parse(res).getAsJsonArray();
			for(int i = 1; i < jsonArray.size(); i++){
				JsonObject object = jsonArray.get(i).getAsJsonObject();
				ImageBean bean = JsonUtils.deserialize(object, ImageBean.class);
				beens.add(bean);
			}
		}catch (Exception e){

		}
		return beens;
	}
}
