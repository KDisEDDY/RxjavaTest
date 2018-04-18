package project.ljy.rxjavatest.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.marshalchen.ultimaterecyclerview.ItemTouchListenerAdapter;
import com.marshalchen.ultimaterecyclerview.RecyclerItemClickListener;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.List;

import project.ljy.rxjavatest.R;
import project.ljy.rxjavatest.data.VideoList;

/**
 * ClassName: VideoListAdapter
 * function:
 * Created by EDDY
 * CreateTime:2018/4/1
 */
public class VideoListAdapter extends UltimateViewAdapter<VideoListAdapter.ViewHolder>{

    private List<VideoList.ItemList> mItemList;
    private Context mContext;

    private static final String TAG = "Logcat_info";

    public VideoListAdapter(Context context , List<VideoList.ItemList> itemList){
        mContext = context;
        mItemList = itemList;
    }

    @Override
    public ViewHolder newFooterHolder(View view) {
        return null;
    }

    @Override
    public ViewHolder newHeaderHolder(View view) {
        return null;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_videolist , parent , false);
        if(view != null){
            return new ViewHolder(view);
        }
        return null;
    }

    @Override
    public int getAdapterItemCount() {
        return mItemList.size();
    }

    @Override
    public long generateHeaderId(int position) {
        return 0;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        VideoList.ItemList item  = mItemList.get(position);
        holder.mTitleTxt.setText(item.getData().getTitle());
        if(item.getData().getCover() != null && !item.getData().getCover().getFeed().isEmpty()){
            Glide.with(mContext).load(item.getData().getCover().getFeed()).placeholder(R.drawable.pic_none_or_preholder).into(holder.mPrePhotoImg);
        } else {
            Glide.with(mContext).load(R.drawable.pic_none_or_preholder);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public void setItemList(List<VideoList.ItemList> mItemList) {
        if(this.mItemList != null){
            this.mItemList = mItemList;
        }
    }

    public List<VideoList.ItemList> getItemList(){
        return mItemList;
    }

    /**添加到顶部list*/
    public void addTopList(List<VideoList.ItemList> list){
        if(list == null) {
            return;
        }
        if(list.size() > 0){
            mItemList.addAll(0 , list);
            notifyDataSetChanged();
        }

    }

    /**添加到尾部list*/
    public void addBottomList(List<VideoList.ItemList> list){
        if(list == null) {
            return;
        }
        if(list.size() > 0){
            mItemList.addAll(list);
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends UltimateRecyclerviewViewHolder{

        TextView mTitleTxt  ;
        ImageView mPrePhotoImg ;

        ViewHolder(View itemView) {
            super(itemView);
            mTitleTxt = (TextView) itemView.findViewById(R.id.tv_title);
            mPrePhotoImg = (ImageView) itemView.findViewById(R.id.iv_preview_photo);
        }
    }
}
