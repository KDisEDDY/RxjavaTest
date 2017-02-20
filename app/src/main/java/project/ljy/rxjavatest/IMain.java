package project.ljy.rxjavatest;

import java.util.List;

import bean.DaliyBean;
import bean.TypeItemBean;
import data.DaliyData;

import static bean.TypeItemBean.*;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface IMain {

    interface View extends BaseView<Presenter>{
        //上拉加载某种类型的数据
        void loadTypeData(boolean isChangeType, List<ResultsBean> list);

        //下拉刷新某种类型的数据
        void requestTypeData(List<ResultsBean> list);
    }

    interface Presenter extends BasePresenter{
        //下拉获取数据
        void loadData(int type);

        //上拉获取数据
        void requestData(int type);

        void downLoadFile(String url, DownLoadCallBack callBack);
    }
}
