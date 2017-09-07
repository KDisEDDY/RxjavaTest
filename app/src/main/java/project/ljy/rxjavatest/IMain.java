package project.ljy.rxjavatest;


import java.util.List;

import data.BaseBO;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface IMain {

    interface View<T extends BaseBO> extends BaseView<Presenter>{
        //下拉获取数据
        void loadData(List<T> list);

        //上拉获取数据
        void requestData(List<T> list);

        //转换今明天的数据
        void switchData(List<T> list);

    }

    interface Presenter<T extends BaseBO> extends BasePresenter{
        //下拉获取数据
        void loadData(int type);

        //上拉获取数据
        void requestData(int type);
    }
}
