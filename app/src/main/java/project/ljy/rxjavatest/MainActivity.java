package project.ljy.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import data.DaliyData;
import io.reactivex.subjects.Subject;


/**
 * 测试rxjava结合retrofit的效果，使用mvp模式构建
 */
public class MainActivity extends AppCompatActivity implements IMain.View {

    //    Observable<String> observable;
    IMain.Presenter mPresenter;
    @BindView(R.id.list)
    RecyclerView list;

    private DaliyItemAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);
        new MainPresenter(this).loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }

    @Override
    public void showData(List<DaliyData> list) {
        if (list != null) {
            if(mAdapter != null){
                mAdapter = new DaliyItemAdapter(list);
            }
        }
    }

    @Override
    public void setPresenter(IMain.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }
}
