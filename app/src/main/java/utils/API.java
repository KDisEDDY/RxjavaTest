package utils;

import org.json.JSONObject;

import java.util.List;

import bean.DaliyBean;
import bean.GankBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

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
}
