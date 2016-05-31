package project.ljy.rxjavatest;

import java.util.List;

import data.DaliyData;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface IMain {

    interface View extends BaseView<Presenter>{
        void showData(List<DaliyData> list);
    }

    interface Presenter extends BasePresenter{
        void loadData();

        void unsubscribe();
    }
}
