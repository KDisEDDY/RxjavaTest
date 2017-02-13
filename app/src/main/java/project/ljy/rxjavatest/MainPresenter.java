package project.ljy.rxjavatest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import bean.DaliyBean;
import bean.DaliyBean.ResultsEntity;
import bean.DaliyBean.ResultsEntity.AndroidEntity;
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
    List<TypeItemBean.ResultsBean> list;
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
                .map(new Function<DaliyBean, List<TypeItemBean>>() {
                    @Override
                    public List<TypeItemBean> apply(DaliyBean daliyBean) throws Exception {
                        return null;
                    }
                })

                .subscribe(new DefaultObserver<List<TypeItemBean>>() {
                    @Override
                    public void onNext(List<TypeItemBean> list) {
                        view.showData(list);
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

    @Override
    public void requestData() {

    }
}
