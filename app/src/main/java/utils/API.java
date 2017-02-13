package utils;

import bean.DaliyBean;
import bean.TypeItemBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

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
        @GET("/data/{type}/{month}/{day}")
        Observable<TypeItemBean> getTypeDaliyApi(@Path("type") String type,
                                                 @Path("month") String month,
                                                 @Path("day") String day);
    }

    interface AndroidDaliyApi{
        /**
         * http://gank.io/api/data/Android/10/1
         */
        @GET("/data/Android/{month}/{day}")
        Observable<TypeItemBean> getAndroidDaliyApi(@Path("month") String month,
                                                    @Path("day") String day);
    }

    interface IOSDaliyApi{
        /**
         * http://gank.io/api/data/iOS/10/1
         */
        @GET("/data/iOS/{month}/{day}")
        Observable<TypeItemBean> getAndroidDaliyApi(@Path("month") String month,
                                                    @Path("day") String day);
    }

    interface WebDaliyApi{
        /**
         * http://gank.io/api/data/前端/10/1
         */
        @GET("/data/前端/{month}/{day}")
        Observable<TypeItemBean> getWebDaliyApi(@Path("month") String month,
                                                    @Path("day") String day);
    }

}
