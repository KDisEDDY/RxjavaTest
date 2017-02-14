package utils;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/5/25.
 */
public class RetrofitManager {

    static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl("http://gank.io/api/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
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
}
