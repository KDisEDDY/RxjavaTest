package utils;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/5/25.
 */
public class RetrofitManager {

    static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if(retrofit == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build();
            retrofit = new Retrofit.Builder().baseUrl("http://gank.io/api/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    static public API.DaliyApi getDaliyApi(){
        return getRetrofitInstance().create(API.DaliyApi.class);
    }

    static public API.TypeDaliyApi getTypeDaliyApi(){
        return getRetrofitInstance().create(API.TypeDaliyApi.class);
    }

    static public API.DownLoadApi getDownLoadApi(){
        return getRetrofitInstance().create(API.DownLoadApi.class);
    }
}
