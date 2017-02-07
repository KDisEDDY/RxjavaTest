package utils;

import bean.DaliyBean;
import bean.GankBean;
import bean.TypeItemBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface API {
    interface GankApi{
        @GET("history/content/day/{year}/{month}/{day}")
        Observable<GankBean> Found(@Path("year") String year,
                                   @Path("month") String month,
                                   @Path("day") String day);
    }

    interface DaliyApi{
        @GET("day/{year}/{month}/{day}")
        Observable<DaliyBean> getDaliyData(@Path("year") String year,
                                           @Path("month") String month,
                                           @Path("day") String day);
    }

    interface TypeDaliyApi{
        @GET("/data/{type}/{month}/{day}")
        Observable<TypeItemBean> getTypeDaliyApi(@Path("type") String type,
                                                 @Path("month") String month,
                                                 @Path("day") String day);
    }
}
