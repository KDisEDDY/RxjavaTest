package project.ljy.rxjavatest.presenter;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import project.ljy.rxjavatest.data.BaseBO;

/**
 * Created by Administrator on 2016/5/25.
 */
public class MainPresenter implements IMain.Presenter {

    IMain.View mView;

    public MainPresenter(IMain.View view) {
        this.mView = view;
        mView.setPresenter(this);
    }
}
