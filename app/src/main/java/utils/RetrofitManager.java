package utils;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/5/25.
 */
public class RetrofitManager {

    static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl("http://gank.io/api/")
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    static public API.GankApi getGankApi(){
        API.GankApi gankApi = getRetrofitInstance().create(API.GankApi.class);
        return gankApi;
    }

    static public API.DaliyApi getDaliyApi(){
        return getRetrofitInstance().create(API.DaliyApi.class);
    }
}
