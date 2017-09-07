package project.ljy.rxjavatest;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import data.BaseBO;

/**
 * Created by Administrator on 2016/5/25.
 */
public class MainPresenter<T extends BaseBO> implements IMain.Presenter{
    IMain.View<T> mView;

    /**
     * 用于获取单个类型的分页条件
     */
    static int pageSize = 10;

    public MainPresenter(IMain.View<T> view) {
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void loadData(@NonNull final int type) {
        mView.loadData(new ArrayList<T>());
    }

    @Override
    public void requestData(int type) {
        mView.requestData(new ArrayList<T>());
    }

}
