package project.ljy.rxjavatest.presenter;

/**
 * Title: LoginPresenter
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/9/12
 * Version: 1.0
 */

public class LoginPresenter implements ILogin.Presenter {

    private ILogin.View mView ;

    public LoginPresenter(ILogin.View view){
        mView = view;
    }

    @Override
    public void login(String name, String password) {
        mView.loginSuc();
        mView.loginError(1);
    }
}
