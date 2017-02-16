package project.ljy.rxjavatest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bean.TypeItemBean.ResultsBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import project.ljy.rxjavatest.RecycleViewItemClickListener.ItemClickListener;
import project.ljy.rxjavatest.RecycleViewItemClickListener.LongItemClickListener;

/**
 * Created by Administrator on 2016/5/30.
 */
public class DaliyItemAdapter extends BaseRecyclerViewAdapter<DaliyItemAdapter.ViewHolder,ResultsBean> {

    public DaliyItemAdapter(List<ResultsBean> list) {
        super(list);
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
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_item)
        TextView tv_item;

         public ViewHolder(View view){
             super(view);
             ButterKnife.bind(this,view);
         }
    }
}
