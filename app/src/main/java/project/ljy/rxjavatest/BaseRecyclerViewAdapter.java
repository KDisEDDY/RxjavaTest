package project.ljy.rxjavatest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import listener.RecycleViewItemClickListener;

/**
 * Title: BaseRecyclerViewAdapter
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/2/16
 * Version: 1.0
 */
public abstract class BaseRecyclerViewAdapter<T extends RecyclerView.ViewHolder , S> extends RecyclerView.Adapter<T> {

    public List<S> list = null;

    private RecycleViewItemClickListener.ItemClickListener onItemClickListener  = null;

    private RecycleViewItemClickListener.LongItemClickListener onLongItemClickListener = null;

    public BaseRecyclerViewAdapter(List<S> list){
        this.list  = list;
    }

    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    /**
     * 需要使用点击事件时，重写onBindViewHolder时要调用父类方法，封装了监听在该方法
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final T holder, int position) {
        if(onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClickListener(v,holder.getAdapterPosition());
                }
            });
        }
        if(onItemClickListener != null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onLongItemClickListener.onLongItemClickListener(v,holder.getAdapterPosition());
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(RecycleViewItemClickListener.ItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnLongItemClickListener(RecycleViewItemClickListener.LongItemClickListener onLongItemClickListener) {
        this.onLongItemClickListener = onLongItemClickListener;
    }

    public S getItem(int position) {
        if(position < 0 && position > list.size() -1){
            try {
                throw new Exception("the positiion is wrong");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return list.get(position);
        }
        return null;
    }

    public void addList(@NonNull List<S> newList){
        if(newList.size() > 0){
            list.addAll(newList);
        }
    }

    public void requestList(@NonNull List<S> firstList){
        if (firstList.size() > 0){
            list.clear();
            list.addAll(firstList);
        }
    }
}
