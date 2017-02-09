package project.ljy.rxjavatest;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import event.ShowEvent;
import utils.RxBus;

public class AActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_turn_b)
    public void onclick(){
        startActivity(new Intent(this,BActivity.class));
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
        ShowEvent event = new ShowEvent();
        event.setShowMessage("showEvent");
        RxBus.getDefault().post(event);
//            }
//        },1000);
    }
}
