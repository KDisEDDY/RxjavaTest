package project.ljy.rxjavatest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bean.DaliyBean;
import bean.GankBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import data.DaliyData;

/**
 * Created by Administrator on 2016/5/30.
 */
public class DaliyItemAdapter extends RecyclerView.Adapter<DaliyItemAdapter.ViewHolder>{

    List<DaliyData> list;
    public DaliyItemAdapter(List<DaliyData> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.gankitem,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DaliyData item = list.get(position);

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
