package project.ljy.rxjavatest;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import bean.DaliyBean;
import bean.GankBean;
import data.DaliyData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import utils.RetrofitManager;

/**
 * Created by Administrator on 2016/5/25.
 */
public class MainPresenter implements IMain.Presenter{
    IMain.View view;
    List<GankBean.ResultsEntity> list;
    protected CompositeSubscription mSubscriptions = new CompositeSubscription();
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
        mSubscriptions.add(RetrofitManager.getDaliyApi().getDaliyData(year + "", month + "", day + "")
                .map(new Func1<DaliyBean, List<DaliyData>>() {
                    @Override
                    public List<DaliyData> call(DaliyBean daliyBean) {
                        return null;
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<List<DaliyData>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<DaliyData> list) {
                        if(list == null){

                        }
                        view.showData(list);
                    }
                }));
    }

    @Override
    public void unsubscribe() {
        if (mSubscriptions != null && !mSubscriptions.isUnsubscribed()) {
            mSubscriptions.unsubscribe();
        }
    }
}
