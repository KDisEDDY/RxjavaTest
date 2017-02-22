package utils;

import bean.DaliyBean;
import bean.TypeItemBean;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import project.ljy.rxjavatest.ProgressResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface API {

    interface DaliyApi{
        @GET("day/{year}/{month}/{day}")
        Observable<DaliyBean> getDaliyData(@Path("year") String year,
                                                 @Path("month") String month,
                                                 @Path("day") String day);
    }

    interface TypeDaliyApi{
        @GET("data/{type}/{pageSize}/{page}")
        Observable<TypeItemBean> getTypeDaliyApi(@Path("type") String type,
                                                 @Path("pageSize") String pageSize,
                                                 @Path("page") String page);
    }

    interface DownLoadApi{
        @Streaming
        @GET()
        retrofit2.Call<ResponseBody> downLoadFile(@Url String url);

        @Streaming
        @GET()
        retrofit2.Call<ProgressResponseBody> downloadProgressFile(@Url String url);
    }
}
