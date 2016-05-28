package project.ljy.rxjavatest;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import bean.DaliyBean;
import bean.GankBean;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
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
        mSubscriptions.add(RetrofitManager.getDaliyApi().getDaliyData(year + "", month + "", day + "").subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<DaliyBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(DaliyBean daliyBean) {
                        if(daliyBean == null){

                        }
                        view.showData(daliyBean);
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
