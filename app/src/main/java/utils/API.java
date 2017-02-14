package utils;

import bean.DaliyBean;
import bean.TypeItemBean;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
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
        @GET("data/{type}/{pageSize}/{page}")
        Observable<TypeItemBean> getTypeDaliyApi(@Path("type") String type,
                                                 @Path("pageSize") String pageSize,
                                                 @Path("page") String page);
    }

}
