package project.ljy.rxjavatest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;

import bean.TypeItemBean.ResultsBean;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/30.
 */
public class DaliyItemAdapter extends BaseRecyclerViewAdapter<DaliyItemAdapter.ViewHolder,ResultsBean> {

    public DaliyItemAdapter(Context context ,List<ResultsBean> list) {
        super(context,list);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.gankitem,parent,false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        super.onBindViewHolder(holder,position);
        ResultsBean item = getItem(position);
        holder.tv_item.setText(item.getDesc());
        if(item.getImages() != null){
            List<String> strings = item.getImages();
            Glide.with(context).load(strings.get(0) + "?imageView2/0/w/600").placeholder(R.mipmap.ic_launcher).into(holder.iv_snapchat);
        } else {
            holder.iv_snapchat.setImageResource(R.mipmap.ic_launcher);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_item)
        TextView tv_item;
        @BindView(R.id.iv_project_snap)
        ImageView iv_snapchat;

         public ViewHolder(View view){
             super(view);
             ButterKnife.bind(this,view);
         }
    }
}
