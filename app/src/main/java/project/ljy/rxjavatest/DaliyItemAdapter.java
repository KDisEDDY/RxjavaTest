package project.ljy.rxjavatest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bean.TypeItemBean.ResultsBean;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/30.
 */
public class DaliyItemAdapter extends RecyclerView.Adapter<DaliyItemAdapter.ViewHolder>{

    List<ResultsBean> list;
    public DaliyItemAdapter(List<ResultsBean> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.gankitem,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResultsBean item = list.get(position);
        holder.tv_item.setText(item.getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
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
