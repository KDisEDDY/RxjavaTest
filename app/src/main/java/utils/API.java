package utils;

import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface API {

    interface DownLoadApi{
        @Streaming
        @GET()
        retrofit2.Call<ResponseBody> downLoadFile(@Url String url);

        @Streaming
        @GET()
        Observable<ResponseBody> downloadProgressFile(@Url String url);
    }

    interface MoveListApi{
        ResponseBody getMovieList(String url);
    }
}
