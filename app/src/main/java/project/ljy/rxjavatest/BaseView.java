package project.ljy.rxjavatest;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface BaseView<T extends BasePresenter> {

    void setPresenter(T mPresenter);
}
