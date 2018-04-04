package project.ljy.rxjavatest.presenter;

import android.content.Context;

import java.util.List;

import project.ljy.rxjavatest.base.BasePresenter;
import project.ljy.rxjavatest.base.BaseView;
import project.ljy.rxjavatest.data.VideoList;

/**
 * ClassName: IVideoList
 * function:
 * Created by EDDY
 * CreateTime:2018/3/25
 */
public interface IVideoList {

    interface View extends BaseView<IVideoList.Presenter> {
        public void loadCurItemList(List<VideoList.ItemList> itemList);
    }

    interface Presenter extends BasePresenter {
        public void requestData(Context context , int num , int page);
    }
}
