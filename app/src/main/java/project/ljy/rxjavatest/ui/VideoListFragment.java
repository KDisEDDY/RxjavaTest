package project.ljy.rxjavatest.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.ItemTouchListenerAdapter;
import com.marshalchen.ultimaterecyclerview.RecyclerItemClickListener;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import project.ljy.rxjavatest.R;
import project.ljy.rxjavatest.adapter.VideoListAdapter;
import project.ljy.rxjavatest.data.VideoList;
import project.ljy.rxjavatest.network.Callable;
import project.ljy.rxjavatest.network.VideoListModel;
import project.ljy.rxjavatest.presenter.IVideoList;
import project.ljy.rxjavatest.presenter.VideoListPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoListFragment extends Fragment implements IVideoList.View{
    //相当于intent传送的标志变量
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private UltimateRecyclerView mListView;

    private VideoListAdapter mAdapter;

    IVideoList.Presenter mPresenter;


    private Action mAction;
    public VideoListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment VideoListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoListFragment newInstance(Bundle bundle) {
        VideoListFragment fragment = new VideoListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            getArguments().getString(ARG_PARAM1);
            getArguments().getString(ARG_PARAM2);
        }
        mPresenter = new VideoListPresenter(this);
        mAdapter = new VideoListAdapter(getActivity() , new ArrayList<VideoList.ItemList>());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //测试用接口做Activity和Fragment的通信
        mAction = (Action) context;
        mAction.sendData("Bird MAN");
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_record_list,container,false);
        mListView = (UltimateRecyclerView) layout.findViewById(R.id.ulrv_recycler_list);
        mListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mListView.setAdapter(mAdapter);
        mListView.addOnItemTouchListener(new ItemTouchListenerAdapter(mListView.mRecyclerView , new ItemTouchListenerAdapter.RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View clickedView, int position) {
                VideoList.ItemList item = mAdapter.getItemList().get(position);
                if(item.getData() != null && !item.getData().getPlayUrl().isEmpty()){
                    Intent intent = new Intent(getActivity() ,PlayerActivity.class);
                    intent.putExtra(PlayerActivity.INTENT_VIDEOURL , item.getData().getPlayUrl());
                    startActivity(intent);
                }
            }

            @Override
            public void onItemLongClick(RecyclerView parent, View clickedView, int position) {

            }
        }));
       return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.requestData(getActivity() , 1,1);
    }

    @Override
    public void setPresenter(IVideoList.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void loadCurItemList(List<VideoList.ItemList> itemList) {
        mAdapter.addBottomList(itemList);
    }

    public interface Action {
        void sendData(String str);
    }
}
