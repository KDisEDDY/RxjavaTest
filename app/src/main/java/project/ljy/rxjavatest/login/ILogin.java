package project.ljy.rxjavatest.login;

import project.ljy.rxjavatest.BasePresenter;
import project.ljy.rxjavatest.BaseView;

/**
 * Title: ILogin
 * Description: 登录接口
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/9/12
 * Version: 1.0
 */

public interface ILogin {

    interface View extends BaseView<Presenter>{

        void loginError(int type);

        void loginSuc();
    }

    interface Presenter extends BasePresenter{

        void login(String name , String password);

    }
}
