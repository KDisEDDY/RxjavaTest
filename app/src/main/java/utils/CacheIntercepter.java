package utils;

import java.io.IOException;
import okhttp3.Interceptor;

import okhttp3.Response;

/**
 * ClassName: CacheIntercepter
 * function:
 * Created by EDDY
 * CreateTime:2018/4/5
 */
public class CacheIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .header("Cache-Control", "max-age=60")
                .build();
    }
}
