package project.ljy.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import bean.TypeItemBean;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 测试rxjava结合retrofit的效果，使用mvp模式构建
 */
public class MainActivity extends AppCompatActivity implements IMain.View {

    IMain.Presenter mPresenter;
    @BindView(R.id.list)
    RecyclerView mRecycleList;

    private DaliyItemAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleList.setLayoutManager(manager);
        new MainPresenter(this).loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }

    @Override
    public void showData(TypeItemBean list) {
        if (list != null) {
            if(mAdapter == null){
                mAdapter = new DaliyItemAdapter(list.getResults());
                mRecycleList.setAdapter(mAdapter);
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setPresenter(IMain.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }
}
