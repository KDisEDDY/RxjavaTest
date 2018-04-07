package utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import project.ljy.rxjavatest.base.BaseConstant;

/**
 * ClassName: HttpClientUtil
 * function:http封装类
 * Created by EDDY
 * CreateTime:2018/4/5
 */
public class HttpClientUtil {

    public static synchronized OkHttpClient getDefaultClient(Boolean isUseCache){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.addInterceptor(interceptor);
        if(isUseCache){
            clientBuilder.cache(getHttpCache());
        }
        clientBuilder.addInterceptor(getCacheIntercepter())
                     .connectTimeout(15, TimeUnit.SECONDS);
        return clientBuilder.build();
    }

    private static Cache getHttpCache(){
        return new Cache(new File(BaseConstant.DIR_HTTP_CACHE) , (long)(10 * 1024));
    }

    private static Interceptor getCacheIntercepter(){
        return new CacheIntercepter();
    }
}
