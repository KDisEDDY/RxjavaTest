package project.ljy.rxjavatest;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.List;

import bean.DaliyBean;
import bean.TypeItemBean;
import bean.TypeItemBean.ResultsBean;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v7.widget.RecyclerView.*;

/**
 * 测试rxjava结合retrofit的效果，使用mvp模式构建
 */
public class MainActivity extends AppCompatActivity implements IMain.View {

    IMain.Presenter mPresenter;
    @BindView(R.id.list)
    RecyclerView mRecycleList;
    @BindView(R.id.swl_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private LinearLayoutManager manager = null;
    private DaliyItemAdapter mAdapter = null;

    private int mCurrentType = BaseConstant.TYPE_ANDROID;
    SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

        }
    };

    class RVOnScrollListener extends OnScrollListener {
        private SwipeRefreshLayout swipeRefreshLayout = null;
        private int nowState = SCROLL_STATE_IDLE;
        public RVOnScrollListener( SwipeRefreshLayout swipeRefreshLayout){
            this.swipeRefreshLayout = swipeRefreshLayout;
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            switch (newState){
                case SCROLL_STATE_IDLE:
                    LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if(layoutManager instanceof LinearLayoutManager){
                        LinearLayoutManager llmanager = (LinearLayoutManager) layoutManager;
                        if(llmanager.findLastCompletelyVisibleItemPosition() == recyclerView.getAdapter().getItemCount() - 1){
                            swipeRefreshLayout.setRefreshing(true);
                            mPresenter.loadData(mCurrentType);
                        } else {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    }
                    nowState = SCROLL_STATE_IDLE;
                    break;
                case SCROLL_STATE_SETTLING:
                    nowState = SCROLL_STATE_SETTLING;
                    swipeRefreshLayout.setRefreshing(false);
                    break;
                case SCROLL_STATE_DRAGGING:
                    nowState = SCROLL_STATE_DRAGGING;
                    swipeRefreshLayout.setRefreshing(false);
                default:
                    break;
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mPresenter = new MainPresenter(this);
        mPresenter.loadData(mCurrentType);
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
        manager = new LinearLayoutManager(this);
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
        mRecycleList.addOnScrollListener(new RVOnScrollListener(mSwipeRefreshLayout));
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
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void requestTypeData(List<ResultsBean> list) {

        mSwipeRefreshLayout.setRefreshing(false);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.fab_android:
                mCurrentType = BaseConstant.TYPE_ANDROID;
                break;
            case R.id.fab_ios:
                mCurrentType = BaseConstant.TYPE_IOS;
                break;
            case R.id.fab_webfront:
                mCurrentType = BaseConstant.TYPE_WEBFRONT;
                break;
            case R.id.fab_fuli:
                mCurrentType = BaseConstant.TYPE_FULI;
                break;
            case R.id.fab_extendresource:
                mCurrentType = BaseConstant.TYPE_EXTENDEDRESOURCE;
                break;
            default:
                break;
        }
        mPresenter.loadData(mCurrentType);
    }
}
