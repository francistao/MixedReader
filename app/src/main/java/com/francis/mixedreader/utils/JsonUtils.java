package com.francis.mixedreader.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-22-2016
 */
public class JsonUtils{

	private static Gson mGson = new Gson();

	/**
	 * 将对象转换为 json 字符串
	 * @param object
	 * @param <T>
	 * @return
	 */
	public static <T> String serialize(T object){
		return mGson.toJson(object);
	}

	/**
	 * 将 json 字符串转换为对象
	 * @param json
	 * @param clz
	 * @param <T>
	 * @return
	 * @throws JsonSyntaxException
	 */
	public static <T> T deserialize(String json, Class<T> clz) throws JsonSyntaxException{
		return mGson.fromJson(json, clz);
	}

	/**
	 * 将 json 对象转换为对象
	 * @param json
	 * @param clz
	 * @param <T>
	 * @return
	 * @throws JsonSyntaxException
	 */
	public static <T> T deserialize(JsonObject json, Class<T> clz) throws JsonSyntaxException{
		return mGson.fromJson(json, clz);
	}

	/**
	 * 将 json 字符串转换为对象
	 * @param json
	 * @param type
	 * @param <T>
	 * @return
	 * @throws JsonSyntaxException
	 */
	public static <T> T deserialize(String json, Type type) throws JsonSyntaxException{
		return mGson.fromJson(json, type);
	}




}
