package utils;

import java.io.IOException;
import okhttp3.Interceptor;

import okhttp3.Response;

/**
 * ClassName: CacheInterceptor
 * function: 缓存拦截器
 * Created by EDDY
 * CreateTime:2018/4/5
 */
public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .addHeader("Cache-Control", "max-age=60")
                .build();
    }
}
