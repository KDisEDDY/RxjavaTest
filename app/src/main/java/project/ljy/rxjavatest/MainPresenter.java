package project.ljy.rxjavatest;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.TypeItemBean;
import bean.TypeItemBean.ResultsBean;
import callback.DownLoadCallBack;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;
import listener.UIProgressResponseListener;
import utils.DownLoadUtil;
import utils.RetrofitManager;

/**
 * Created by Administrator on 2016/5/25.
 */
public class MainPresenter implements IMain.Presenter{
    IMain.View view;
//    /**
//     * 用于获取全部数据的时间条件
//     */
//    static Calendar localCalendar ;
//    static int year = 0;
//    static int month = 0;
//    static int day = 0;

    /**
     * 当前的model数据
     */
    Map<Integer,Integer> pageMap = new HashMap<>();
    Map<Integer,List<ResultsBean>> itemListMap = new HashMap<>();
    /**
     * 用于获取单个类型的分页条件
     */
    static int pageSize = 10;
    int currentType = BaseConstant.TYPE_ANDROID;

    public MainPresenter(IMain.View view) {
        this.view = view;
        pageMap.put(BaseConstant.TYPE_ALL,1);
        pageMap.put(BaseConstant.TYPE_ANDROID,1);
        pageMap.put(BaseConstant.TYPE_IOS,1);
        pageMap.put(BaseConstant.TYPE_EXTENDEDRESOURCE,1);
        pageMap.put(BaseConstant.TYPE_FULI,1);
        pageMap.put(BaseConstant.TYPE_WEBFRONT,1);

        itemListMap.put(BaseConstant.TYPE_ALL,new ArrayList<ResultsBean>());
        itemListMap.put(BaseConstant.TYPE_ANDROID,new ArrayList<ResultsBean>());
        itemListMap.put(BaseConstant.TYPE_IOS,new ArrayList<ResultsBean>());
        itemListMap.put(BaseConstant.TYPE_EXTENDEDRESOURCE,new ArrayList<ResultsBean>());
        itemListMap.put(BaseConstant.TYPE_FULI,new ArrayList<ResultsBean>());
        itemListMap.put(BaseConstant.TYPE_WEBFRONT,new ArrayList<ResultsBean>());
        view.setPresenter(this);
    }

    @Override
    public void loadData(@NonNull final int type) {
//        if(localCalendar == null){
//            localCalendar = Calendar.getInstance();
//            year = localCalendar.get(Calendar.YEAR);
//            month = localCalendar.get(Calendar.MONTH);
//            day = localCalendar.get(Calendar.DAY_OF_MONTH);
//        } else {
//            localCalendar.add(Calendar.DAY_OF_MONTH,-1);
//            year = localCalendar.get(Calendar.YEAR);
//            month = localCalendar.get(Calendar.MONTH);
//            day = localCalendar.get(Calendar.DAY_OF_MONTH);
//        }
//        final int localYear = year;
//        final int localMonth = month;
//        final int localDay = day;
        Observable.just(type)
                .subscribe(new DefaultObserver<Integer>() {
                    @Override
                    public void onNext(Integer integer) {
                        String typeStr = null;
                        switch (integer){
                            case BaseConstant.TYPE_ANDROID:
                                typeStr = "Android";
                                break;
                            case BaseConstant.TYPE_IOS:
                                typeStr = "iOS";
                                break;
                            case BaseConstant.TYPE_EXTENDEDRESOURCE:
                                typeStr = "瞎推荐";
                                break;
                            case BaseConstant.TYPE_WEBFRONT:
                                typeStr = "前端";
                                break;
                            case BaseConstant.TYPE_FULI:
                                typeStr = "福利";
                                break;
                            default:
                                break;
                        }
                        int page = pageMap.get(type);
                        if(currentType == type){
                            RetrofitManager.getTypeDaliyApi()
                                    .getTypeDaliyApi(typeStr,pageSize + "" , page +"")
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeOn(Schedulers.newThread())
                                    .map(new Function<TypeItemBean,  List<ResultsBean>>() {
                                        @Override
                                        public  List<ResultsBean> apply(TypeItemBean typeItemBean) throws Exception {
                                            List<ResultsBean> list = typeItemBean.getResults();
                                                    List<ResultsBean> itemList = itemListMap.get(type);
                                                    itemList.addAll(list);
                                                    itemListMap.put(type,itemList);
                                            return list;
                                        }
                                    })
                                    .subscribe(new DefaultObserver<List<ResultsBean>>() {
                                        @Override
                                        public void onNext( List<ResultsBean> list) {
                                            view.loadTypeData(false,list);
                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            e.printStackTrace();
                                        }

                                        @Override
                                        public void onComplete() {

                                        }
                                    });
                            pageMap.put(type,++ page);
                        } else {
                            view.loadTypeData(true,itemListMap.get(type));
                            currentType = type;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void requestData(int type) {
    }

    @Override
    public void downLoadFile(String url, DownLoadCallBack callBack) {
        DownLoadUtil.downloadFile(url,callBack);
    }

    @Override
    public void downloadProgressFile(String url, UIProgressResponseListener listener) {
        DownLoadUtil.downloadProgressFile(url, listener);
    }
}
