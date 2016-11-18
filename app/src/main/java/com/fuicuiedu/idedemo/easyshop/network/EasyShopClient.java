package com.fuicuiedu.idedemo.easyshop.network;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2016/11/17 0017.
 */

public class EasyShopClient {

    private static EasyShopClient easyShopClient;

    private OkHttpClient okHttpClient;

    private EasyShopClient() {
        //日志拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    public static EasyShopClient getInstance() {
        if (easyShopClient == null) {
            easyShopClient = new EasyShopClient();
        }
        return easyShopClient;
    }

    /**
     * 注册
     * <p>
     * post
     *
     * @param username 用户名
     * @param password 密码
     */
    public Call register(String username, String password) {
        //表单形式构建请求体
        RequestBody requestBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();

        //构建请求
        Request request = new Request.Builder()
                .url(EasyShopApi.BASE_URL + EasyShopApi.REGISTER)
                .post(requestBody) //ctrl+p查看参数
                .build();

        return okHttpClient.newCall(request);
    }


    /**
     * 注册
     * <p>
     * post
     *
     * @param username 用户名
     * @param password 密码
     */
    public Call register_Demo(String username, String password) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", username);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(null,jsonObject.toString());

        //构建请求
        Request request = new Request.Builder()
                .url(EasyShopApi_Demo.REGISTER)
                .post(body)
                .build();

        return okHttpClient.newCall(request);
    }
}
