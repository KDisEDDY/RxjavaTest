package project.ljy.rxjavatest.network;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import project.ljy.rxjavatest.data.BaseBO;
import utils.RequestUtil;

/**
 * Title: BaseRequest
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2018/3/31
 * Version: 1.0
 */

public class BaseRequest {

    private static OkHttpClient mClient ;

    private static synchronized  OkHttpClient getDefaultClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();
        return client;
    }

    <T extends BaseBO> void request(String url, RequestBody requestBody, final Callable<T> callable){
        if(mClient == null){
            synchronized (RequestUtil.class) {
                if(mClient == null){
                    mClient = getDefaultClient();
                }
            }
        }
        Request request = null;
        if(requestBody != null){
            request = new Request.Builder()
                    .url(url)
                    .put(requestBody)
                    .build();
        } else {
            request = new Request.Builder()
                    .url(url)
                    .build();
        }

        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if(callable != null){
                    callable.onFailure(call , e);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(callable != null){
                    T rsp = new Gson().fromJson(response.body().string(),callable.getRspClass());
                    callable.onResponse(call , rsp);
                }
            }
        });
    }
}
