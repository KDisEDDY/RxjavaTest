package project.ljy.rxjavatest.ui;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.widget.Button;

import project.ljy.rxjavatest.base.BaseActivity;
import project.ljy.rxjavatest.base.BaseConstant;
import project.ljy.rxjavatest.R;
import project.ljy.rxjavatest.presenter.ILogin;
import project.ljy.rxjavatest.presenter.ILogin.View;
import project.ljy.rxjavatest.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity implements View {

    protected ILogin.Presenter mPresenter;
    protected TextInputEditText mNameEdt;
    protected Button mLoginBtn;
    protected TextInputEditText mPasswordEdt;
    protected AppCompatButton mRegisterBtn;

    @Override
    public int setSubContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTitle("登录", BaseConstant.STYLE_RETURN_BACK);
        initView();
        mPresenter = new LoginPresenter(this);

    }

    @Override
    public void setPresenter(ILogin.Presenter mPresenter) {

    }

    @Override
    public void loginError(int type) {
        Log.i("login", type + "");
    }

    @Override
    public void loginSuc() {
        Log.i("login", "success");
    }

    private void initView() {
        mNameEdt = (TextInputEditText) findViewById(R.id.edt_name);
        mLoginBtn = (Button) findViewById(R.id.btn_login);
        mLoginBtn.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                mPresenter.login(mNameEdt.getText().toString(), mPasswordEdt.getText().toString());
            }
        });
        mPasswordEdt = (TextInputEditText) findViewById(R.id.edt_password);
        mRegisterBtn = (AppCompatButton) findViewById(R.id.btn_register);
    }
}
