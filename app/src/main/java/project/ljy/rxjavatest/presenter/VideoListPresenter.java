package project.ljy.rxjavatest.presenter;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import project.ljy.rxjavatest.data.BaseBO;
import project.ljy.rxjavatest.data.VideoList;
import project.ljy.rxjavatest.network.Callable;
import project.ljy.rxjavatest.network.VideoListModel;

/**
 * ClassName: VideoListPresenter
 * function:
 * Created by EDDY
 * CreateTime:2018/4/1
 */
public class VideoListPresenter implements IVideoList.Presenter {

    private IVideoList.View mView;

    public VideoListPresenter(IVideoList.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void requestData(Context context, int num, int page) {
        new VideoListModel(context).getVideoListRequest(new Callable<VideoList>(VideoList.class) {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, VideoList data) throws IOException {
                if(data != null && data.getItemList() != null){
                    mView.loadCurItemList(filterData(data));
                }
            }

        });
    }

    /**用于过滤数据*/
    private List<VideoList.ItemList> filterData(VideoList data){
        List<VideoList.ItemList> itemList = new ArrayList<>();
        for(VideoList.ItemList item : data.getItemList()){
            if(item.getData().getDataType().equals("VideoBeanForClient")){
                itemList.add(item);
            }
        }
        return itemList;
    }

}
