package project.ljy.rxjavatest;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import bean.DaliyBean;
import bean.TypeItemBean;
import bean.TypeItemBean.ResultsBean;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 测试rxjava结合retrofit的效果，使用mvp模式构建
 */
public class MainActivity extends AppCompatActivity implements IMain.View {

    IMain.Presenter mPresenter;
    @BindView(R.id.list)
    RecyclerView mRecycleList;
    @BindView(R.id.swl_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private DaliyItemAdapter mAdapter = null;
    SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mPresenter = new MainPresenter(this);
        mPresenter.loadData(BaseConstant.TYPE_ANDROID);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void setPresenter(IMain.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    /**
     * 初始化
     */
    private void initView(){
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);
        if(mAdapter == null){
            mAdapter = new DaliyItemAdapter(new ArrayList<ResultsBean>());
            mRecycleList.setAdapter(mAdapter);
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleList.setLayoutManager(manager);
        mSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light
        );

        mSwipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void loadTypeData(boolean isChangeType, List<ResultsBean> list) {
        if(isChangeType){
            mAdapter.list.clear();
            mAdapter.addList(list);
        } else {
            mAdapter.addList(list);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void requestTypeData(List<ResultsBean> list) {

    }
}
