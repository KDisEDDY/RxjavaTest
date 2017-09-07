package utils;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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

    static public OkHttpClient getDefaultClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();
        return client;
    }

    static public API.DownLoadApi getDownLoadApi(){
            return getRetrofitInstance().create(API.DownLoadApi.class);
    }
}
