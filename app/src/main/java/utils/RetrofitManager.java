package utils;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import listener.ProgressResponseListener;
import listener.UIProgressResponseListener;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import project.ljy.rxjavatest.ProgressResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/5/25.
 */
public class RetrofitManager {

    static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(OkHttpClient ...client) {
        OkHttpClient okHttpClient ;
        if(client.length == 0){
            okHttpClient = getDefaultClient();
        } else {
            okHttpClient = client[0];
        }
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl("http://gank.io/api/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

    static public OkHttpClient getDownFileClient(final ProgressResponseListener progressListener){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        //拦截
                        Response originalResponse = chain.proceed(chain.request());
                        //包装响应体并返回
                        return originalResponse.newBuilder()
                                .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                                .build();
                    }
                })
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();
    }

    static public OkHttpClient getDefaultClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();
        return client;
    }

    static public API.DaliyApi getDaliyApi(){
        return getRetrofitInstance().create(API.DaliyApi.class);
    }

    static public API.TypeDaliyApi getTypeDaliyApi(){
        return getRetrofitInstance().create(API.TypeDaliyApi.class);
    }

    static public API.DownLoadApi getDownLoadApi(UIProgressResponseListener...listener){
        if(listener.length == 0){
            return getRetrofitInstance(getDefaultClient()).create(API.DownLoadApi.class);
        } else {
            return getRetrofitInstance(getDownFileClient(listener[0])).create(API.DownLoadApi.class);
        }
    }
}
