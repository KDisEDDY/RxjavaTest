package project.ljy.rxjavatest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import bean.DaliyBean;
import bean.DaliyBean.ResultsEntity;
import bean.DaliyBean.ResultsEntity.AndroidEntity;
import bean.GankBean;
import bean.TypeItemBean;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;
import utils.RetrofitManager;

/**
 * Created by Administrator on 2016/5/25.
 */
public class MainPresenter implements IMain.Presenter{
    IMain.View view;
    List<GankBean.ResultsEntity> list;
    public MainPresenter(IMain.View view) {
        this.view = view;
        list = new LinkedList<>();
        view.setPresenter(this);
    }

    @Override
    public void loadData() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        RetrofitManager.getDaliyApi()
                .getDaliyData(year + "", month + "", day + "")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<DaliyBean, Observable<TypeItemBean>>(){
                    @Override
                    public Observable<TypeItemBean> apply(DaliyBean daliyBean) throws Exception {
                        TypeItemBean androidList = new TypeItemBean();
                        List<TypeItemBean.ResultsBean> androidBean = new ArrayList<>();
                        for (int i = 0; i < daliyBean.getResults().getAndroid().size(); i++) {
                            AndroidEntity entity = daliyBean.getResults().getAndroid().get(i);
                            TypeItemBean.ResultsBean item = new TypeItemBean.ResultsBean();
                            item.setWho(entity.getWho());
                            item.set_id(entity.get_id());
                            item.setCreatedAt(entity.getCreatedAt());
                            item.setDesc(entity.getDesc());
                            item.setPublishedAt(entity.getPublishedAt());
                            item.setType(entity.getType());
                            item.setUrl(entity.getUrl());
                            androidBean.add(item);
                        }
                        androidList.setResults(androidBean);

                        TypeItemBean iOSList = new TypeItemBean();
                        List<TypeItemBean.ResultsBean> iOSBean = new ArrayList<>();
                        for (int i = 0; i < daliyBean.getResults().getIOS().size(); i++) {
                            ResultsEntity.IOSEntity entity = daliyBean.getResults().getIOS().get(i);
                            TypeItemBean.ResultsBean item = new TypeItemBean.ResultsBean();
                            item.setWho(entity.getWho());
                            item.set_id(entity.get_id());
                            item.setCreatedAt(entity.getCreatedAt());
                            item.setDesc(entity.getDesc());
                            item.setPublishedAt(entity.getPublishedAt());
                            item.setType(entity.getType());
                            item.setUrl(entity.getUrl());
                            iOSBean.add(item);
                        }
                        iOSList.setResults(iOSBean);
                        TypeItemBean[] amountList = {
                                androidList,iOSList
                        };
                        return Observable.fromArray(amountList);
                    }
                })
                .subscribe(new DefaultObserver<TypeItemBean>() {
                    @Override
                    public void onNext(TypeItemBean typeItemBean) {
                        view.showData(typeItemBean);
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
    public void unsubscribe() {
    }
}
