package project.ljy.rxjavatest;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import bean.DaliyBean;
import bean.GankBean;
import data.DaliyData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
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
                .map(new Function<DaliyBean, List<DaliyData>>() {
                    @Override
                    public List<DaliyData> apply(DaliyBean daliyBean) throws Exception {
                        List<DaliyData> list =new ArrayList<>();
                        for(DaliyBean.ResultsEntity.AndroidEntity entity :daliyBean.getResults().getAndroid()){
                            DaliyData item = new DaliyData();
                            item.set_id(entity.get_id());
                            item.setCreatedAt(entity.getCreatedAt());
                            item.setDesc(entity.getDesc());
                            item.setPublishedAt(entity.getPublishedAt());
                            item.setType(entity.getType());
                            item.setUrl(entity.getUrl());
                            item.setWho(entity.getWho());
                            list.add(item);
                        }
                        for(DaliyBean.ResultsEntity.IOSEntity entity :daliyBean.getResults().getIOS()){
                            DaliyData item = new DaliyData();
                            item.set_id(entity.get_id());
                            item.setCreatedAt(entity.getCreatedAt());
                            item.setDesc(entity.getDesc());
                            item.setPublishedAt(entity.getPublishedAt());
                            item.setType(entity.getType());
                            item.setUrl(entity.getUrl());
                            item.setWho(entity.getWho());
                            list.add(item);
                        }
                        for(DaliyBean.ResultsEntity.休息视频Entity entity :daliyBean.getResults().get休息视频()){
                            DaliyData item = new DaliyData();
                            item.set_id(entity.get_id());
                            item.setCreatedAt(entity.getCreatedAt());
                            item.setDesc(entity.getDesc());
                            item.setPublishedAt(entity.getPublishedAt());
                            item.setType(entity.getType());
                            item.setUrl(entity.getUrl());
                            item.setWho(entity.getWho());
                            list.add(item);
                        }
                        for(DaliyBean.ResultsEntity.AndroidEntity entity :daliyBean.getResults().getAndroid()){
                            DaliyData item = new DaliyData();
                            item.set_id(entity.get_id());
                            item.setCreatedAt(entity.getCreatedAt());
                            item.setDesc(entity.getDesc());
                            item.setPublishedAt(entity.getPublishedAt());
                            item.setType(entity.getType());
                            item.setUrl(entity.getUrl());
                            item.setWho(entity.getWho());
                            list.add(item);
                        }
                        return list;
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<List<DaliyData>>() {
                    @Override
                    public void onNext(List<DaliyData> daliyDatas) {
                        view.showData(daliyDatas);
                    }

                    @Override
                    public void onError(Throwable e) {

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
