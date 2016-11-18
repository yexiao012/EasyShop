package com.fuicuiedu.idedemo.easyshop.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/11/18 0018.
 */

public class BombInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        //拿到拦截到请求
        Request request = chain.request();
        //拿到拦截请求的构造器
        Request.Builder builder = request.newBuilder();
        //使用构造器来添加请求头
//        X-Bmob-Application-Id: Your Application ID
//        X-Bmob-REST-API-Key: Your REST API Key
//        Content-Type: application/json
        builder.addHeader("X-Bmob-Application-Id","623aaef127882aed89b9faa348451da3");
        builder.addHeader("X-Bmob-REST-API-Key","c00104962a9b67916e8cbcb9157255de");
        builder.addHeader("Content-Type","application/json");
        //添加完请求头的请求
        Request request_new = builder.build();

        return chain.proceed(request_new);
    }
}
