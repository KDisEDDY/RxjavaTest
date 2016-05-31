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

/**
 * Created by Administrator on 2016/5/30.
 */
public class DaliyItemAdapter extends RecyclerView.Adapter<DaliyItemAdapter.ViewHolder>{

    DaliyBean list;
    public DaliyItemAdapter(DaliyBean list) {
        this.list = list;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.gankitem,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
