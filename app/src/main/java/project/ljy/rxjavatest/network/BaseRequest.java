package project.ljy.rxjavatest.network;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import project.ljy.rxjavatest.base.BaseConstant;
import project.ljy.rxjavatest.data.BaseBO;
import utils.HttpClientUtil;

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
    private static MainHandler mHandler ;

    private static class MainHandler extends Handler{
        WeakReference<Context> mActivityReference;
        public MainHandler(Context activity) {
            super(Looper.getMainLooper());
            mActivityReference= new WeakReference<>(activity);
        }
    }

    public BaseRequest(Context context){
        if(mClient == null){
            synchronized (BaseRequest.class) {
                if(mClient == null){
                    mClient = HttpClientUtil.getDefaultClient(true);
                }
            }
        }

        if(mHandler == null){
            synchronized (BaseRequest.class){
                if(mHandler == null){
                    mHandler = new MainHandler(context);
                }
            }
        }
    }

    <T extends BaseBO> void request(String url, RequestBody requestBody, final Callable<T> callable){

        Request request ;
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
            public void onFailure(final Call call, final IOException e) {
                if(callable != null){
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callable.onFailure(call , e);
                        }
                    });
                }
            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                if(callable != null){
                    String responseStr = response.body().string();
                    final T rsp = new Gson().fromJson(responseStr,callable.getRspClass());
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                callable.onResponse(call , rsp);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
    }
}
