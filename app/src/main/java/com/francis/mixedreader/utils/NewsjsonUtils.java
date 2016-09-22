package com.francis.mixedreader.utils;

import com.francis.mixedreader.model.NewsBean;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-22-2016
 *
 * 新闻 Json 的工具类
 */
public class NewsjsonUtils {

	private final String TAG = "NewsJsonUtils";

	/**
	 * 将获取到的 Json 对象转换为新闻列表对象
	 * @param res
	 * @param value
	 * @return
	 */
	public static List<NewsBean> readJsonNewsBeans(String res, String value){

		List<NewsBean> beans = new ArrayList<>();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(res).getAsJsonObject();
		JsonElement jsonElement = jsonObject.get(value);
		if(jsonElement == null){
			return null;
		}
		JsonArray jsonArray = jsonElement.getAsJsonArray();
		for(int i = 1; i < jsonArray.size(); i++){
			JsonObject jo = jsonArray.get(i).getAsJsonObject();
			if (jo.has("skipType") && "special".equals(jo.get("skipType").getAsString())) {
				continue;
			}
			if (jo.has("TAGS") && !jo.has("TAG")) {
				continue;
			}

			if(!jo.has("imgextra")){
				NewsBean news = JsonUtils.deserialize(jo, NewsBean.class);
				beans.add(news);
			}
		}
		return beans;
	}
}
