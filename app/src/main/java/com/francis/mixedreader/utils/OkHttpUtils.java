package com.francis.mixedreader.utils;

import android.os.Handler;
import android.os.Looper;
import com.google.gson.internal.$Gson$Types;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-20-2016
 *
 *
 * OkHttp 网络连接封装工具类
 *
 * 这个类使用单例模式
 *
 *
 */
public class OkHttpUtils {

	private static final String TAG = "OkHttpUtils";

	private static OkHttpUtils mInstance;
	private OkHttpClient mOkHttpClient;
	private Handler mDelivery;

	private OkHttpUtils() {
		mOkHttpClient = new OkHttpClient();
		mOkHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
		mOkHttpClient.setWriteTimeout(10, TimeUnit.SECONDS);
		mOkHttpClient.setReadTimeout(30, TimeUnit.SECONDS);

		//cookie enabled
		mOkHttpClient.setCookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));
		mDelivery = new Handler(Looper.getMainLooper());
	}

	/**
	 * 单例化
	 * @return
	 */
	private synchronized static OkHttpUtils getInstance(){
		if(mInstance == null){
			mInstance = new OkHttpUtils();
		}
		return mInstance;
	}

	private void getRequest(String url, final ResultCallback callback){
		final Request request = new Request.Builder().url(url).build();
		deliveryResult(callback, request);
	}

	private void postRequest(String url, ResultCallback callback, List<Param>params){
		//Request request =
	}




	private void deliveryResult(final ResultCallback callback, Request request){
		mOkHttpClient.newCall(request).enqueue(new Callback() {

			@Override
			public void onFailure(Request request, IOException e) {
				sendFailCallback(callback, e);
			}

			@Override
			public void onResponse(Response response) throws IOException {
				String str = response.body().string();
				if(callback.mType == String.class){
					sendSuccessCallBack(callback, str);
				}else {
					//Object object =
				}
			}
		});
	}

	private void sendFailCallback(final ResultCallback callback, final Exception e){
		mDelivery.post(new Runnable() {

			@Override
			public void run() {
				if(callback != null){
					callback.onFailure(e);
				}
			}
		});
	}

	private void sendSuccessCallBack(final ResultCallback callback, final Object obj){
		mDelivery.post(new Runnable() {

			@Override
			public void run() {
				if(callback != null){
					callback.onSuccess(obj);
				}
			}
		});
	}


	private Request buildPostRequest(String url,List<Param> params){
		FormEncodingBuilder builder = new FormEncodingBuilder();
		for(Param param : params){
			builder.add(param.key, param.value);
		}
		RequestBody requestBody = builder.build();
		return new Request.Builder().url(url).post(requestBody).build();
	}

	/**
	 * ================================== 对外接口 ============================
	 */

	/**
	 * get 请求
	 * @param url   请求 url
	 * @param callback   请求回调
	 */
	public static void get(String url, ResultCallback callback){
		getInstance().getRequest(url, callback);
	}

	/**
	 * post 请求
	 * @param url
	 * @param callback
	 * @param params
	 */
	public static void post(String url, ResultCallback callback, List<Param> params){
		getInstance().postRequest(url, callback, params);
	}

	/**
	 * http 请求回调类，回调方法会在 UI 线程中调用
	 * @param <T>
	 */
	public static abstract class ResultCallback<T>{
		Type mType;

		public ResultCallback() {
			mType = getSuperclassTypeParameter(getClass());
		}

		static Type getSuperclassTypeParameter(Class<?> subclass){
			Type superclass = subclass.getGenericSuperclass();
			if(subclass instanceof Class){
				throw new RuntimeException("Missing type parameter.");
			}
			ParameterizedType parameterizedType = (ParameterizedType) superclass;
			return $Gson$Types.canonicalize(parameterizedType.getActualTypeArguments()[0]);
		}

		/**
		 * 请求回调成功
		 * @param response
		 */
		public abstract void onSuccess(T response);

		/**
		 * 请求失败回调
		 * @param e
		 */
		public abstract void onFailure(Exception e);
	}

	/**
	 * Post 请求参数类
	 */
	public static class Param{

		String key;
		String value;

		public Param(){

		}

		public Param(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}
}
