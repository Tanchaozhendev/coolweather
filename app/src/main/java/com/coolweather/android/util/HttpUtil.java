package com.coolweather.android.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 发请求的工具类。address 请求地址，callback发情时的回调
 * Created by Administrator on 2016/12/21 0021.
 */

public class HttpUtil {

    public static void  sendOkHttpRequest(String address ,okhttp3.Callback callback){

        OkHttpClient client=new OkHttpClient();
        Request request=new  Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
