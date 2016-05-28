package project.ljy.rxjavatest;

import bean.DaliyBean;
import bean.GankBean;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface IMain {

    interface View extends BaseView<Presenter>{
        void showData(DaliyBean bean);
    }

    interface Presenter extends BasePresenter{
        void loadData();

        void unsubscribe();
    }
}
