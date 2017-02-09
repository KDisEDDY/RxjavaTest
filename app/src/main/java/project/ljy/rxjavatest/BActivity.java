package project.ljy.rxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import event.ShowEvent;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import utils.RxBus;

public class BActivity extends AppCompatActivity {

    @BindView(R.id.tv_show_msg)
    TextView mShowMsgTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);
        RxBus.getDefault().toObservable(ShowEvent.class).subscribe(new Observer<ShowEvent>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ShowEvent showEvent) {
                mShowMsgTxt.setText(showEvent.getShowMessage());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
//        RxBus.getDefault().subConnect(ShowEvent.class);
    }
}
