package project.ljy.rxjavatest.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import project.ljy.rxjavatest.BaseActivity;
import project.ljy.rxjavatest.BaseConstant;
import project.ljy.rxjavatest.R;
import project.ljy.rxjavatest.login.ILogin.View;

public class LoginActivity extends BaseActivity implements View {

    protected ILogin.Presenter mPresenter;
    protected EditText etText;
    protected Button btnTxt;

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
        Log.i("login",type + "");
    }

    @Override
    public void loginSuc() {
        Log.i("login","success");
    }

    private void initView() {
        etText = (EditText) findViewById(R.id.et_text);
        btnTxt = (Button) findViewById(R.id.btn_txt);
        btnTxt.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                mPresenter.login(etText.getText().toString(),etText.getText().toString());
            }
        });
    }
}
